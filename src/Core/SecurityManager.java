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
 * Provides Security-related functionality to the system. SecurityManager
 * is the system-level security gatekeeper. It keeps all objects from taking
 * inappropriate actions. The Rights class allows individual parts of the 
 * system to allow or disallow access to various pieces of system functionality.
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class SecurityManager {
    private MessageQueue securityMessageQueue;
    
    private boolean canAccess(Securable target, Actor actor, Permission request){
        return false;
    }
    
    private boolean canAccess(Securable target, Actor actor, Integer requested){
        return false;
    }
    
    public boolean canRead (Securable target, Actor user){
        return canAccess(target, user, Permission.READ);
    } 
    public boolean canWrite (Securable target, Actor user){
        return canAccess(target, user, Permission.WRITE);
    }
    public boolean canLock (Securable target, Actor user){
        return canAccess(target, user, Permission.LOCK);
    }
    public boolean canDelete (Securable target, Actor user){
        return canAccess(target, user, Permission.DELETE);
    }
    public boolean canExecute (Securable target, Actor user){
        return canAccess(target, user, Permission.EXECUTE);
    }
    public boolean canAlterPermissions (Securable target, Actor user){
        return canAccess(target, user, Permission.ALTER_PERMISSIONS);
    }
    public boolean canTakeOwnership (Securable target, Actor user){
        return canAccess(target, user, Permission.TAKE_OWNERSHIP);
    }
    public boolean canSendMessage (Securable target, Actor user){
        return canAccess(target, user, Permission.SEND_MESSAGE);
    }
    public boolean canImpersonate (Securable target, Actor user){
        return canAccess(target, user, Permission.IMPERSONATE);
    }
    public boolean isOwner (Securable target, Actor user){
        return canAccess(target, user, Permission.OWNER);
    }
    public boolean isAdministrator (Securable target, Actor user){
        return canAccess(target, user, Permission.ADMINISTRATOR);
    }
    public boolean isAudited (Securable target, Actor user){
        return canAccess(target, user, Permission.AUDIT);
    }
    
    public boolean requestRead(Securable target, Actor user){
        return false;
    }
    public boolean requestWrite(Securable target, Actor user){
        return false;
    }
    
}
