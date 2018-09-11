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
 * An ACHFile contains a batch of ACH objects (individual transactions). ACHFile
 * provides the means to examine individual transactions, to delete selected ACH
 * transactions from the file, approve the file (producing an actual ACH file that
 * can be sent to a bank), etc.
 * Security for both ACHFile and individual ACH objects is provided by ACHFile. A
 * user without permissions to change ACHFile cannot do anything to its ACH
 * objects beyond getting information about them. Once an ACHFile is created (at
 * which time, all pending ACH transactions are created and added to it), no one
 * can change the included ACH transactions unless they have CHANGE permission on
 * the ACHFile object. Processes can add ACH transactions until the ACHFile is 
 * closed, at which it produces the appropriate file and sends it out.
 * @author rserrano
 */
public class ACHFile implements Reportable, Securable{
    
}
