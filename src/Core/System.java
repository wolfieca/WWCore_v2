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

import java.util.HashMap;

/**
 * System represents the WolffeWare system. It is the primary active entity,
 * responsible for resource management, communications (setting up the local
 * instance's communication channels
 * @author Robert Serrano <wolfieca.rs@gmail.com>
 */
public class System {
    private WWCommChannel commChannel;
    private HashMap<String, WWPeer> peerList;
    private Company company;
    private SysLogger sysLog;
    private Boolean isServer;
    private Boolean isClient;
    private Boolean sysIsLaunching;
    private Boolean sysIsShuttingDown;
    private Boolean sysIsLaunched;
    private Boolean sysIsShutdown;
    private MessageQueue sysMessageQueue;
    
    private HashMap<Long, Debtor> debtorCache;
    private HashMap<String, User> users;
    private HashMap<String, Boolean> userLoggedIn;

    /**
     *
     */
    public static String BUILD="0.01";
    
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
        sysMessageQueue = new MessageQueue();
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
        sysMessageQueue = new MessageQueue();
    }
    
    /**
     *
     * @param srvSocket
     * @param peers
     */
    public System(WWCommChannel srvSocket, HashMap<String,WWPeer> peers){
        commChannel = srvSocket;
        peerList = peers;
        company = new Company();
        sysLog = new SysLogger();
        sysIsLaunching = false;
        sysIsShuttingDown = false;
        sysIsLaunched = false;
        sysIsShutdown = false;
        sysMessageQueue = new MessageQueue();        
    }
    
    /**
     *
     * @param srvSocket
     * @param peers
     * @param log
     */
    public System(WWCommChannel srvSocket, HashMap<String,WWPeer>peers, SysLogger log){
        commChannel = srvSocket;
        peerList = peers;
        company = new Company();
        sysLog = log;
        sysIsLaunching = false;
        sysIsShuttingDown = false;
        sysIsLaunched = false;
        sysIsShutdown = false;
        sysMessageQueue = new MessageQueue();        
    }
    
    /**
     *
     * @param srvSocket
     * @param peers
     * @param log
     * @param messageQueue
     */
    public System(WWCommChannel srvSocket, HashMap<String,WWPeer> peers, SysLogger log, 
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
    public System(WWCommChannel srvSocket, HashMap<String,WWPeer> peers, SysLogger log, 
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
    
    
}
