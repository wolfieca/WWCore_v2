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
 * Server represents a server process for WolffeWare. It works as a holder
 * for the various base core objects, especially the communications and security
 * facilities.
 * @author Robert Serrano <wolfieca.rs@gmail.com>
 */
public class System {
    WWSocket serverSocket;
    HashMap<String, WWPeer> peerList;
    Company company;
    SysLogger sysLog;
    Boolean sysIsLaunching;
    Boolean sysIsShuttingDown;
    Boolean sysIsLaunched;
    Boolean sysIsShutdown;
    MessageQueue sysMessageQueue;
    public static String BUILD="0.01";
    
    
    public System(){
        serverSocket = new WWSocket();
        peerList = null;
        company = new Company();
        sysLog = new SysLogger();
        sysIsLaunching = false;
        sysIsShuttingDown = false;
        sysIsLaunched = false;
        sysIsShutdown = false;
        sysMessageQueue = new MessageQueue();
    }
    
    public System(WWSocket srvSocket){
        serverSocket = srvSocket;
        peerList = null;
        company = Company.create();
        sysLog = new SysLogger();
        sysIsLaunching = false;
        sysIsShuttingDown = false;
        sysIsLaunched = false;
        sysIsShutdown = false;
        sysMessageQueue = new MessageQueue();
    }
    
    public System(WWSocket srvSocket, HashMap<String,WWPeer> peers){
        serverSocket = srvSocket;
        peerList = peers;
        company = Company.create();
        sysLog = new SysLogger();
        sysIsLaunching = false;
        sysIsShuttingDown = false;
        sysIsLaunched = false;
        sysIsShutdown = false;
        sysMessageQueue = new MessageQueue();        
    }
    
    public System(WWSocket srvSocket, HashMap<String,WWPeer>peers, SysLogger log){
        serverSocket = srvSocket;
        peerList = peers;
        company = Company.create();
        sysLog = log;
        sysIsLaunching = false;
        sysIsShuttingDown = false;
        sysIsLaunched = false;
        sysIsShutdown = false;
        sysMessageQueue = new MessageQueue();        
    }
    
    public System(WWSocket srvSocket, HashMap<String,WWPeer> peers, SysLogger log, 
            MessageQueue messageQueue) {
        serverSocket = srvSocket;
        peerList = peers;
        company = Company.create();
        sysLog = log;
        sysIsLaunching = false;
        sysIsShuttingDown = false;
        sysIsLaunched = false;
        sysIsShutdown = false;
        sysMessageQueue = messageQueue;        
    }
    
    public System(WWSocket srvSocket, HashMap<String,WWPeer> peers, SysLogger log, 
            MessageQueue messageQueue, Company sysCompany) {
        serverSocket = srvSocket;
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
