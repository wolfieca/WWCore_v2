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
 * This is a System document. Documentation, Letters, Contracts and similar items
 * go here. Basically, Document is a catch-all for any sort of reference or 
 * historical record (ie renditions of letters that have been sent to debtors,
 * Contracts and agreements signed by Clients, etc). This includes both generated
 * (letters, contracts, documentation) documents, and scanned images (ie signed
 * Contracts, returned Letters, etc).
 * Note that, for the purposes of consistency and likely convenience, Documents
 * are stored as XML documents. Printing and displaying the documents is the work 
 * other support objects 
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class WWDocument extends WWObject{

    /**
     *
     * @return
     */
    @Override
    protected WWObject init() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
