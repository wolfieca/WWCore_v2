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
 * A NewbizDebtor is an individual Newbiz entry. It is derived from the Debtor
 * class because, for all intents and purposes, it should behave like a Debtor,
 * except separated from all the actual debtors on the system. Ultimately, this
 * should simplify the newbiz import process as, once they've been approved, the 
 * individual NewbizDebtor objects can be re-cast as Debtor objects and allowed to
 * propagate into the system passively (ie NewbizBatch creates Debtor objects
 * for the NewbizDebtors).
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class NewbizDebtor extends Debtor{
    
}
