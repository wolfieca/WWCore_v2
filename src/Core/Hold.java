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
 * A Hold is a special kind of Message. It is characterized by having the highest
 * normal priority available to messages, for being released without delay, and 
 * for simply expiring at a certain point in time (optionally leaving a Reminder
 * to commemorate its passing). A Hold effectively pauses a message queue until
 * either it expires or it is removed by a user with the required privileges). 
 * While the hold is active, objects controlled by the queue will do nothing (with
 * the exception of sending letters as a result of a Letter Series, or messages
 * sent with a higher priority). Alternatively, a Hold can be conditional, expiring
 * when a certain even occurs (ie Hold lasts until the debtor calls or makes a
 * payment). Holds can also be used at the system level to effectively lock a Debtor
 * until some occurrence can be investigated. A Hold can also be placed on a User
 * queue to prevent the scheduler from scheduling things during a particular period
 * of time, or to cause previously scheduled events to be moved to other dates. 
 * This last use is obviously available only to Supervisor or Manager users (the 
 * latter only if the queue owner reports to them)
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class Hold extends Message{
    
}
