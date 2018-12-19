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

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * A single user session. Classes use this to get information about the 
 * user requesting service. Instances of this object are created on user login 
 * and destroyed when the user logs off, or when the session is terminated. A user
 * can have multiple sessions open simultaneously, each looking at different
 * things. A Session can belong to only one User. A session can be identified by
 * an Actor:Username:SessionName triad in the Sessions object.
 * Each Session is assigned to a Thread on the client side, and may be assigned 
 * threads on the Server-side depending on need and availability. The session is
 * used to hold the security context for all requests. A Session impersonating 
 * another user does not affect any other session belonging to the real user, so
 * if Actor1:User1:Session1 is impersonating User2, :Session2 will run as User1. 
 * Note that impersonations are always logged by the system
 * @author Robert Serrano (wolfieca.rs at gmail.com).
 */
public class Session extends WWObject implements Runnable{
    private String sessionName;
    private WWSystem owningSystem;
    private User sessionOwner;
    private User sessionUser;
    private Set<WWObject> readLocks;
    private Set<WWObject> writeLocks;
    private transient MessageQueue sessionMessageQueue;
    
    
    
    @Override
    public void run(){
        
    }

    /**
     *
     * @return
     */
    @Override
    public WWObject init() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param name
     * @param ownerSys
     * @param owner
     * @param user
     */
    protected void init(String name, WWSystem ownerSys, User owner, User user){
        sessionName = name;
        owningSystem = ownerSys;
        sessionOwner = owner;
        sessionUser = user;
        readLocks = new HashSet<>();
        writeLocks = new HashSet<>();
        sessionMessageQueue = new MessageQueue();
    }
    
    protected void init(User owner, User user, WWSystem ownerSys){
        
    }
    
    private String genSessionName(User owner, User user){
        return owner.getUserName()+":"+user.getUserName()+":Session-"+
                LocalDateTime.now();
    }
    
    /**
     *
     * @return
     */
    public String sessionName(){
        return sessionName;
    }
    
    /**
     * Destroy this session.
     */
    public void destroy(){
        
    }
    
}
