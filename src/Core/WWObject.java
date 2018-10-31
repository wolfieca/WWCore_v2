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
 * Base class for the WolffeWare system object. The base security model comes
 * from this class.
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public abstract class WWObject implements Securable{
    private AccessControlList acl;
    private Sessions readers;
    private Session writer;
    
    protected boolean requestAccess(Permission requested) 
            throws InvalidPermissionsException{
        return this.acl.requestAccess(requested);
    }
    
    /**
     * Try to determine which session is seeking access to this object.
     * @return 
     */
    protected Session getSession(){
        return null;
    }
    
    protected boolean requestRead(){
        if(this.acl.requestAccess(new Permission(false,Permission.READ))) {
            
        }
        return false;
    }
    
    protected boolean requestWrite(){
        return this.acl.requestAccess(new Permission(false,Permission.WRITE_ACCESS));
    }
    
    protected WWObject(){
        
    }
    protected abstract WWObject init();
}
