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

import java.util.Set;

/**
 * A grouping of Clients. Specifically designed to facilitate campaigns that are 
 * meant to work on debtors that belong to specific groups of clients, as opposed
 * to single clients. Can be defined on an ad hoc basis, and clients may belong 
 * to multiple groups
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class ClientGroup extends WWObject{
    private String groupName;
    private Set<Client> clientGroup;

    @Override
    protected WWObject init() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
