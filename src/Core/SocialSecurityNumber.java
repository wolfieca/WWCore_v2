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
 * A Social Security Number. This is fairly self-explanatory. This class provides
 * functionality to manage, format, validate and display Social Security Numbers.
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class SocialSecurityNumber {
    private Integer ssn;
    
    public SocialSecurityNumber(int ssn) {
        this.ssn = ssn;
    }
    @Override
    public String toString(){
        return group1()+"-"+group2()+"-"+group3();
    }
    /**
     * Validates a given SSN, using the current valildation rules.
     * A valid social security number cannot:
     * Contain all zeroes in any group (000-xx-xxxx, xxx-00-xxxx, xxx-xx-0000)
     * Begin with '666'
     * Begin with a value in the range 900-999
     * Be 078-05-1120 (Woolworth's wallet)
     * Be 219-09-9999 (SSA Advert number)
     * @return true if the SSN has a valid value.
     */
    public boolean validate(){
        boolean valid = true;
        valid = (!group1().equals("000") && !group2().equals("00") && 
                !group3().equals("0000") && !group1().equals("666") && 
                ssn<900000000 && !this.toString().equals("078-05-1120") &&
                !this.toString().equals("219-09-9999"));
        return valid;
    }
    
    private String group1(){
        String test = String.format("%9d", ssn.toString());
        return test.substring(0,2);  
    }
    private String group2(){
        String test = String.format("%9d", ssn.toString());
        return test.substring(3,4);
    }
    
    private String group3(){
        String test = String.format("%9d", ssn.toString());
        return test.substring(5);
    }
    /**
     * Validates a given SSN.
     * @param ssn
     * @return
     */
    public static Boolean validate(int ssn){
        return new SocialSecurityNumber(ssn).validate();
    }

    /**
     * Returns a formatted ssn string.
     * @param ssn
     * @return
     */
    public static String toString(int ssn){
        return new SocialSecurityNumber(ssn).toString();
    }
}
