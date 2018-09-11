/*
 * Copyright (C) 2018 rserrano
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
 * An ACH transaction. These are Automated Clearing House records and can be
 * produced either as a result of payment activity (payments made by a debtor),
 * or as a result of invoice reporting activity (i.e. payments made to a client).
 * We can also receive them back as a result of failures (i.e. NSF, Closed 
 * Accounts, Blocked, etc), though that primarily affects the first variety.
 * Unlike checks, ACH transactions can be either incoming or outbound (either
 * we are crediting a client's account or we are debiting a debtor's account). As
 * such, the type of an individual transaction will have to be specified on 
 * creation, so that they end up in the correct ACHFile object before being sent
 * to the bank.
 * Security Note: ACH is only creatable/modifiable from ACHFile. So, adding, 
 * deleting or modifying an ACH requires that the user have the required 
 * permission set in ACHFile.
 * @author rserrano
 */
public class ACH extends WWDocument implements Reportable, Securable {
    
}
