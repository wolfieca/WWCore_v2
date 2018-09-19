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
 * Supplemental Data is non-demographic data belonging to a debtor. This
 * includes data like Insurance Carrier (which may, instead be considered 
 * DemographicData), letters that have been sent to the debtor by the Company,
 * notes on the Debtor, Itemized Statements, if available, AKAs (if applicable), 
 * etc. It can also be used for medical-record specific information (blood-type,
 * etc), for Companies dealing with medical records.
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class SupplementalData implements Reportable, Securable{
    
}
