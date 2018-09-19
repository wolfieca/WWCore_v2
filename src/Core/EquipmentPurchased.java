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
 * EquipmentPurchased is the final step in the Equipment Purchasing process. This
 * object contains various data pertaining to actually placing an EquipmentOrder
 * with a vendor, including vendor information, purchase date, bill date, items
 * purchased and the related quantities, prices, and conditions, ship date, 
 * arrival date, responsible party, etc. Once the Equipment has arrived and been
 * signed for, this object is made inactive and placed in the Company's History.
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class EquipmentPurchased extends Message{
    
}
