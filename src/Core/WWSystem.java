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
public final class WWSystem extends WWObject {
    private static WWCommChannel commChannel;
    private static HashMap<String, Node> peerList;
    private static Company company;
    private static SysLogger sysLog;
    private static Boolean isServer;
    private static Boolean isClient;
    private static Boolean sysIsLaunching;
    private static Boolean sysIsShuttingDown;
    private static Boolean sysIsLaunched;
    private static Boolean sysIsShutdown;
    private static MessageQueue sysMessageQueue;
    /**
     * The priorities of the alternate collector queues. This is used by the
     * system to determine what happens to queue messages when the primary 
     * collector queue gets full. It is also used to determine where messages
     * are pulled from if the primary queue is empty. Queues at priority 0 are
     * not included in this. They can only be populated by having messages sent
     * directly to them (for example a "Letters" queue which contains letters the
     * collector has requested).
     */
    private static Map<String,Integer> validCollectorQueues;
    private static ThreadPoolExecutor sysThreadPool;
    private static ScheduledExecutorService sysScheduledThreads;
    
    private static Sessions sysSessions;
    private static DebtorCache debtorCache;
    private static Users users;
    //private HashMap<String, Boolean> userLoggedIn;
    private static DataSource sysDataSource;
    

    /**
     * The system build number
     */
    public static String BUILD="0.01";
    
    /**
     *
     */
    public WWSystem(){
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
    public WWSystem(WWCommChannel srvSocket){
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
    public WWSystem(WWCommChannel srvSocket, HashMap<String,Node> peers){
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
    public WWSystem(WWCommChannel srvSocket, HashMap<String,Node>peers, SysLogger log){
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
    public WWSystem(WWCommChannel srvSocket, HashMap<String,Node> peers, SysLogger log, 
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
    public WWSystem(WWCommChannel srvSocket, HashMap<String,Node> peers, SysLogger log, 
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

    /**
     *
     * @return
     */
    @Override
    protected WWObject init() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     *
     * @param name
     * @return
     */
    public Session getSession (String name){
        return null;
    }
    
}

