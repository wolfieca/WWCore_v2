/*
 * Copyright (C) 2018 Robert Serrano <wolfieca.rs@gmail.com>
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
 * A processing strategy for accounts to pass through over the course of their 
 * lifetime. This is basically a chain of operations that will be taken in a
 * particular order once an account has entered the system as an active account.
 * In WolffeWare, a strategy is an ordered set of RequestMessages and 
 * ActionMessages.
 * @author Robert Serrano <wolfieca.rs@gmail.com>
 */
public class Strategy  implements Reportable{
    
}
