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
 * A single user session. Classes use this to get information about the 
 * user requesting service. Instances of this object are created on user login 
 * and destroyed when the user logs off, or when the session is terminated. A user
 * can have multiple sessions open simultaneously, each looking at different
 * things. A Session can belong to only one User. A session can be identified by
 * an Actor:Username:SessionName triad in the Sessions object.
 * Each Session is assigned to a Thread on the client side, and may be assigned 
 * threads on the Server-side depending on need and availability. The session is
 * used to hold the security context for all requests. A Session impersonating 
 * another user does not affect any other session belonging to the real user
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class Session implements Runnable{
    private User sessionOwner;
    
    @Override
    public void run(){
        
    }
}
