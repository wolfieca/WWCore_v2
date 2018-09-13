/*
 * Copyright (C) 2018 rserrano
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

/**
 * Role defines a user role in the system. A role works like a template for new
 * users, allowing for a set of default permissions, groups, rights, etc to be 
 * assigned at one time. A user's role is also a part of their security context
 * and can be used to allow extra activities under certain circumstances or just
 * to all for a user's permissions to be reset according to their role.
 * @author rserrano
 */
public class Role {
    private String roleName;
    private Rights roleRights;
    private ArrayList<Group> roleGroups;
    
    /**
     *
     */
    public Role (){
        roleName = "";
        roleRights=null;
        roleGroups = new ArrayList<>();
    }
    
    /**
     *
     * @param roleName
     * @return
     */
    public Role get (String roleName){
        return null;
    }
    
   
}
