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

import java.util.HashSet;
import java.util.Set;

/**
 * WWPermission describes a set of permissions for an object.
 * Exact interpretations are left up to the object protected.
 * 12/18/2018 - A permission is actually made up of two separate permission sets.
 * One is the denied accesses and the other is the allowed accesses. When the
 * permission is being checked, priority goes to the denied permission set. If
 * any requested access is explicitly denied, the entire request is denied. If 
 * no requested access is explicitly denied, then any requested access that is
 * explicitly allowed is returned as a logical AND of the allowed and requested
 * permissions so that the caller can look further.
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class WWPermission {
    private int permissions;
    
    // Deny Permissions are bit-shifted 12 to the left
    static final int NONE               = 0x00000000;
    static final int ALL                = 0x00000fff;
    static final int READ               = 0x00000001;
    static final int WRITE              = 0x00000002;
    static final int CREATE             = 0x00000004;
    static final int MODIFY             = 0x00000008;
    static final int DELETE             = 0x00000010;
    //static final int EXECUTE            = 0x00000020;
    static final int ALTER_PERMISSIONS  = 0x00000020;
    static final int TAKE_OWNERSHIP     = 0x00000040;
    static final int WRITE_ACCESS       = WRITE+MODIFY+DELETE;
    static final int SEND_MESSAGE       = 0x00000080;
    static final int OWNER              = 0x10000fff;
    static final int ADMINISTRATOR      = 0x20000fff;
    static final int AUDIT              = 0x40000000;
    static final int DENY               = 0x80000000;
    static final int VALID_MASK         = 0xf0000fff;

    /**
     * Design Notes:
     * The basic permissions for a given object are Read, Modify, Create, Delete,
     * View/List, Alter Permissions, and Take Ownership. Send Message indicates 
     * the ability to send to an associated message queue, and will be moot if 
     * the protected object has no message queue. The remaining are 
     * administrative permissions indicating that the user is the owner or 
     * administrator of the object; if the user's interactions with the object 
     * are to be audited; or if this permission is an explicit denial permission,
     * in which the listed permissions are negated, instead indicating something
     * to be denied to the associated user.
     * Read access indicates that the user can request read access to the object.
     * The user's ability to see specific data is still limited by their ability 
     * to view PHI.
     * View/List access indicates that the user can see that the object exists. 
     * If the object is a container for other object, the user can also list items
     * contained within (again, subject to PHI restrictions)
     * Modify access indicates that the user is allowed to change the object. 
     * Create access, when applied to a container object, allows the user to 
     * create new objects in the container (i.e. in the payment meta-object, this
     * user is allowed to create new payments).
     * Delete access allows the user to delete the object. On a container object,
     * indicates that contained objects may be deleted. Both permissions must be
     * present (container and contained) for a particular object to be deletable.
     * View/List permission is required for the user to even see that the object
     * exists. On containers, allows the contained objects to be queried and/or
     * viewed by the user.
     * Alter Permissions allows the user to change the permissions on the object.
     * To users other than the specified owner or the administrator, the user can
     * only create permissions they themselves have to the object, and can only 
     * alter themselves (i.e. the user can reduce their own level of access, but
     * can't raise it or grant access to others). The owner can allow any access
     * they have been granted and can also expand that access to other users. The
     * administrator can grant any level of access to any object it controls. The
     * administrator cannot allow users not in at least one of the same groups as
     * them to access the object. One reason for this is to allow entities such 
     * as business offices to be kept separate from one another. So a company
     * can setup an office 1 administrator that is a member of the office 1 group
     * that is shared by clients, collectors, etc that are assigned to office 1.
     * That administrator can change permissions on office 1 objects, but can't,
     * say, do anything with an office 2 objects. Of course meta-administrators,
     * which have control over various offices, can also be set up to manage the
     * whole thing and facilitate activities such as inter-office rollovers.
     * Take Ownership allows the user to claim ownership of the object.
     * Send Message means that the user can send messages to the protected object.
     * This in only meaningful if the object is or has a MessageQueue.
     * The owner and administrator flags indicate the the user is the owner or
     * administrator of the object.
     * The Audit flag causes all interactions with this object to be logged.
     * The deny permission basically inverts the permissions, which causes the 
     * following changes:
     * 1. All the base permissions are read as denying that particular access to 
     * that object. 
     * 2. The audit flag is unaffected.
     * 3. The owner and administrator flags are read as prohibiting the user from
     * being an owner or administrator of the object. Even if otherwise allowed,
     * (via a Take Ownership permission), the user will be unable to become the
     * owner or administrator for this object
     */
    
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
     * Default constructor, allow none, deny none
     */
    private WWPermission() {
        this.permissions = NONE;
        //this.deny = false;
        //this.audit = false;
    }
    private WWPermission (int newMask){
        this();
        if ( (newMask & VALID_MASK) == newMask)
            permissions = newMask;
        
    }

    public static WWPermission init(){
        return new WWPermission();
    }
    /**
     *
     * @param createdMask
     * @return
     */
    public static WWPermission init(int createdMask){
        return new WWPermission(createdMask);
    }
    /**
     * Check to ensure the allowed and denied permissions don't overlap
     * @param tester permissions being tested
     * @param testee permissions being tested
     * @return 0 if allowed and denied permissions don't overlap
     */
    private final int comparePermissions( int tester, int testee) {
        return tester & testee;
    }
    
    private final int comparePermissions( WWPermission tester, 
            WWPermission testee){
        return (tester.bitMask() & testee.bitMask()) ;
    }

    /**
     *
     * @return
     */
    protected int bitMask () {
        return permissions;
    }
    /**
     * Checks if requestedPermissions are allowed
     * @param requestedPermissions the requested permissions
     * @return
     */
    private int checkAccess(int requestedPermissions){
        if ( ((requestedPermissions<<12) & permissions) != 0)
            return 0;
        else return (permissions) & requestedPermissions;
    }
    
    private int checkAccess(WWPermission requestedPermissions){
        return comparePermissions(this, requestedPermissions);
    }
    
    /**
     *
     * @param requested
     * @return
     */
    public boolean requestAccess(WWPermission requested){
        return (checkAccess(requested) == requested.bitMask());
    }
    

    /**
     *
     * @return
     */
    public Set<String> interpret() {
        Set<String> translations = new HashSet<>();
        if ( permissions == NONE)
            translations.add("No Access");
        if ( permissions == ALL)
            translations.add("Full Control");
        if ( (permissions & READ) != 0 )
            translations.add("Read");
        if ( (permissions & WRITE) != 0 )
            translations.add("Write");
        if ( (permissions & LOCK) != 0 )
            translations.add("Lock Object");
        if ( (permissions & MODIFY) != 0 )
            translations.add("Modify");
        if ( (permissions & DELETE) != 0 )
            translations.add("Delete");
        if ( (permissions & ALTER_PERMISSIONS) != 0 )
            translations.add("Change Permissions");
        if ( (permissions & TAKE_OWNERSHIP) != 0 )
            translations.add("Take Ownership");
        if ( (permissions & SEND_MESSAGE) != 0 )
            translations.add("Send Message");
        if ( (permissions & OWNER) != 0 )
            translations.add("Object Owner");
        if ( (permissions & ADMINISTRATOR) != 0 )
            translations.add("Object Administrator");
        if ( (permissions & AUDIT) != 0 )
            translations.add("Access is Audited");
        if ( (permissions & DENY) != 0 )
            translations.add("Denied Permissions");
        else
            translations.add("Allowed Permissions");
        
        return translations;
    }
  
}
