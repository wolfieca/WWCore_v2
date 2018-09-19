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
 * Classes implementing the Reportable interface can export their data in a 
 * report format to either a printed document (straight text output) or an XML
 * stream so that the data can be formatted (and redacted, as needed) to be
 * sent to a printer. The first form is useful if the user just wants to see the
 * data on the screen, while the second for is useful to produce reports suitable
 * to be sent to Clients (or potential clients). A related XML specification for
 * the report class and a set of XSLT files to transform the report files will 
 * be provided, and the Form class operates as the interface to all this.
 * The exact details of the export format are left to the individual implementing
 * classes as far as what data is exported and, for the pure text export, the
 * layout of the text. The XML export is basically unformatted, with all layout
 * decisions being left up to the Report class (or other implementer of the 
 * iReport interface).
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public interface Reportable {
    
}
