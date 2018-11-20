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
 * This is a base Credit File exported in the standard format (currently Metro2)
 * for submission to the major credit repositories.
 * A CreditFile instance iterates over all debtors (or a specific subset of them), 
 * and then requests those debtors to return Metro2-format data for each 
 * applicable debt. Debtors have limited control over this process, though the 
 * individual debts do ultimately determine whether or not they get reported and 
 * how.
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class CreditFileExport extends WWObject {

    /**
     *
     * @return
     */
    @Override
    protected WWObject init() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
