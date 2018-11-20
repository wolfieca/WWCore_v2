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

/**
 * A Pack is a list of systems that have been discovered or registered with
 * this one. Each peer is a separate unit capable of performing operations on the
 * Wolffe system data. They maintain a certain amount of state data (such as the
 * local DebtorCache), and can distribute work based on latency, current work load
 * and other factors. To facilitate operations, the registered peers will pick a
 * primary peer that is responsible for fanning messages out and keeping the
 * system synchronized. Each peer can be assigned a priority that reflects the
 * preference that should be given to it in determining what should be sent to it.
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class Pack extends WWObject{
    private HashMap<String, Node> nodeList;

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
     * @return
     */
    public Node[] findNodes(){
        return null;
    }

    /**
     *
     * @param ip
     * @param subnet
     * @param port
     * @return
     */
    public Node[] findNodes(String ip, int subnet, int port){
        return null;
    }
    
    /**
     *
     * @param ip
     * @param port
     * @return
     */
    public Node findNode(String ip, int port){
        return null;
    }
    
    /**
     *
     * @param thePeer
     * @return
     */
    public String getNodeName(Node thePeer){
        return null;
    }
    
    /**
     *
     * @param thePeer
     * @return
     */
    public int getNodeLatency(Node thePeer){
        return 0;
    }
    
    
}
