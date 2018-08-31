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
 * A WorkOrder is a multi-part message that indicates that a compound task has
 * been requested. The requirements for the WorkOrder to be completed are
 * contained within the WorkOrder, as well as who has been assigned to complete 
 * them, what the deadline is, and what their current status is. Because of their
 * nature WorkOrders are ActionMessages (they stay in the queue of the current
 * responsible party until they've been addressed).
 * @author Robert Serrano <wolfieca.rs@gmail.com>
 */
public class WorkOrder {
    
}
