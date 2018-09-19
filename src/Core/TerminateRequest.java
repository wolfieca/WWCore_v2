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
 * Employee has been terminated, includes date of termination, reasons, etc.
 * Automatically locks user's account on the system. If employee has a queue 
 * associated with them, or is a Collector, the queue may be distributed among
 * other users, or it may just be made inactive, with all messages just staying
 * in the queue until they expire or are set to requeue. New messages will not
 * be place in the Employee's user queue, and will either be silently redirected
 * to an active queue or produce an error message on the sender's end.
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class TerminateRequest {
    
}
