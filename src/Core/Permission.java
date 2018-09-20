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

/**
 * Permission describes a set of permissions for an object.
 * Exact interpretations are left up to the object protected.
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class Permission {
    private Permission inheritFrom;
    private boolean deny;
    private boolean audit;
    private int permissions;
    
    static final int NONE               = 0x00000000;
    static final int ALL                = 0x00000fff;
    static final int READ               = 0x00000001;
    static final int WRITE              = 0x00000002;
    static final int LOCK               = 0x00000004;
    static final int MODIFY             = 0x00000008;
    static final int DELETE             = 0x00000010;
    static final int EXECUTE            = 0x00000020;
    static final int ALTER_PERMISSIONS  = 0x00000040;
    static final int TAKE_OWNERSHIP     = 0x00000080;
    static final int WRITE_ACCESS       = WRITE+MODIFY+DELETE;
    static final int SEND_MESSAGE       = 0x00000100;
    static final int OWNER              = 0x10000fff;
    static final int ADMINISTRATOR      = 0x20000fff;
    static final int AUDIT              = 0x40000000;
    static final int DENY               = 0x80000000;

    /**
     * Permission notes:
     *  Permissions are defined as a 32-bit mask. The top 8 bits are basically
     *  administrative characteristics of the mask, while the remainder are access
     *  permissions. In the ACL itself, only one entry can be Administrator and
     *  only one entry can be Owner. The Audit permission causes all access to 
     *  create an audit trail. 
     *  Deny causes the selected access permissions to be explicitly denied to the
     *  affected user. Otherwise selected access permissions are allowed. Both 
     *  allowed and denied permissions can be assigned to a single user. Denied
     *  permissions are processed first, and if the requested permissions are 
     *  denied, the operation is denied. 
     */
    
    /**
     * Create the specified permission object.
     * @param deny
     * @param permissions
     */
    public Permission(boolean deny, int permissions) {
        //if ( comparePermissions(allowPermissions,denyPermissions) != 0)
        //    throw new InvalidPermissionCombinationException();
        this.permissions = permissions;
        this.deny = deny;
        this.inheritFrom = null;
    }

    /**
     * Default constructor, allow all, deny none
     */
    public Permission() {
        this.permissions = ALL;
        this.deny = false;
        this.audit = false;
        this.inheritFrom = null;
    }
    
    /**
     * Copy constructor, create a Permission object inheriting from the 
     * specified Permission object.
     * @param inherit the Permission object to inherit from
     */
    public Permission(Permission inherit){
        this.permissions = inherit.permissions;
        this.deny = inherit.deny;
        this.inheritFrom = inherit;
    }
    
    /**
     * Check to ensure the allowed and denies permissions don't overlap
     * @param tester permissions being tested
     * @param testee permissions being tested
     * @return 0 if allowed and denied permissions don't overlap
     */
    public final int comparePermissions( int tester, int testee) {
        return tester & testee;
    }

    /**
     * Checks if requestedPermissions are allowed
     * @param requestedPermissions the requested permissions
     * @return
     */
    public int checkAccess(int requestedPermissions){
        if ( this.deny ) 
            return ( ~permissions & requestedPermissions );
        else
            return (permissions) & requestedPermissions;
    }

    /**
     * Set the permissions on a pre-existing permission object
     * @param permissions
     * @return true on success
     */
    public boolean setPermissions(int permissions) {
            this.permissions = permissions;
            return true;
        }
    

    /**
     * Modify the permission object to allow the requested permissions. Note 
     * that in deny permissions, allow is effectively reversed to mean deny
     * @param requestedPermissions the requested permissions
     */
    protected void allow (int requestedPermissions) {
        this.permissions |= requestedPermissions;
    }

    /**
     * Modify the permission object to disallow the requested permissions.
     * Disallowing removes the permissions from the allowed list, but doesn't
     * deny the permission.
     * @param requestedPermissions
     */
    protected void disallow(int requestedPermissions){
        this.permissions &= ~requestedPermissions;
    }

    /**
     * Modify a Permission object to deny the requested permissions.
     * @param requestedPermissions 
     */
    protected void deny (int requestedPermissions) {
        
        //this.denyPermissions |= requestedPermissions;
        //this.allowPermissions &= ~requestedPermissions;
    }

    /**
     * Modify the Permission object to clear the requested permissions from both
     * the allowed and the denied lists.
     * @param requestedPermissions
     */
    protected void unset (int requestedPermissions) {
        //this.denyPermissions &= ~requestedPermissions;
        //this.allowPermissions &= ~requestedPermissions;
    }
    
    /**
     * Updates this Permission to match the parent Permission object.
     * @throws NullPointerException
     */
    protected void update() throws NullPointerException {
        //this.allowPermissions = this.inheritFrom.allowPermissions;
        //this.denyPermissions = this.inheritFrom.denyPermissions;
    }

    /**
     *
     * @return
     */
    protected Permission getInheritFrom() {
        return inheritFrom;
    }

    /**
     *
     * @param inheritFrom
     */
    protected void setInheritFrom(Permission inheritFrom) {
        this.inheritFrom = inheritFrom;
    }

    /**
     * Is this permission set denied? Denied permissions are explicitly 
     * denied to the user
     * @return
     */
    protected boolean isDeny() {
        return deny;
    }

    /**
     *
     * @param deny
     */
    protected void setDeny(boolean deny) {
        this.deny = deny;
    }
  
}
