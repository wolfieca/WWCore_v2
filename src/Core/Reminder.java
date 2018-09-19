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
 * A Reminder is literally what its name implies. It's a reminder that is scheduled
 * to be sent to a specific queue at a particular time in the future. Like a Hold,
 * a Reminder gets placed in a queue at a relatively high priority, but it's set
 * to send at a particular time in the future, rather than immediately. The primary
 * target of a Reminder is a Collector or other User-related
 * queue, whereas Holds mainly target Debtor queues, so the actions of either 
 * can differ greatly in practice.
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class Reminder extends Message{
    
}
