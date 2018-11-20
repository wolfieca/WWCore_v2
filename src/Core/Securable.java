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
 * Classes implementing the Securable interface are designed to interact with 
 * the SecurityManager.
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public interface Securable {
    //Request read access to the object

    /**
     *
     * @param requester
     * @return
     */
    public boolean requestRead(Session requester);
    //Request write access to the object

    /**
     *
     * @param requester
     * @return
     */
    public boolean requestWrite(Session requester);
    //Request access to the object

    /**
     *
     * @param requester
     * @param requested
     * @return
     * @throws InvalidPermissionsException
     */
    public boolean requestAccess(Session requester, Permission requested) 
            throws InvalidPermissionsException;
    //Relinquish access to the object.

    /**
     *
     * @param requester
     * @return
     */
    public boolean relinquishRead(Session requester);

    /**
     *
     * @param requester
     * @return
     */
    public boolean relinquishWrite(Session requester);
    //Relinquish all access to the object.

    /**
     *
     * @param requester
     * @return
     */
    public boolean relinquishAccess(Session requester);
    
}
