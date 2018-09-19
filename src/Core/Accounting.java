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
 * This is the primary object of the Accounting subsystem. It is designed as a
 * rudimentary accounting system, though individual Companies can subclass it
 * to suit their purposes. It operates as a listener object on various other
 * systems (especially payments), so that it can be updated in real time as 
 * transactions occur.
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class Accounting implements Reportable, Securable{
    
}
