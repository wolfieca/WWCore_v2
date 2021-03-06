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
 * A security group. A group is like a user in many ways. A user can be a member
 * of one or more groups. A group has no real security context on its own, it just
 * provides a single point to control access to system object on a less-granular-
 * than-individual user level
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */


public class Group extends Actor {
    private String groupName;
    private String groupID;

    /**
     * @return the groupName
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * @return the groupID
     */
    public String getGroupID() {
        return groupID;
    }

    /**
     * @param groupName the groupName to set
     */
    protected void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * @param groupID the groupID to set
     */
    protected void setGroupID(String groupID) {
        this.groupID = groupID;
    }
    
    
}

