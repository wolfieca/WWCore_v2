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
 * An AccessDeniedException gets thrown when inappropriate access to an object
 * is requested.
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class AccessDeniedException extends Exception {

    /**
     * Creates a new instance of <code>AccessDeniedException</code> without
     * detail message.
     */
    public AccessDeniedException() {
    }

    /**
     * Constructs an instance of <code>AccessDeniedException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public AccessDeniedException(String msg) {
        super(msg);
    }
}
