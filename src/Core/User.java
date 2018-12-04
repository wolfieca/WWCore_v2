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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A user on the system. This is the basic security context for the system,
 * and is used to determine access to various bits of functionality. Everything
 * that happens in the system is done by Users. Services run as Users and even
 * have their own Sessions. This allows for fine-grained control and accounting,
 * and facilitates a separate sand-boxing model for modules and the like (which 
 * operate as a particular user, and can be restricted as that user).
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */


public class User  extends Actor implements Reportable, Securable{
    private String userName;
    private String userID;
    //A list of groups this user belongs to. Groups are basically users, except 
    //they do not have sessions (they are not active parts of the system).
    private Set<Group> supplementaryGroups;
    // The rights this user has.
    private Rights userRights;   
    private User effUser;   // Used by System Administrators to act as if they
                            // were another user. Programs may choose to ignore
                            // this security context and operate only as the 
                            // actual user, at their own discretion.

    private boolean canWorkOffHours;
    private Long lastMessageID;
    // What modules is this user allowed to access?
    private HashMap<String, Boolean> moduleAccess; 
    // Active sessions that belong to this user.
    private Sessions sessions;
    // The user's history on the system. 
    private History activity;
    // The user's primary message queue.
    private MessageQueue userMessageQueue;
    // Supplemental message queue the user can access.
    private Set<String> supplementalMessageQueues;

    /**
     * Create a new default user
     * @param id
     */
    public User(long id) {
        super(id);
        this.userName = "";
        this.userID = "";
        this.supplementaryGroups = new HashSet();
        this.userRights = null;
        this.canWorkOffHours = false;
        this.moduleAccess = new HashMap();
        this.lastMessageID=Long.valueOf(0);
    }

    /**
     * Create a user with the specified access token.
     * @param token
     */
    public User (String token){
        
    }

    /**
     * Create a user with the specified username and password.
     * @param userName
     * @param password
     */
    public User (String userName, String password){
        
    }

    /**
     *
     * @param caller
     * @return
     */
    @Override
    public Report produceReportFor(Session caller) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param caller
     * @return
     */
    @Override
    public Report produceReportFor(User caller) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, Object> reportParameters() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reportParameters(Map<String, Object> parameters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Get the current user's username.
     * @return
     */
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @param userName
     */
    protected void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     *
     * @return
     */
    public String getUserID() {
        return userID;
    }

    /**
     *
     * @return
     */
    public String getMessageID(){
        lastMessageID++;
        return this.userName+this.lastMessageID.toString();
    }
    /**
     *
     * @param userID
     */
    protected void setUserID(String userID) {
        this.userID = userID;
    }


    /**
     *
     * @return
     */
    public Set<Group> getSupplementaryGroups() {
        return supplementaryGroups;
    }

    /**
     *
     * @param supplementaryGroups
     */
    protected void setSupplementaryGroups(Set<Group> supplementaryGroups) {
        this.supplementaryGroups = supplementaryGroups;
    }

    /**
     *
     * @return
     */
    public Rights getUserRights() {
        return userRights;
    }

    /**
     *
     * @param userRights
     */
    protected void setUserRights(Rights userRights) {
        this.userRights = userRights;
    }


    /**
     *
     * @return
     */
    public int getWorkHours() {
        return 0;
        //return this.getUserRights().getHours(userID);
    }


    /**
     *
     * @return
     */
    public boolean getCanWorkOffHours() {
        return canWorkOffHours;
    }

    /**
     *
     * @param canWorkOffHours
     */
    protected void setCanWorkOffHours(boolean canWorkOffHours) {
        this.canWorkOffHours = canWorkOffHours;
    }

    /**
     *
     * @return
     */
    public HashMap<String, Boolean> getModuleAccess() {
        return moduleAccess;
    }

    /**
     *
     * @param moduleAccess
     */
    protected void setModuleAccess(HashMap<String, Boolean> moduleAccess) {
        this.moduleAccess = moduleAccess;
    }
    
    /**
     *
     * @return
     */
    public String UserName(){
        return this.userName;
    }

    /**
     *
     * @param username
     */
    protected void UserName(String username){
        this.userName = username;
    }

    /**
     *
     * @return
     */
    public String UserID(){
        return this.userID;
    }

    /**
     *
     * @param userid
     */
    protected void UserID(String userid){
        this.userID = userid;
    }


    /**
     *
     * @return
     */
    public Set SupplementaryGroups(){
        return this.supplementaryGroups;
    }

    /**
     *
     * @param supplementarygroups
     */
    protected void SupplementaryGroups(Set supplementarygroups){
        this.supplementaryGroups = supplementarygroups;
    }

    /**
     *
     * @return
     */
    public Rights UserRights(){
        return this.userRights;
    }

    /**
     *
     * @param userRights
     */
    protected void UserRights(Rights userRights){
        this.userRights = userRights;
    }
    
    /**
     *
     * @return
     */
    public int loginUser(){
        return 0;
    }
    
    /**
     *
     * @return
     */
    public String genToken(){
        return "";
    }
    
    /**
     *
     * @param object
     * @param access
     * @return
     */
    public int request(Object object, int access){
        return 0;
    }
    
    /**
     *
     * @param rightName
     * @return
     */
    public Boolean hasRight(String rightName){
        return false;
        //return userRights.hasRight(rightName);
    }
}
