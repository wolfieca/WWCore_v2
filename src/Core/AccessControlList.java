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
    
    /**
     * The ACL for the protected object. Entries within the ACL must exist for
     * the owner and administrator with the appropriate Owner and Administrator
     * bits set. The access bits for the Owner and Administrator are largely
     * ignored while those entries are still defined as those respective
     * entities, but if administrator or owner changes, they become normal users
     * again and beholden to the access granted by their ACL entries.
     */
    private HashMap<Actor, Permission> acl;
    
    /**
     * Create an empty AccessControlList.
     */
    public AccessControlList(){
        owner = null;
        administrator = null;
        acl = new HashMap<>();
    }
    
    /**
     * Create an AccessControlList with the given characteristics.
     * @param owner the owner of the protected object
     * @param administrator designated administrator of the protected object
     * @param acl ACL assigned to the protected object
     */
    public AccessControlList(Actor owner, Actor administrator, 
            HashMap<Actor,Permission> acl){
        this.owner = owner;
        this.administrator = administrator;
        this.acl = acl;
    }
    
    private boolean checkAccess(Actor requestor, Permission requested){
        return false;
    }

    /**
     * Request a specific access to the protected object on behalf of the
     * requestor. 
     * @param requestor
     * @param requested
     * @return
     */
    public boolean requestAccess(Actor requestor, Permission requested){
        return checkAccess(requestor,requested);
    }
    
    /*
     * In order to change an ACL, the requesting user must be the Owner, the 
     * Administrator, or have the Alter Permission permission. In any event,
     * changing the ACL on an object is subject to several consistency checks
     * before it will be allowed.
     */
    
    /**
     *
     * @param requestor
     * @param user
     * @param permission
     * @return
     */
    protected boolean add(Actor requestor, Actor user, Permission permission){
        return false;
    }

    /**
     *
     * @param requestor
     * @param user
     * @param permission
     * @return
     */
    protected boolean remove(Actor requestor, Actor user, Permission permission){
        return false;
    }

    /**
     *
     * @param requestor
     * @param user
     * @param permission
     * @return
     */
    protected boolean modify(Actor requestor, Actor user, Permission permission){
        return false;
    }

    /**
     *
     * @param requestor
     * @param user
     * @return
     */
    protected boolean strip(Actor requestor, Actor user){
        return false;
    }

    /**
     *
     * @param requestor
     * @return
     */
    protected boolean takeOwnership(Actor requestor){
        return false;
    }

    /**
     *
     * @param requestor
     * @param target
     * @return
     */
    protected boolean giveOwnership(Actor requestor, Actor target){
        return false;
    }

    /**
     *
     * @param requestor
     * @param newAdmin
     * @return
     */
    protected boolean makeAdministrator(Actor requestor, Actor newAdmin){
        return false;
    }
}
