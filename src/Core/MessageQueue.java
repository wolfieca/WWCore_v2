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

import java.util.GregorianCalendar;
import java.util.PriorityQueue;

/**
 * MessageQueue is a straightforward message queue. CollectorQueue is based
 * on the MessageQueue class. A MessageQueue is typically an unbounded queue (in
 * contrast to CollectorQueue which can be bounded by size and/or type of message).
 * The MessageQueue provides mechanisms to prevent messages from getting too old
 * without being seen or operated on by a user. First, the queue will boost the
 * priority of messages that have sat in the queue for priorityBoostInterval days.
 * After that, the messages older than maxAgeBeforeRequeue will be requeued,
 * either to another queue (if appropriate) or to the same queue but with a Hold
 * priority so it must be looked at before the queue user can go any further in 
 * their queue. Non-interactive queues or messages are excluded from these, since 
 * neither needs to be acted upon in any way (for example, the user PunchBreak queue, 
 * which is primarily just a channel to notify supervisors when people log in or
 * out). 
 * MessageQueues replace the Scheduler/Activity paradigm used by the Wizard
 * System. 
 * @author Robert Serrano <wolfieca.rs@gmail.com>
 */
public class MessageQueue {
    private String queueName;
    private GregorianCalendar nextActivity;
    private PriorityQueue<Message> messageQueue;
    private Integer priorityBoostInterval;
    private Integer maxAgeBeforeRequeue;    
    private Integer maxQueueSizeBeforeReeval;
    private Boolean waiting;
    
    /**
     *
     */
    public MessageQueue(){
        queueName = "";
        nextActivity = new GregorianCalendar();
        messageQueue = new PriorityQueue<>();
        maxAgeBeforeRequeue=0;
        waiting = false;
    }
    
    /**
     *
     * @param queueName
     */
    public MessageQueue(String queueName){
        this.queueName = queueName;
        nextActivity = new GregorianCalendar();
        messageQueue = new PriorityQueue<>();
        maxAgeBeforeRequeue = 0;
        waiting = false;
    }
    
    /**
     * 
     * @return
     */
    public GregorianCalendar nextMessageDate(){
        return (GregorianCalendar) nextActivity.clone();
    }
    
    /**
     *
     * @return
     */
    public Integer queueSize(){
        return messageQueue.size();
    }
    
    /**
     *
     * @return
     */
    public String queueID(){
        return queueName;
    }
    
    /**
     *
     * @param inbound
     */
    public void enqueue (Message inbound){
        
    }
    
    /**
     *
     * @return
     */
    public Message dequeue (){
        return null;
    }
}
