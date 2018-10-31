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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * An individual Item in the System History. History operates as a sort of log
 * of system activities, including debtor activity, phone calls, changes to
 * debtors and/or debts, user actions, system activity, etc. Every entry in the
 * history has an originator/creator (the user that took the action), a target
 * (the object that was affected by the action), a message reflecting what was
 * actually done, and a variety of basic bookkeeping information. Note that the
 * HistoryItem is ultimately where most messages end up once they've served their
 * purpose.
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class HistoryItem implements Reportable{
    //private boolean active;
    private final User originator;
    private final WWObject target;
    private final LocalDateTime created;
    private final Message message;
    
    /**
     * Constructor. HistoryItem objects are intended to be immutable. Once they've
     * been initialized, they don't change.
     * @param originator The user initiating the action
     * @param target The target of the action
     * @param message Details of the action that was requested.
     */
    protected HistoryItem(User originator, WWObject target, Message message){
        this.originator = originator;
        this.target = target;
        this.message = message;
        created = LocalDateTime.now();
    }
    
    public String createdBy(){
        return originator.UserName();
    }
    public User auditUser(){
        return originator;
    }
    public WWObject checkTarget(){
        return target;
    }
    public String readMessage(){
        return message.read();
    }
    public String timeCreated(){
        return created.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG, FormatStyle.MEDIUM));
    }    
    
}
