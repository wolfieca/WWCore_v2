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
 * Thrown when a change has been attempted on a locked item (typically a debtor).
 * In WolffeWare, Debtors and Debts are the primary lockable objects, and the
 * locking mechanism is fairly fine tuned. This particular exception is thrown 
 * when someone attempts to change something that has been explicitly locked
 * for the target object (ie Debts can have interest locked if they are included
 * in certain legal actions).
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class LockedItemException extends Exception {

    /**
     * Creates a new instance of <code>LockedItemException</code> without detail
     * message.
     */
    public LockedItemException() {
    }

    /**
     * Constructs an instance of <code>LockedItemException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public LockedItemException(String msg) {
        super(msg);
    }
}
