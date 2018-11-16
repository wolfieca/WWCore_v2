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
 * QueueList is a manager object for the System Message Queues.
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class QueueList extends WWObject implements Reportable {

    @Override
    protected WWObject init() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private OldAccessControlList ACL;
    private HashMap<String,MessageQueue> queues;
    
    /**
     *
     */
    public QueueList(){
        
    }
    
    /**
     *
     */
    public static void initialize(){
        
    }
    
    /**
     *
     * @param queueName
     */
    public void initQueue(String queueName){
        
    }
}
