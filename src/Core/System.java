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

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * System represents the WolffeWare system. It is the primary active entity,
 * responsible for resource management, communications (setting up the local
 * instance's communication channels), and various other aspects of the system.
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class System implements Runnable, Securable{
    private WWCommChannel commChannel;
    private HashMap<String, Node> peerList;
    private Company company;
    private SysLogger sysLog;
    private Boolean isServer;
    private Boolean isClient;
    private Boolean sysIsLaunching;
    private Boolean sysIsShuttingDown;
    private Boolean sysIsLaunched;
    private Boolean sysIsShutdown;
    private final MessageQueue sysMessageQueue;
    /**
     * The priorities of the alternate collector queues. This is used by the
     * system to determine what happens to queue messages when the primary 
     * collector queue gets full. It is also used to determine where messages
     * are pulled from if the primary queue is empty. Queues at priority 0 are
     * not included in this. They can only be populated by having messages sent
     * directly to them (for example a "Letters" queue which contains letters the
     * collector has requested).
     */
    private Map<String,Integer> validCollectorQueues;
    private ThreadPoolExecutor sysThreadPool;
    private ScheduledExecutorService sysScheduledThreads;
    
    private Sessions sysSessions;
    private DebtorCache debtorCache;
    private Users users;
    //private HashMap<String, Boolean> userLoggedIn;
    private DataSource sysDataSource;
    

    /**
     * The system build number
     */
    public static String BUILD="0.01";
    
    /**
     * The run method of System. This initializes everything, creates the thread 
     * pools, and gets everything rolling. If this is a Node process, connect
     * to any other Nodes that allow it. If a Client process, connect to a Node.
     * Once all the initialization is complete, the System object actually does
     * very little, serving messages sent to it, but basically staying out of the 
     * way otherwise. 
     */
    @Override
    public void run(){
        
    }
    /**
     *
     */
    public System(){
        commChannel = null;
        peerList = null;
        company = new Company();
        sysLog = new SysLogger();
        sysIsLaunching = false;
        sysIsShuttingDown = false;
        sysIsLaunched = false;
        sysIsShutdown = false;
        sysMessageQueue = new MessageQueue("System");
    }
    
    /**
     *
     * @param srvSocket
     */
    public System(WWCommChannel srvSocket){
        commChannel = srvSocket;
        peerList = null;
        company = new Company();
        sysLog = new SysLogger();
        sysIsLaunching = false;
        sysIsShuttingDown = false;
        sysIsLaunched = false;
        sysIsShutdown = false;
        sysMessageQueue = new MessageQueue("System");
    }
    
    /**
     *
     * @param srvSocket
     * @param peers
     */
    public System(WWCommChannel srvSocket, HashMap<String,Node> peers){
        commChannel = srvSocket;
        peerList = peers;
        company = new Company();
        sysLog = new SysLogger();
        sysIsLaunching = false;
        sysIsShuttingDown = false;
        sysIsLaunched = false;
        sysIsShutdown = false;
        sysMessageQueue = new MessageQueue("System");        
    }
    
    /**
     *
     * @param srvSocket
     * @param peers
     * @param log
     */
    public System(WWCommChannel srvSocket, HashMap<String,Node>peers, SysLogger log){
        commChannel = srvSocket;
        peerList = peers;
        company = new Company();
        sysLog = log;
        sysIsLaunching = false;
        sysIsShuttingDown = false;
        sysIsLaunched = false;
        sysIsShutdown = false;
        sysMessageQueue = new MessageQueue("System");        
    }
    
    /**
     *
     * @param srvSocket
     * @param peers
     * @param log
     * @param messageQueue
     */
    public System(WWCommChannel srvSocket, HashMap<String,Node> peers, SysLogger log, 
            MessageQueue messageQueue) {
        commChannel = srvSocket;
        peerList = peers;
        company = new Company();
        sysLog = log;
        sysIsLaunching = false;
        sysIsShuttingDown = false;
        sysIsLaunched = false;
        sysIsShutdown = false;
        sysMessageQueue = messageQueue;        
    }
    
    /**
     *
     * @param srvSocket
     * @param peers
     * @param log
     * @param messageQueue
     * @param sysCompany
     */
    public System(WWCommChannel srvSocket, HashMap<String,Node> peers, SysLogger log, 
            MessageQueue messageQueue, Company sysCompany) {
        commChannel = srvSocket;
        peerList = peers;
        company = sysCompany;
        sysLog = log;
        sysIsLaunching = false;
        sysIsShuttingDown = false;
        sysIsLaunched = false;
        sysIsShutdown = false;
        sysMessageQueue = messageQueue;        
    }
    
    public Session getSession (String name){
        return null;
    }
    
}
