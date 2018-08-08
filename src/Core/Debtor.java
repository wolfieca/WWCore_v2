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

import java.sql.Connection;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * Debtor represents a single debtor on the system. This includes individual
 * debts, payments, legal actions, history, demographic information, etc.
 * @author Robert Serrano <wolfieca.rs@gmail.com>
 */
public class Debtor {
    private Long debtor;
    private AccessControlList ACL;
    private Client primaryClient;
    //private HashMap<Client,Integer> clients;
    //private Actor collector;
    private CollectionUnit unit;
    private Boolean mailReturn;
    private Boolean paidInFull;
    private Boolean workedSinceLastNewbiz;
    private Boolean hasAssetWindow;
    private Boolean withAttorney;
    private Boolean withForward;
    private Boolean hasRestrictionsWindow;
    private Boolean doNotCall;
    private Boolean doNotCallHome;
    private Boolean doNotWriteWork;
    private Boolean doNotCallWork;
    private Boolean debtReturned;
    private Boolean everNSF;
    private Boolean everSkipTracedPhone;
    private Boolean everSkipTracedAddress;
    private Boolean everSkipTracedOther;
    private Boolean everMailReturn;
    private Boolean preCollect;
    private Boolean mergeInProgress;
    private Boolean splitInProgress;
    private Boolean debtsCanAccrueInterest;
    private AttorneyForwarder attorneyForwarder;
    private GregorianCalendar dateSentOut;
    private GregorianCalendar dateLastPaid;
    private GregorianCalendar dateLastSeen;
    private GregorianCalendar dateLastNewbiz;
    private GregorianCalendar dateOriginallyReceived;
    private GregorianCalendar dateClosed;
    private GregorianCalendar dateLastUpdated;
    private Integer collectorRetrySendDays;
    private Integer lettersLeft;
    private Priority priority;
    private CollectionUnit priorCollector;
    private Promise paymentPromise;
    private AccountStatus status;
    private Integer keptPromises;
    private Integer brokenPromises;
    
    // Matchable debtors can be processed by the match finding routines.
    private Boolean matchable;
    // Mergeable debtors can be merged with other debtors.
    private Boolean mergeable;
    // Locked debtors can't be changed outside of those changes needed for
    // payment processing.
    private Boolean locked;
    private Demographics demographics;
    
    // Begin working data fields
    //private HashMap<String,SupplementalData> ancil;
    private Debts debts;
    private History history;
    private Payments payments;
    private Promise promise;
    private LegalActions legal;
    private MessageQueue activity;
    private Strategy strategy;
    private Status currentStatus;
    
    //Constructors
    
    public Debtor() {
    }
    
    public Debtor(Long debtor){
        
    }
    
    public Debtor(Long debtor, Connection sqlConnection){
        
    }
    
    public Debtor(HashMap<String, Object> setup){
        
    }
    
    //Methods
    
    public void addDebt(Debt debt, User user){   
        
    }
    
    public void addContact(HistoryItem item, User user){
        
    }
    
    public void addPayment(Payment payment, User user){
        
    }
    
    public void addLegalAction (Legal action, User user){
        
    }
    
    public void updateDemographics(DemographicField demographic, User user){
        
    }
    
    public void lock(User user){
        if ( user.hasRight("Debtor.Lock") )
            locked = true;
    }
    
    public void unlock(User user){
        if ( user.hasRight("Debtor.Lock") )
            locked = false;
    }
    
    // For simplicity sake
    public void allowMatch(User user){
        if ( user.hasRight("Debtor.Lock") )
            matchable = true;
    }
    
    public void denyMatch(User user){
        if ( user.hasRight("Debtor.Lock") )
            matchable = false;
    }
    
    public void allowMerge(User user) {
        if ( user.hasRight("Debtor.Lock") )
            mergeable = true;
    }
    
    public void denyMerge(User user) {
        if ( user.hasRight("Debtor.Lock") )
            mergeable = true;
    }
    public Client primaryClient(){
        return this.primaryClient;
    }
    
    public GregorianCalendar nextActivity(){
        return null;
    }
}
