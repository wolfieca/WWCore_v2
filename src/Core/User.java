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

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A user on the system
 * @author Robert Serrano <wolfieca.rs@gmail.com>
 */


public class User  extends Actor{
    private String userName;
    private String userID;
    private Group primaryGroup;
    private ArrayList<Group> supplementaryGroups;
    private Rights userRights;   
    private User effUser;    // Used by System Administrators to act as if they
                            // were another user. Programs may choose to ignore
                            // this security context and operator only as the 
                            // actual user, at their own discretion.

    private boolean canWorkOffHours;
    private HashMap<String, Boolean> moduleAccess; 

    /**
     * Create a new default user
     * @param id
     */
    public User(long id) {
        super(id);
        this.userName = "";
        this.userID = "";
        this.primaryGroup = null;
        this.supplementaryGroups = new ArrayList();
        this.userRights = null;
        this.canWorkOffHours = false;
        this.moduleAccess = new HashMap();
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
     * @param userID
     */
    protected void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     *
     * @return
     */
    public Group getPrimaryGroup() {
        return primaryGroup;
    }

    /**
     *
     * @param primaryGroup
     */
    protected void setPrimaryGroup(Group primaryGroup) {
        this.primaryGroup = primaryGroup;
    }

    /**
     *
     * @return
     */
    public ArrayList<Group> getSupplementaryGroups() {
        return supplementaryGroups;
    }

    /**
     *
     * @param supplementaryGroups
     */
    protected void setSupplementaryGroups(ArrayList<Group> supplementaryGroups) {
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
        return this.getUserRights().getHours(userID);
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
    public Group PrimaryGroup() {
        return this.primaryGroup;
    }

    /**
     *
     * @param primarygroup
     */
    protected void PrimaryGroup(Group primarygroup){
        this.primaryGroup = primarygroup;
    }

    /**
     *
     * @return
     */
    public ArrayList SupplementaryGroups(){
        return this.supplementaryGroups;
    }

    /**
     *
     * @param supplementarygroups
     */
    protected void SupplementaryGroups(ArrayList supplementarygroups){
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
        return userRights.hasRight(rightName);
    }
}
