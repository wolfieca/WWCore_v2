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

import java.util.Dictionary;

/**
 * An AccessControlList, which is the basic unit of access control for system 
 * objects. This is in the middle of a redesign to make the whole thing simpler.
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class OldAccessControlList {
    
    /**
     * The admin object is for maintenance of this object. It will usually be 
     * a user on the system, normally a member of the Admin group. The admin
     * object is capable of reassigning ownership of the object.
     */
    private Actor admin; 
    private WWPermission adminPerms; 
    /**
     * The owner object owns the object protected by this ACL. By default,
     * the owner is allowed to do most anything with their objects, though 
     * system policy may prevent things such as deletion.
     */
    private Actor owner;
    private WWPermission ownerPerms;
    /**
     * The group object is the system group (or other object) in charge of this
     * object. If the group is an actual system group, then members of that 
     * group are allowed the specified access to the protected object
     */
    private Actor  group;
    private WWPermission groupPerms;
    /**
     * World permissions apply to anyone not an admin, owner or owning group,
     * This permission set is the default access to this object, before getting 
     * to the ACL
     */
    private WWPermission worldPerms;
    private Dictionary<Actor,WWPermission> ACL;
    
    /**
     * requests some form of access to this object
     * @param requestor the object requesting access
     * @param request the request being bate
     * @return true if the request is allowed
     * 
     * Note that admin, owner, and group can not be the same object, and none of
     * them can also appear in the ACL object. The check for whether a 
     * specific access request is allowed is as follows: If the requestor is
     * the admin, owner or group, those permissions are compared with the 
     * requested access and accepted if all the requested permissions are allowed
     * (and not specifically denied). If a permission is neither allowed nor 
     * denied, then the access world permissions are checked and, if they are 
     * allowed there, the request is accepted. If the requested permissions are 
     * not allowed there, the request is rejected.
     * If the user is not the admin, owner or member of the owning group, the ACL proper has to be
     * checked. Every ACL entry that is applicable to the requestor is checked
     * against the request. The request is granted if and only if each requested
     * permission is allowed either in the applicable ACLs or in the world 
     * permission set.
     * In all cases, if one of the requested permissions is denied by the ACL, 
     * the request fails (requests are an all or nothing affair). Denied 
     * permissions on world are ignored.
     */

    public boolean requestAccess(Actor requestor, int request){
        /*
        if ( requestor.equals(admin) ) {
            return adminPerms.checkAccess(request) == request;
        } else if ( requestor.equals(owner) ) {
            return ownerPerms.checkAccess(request) == request;
        }else if ( requestor.equals(group) ){
            return groupPerms.checkAccess(request) == request;
        }/* else if ( requestor.PrimaryGroup() != null ) {
            if ( requestor.PrimaryGroup() != group.PrimaryGroup()) {
                
            } else {
            }
        }*/
        /*
        if ( ACL.get(requestor) != null )
            return ACL.get(requestor).checkAccess(request) == request;
        else
            return worldPerms.checkAccess(request) == request;
        */
        return false;
    }
    
    /**
     * Add the specified permissionLest to this ACL
     * @param requestor
     * @param permissionList
     */
    protected void addAccess(Actor requestor, WWPermission permissionList){
        
    }

    /**
     * Who is the Administrative user for this object?
     * @return
     */
    public Actor getAdmin() {
        return admin;
    }

    /**
     * Set/Change the administrator user.
     * @param admin
     */
    public void setAdmin(Actor admin) {
        this.admin = admin;
    }

    /**
     * What permissions does the Admin user have?
     * @return
     */
    public WWPermission getAdminPerms() {
        return adminPerms;
    }

    /**
     * Set/Change the Admin user's permissions.
     * @param adminPerms
     */
    public void setAdminPerms(WWPermission adminPerms) {
        this.adminPerms = adminPerms;
    }

    /**
     * Who is the owner of this object?
     * @return
     */
    public Actor getOwner() {
        return owner;
    }

    /**
     * Set/Change the owner.
     * @param owner
     */
    public void setOwner(Actor owner) {
        this.owner = owner;
    }

    /**
     * What are the owners permissions?
     * @return
     */
    public WWPermission getOwnerPerms() {
        return ownerPerms;
    }

    /**
     * Set the owner's permissions.
     * @param ownerPerms
     */
    public void setOwnerPerms(WWPermission ownerPerms) {
        this.ownerPerms = ownerPerms;
    }

    /**
     * What is the primary group owning this object?
     * @return
     */
    public Actor getGroup() {
        return group;
    }

    /**
     * Change the owning group.
     * @param group
     */
    public void setGroup(Actor group) {
        this.group = group;
    }

    /**
     * Get the owning group's permissions.
     * @return
     */
    public WWPermission getGroupPerms() {
        return groupPerms;
    }

    /**
     * Set the owning group's permissions.
     * @param groupPerms
     */
    public void setGroupPerms(WWPermission groupPerms) {
        this.groupPerms = groupPerms;
    }

    /**
     * Get world (default) permissions.
     * @return
     */
    public WWPermission getWorldPerms() {
        return worldPerms;
    }

    /**
     * Set/Change world (default) permissions.
     * @param worldPerms
     */
    public void setWorldPerms(WWPermission worldPerms) {
        this.worldPerms = worldPerms;
    }

    /**
     * Get the ACL for this object.
     * @return
     */
    public Dictionary<Actor, WWPermission> getACL() {
        return ACL;
    }

    /**
     * Change the ACL or this object (restricted).
     * @param ACL
     */
    public void setACL(Dictionary<Actor, WWPermission> ACL) {
        this.ACL = ACL;
    }

}
