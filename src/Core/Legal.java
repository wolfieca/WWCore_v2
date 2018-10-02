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

import java.util.HashMap;

/**
 * Legal data. This is structured somewhat like the Supplemental and Demographic
 * Data classes. Legal data is not necessarily encumbered by PHI, but that can
 * be set up by the company. Legal Data is associated with a particular 
 * LegalAction on a particular Debtor, and there can be multiple Legal datasets
 * for a particular Debtor, though Debts can only be included in a single 
 * LegalAction.
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class Legal implements Reportable, Securable{
    private HashMap<String,HashMap<String,LegalData>> legalData;
}
