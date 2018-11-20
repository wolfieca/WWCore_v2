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
    
    /**
     *
     * @param target
     * @param user
     * @return
     */
    public boolean canRead (Securable target, Actor user){
        return canAccess(target, user, Permission.READ);
    } 

    /**
     *
     * @param target
     * @param user
     * @return
     */
    public boolean canWrite (Securable target, Actor user){
        return canAccess(target, user, Permission.WRITE);
    }

    /**
     *
     * @param target
     * @param user
     * @return
     */
    public boolean canLock (Securable target, Actor user){
        return canAccess(target, user, Permission.LOCK);
    }

    /**
     *
     * @param target
     * @param user
     * @return
     */
    public boolean canDelete (Securable target, Actor user){
        return canAccess(target, user, Permission.DELETE);
    }

    /**
     *
     * @param target
     * @param user
     * @return
     */
    public boolean canExecute (Securable target, Actor user){
        return canAccess(target, user, Permission.EXECUTE);
    }

    /**
     *
     * @param target
     * @param user
     * @return
     */
    public boolean canAlterPermissions (Securable target, Actor user){
        return canAccess(target, user, Permission.ALTER_PERMISSIONS);
    }

    /**
     *
     * @param target
     * @param user
     * @return
     */
    public boolean canTakeOwnership (Securable target, Actor user){
        return canAccess(target, user, Permission.TAKE_OWNERSHIP);
    }

    /**
     *
     * @param target
     * @param user
     * @return
     */
    public boolean canSendMessage (Securable target, Actor user){
        return canAccess(target, user, Permission.SEND_MESSAGE);
    }

    /**
     *
     * @param target
     * @param user
     * @return
     */
    public boolean canImpersonate (Securable target, Actor user){
        return canAccess(target, user, Permission.IMPERSONATE);
    }

    /**
     *
     * @param target
     * @param user
     * @return
     */
    public boolean isOwner (Securable target, Actor user){
        return canAccess(target, user, Permission.OWNER);
    }

    /**
     *
     * @param target
     * @param user
     * @return
     */
    public boolean isAdministrator (Securable target, Actor user){
        return canAccess(target, user, Permission.ADMINISTRATOR);
    }

    /**
     *
     * @param target
     * @param user
     * @return
     */
    public boolean isAudited (Securable target, Actor user){
        return canAccess(target, user, Permission.AUDIT);
    }
    
    /**
     *
     * @param target
     * @param user
     * @return
     */
    public boolean requestRead(Securable target, Actor user){
        return false;
    }

    /**
     *
     * @param target
     * @param user
     * @return
     */
    public boolean requestWrite(Securable target, Actor user){
        return false;
    }
    
}
