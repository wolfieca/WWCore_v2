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

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A Message is a basic message in the system. It is intended to be a unit of
 * synchronization and communication throughout the system as a whole. A message
 * can be recursive (i.e. containing other messages). A message is considered semi
 * atomic. The message is either entirely loaded, or it's not loaded at all. A 
 * partial message will not be touched by other parts of the system, until it is
 * complete. The basic Message object is just a human readable message with no
 * special data attached to it.
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class Message extends WWObject implements Serializable{

    /**
     * Valid message statuses
     */
    public enum Statuses {

        /**
         * Message has been created and is waiting to send.
         */
        SEND,

        /**
         * Message has been sent (not necessarily delivered)
         */
        SENT,

        /**
         * Message has arrived in the targeted MessageQueue and is waiting to
         * be read.
         */
        UNREAD,

        /**
         * Message has been read by the recipient.
         */
        READ,

        /**
         * Recipient is replying to the message.
         */
        REPLY,

        /**
         * Reply has been sent to the original sender.
         */
        REPLIED,

        /**
         * Recipient has requested the message be forwarded to another user or
         * users.
         */
        FORWARD,

        /**
         * Message has been forwarded to other users.
         */
        FORWARDED,

        /**
         * Recipient has rejected the message and a rejection message is waiting
         * to be sent (message is produced automatically by the system).
         */
        REJECT,

        /**
         * Recipient has rejected the message and either suppressed the rejection
         * message or the message has been delivered to the original sender.
         */
        REJECTED,

        /**
         * Message has aged out and is waiting to be disposed of (removed from
         * the active message queues and stored in the history.
         */
        INTER,

        /**
         * Message has been interred. Interred messages are removed from the 
         * message queues and are placed in the user's History (the portion of the
         * History file that reflects only actions taken by the user).
         */
        INTERRED,

        /**
         * Message has been aged out and has been marked as a disposable Message,
         * so the system is waiting to dispose of it. A discarded message is 
         * removed from the user's Queues and History and is placed in the System
         * History for auditing purposes.
         */
        DISCARD,

        /**
         * Message has been discarded.
         */
        DISCARDED
    }
    private String messageID;
    private Session waitingSession;
    private User sender;
    private User recipient;
    private MessageQueue target;
    private LocalDateTime created;
    private Statuses currentStatus;
    private LocalDateTime sent;
    private LocalDateTime delivered;
//    private LocalDateTime send;
//    private LocalDateTime sent;
//    private LocalDateTime received;
//    private LocalDateTime replied;
//    private LocalDateTime forwarded;
//    private LocalDateTime rejected;
//    private LocalDateTime interred;
//    private LocalDateTime discarded;
    private String message;
    
    /**
     * Default constructor. Create a null message.
     */
    public Message(){
        
    }

    /**
     * Create and send a message to a specified user, to be send at the specified
     * time. The message queueing system will determine which queue to send the
     * message to.
     * @param sender The sending user (messages always originate from a user)
     * @param recipient the receiver (in this case a User)
     * @param send the time the message is to be sent.
     * @param msg The message being sent.
     */
    public Message (User sender, User recipient, LocalDateTime send, String msg){
        messageID = sender.getMessageID();
        this.sender = sender;
        this.recipient = recipient;
        this.target = null;
        this.created = LocalDateTime.now();
        this.message = msg;
    }

    /**
     * Create and send a message to a specified message queue, to be sent at the
     * specified time. Any user with access to the message queue will be able to
     * receive/view/etc the message.
     * @param sender
     * @param msgQueue
     * @param send
     * @param msg
     */
    public Message (User sender, MessageQueue msgQueue, LocalDateTime send, 
            String msg){
        this.messageID = sender.getMessageID();    
        this.sender = sender;
        this.recipient = null;
        this.target = msgQueue;
        this.created = LocalDateTime.now();
        this.message = msg;
    }

    /**
     *
     * @param sender
     * @param recipient
     * @param msg
     */
    public Message (User sender, User recipient, String msg){
        messageID = sender.getMessageID();

        this.sender = sender;
        this.recipient = recipient;
        this.target = null;
        this.created = LocalDateTime.now();
        this.message = msg;
    }
    
    /**
     *
     */
    public void send(){
        
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
     * @return
     */
    protected Message receive(){
        return null;
    }
    
    /**
     *
     */
    protected void reject(){
        
    }

    /**
     *
     */
    public void forward(){
        
    }
    
    /**
     *
     */
    public void reply(){
        
    }
    
    /**
     *
     */
    public void inter(){
        
    }
    
    /**
     *
     * @return
     */
    public String read(){
        return message;
    }
}
