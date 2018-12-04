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
    
    /**
     *
     * @param requester
     * @param requested
     * @return
     * @throws InvalidPermissionsException
     */
    @Override
    public boolean requestAccess(Session requester, WWPermission requested) 
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
    
    /**
     *
     * @param requester
     * @return
     */
    @Override
    public boolean requestRead(Session requester){
        if(this.acl.requestAccess(WWPermission.init(WWPermission.READ))) {
            readers.addSession(requester);
        }
        return false;
    }
    
    /**
     *
     * @param requester
     * @return
     */
    @Override
    public synchronized boolean requestWrite(Session requester){
        if ( writer == null && acl.requestAccess(
                WWPermission.init(WWPermission.WRITE_ACCESS))){            
                writer = requester;
                return true;
        }
        return this.acl.requestAccess(WWPermission.init(WWPermission.WRITE_ACCESS));
    }

    /**
     *
     * @param requester
     * @return
     */
    @Override
    public boolean relinquishRead(Session requester) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param requester
     * @return
     */
    @Override
    public synchronized boolean relinquishWrite(Session requester) {
        if ( writer == requester && writer != null ){
            writer = null;
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param requester
     * @return
     */
    @Override
    public synchronized boolean relinquishAccess(Session requester) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    //public boolean requestAccess(WWPermission requested){
    //    return this.acl.requestAccess(requested);
    //}

    /**
     *
     */
    
    protected WWObject(){
        
    }

    /**
     *
     * @return
     */
    protected abstract WWObject init();
}
