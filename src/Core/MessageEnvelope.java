/*
 * Copyright (C) 2019 Robert Serrano (wolfieca.rs at gmail.com)
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
 * A MessageEnvelope is the delivery details of a Message. A MessageEnvelope
 * contains the data needed to actually send the Message to its intended target,
 * and the final disposition of the Message. Several MessageBody objects targeted 
 * at the same queue can be embedded in the same Message to reduce bandwidth 
 * usage.
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class MessageEnvelope extends WWObject{

    @Override
    protected WWObject init() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
