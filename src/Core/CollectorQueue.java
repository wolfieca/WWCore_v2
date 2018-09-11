/*
 * Copyright (C) 2018 rserrano
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
 * A collector queue. Collectors have a slightly different queue setup than most
 * users, since they have multiple related queues by default (at base, a collector
 * has primary, alternate and miscellaneous queues, though others can be setup, 
 * as needed). This is in addition to the messageQueue(s) belonging to the user.
 * @author rserrano
 */
public class CollectorQueue extends MessageQueue implements Reportable, Securable{
    private HashMap<String,MessageQueue> alternateQueues;
    private Integer primaryQueueMaxSize;
    
    @Override
    public void enqueue(Message incoming){
        
    }
    
    
    public void reevaluate(){
        
    }
    
    public void reevaluate(String queueID){
        
    }
}
