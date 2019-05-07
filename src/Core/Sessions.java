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
import java.util.Map;

/**
 * Sessions is a list of all the currently active Session objects on the system.
 * Each Session is tied to a specific User. A Sessions object will usually be
 * attached to a System object. A Session will also contain a WWClient object,
 * that is the client-side of the communication process. 
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class Sessions extends WWObject implements Reportable {

    /**
     * Default init me
     * @return
     */
    @Override
    protected WWObject init() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private Map<Actor,Map<Actor,Session>> systemSessions;

    /**
     * Produce report for the calling Session.
     * @param caller
     * @return
     */
    @Override
    public Report produceReportFor(Session caller) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Produce a report on behalf of the calling User.
     * @param caller
     * @return
     */
    @Override
    public Report produceReportFor(User caller) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Get the current report parameters.
     * @return
     */
    @Override
    public Map<String, Object> reportParameters() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Set the parameters for reports (i.e. page size, DPI, color support,
     * etc). This affects reports produced on behalf of this Session.
     * @param parameters
     */
    @Override
    public void reportParameters(Map<String, Object> parameters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Return the current Session (the Session controlling the current thread.
     * @return
     */
    public Session getCurrentSession(){
        return null;
    }
    
    /**
     * Add an existing Session to this Sessions object
     * @param newSession
     * @return
     */
    public boolean addSession (Session newSession){
        return false;
    }
    
    /**
     * Create a Session with the specified name
     * @param user
     * @param sessionName
     * @return
     */
    public boolean createSession (Actor user,String sessionName){
        return false;
    }

    /**
     * Create a default Session for the user.
     * @param user
     * @return
     */
    public boolean createSession (Actor user){
        return false;
    }
    
    /**
     * Destroy the specified session, freeing up all the held locks, closing
     * any open objects, and giving the user the opportunity to  update any 
     * objects that have been changed.
     * @param user
     * @param sessionName
     * @return
     */
    public boolean endSession (Actor user, String sessionName){
        return false;
    }

    /**
     * Destroys the specified User's sessions, freeing up all held locks and,
     * ultimately, destroying the security context for the user (i.e. log the
     * User out of the system). This is a graceful Session Termination, allowing
     * the User to save any changes to objects that are currently held.
     * @param user
     * @return
     */
    public boolean endSession (Actor user){
        return false;
    }
    
    /**
     * Terminates the specified Session. This is a more aggressive process than
     * endSession. While it still unlocks held objects (decreasing reference
     * counts, etc), it will automatically revert any uncommitted database
     * changes and will not bother asking the user to save any changes. This
     * is, obviously, designed as a last-ditch measure
     * @param actor
     * @param sessionName
     * @return
     */
    public boolean terminateSession(Actor actor, String sessionName ){
        return false;
    }

    /**
     * Terminates all a User's Sessions. See above for more details.
     * @param actor
     * @return
     */
    public boolean terminateSession(Actor actor){
        return false;
    }
    
}
