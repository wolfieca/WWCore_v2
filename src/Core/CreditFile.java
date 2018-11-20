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
 * CreditFile is a utility class designed to allow for the management and testing
 * of exported Credit File data (eg a Metro2 file produced by CreditFileExport).
 * A CreditFileExport can be targeted at a CreditFile to allow statistics from
 * the produced file to be read, and to allow individual records withing the
 * CreditFileExport to be looked at.
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class CreditFile extends WWObject {
    CreditFileExport creditFile;

    /**
     *
     * @return
     */
    @Override
    protected WWObject init() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
