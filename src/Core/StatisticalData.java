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
 *
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class StatisticalData {
    private Long value;
    private Boolean canChangeSign;
    private Boolean canIncrease;
    private Boolean canDecrease;
    
    /**
     * Increment value by 1
     * @return 
     */
    public boolean increase(){
        if (canIncrease ){ 
            value = value + 1;
            return true;
        } else
            return false;
    }
    
    /**
     * Increase value by specified amount.
     * @param toAdd
     * @return 
     */
    public boolean increase(Long toAdd){
        if (canIncrease) {
            value = value + toAdd;
            return true;
        }else
            return false;
    }

    /**
     * Decrement value by 1
     * @return 
     */
    public boolean decrease(){
        if (canDecrease){
            value = value - 1;
            return true;
        } else
            return false;
    }
    
    /**
     * Reduce value by a specified amount.
     * @param toSub
     * @return true on success
     */
    public boolean decrease(Long toSub){
        if ( canDecrease){
            value = value - toSub;
            return true;
        } else
            return false;
    }

    /**
     * Reset value to 0.
     */
    public void reset(){
        value = 0L;
    }

    /**
     * Return value
     * @return the current value
     */
    public Long value(){
        return value;
    }
}
