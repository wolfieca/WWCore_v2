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
 * A map of the locations of devices in a Company's Office. This is basically a
 * grid representing the layout of the physical building in which the office is 
 * located. Multiple offices may share the same OfficeMap for offices that
 * are located in the same building. The primary use of OfficeMap is to help in
 * determining priorities for printers and similar devices. So if a user is right
 * next to a printer that is offline, the OfficeMap can be used to determine the
 * next best printer to print their jobs to. Terminals will be assigned to their
 * own locations on the map, and any user logging in will be assigned to a default
 * printer based on the location of their terminal within the office.
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class OfficeMap {
    
}
