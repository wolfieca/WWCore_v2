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
 * ReturnRequest indicates that the client has requested that the account be 
 * cancelled from the Company and returned to the Client. The exact implementation
 * may vary, but the effect is the same: the account is removed from placements, 
 * and all action on the account by the company ceases. The account itself becomes
 * locked, preventing any changes from being made to it in the future. Only an
 * existing legal action on the Account can prevent the ReturnRequest from 
 * completing.
 * @author Robert Serrano <wolfieca.rs@gmail.com>
 */
public class ReturnRequest {
    
}
