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
 * DebtorCache is a potential speed optimization, to allow frequently-accessed
 * Debtor objects to be retained in memory instead of being saved and freed. This
 * is currently just a thought, and it may not actually be a part of the final
 * Core product. 
 * Implementation: Singleton object. Debtors are added to the cache as they are
 * referenced and freed when conditions require it (i.e. when memory becomes too 
 * tight).
 * @author Robert Serrano <wolfieca.rs@gmail.com>
 */
public class DebtorCache {
    
}
