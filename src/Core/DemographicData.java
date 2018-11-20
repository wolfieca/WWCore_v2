/*
 * Copyright (C) 2018 Robert
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

import java.util.HashMap;
import java.util.Map;

/**
 * Demographic Data for a debtor. This is intended for core demographic fields,
 * such as Dates of Birth, SSN (for companies operating in the United States), 
 * name, address, etc. Other demographic fields may be specified by the Company,
 * but data that goes too much further out than these should probably be placed 
 * in the SupplementalData object. Because they are somewhat central characteristics
 * of a Debtor, Demographic data have more access restrictions than do 
 * SupplementalData (ie a SSN should rarely ever change, but a person's Insurance
 * carrier can change relatively frequently).
 * Implementation-wise, demographics, supplemental and legal data are accessed 
 * through a unified API, since they are all deliberately similar in structure.
 * This way a user doesn't need to know what kind of data they're looking for,
 * they just specify that they're looking for SSN (for example) and it gets
 * handled automatically by the system
 * @author Robert
 */
public class DemographicData extends WWObject implements Reportable{
    HashMap <String, HashMap<String,DemographicField>> fields;

    /**
     *
     * @return
     */
    @Override
    protected WWObject init() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param caller
     * @return
     */
    @Override
    public Report produceReportFor(Session caller) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param caller
     * @return
     */
    @Override
    public Report produceReportFor(User caller) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, Object> reportParameters() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reportParameters(Map<String, Object> parameters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
