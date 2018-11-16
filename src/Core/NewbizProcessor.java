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
 * A module designed to translate a supplied data file into one or more NewbizBatch
 * objects. Each NewbizProcessor has zero or more clients that it can be explicitly
 * attached to, or it can register some header layout patterns with the Newbiz
 * object to hopefully allow for automatic detection of the correct one to call.
 * The base NewbizProcessor is designed to allow a map file to be submitted to
 * it as well as the data file to specify a generic means of translating the data
 * file provided, for those cases where the client data is fairly well-behaved.
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class NewbizProcessor extends DataImporter 
        implements Reportable{
    
}
