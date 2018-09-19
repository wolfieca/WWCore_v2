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

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Set;

/**
 * WizardImporter is an DataImporter class designed to import data from the
 * Wizard System software by PSSI. This is primarily an OpenVMS package that 
 * relies heavily on features of the OpenVMS RMS facility. There are many parts of
 * the Wizard System's design (and the RMS structure itself) that are just a
 * pain in the butt to work around when it comes to migrating to other platform,
 * which is why this is a separate class. This is a smart import process. It
 * takes known information about the data being brought in and breaks things up
 * to fit within the Wolffe schema. 
 * To hopefully speed things along here, the WizardImporter builds the appropriate
 * objects in memory, putting everything together as it encounters them, 
 * serializing incomplete ones when memory constraints require it
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class WizardImporter extends DataImporter {
    private String searchPath;
    private Set<String> includeFiles;
    private Set<String> dataFiles;
    
    private class FixedWidthFile{
        
    }
    private class VariableWidthFile{
        
    }
    private Connection databaseConnection;
    private FileInputStream inputStream;
    
    /**
     *
     */
    public void importData() {
        
    }
    private void importSystem(){
        
    }
    private void importDebtor(){
        
    }
    private void importDebt(){
        
    }
    private void importDemographics(){
        
    }
    private void importSupplementalData(){
        
    }
    private void importSchedule(){
        
    }
    private void importClient(){
        
    }
    private void importUser(){
        
    }
    private void importStatistics(){
        
    }
    private void importHistory(){
        
    }
    private void importActivity(){
        
    }
    private void importReport(){
        
    }
    private void importPayments(){
        
    }
    private void importFeeSchedule(){
        
    }
    private void importLegal(){
        
    }
    private void importLetters(){
        
    }
    private void importLetterSeries(){
        
    }
    private void importOffice(){
        
    }
    private void importCompany(){
        
    }
    private void importNewbiz(){
        
    }
    private void migrateStrategies(){
        
    }

    /**
     *
     */
    public void commit(){
        
    }
}
