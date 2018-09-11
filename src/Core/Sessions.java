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

/**
 * Sessions is a list of all the currently active Session objects on the system.
 * Each Session is tied to a specific User. A Sessions object will usually be
 * attached to a System object. A Session will also contain a WWClient object,
 * that is the client-side of the communication process. 
 * @author rserrano
 */
public class Sessions implements Reportable, Securable {
    
}
