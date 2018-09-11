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
 * This class encompasses all the historical data for the system. Including
 * debtor contacts, collector activities, client contact, system activities, user
 * activities, and others. A single history item can be associated with multiple
 * system entities (ie a debtor contact item is associated with the debtor, with
 * a collector if appropriate, and with a user, at the same time), and they can 
 * be filtered and arranged on those same criteria for reporting or auditing 
 * purposes. HistoryItem, is a separate class, and controls the mapping of 
 * entities to individual items.
 * @author Robert Serrano <wolfieca.rs@gmail.com>
 */
public class History implements Reportable{
    
}
