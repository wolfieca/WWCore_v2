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
     * A single nodes can be in one of several states:
     * It can be Down (not responsive to node requests)
     * It can be Up (responsive to node requests)
     * It can be Starting (initializing in preparation of entering the Up state)
     * It can be Stopping (engaged in shutdown procedures, preparing to enter the
     * Down state).
     * It can be Crashed (stops responding, for a long time, but never sent a
     * notification that it was Stopping).
     * It can be Recovering (Crashed, but is currently in the process of recovery
     * from the crash so it can rejoin the network).
     * It can be waiting to Join a pack.
     * It can be attempting to join a pack.
     * It can be Joined to a pack.
     * It can be operating as a lone wolf.
     * It can be operating as the master node for its pack.
     * A node that is Starting is implicitly Down (transitioning to be Up)
     * A node that is Stopping is implicitly Up (transitioning to being Down)
     * A node that is Crashed is implicitly Down (awaiting potential transition
     * to a Recovering State)
     * A Recovering node is Down, but is awaiting a transition to an Up state if
     * approved by an Administrator. The recovery process forces the Node to go
     * through a variety of tests to ensure that it is capable of running on a 
     * sustained basis. All files have to be rechecked to ensure there is no 
     * corruption, and the Wolffe system files will all need to be checked against
     * the current files to make sure they are all correct. A node that fails more
     * than a certain number of times may be locked out until an Administrator
     * is able to assure the rest of the nodes that the problem has been resolved.
     * A Waiting cluster is up, but waiting to be joined with a cluster. This may
     * require that the other nodes be told to scan for new nodes first, if the
     * node hasn't been a member of this cluster previously.
     * A Joining node is attempting to negotiate to join a cluster.
     * A Joined node has joined a cluster.
     * A Solo node is not a member of a cluster and is not searching for a 
     * cluster to join. A Solo node is effectively a Master node of its own local
     * cluster.
     * A Master node is joined to a cluster and is operating as the master of the
     * node. A node explicitly attempting to become master will force an election
     * for Master. If there currently is no Master node in the cluster (or the
     * master node has gone offline or otherwise become disconnected from the 
     * cluster) the cluster's nodes will hold an election to determine which node
     * should be made the Master. The election results are based on a number of
     * metrics, with ties ultimately broken by node uptime.
     */
    private int nodeStatus;
    private MessageQueue nodeQueue;

    /**
     *
     * @return
     */
    public String getName(){
        return null;
    }
}
