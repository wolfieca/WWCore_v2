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
 * DataImporter is the base for all data import functionality. A primary use of
 * this class and its descendants is to provide migration services. Secondarily,
 * DataImporter is the base for the NewbizProcessor classes. This class takes an
 * XML description file that details what files contain what data and where that
 * data should be placed. 
 * @author rserrano
 */
public class DataImporter extends Module implements Reportable, Securable{
    
}
