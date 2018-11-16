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
import java.util.Set;

/**
 * State Rights is a list of various characteristics for states.
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class StateRights extends WWObject{
    private HashMap<String,Boolean> rights;
    private Set<String> validRights;
    
    public StateRights(){
        rights = new HashMap<>();
        rights.put("Restricted State", false);
        validRights = new HashSet<>();
        validRights.add("Restricted State");
    }
    
    protected void setRights(HashMap<String,Boolean> rightsMap){
        validRights = rightsMap.keySet();
        
        rights = rightsMap;
    }

    @Override
    protected WWObject init() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
