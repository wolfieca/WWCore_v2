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
 * A message that is meant to be sent via email. The recipients in this case
 * are email addresses. Depending on the receiving end of the message, the 
 * EmailMessage may be converted into a regular message and processed on the
 * remote end.
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class EmailMessage extends Message implements Email{
    
}
