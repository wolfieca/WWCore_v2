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

/**
 * A WolffeWare Peer machine. Peers are the core of the WolffeWare distributed
 * model, allowing for both distributed processing (scalability) and high
 * availability (reliability) for the system itself. WWPeer allows for the
 * detection of other WWPeer processes on the system, as well as keeping
 * track of the latency between the peers to allow for the best responsiveness.
 * Additionally, it allows for the sending of alerts when a registered peer goes
 * offline.
 * @author Robert Serrano <wolfieca.rs@gmail.com>
 */
public class WWPeer {
    Socket systemPeer;
    
    
}
