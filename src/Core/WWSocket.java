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
import java.net.*;
import java.io.*;

/**
 * A WWSocket is the basic communication mechanism of the WolffeWare system. The
 * WWSocket is primarily a listener socket, and it's primary function is to 
 * shuttle and process Messages back and forth throughout the system. Clients
 * communicate with a WWSocket, and the system communicates with them via a
 * WWClient socket. So WWSocket acts as a basic gatekeeper to the system as a 
 * whole
 * @author Robert Serrano <wolfieca.rs@gmail.com>
 */
public class WWSocket extends WWCommChannel{
    public void init(int portNumber){
        
    }
    private ServerSocket listener;
}
