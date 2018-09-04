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
import java.util.Set;
import org.w3c.dom.Document;

/**
 * Debtor represents a single debtor on the system. This includes individual
 * debts, payments, legal actions, history, demographic information, etc. Debtor
 * is the management class for all these things, and is also largely responsible
 * for any related reporting functionality. Debtor is designed to defer as much 
 * as possible until data is actually needed. At the base, a debtor will contain
 * just the debtor information. Further information will be brought in as needed
 * and kept in memory until it's been idle for a while.
 * @author Robert Serrano <wolfieca.rs@gmail.com>
 */
public class Debtor {
    private Long debtor;
    private AccessControlList ACL;
    //private Client primaryClient; //obsolete
    //private HashMap<Client,Integer> clients;
    //private Actor collector;
    private CollectionUnit collector;
    private Boolean mailReturn;
    private Boolean paidInFull;
    private Boolean workedSinceLastNewbiz;
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
    private Office debtorOffice;
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
    private SupplementalData supplementalData;
    
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
    private Set<User> readers;
    private User writer;
    
    //Constructors

    /**
     *
     */
    
    public Debtor() {
    }
    
    /**
     *
     * @param debtor
     */
    public Debtor(Long debtor){
        
    }
    
    /**
     *
     * @param debtor
     * @param sqlConnection
     */
    public Debtor(Long debtor, Connection sqlConnection){
        
    }
    
    /**
     *
     * @param setup
     */
    protected Debtor(HashMap<String, Object> setup){
        
    }
    
    //Methods

    /**
     *
     * @param debt
     * @param user
     */
    
    public void addDebt(Debt debt, User user){   
        
    }
    
    /**
     *
     * @param item
     * @param user
     */
    public void addContact(HistoryItem item, User user){
        
    }
    
    /**
     *
     * @param payment
     * @param user
     */
    public void addPayment(Payment payment, User user){
        
    }
    
    /**
     *
     * @param action
     * @param user
     */
    public void addLegalAction (Legal action, User user){
        
    }
    
    /**
     *
     * @param demographic
     * @param user
     */
    public void updateDemographics(DemographicField demographic, User user){
        
    }
    
    /**
     *
     * @param user
     */
    public void lock(User user){
        if ( user.hasRight("Debtor.Lock") )
            locked = true;
    }
    
    /**
     *
     * @param user
     */
    public void unlock(User user){
        if ( user.hasRight("Debtor.Lock") )
            locked = false;
    }
    
    // For simplicity sake

    /**
     *
     * @param user
     */
    public void allowMatch(User user){
        if ( user.hasRight("Debtor.Lock") )
            matchable = true;
    }
    
    /**
     *
     * @param user
     */
    public void denyMatch(User user){
        if ( user.hasRight("Debtor.Lock") )
            matchable = false;
    }
    
    /**
     *
     * @param user
     */
    public void allowMerge(User user) {
        if ( user.hasRight("Debtor.Lock") )
            mergeable = true;
    }
    
    /**
     *
     * @param user
     */
    public void denyMerge(User user) {
        if ( user.hasRight("Debtor.Lock") )
            mergeable = true;
    }

    /**
     *
     * @param user
     * @return
     */
    public Client primaryClient(User user){
        return null;
    }
    
    /**
     *
     * @param user
     * @return
     */
    public GregorianCalendar nextActivity(User user){
        return null;
    }
    
    /**
     *
     * @param promise
     * @param user
     */
    public void createPromise(Promise promise, User user){
        
    }
    
    /**
     *
     * @param newCollector
     * @param user
     */
    public void changeCollector(CollectionUnit newCollector, User user){
        
    }
    
    /**
     *
     * @param debtorToMerge
     * @return
     */
    public Debtor merge (Debtor debtorToMerge){
        return null;
    }
    
    /**
     *
     * @param debtsToSplit
     * @return
     */
    public Debtor split (Integer[] debtsToSplit){
        return null;
    }
    
    /**
     *
     * @param debtsToMerge
     * @return
     */
    public Debtor merge(Debt[] debtsToMerge){
        return null;
    }
    
    /**
     *
     * @param toForwarder
     */
    public void forward(AttorneyForwarder toForwarder){
        
    }
    
    /**
     *
     * @param letter
     */
    public void requestLetter(Letter letter){
        
    }
    
    /**
     *
     * @param testDebtor
     */
    public void match(Debtor testDebtor){
        
    }
    
    /**
     *
     */
    public static void findMatches(){
        
    }
    
    /**
     * 
     * @param debtorNumber
     * @return 
     */
    public static Debtor getDebtor(Long debtorNumber){
        return null;
    }
    
    /**
     *
     */
    public void view(){
        
    }
    
    /**
     *
     */
    public void edit(){
        
    }
    
    public String metro2(){
        return null;
    }
    
    public Document exportXML(){
        return null;
    }
}
