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
import java.util.Set;

/**
 * A WolffeWare Peer machine. Peers are the core of the WolffeWare distributed
 * model, allowing for both distributed processing (scalability) and high
 * availability (reliability) for the system itself. WWPeer allows for the
 * detection of other WWPeer processes on the system, as well as keeping
 * track of the latency between the peers to allow for the best responsiveness.
 * Additionally, it allows for the sending of alerts when a registered peer goes
 * offline. All peers have a list of other peers that have been discovered.
 * The peer system is designed so that, once a Wolffe instance is launched, it
 * seeks out other peers on the local network. If none are found, this peer 
 * assigns itself as Peer zero (or Prime), which is treated as a sort of traffic
 * cop among the peers. Other peers that subsequently come online will defer to
 * Prime and register it as such. If Prime disappears for whatever reason, the 
 * other peers will hold an election to determine a new Prime. If the previous 
 * Prime reappears, it will simply register itself as a normal peer, flush any
 * unprocessed messages, and continue on as usual. The Prime peer distributes 
 * messages to other peers based on information it has received from those nodes,
 * such as the current load on the node, how many messages that node has
 * processed recently, users currently messaging that node for services, and 
 * the latency to that node.
 * When a User comes online, Prime's first job is to determine which peer is
 * most appropriate to serving that User's requests. The User is then attached
 * to that peer, including all appropriate queues. Prime keeps track of the User
 * and the peer assigned to it, so that it can be reassigned in the event of the
 * peer failing. User's can be dynamically reassigned to peers and requests they 
 * make may also be sent to other peers transparently. The servicing peer will be
 * noted, for the sake of auditing, though.
 * Note that in a scenario with only a single peer instance (i.e. a single server),
 * Prime is the only peer and will be the only target for messages or User
 * logins.
 * Prime is also capable of designating a Peer or Peers as Replicators. These
 * peers are automatically sent copies of all messages that pass through Prime's
 * queues, and will be able to take over if Prime fails for some reason (the
 * election of a Prime favors a Replicator, for this reason). Replicators also
 * contain the information for Users logged into Prime so that they can be 
 * quietly reassigned to the Replicator in such cases. Note that this is done
 * through the token interface and the message passing done when a User logs in.
 * If this movement can not be carried out, then the user is considered to have
 * logged out and will need to log back in.
 * Client software is presented with a simplified view of the system topology. 
 * Basically, clients only see the communication channel to the server, which 
 * will be the Prime Node. The Prime node will route the message as appropriate
 * (preferring to save itself for local users and small, simple requests), 
 * transparently to the user. Prime will attempt to reduce the work load on itself
 * and the other nodes as much as possible without dropping messages.
 * 
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class Node {
    //private Socket systemPeer;
    private WWServer nodeServer;
    private Set<Node> neighbors;
    private String peerName;
    private boolean prime;
    private int localEventClock;

    /**
     *
     */
    public enum Status {

        /**
         *
         */
        UP,

        /**
         *
         */
        DOWN,

        /**
         *
         */
        UNKNOWN
    }
    private Status peerStatus;
    private MessageQueue primeQueue;

    /**
     *
     * @return
     */
    public String getName(){
        return null;
    }
}
