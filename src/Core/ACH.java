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
 * @author rserrano
 */
public class ACH extends WWDocument {
    
}
