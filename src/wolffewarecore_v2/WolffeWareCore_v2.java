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
package wolffewarecore_v2;
import Core.*;

/**
 * WolffeWareCore server application and libraries. The primary purpose of this
 * object is to initialize the Core system. First, it needs to determine in
 * what capacity it's running: Server or Client. Node and Server are effectively
 * synonymous (a single-Node topography equivocates the two).
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class WolffeWareCore_v2 {

    /**
     * Main entry point for WolffeWareCore. There are a number of command-line 
     * parameters that are available. By default, running with no arguments will 
     * look for a Server/Node running on the local network, initializing a local 
     * Node if none is found. If there is an extant Node operating on the network,
     * this queries it to determine if this is another known Node, in which case
     * it will continue on along the Node setup path.
     * If there is a Node running on the network and this is NOT another known
     * Node, then this will by default begin the Client startup process. Clients
     * only see a subset of the Nodes on the system, namely the Master Node and
     * the Node it is directly tied to (which may be the same).
     * Once the initialization is completed, this code basically steps out of the
     * way and lets the System objects do their jobs
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
