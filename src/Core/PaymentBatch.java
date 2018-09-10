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
 * A batch of payments to apply to system accounts, either debtor or client. A
 * typical batch will include multiple payments of one type/direction. The
 * PaymentBatch object is used to hold payments prior to approval for disbursal 
 * to the permanent Ledger object (they are attached to the appropriate
 * Debtor, Debt and Client objects immediately, though the batch can be deleted
 * prior to being balanced and processed
 * @author Robert Serrano <wolfieca.rs@gmail.com>
 */
public class PaymentBatch {
    
}
