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
 * Permission describes a set of permissions for an object.
 * Exact interpretations are left up to the object protected.
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class WWPermission {
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
    static final int IMPERSONATE        = 0x0f000000;
    static final int OWNER              = 0x10000fff;
    static final int ADMINISTRATOR      = 0x20000fff;
    static final int AUDIT              = 0x40000000;
    static final int DENY               = 0x80000000;
    static final int VALID_MASK         = 0xf0000fff;

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
        return (tester.bitMask() & testee.bitMask()) | (permissions & DENY);
    }

    protected int bitMask () {
        return permissions;
    }
    /**
     * Checks if requestedPermissions are allowed
     * @param requestedPermissions the requested permissions
     * @return
     */
    private int checkAccess(int requestedPermissions){
        //if ( this.deny ) 
        //   return ( ~permissions & requestedPermissions );
        //else
            return (permissions) & requestedPermissions;
    }
    
    private int checkAccess(WWPermission requestedPermissions){
        return comparePermissions(this, requestedPermissions);
    }
    
    public boolean requestAccess(WWPermission requested){
        return (checkAccess(requested) == requested.bitMask());
    }
    
    public boolean isDeny(){
        return (permissions & DENY) != 0;
    }

    
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
        if ( (permissions & EXECUTE) != 0 )
            translations.add("Execute");
        if ( (permissions & ALTER_PERMISSIONS) != 0 )
            translations.add("Change Permissions");
        if ( (permissions & TAKE_OWNERSHIP) != 0 )
            translations.add("Take Ownership");
        if ( (permissions & SEND_MESSAGE) != 0 )
            translations.add("Send Message");
        if ( (permissions & IMPERSONATE) != 0 )
            translations.add("Impersonate");
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
