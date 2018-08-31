/*
 * Copyright (C) 2018 Robert Serrano <wolfieca.rs@gmail.com>
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
 * This message is produced in response to an employee resigning. This is treated
 * as a ActionMessage, and the employee is frozen until the message has been 
 * dealt with (either by being accepted by a Supervisor or the Company, or by
 * being rejected). In the event that the resignation is accepted, the resignation
 * sets off a cascade of related end-of-employment activities (i.e. check-in of
 * all checked-out equipment, deactivation of the employee's accounts, disbursing
 * of the employee's queue, determination of the employee's rehire status, etc).
 * @author Robert Serrano <wolfieca.rs@gmail.com>
 */
public class Resignation extends ActionMessage{
    
}
