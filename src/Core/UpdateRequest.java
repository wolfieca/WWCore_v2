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
 * Update request. Some change has been made to the referring object and
 * needs to be committed, so that the change can be made visible to other users.
 * In light of multiple readers, subsequent attempts to lock the object for
 * writing will fail until the update has propagated (i.e. all current readers
 * have acknowledge the update and refreshed their own views of the object).
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class UpdateRequest extends Message{
    
}
