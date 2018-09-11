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
 * A single batch of new business. Contrary to the Wizard implementation, the
 * WolffeWare NewbizBatch is built as a parallel structure to normal newbiz. That
 * is, there are Debtor, Debt, Demographic, etc tables in the database and any
 * given entry in a NewbizBatch can be treated as a normal Debtor for the most
 * part (the biggest exception is the lack of a local account number, and the lack
 * of an independent message queue for the newbiz debtors, though the batch does
 * have a message queue).
 * @author Robert Serrano <wolfieca.rs@gmail.com>
 */
public class NewbizBatch implements Reportable, Securable{
    private Debtor nbizDebtor;
    
}
