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
import java.net.*;
import java.io.*;

/**
 * A WWServer is a server communication channel. This is the primary method
 * by which the Server/Node processes communicate with clients and with each
 * other. Clients get a WWServer reflecting the Prime Node on the system at the
 * time they start. They are also given a WWServer reflecting the local node they
 * are attached to, so that they can attempt to find the new Prime Node when it
 * has been elected. In the event of total network breakdown (i.e. one or more 
 * Nodes is left stranded with no connected Nodes), the local node will attempt
 * to queue messages until the breakdown is resolved. It will attempt to use 
 * local data to satisfy message requests where such is available, while noting
 * any changes made to allow reconciliation of discrepancies that might have 
 * occurred while the network was down.
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class WWServer extends WWCommChannel{

    /**
     * Set WWServer to listen on the specified port number on the localhost
     * @param portNumber
     */
    @Override
    public void init(int portNumber){
        
    }
    private ServerSocket listener;
    
    
}
