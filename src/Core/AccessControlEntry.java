/* 
 * Copyright (C) 2018 Robert Serrano <wolfieca.rs@gmail.com>
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
 * AccessControlEntry is a single entry in an AccessControlList. Objects of this
 * class are responsible for maintaining the permissions and testing whether
 * a particular access is possible. AccessControlEntry objects are immutable. 
 * Once they're created, changes can only be made by creating a new AccessControlEntry
 * object and replacing the old entry on the AccessControlList. Note that the
 * sole responsibility of this class is to answer inquiries about whether a
 * given Actor is allowed the specified access to the managed object. This class
 * works as the glue between Actors and Permissions
 * AccessControlEntry object with the desired permissions.
 * @author Robert Serrano <wolfieca.rs@gmail.com>
 */
public class AccessControlEntry {
    private final Actor refActor;
    private final Permission permissions;
    
    public AccessControlEntry(){
        refActor = null;
        permissions = null;
    }
    
    public AccessControlEntry(Actor actor, Permission permissions){
        refActor = actor;
        this.permissions = permissions;
    }
    
    /**
     * Can this user claim the requested access?
     * @param refActor
     * @param requested
     * @return
     */
    public boolean canAccess(Actor refActor, int requested){
        if ( refActor != this.refActor )
            return false;
        else
            return (permissions.checkAccess(requested) == requested);
    }
}
