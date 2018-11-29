/*
 * Copyright (C) 2018 Robert Serrano (wolfieca.rs at gmail.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package Core;

import java.util.HashMap;
import java.util.Set;

/**
 * An Access Control List, which is the basic unit of access control for the 
 * system.
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class AccessControlList {

    /**
     * The assigned owner of the protected object.
     */
    private Actor owner;

    /**
     * The assigned administrator of the protected object.
     */
    private Actor administrator;
    
    /**
     * What session has this object locked, if any? This indicates that the User
     * that owns that session has indicated that they intend to make changes to
     * the object. Read access doesn't generally cause a lock to be placed on an 
     * object. Note that this process is distinct from, though similar to, marking
     * an object as locked, indicating that changes to the object are not to be
     * allowed on an ongoing basis.
     */
    private Session locked;

    private Set<Session> viewers;
    
    protected enum PermissionTypes{
        ALLOWED,
        DENIED
    }
    
    /**
     * The ACLs for the protected object. Entries within the ACL must exist for
     * the owner and administrator with the appropriate Owner and Administrator
     * bits set. The access bits for the Owner and Administrator are largely
     * ignored while those entries are still defined as those respective
     * entities, but if administrator or owner changes, they become normal users
     * again and beholden to the access granted by their ACL entries.
     * Entries in acl are explicitly allowed permissions. Entries in denied are 
     * explicitly denied permission. Access is checked in order of denied, then
     * allowed from specific user, to the groups that user is a member of, the
     * office the user works in, the company the user is a member of, and, 
     * finally, at the world level (the most generic). If, at any point, the 
     * access is explicitly granted or denied, the evaluation stops. If the 
     * requested access is not explicitly granted or denied, even at the World 
     * level, access is generally denied.
     * Ponder: Do I really need to have both denied and allowed implemented as 
     * separate lists?
     */
    private HashMap<Actor, WWPermission> allowed;
    private HashMap<Actor, WWPermission> denied;
    private HashMap<PermissionTypes, HashMap<Actor, WWPermission>> entries;
    private WWPermission worldPermissions;
    
    private AccessControlList(){
        entries = new HashMap<>();
        entries.put(PermissionTypes.DENIED, new HashMap<>());
        entries.put(PermissionTypes.ALLOWED, new HashMap<>());
        worldPermissions = WWPermission.init(WWPermission.NONE);
    }
    
    /**
     * In all cases of requesting a specific type of access to a particular 
     * object, a message is sent to the server requesting the access be granted,
     * and the local request will only be honored when the acknowledgment is 
     * received from the server. Read requests only fail if permissions are not
     * sufficient. Write requests only fail if another session is already using
     * the object for writing, and the request is made to not wait. Otherwise,
     * the thread will wait for a notification that the write lock has been 
     * provided.
     */
    /**
     * checks whether or not requester has the required permissions on the
     * protected object to claim the specified access
     * @param requestor the requesting Actor
     * @param requested the requested permissions
     * @return True if requested access is allowed
     */
    private synchronized boolean checkAccess(User requestor, WWPermission requested){
        //First, check the denied permissions
        WWPermission testee = entries.get(PermissionTypes.DENIED).get(requestor);
        if (testee != null){
            if (testee.requestAccess(requested))
                return false;
        }
        testee = entries.get(PermissionTypes.ALLOWED).get(requestor);
        if ( testee!= null){
            return (testee.requestAccess(requested));
        }
        return worldPermissions.requestAccess(requested);
    }

    /**
     * Request a specific access to the protected object on behalf of the
     * requester. 
     * @param requestor the Actor requesting the access
     * @param requested the requested permissions
     * @return True if requested access is allowed and was able to be granted
     * (generally true if read access, false if write access was requested and
     * the object was already locked).
     */
    public boolean requestAccess(User requestor, WWPermission requested){
        return checkAccess(requestor,requested);
    }
    
    /**
     * Request a specific access to the protected object. The requester will be
     * inferred from the current thread's security context (user and session info).
     * If the requester can't be determined, this will check against the World
     * group alone.
     * @param requested
     * @return 
     */
    public boolean requestAccess(WWPermission requested){
        return false;
    }
    
    /**
     *
     * @param checkSession
     * @return
     */
    public boolean validateSession(Session checkSession){
        return false;
    }
    /*
     * In order to change an ACL, the requesting user must be the Owner, the 
     * Administrator, or have the Alter WWPermission permission. In any event,
     * changing the ACL on an object is subject to several consistency checks
     * before it will be allowed.
     */
    
    /**
     * Add the specified user:permission to the ACL. The requester must have 
     * Alter Permissions access, and the user must not already have a permission
     * of the same type (allow or deny) in the ACL. If an Owner or Administrator
     * permission is being added, the requester must have Take Ownership 
     * permissions (if taking ownership), or Owner or Administrator permissions
     * (if giving them to another user).
     * @param requestor The user requesting the addition
     * @param user the user to be added to the ACL
     * @param permission the permissions the user is to have
     * @return True if the operation was allowed and succeeded.
     */
    protected boolean add(Actor requestor, Actor user, WWPermission permission){
        return false;
    }

    /**
     * The negation of add, deny explicitly denies the specified permission list
     * to the user. If the specified permission is not defined
     * @param requestor
     * @param user
     * @param permission
     * @return 
     */
    protected boolean deny(Actor requestor, Actor user, WWPermission permission){
        return false;
    }
    /**
     * Remove the specified permission from the specified user in the ACL. Most 
     * requirements as above. The specified permissions must already be possessed
     * by the user or this fails. 
     * @param requestor The user requesting the removal
     * @param user The user whose ACE is to be altered
     * @param permission The permissions to be removed
     * @return True if the operation was allowed and succeeded
     */
    protected boolean remove(Actor requestor, Actor user, WWPermission permission){
        return false;
    }

    /**
     * Modify the specified user's existing permissions. Requestor must have
     * Alter Permissions access to the protected object. Requestor must have all
     * permission they are granting to the user. This method does not allow 
     * owner or administrator changes, nor does it allow
     * @param requestor The requesting Actor
     * @param user The target user
     * @param permission The new permission set
     * @return True if allowed and successful
     */
    protected boolean modify(Actor requestor, Actor user, WWPermission permission){
        return false;
    }

    /**
     * Remove access to the protected object from user. User must already exist
     * in the ACL, otherwise, this operation will fail (and be mooted). This will
     * completely remove user from the ACL for the object (both allow and deny
     * permissions will be removed), so the user will be limited to default/World
     * access afterward.
     * @param requestor Requesting user
     * @param user the target user.
     * @return True if successful.
     */
    protected boolean strip(Actor requestor, Actor user){
        return false;
    }

    /**
     * Take ownership of the protected object. Requestor must have Take Ownership
     * permission on the object
     * @param requestor The user requesting ownership.
     * @return
     */
    protected boolean takeOwnership(Actor requestor){
        return false;
    }

    /**
     * Give ownership of the protected object to the target. Requestor must be
     * the owner or administrator of the protected object.
     * @param requestor The user requesting the ownership change
     * @param target The target to give ownership to
     * @return True if successful.
     */
    protected boolean giveOwnership(Actor requestor, Actor target){
        return false;
    }

    /**
     * Make the specified user the Administrator of the protected object. The 
     * requestor must currently be the administrator of the object.
     * @param requestor The user requesting the change
     * @param newAdmin The new Administrator.
     * @return True if successful.
     */
    protected boolean makeAdministrator(Actor requestor, Actor newAdmin){
        return false;
    }
    
    /**
     * Requests that the specified user session be given read access. User must
     * have permission to read the object. Multiple user sessions can read a
     * given object at the same time.
     * @param session the user session to be given access.
     * @return True if successful.
     */
    public boolean requestRead(Session session){
        return false;
    }
    
    /**
     * Requests that the specified user session be given access to write/modify
     * the object. User must have write permission. Only one user session can 
     * hold write access to an object at a time. Once it has been given to one
     * session, other requests block or fail until it has been released.
     * @param session the user session requesting access.
     * @return True if successful.
     */
    public boolean requestWrite(Session session){
        return false;
    }
}
