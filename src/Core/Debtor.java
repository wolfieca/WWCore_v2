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
import java.util.HashMap;

/**
 * Debtor represents a single debtor on the system. This includes individual
 * debts, payments, legal actions, history, demographic information, etc.
 * @author Robert Serrano <wolfieca.rs@gmail.com>
 */
public class Debtor {
    private int debtor;
    private Client primaryClient;
    private HashMap<Client,Integer> clients;
    private Actor collector;
    private CollectionUnit unit;
    private int currBal;
    private int origBal;
    private int payments;
    private boolean mailReturn;
    private boolean paidInFull;
    private boolean workedSinceLastNewbiz;
    private boolean hasAssetWindow;
    private boolean hasEmploymentWindow;
    private boolean hasAddressWindow;
    private boolean hasPhone;
    private boolean withAttorney;
    private boolean withForward;
    private boolean hasRestrictionsWindow;
    private boolean doNotCall;
    private boolean doNotCallHome;
    private boolean doNotWriteWork;
    private boolean doNotCallWork;
    private boolean debtReturned;
    private boolean everNSF;
    private boolean everSkipTracedPhone;
    private boolean everSkipTracedAddress;
    private boolean everSkipTracedOther;
    private boolean everMailReturn;
    private boolean preCollect;
    private boolean mergeInProgress;
    private boolean splitInProgress;
    private boolean debtsCanAccrueInterest;
    private AttorneyForwarder attorneyForwarder;
    private GregorianCalendar dateSentOut;
    private GregorianCalendar dateLastPaid;
    private GregorianCalendar dateLastSeen;
    private GregorianCalendar dateLastNewbiz;
    private GregorianCalendar dateOriginallyReceived;
    private GregorianCalendar dateClosed;
    private GregorianCalendar dateLastUpdated;
    private int collectorRetrySendDays;
    private int lettersLeft;
    private Priority priority;
    private CollectionUnit priorCollector;
    private Promise paymentPromise;
    private AccountStatus status;
    private int keptPromises;
    private int brokenPromises;
    
    // Matchable debtors can be processed by the match finding routines.
    private boolean matchable;
    // Mergeable debtors can be merged with other debtors.
    private boolean mergeable;
    // Locked debtors can't be changed outside of those changes needed for
    // payment processing.
    private boolean locked;
    private HashMap<String, DemographicField> demoFields;
    // Begin PHI data fields...
    // The level of access to the PHI fields is controlled by the 
    // Account.PHI.Read and Account.PHI.Write rights. If the requestor doesn't
    // have Read access, only a limited subset of the PHI data will be returned:
    // namely lastName and the last four digits of ssn. 
    // Primary Demographic Data
    private DemographicField<String> lastName;
    private DemographicField<String> firstName;
    private DemographicField<String> middleName;
    private DemographicField<String> suffix;

    private DemographicField<String> title;
    private DemographicField<String> phone;
    // Wizard does not put SSN or birthdate in the MASTER data, and we have to
    // put it in the NI window, even though it is always pertinent
    private DemographicField<String> ssn;
    private DemographicField<GregorianCalendar> birthDate;
    // Wizard system puts most of the address in the Ancil A1 window, keeping
    // only the City, State, and Zip portions here. I don't see a real reason
    // to carry that practice over.
    private DemographicField<String> addressLine1;
    private DemographicField<String> addressLine2;
    private DemographicField<String> addressLine3;
    private DemographicField<String> city;
    private DemographicField<String> state;
    private DemographicField<String> zip;
    // End PHI data fields
    
    // Begin working data fields
    private HashMap<String,SupplementalData> ancil;
    private HashMap<Integer,Debt> debt;
    private HashMap<Integer,History> history;
    private HashMap<Integer,Payment> payment;
    private HashMap<Integer,Legal> legal;
    private MessageQueue activity;
    private Strategy strategy;

    public int getDebtor() {
        return debtor;
    }

    protected void setDebtor(int debtor) {
        this.debtor = debtor;
    }

    public Client getPrimaryClient() {
        return primaryClient;
    }

    protected void setPrimaryClient(Client primaryClient) {
        this.primaryClient = primaryClient;
    }

    public HashMap<Client, Integer> getClients() {
        return clients;
    }

    protected void setClients(HashMap<Client, Integer> clients) {
        this.clients = clients;
    }

    public Actor getCollector() {
        return collector;
    }

    protected void setCollector(Actor collector) {
        this.collector = collector;
    }

    public CollectionUnit getUnit() {
        return unit;
    }

    protected void setUnit(CollectionUnit unit) {
        this.unit = unit;
    }

    public int getCurrBal() {
        return currBal;
    }

    protected void setCurrBal(int currBal) {
        this.currBal = currBal;
    }

    public int getOrigBal() {
        return origBal;
    }

    protected void setOrigBal(int origBal) {
        this.origBal = origBal;
    }

    public int getPayments() {
        return payments;
    }

    protected void setPayments(int payments) {
        this.payments = payments;
    }

    public boolean isMailReturn() {
        return mailReturn;
    }

    protected void setMailReturn(boolean mailReturn) {
        this.mailReturn = mailReturn;
    }

    public boolean isPaidInFull() {
        return paidInFull;
    }

    protected void setPaidInFull(boolean paidInFull) {
        this.paidInFull = paidInFull;
    }

    public boolean isWorkedSinceLastNewbiz() {
        return workedSinceLastNewbiz;
    }

    protected void setWorkedSinceLastNewbiz(boolean workedSinceLastNewbiz) {
        this.workedSinceLastNewbiz = workedSinceLastNewbiz;
    }

    public boolean isHasAssetWindow() {
        return hasAssetWindow;
    }

    protected void setHasAssetWindow(boolean hasAssetWindow) {
        this.hasAssetWindow = hasAssetWindow;
    }

    public boolean isHasEmploymentWindow() {
        return hasEmploymentWindow;
    }

    protected void setHasEmploymentWindow(boolean hasEmploymentWindow) {
        this.hasEmploymentWindow = hasEmploymentWindow;
    }

    public boolean isHasAddressWindow() {
        return hasAddressWindow;
    }

    protected void setHasAddressWindow(boolean hasAddressWindow) {
        this.hasAddressWindow = hasAddressWindow;
    }

    public boolean isHasPhone() {
        return hasPhone;
    }

    protected void setHasPhone(boolean hasPhone) {
        this.hasPhone = hasPhone;
    }

    public boolean isWithAttorney() {
        return withAttorney;
    }

    protected void setWithAttorney(boolean withAttorney) {
        this.withAttorney = withAttorney;
    }

    public boolean isWithForward() {
        return withForward;
    }

    protected void setWithForward(boolean withForward) {
        this.withForward = withForward;
    }

    public boolean isHasRestrictionsWindow() {
        return hasRestrictionsWindow;
    }

    protected void setHasRestrictionsWindow(boolean hasRestrictionsWindow) {
        this.hasRestrictionsWindow = hasRestrictionsWindow;
    }

    public boolean isDoNotCall() {
        return doNotCall;
    }

    protected void setDoNotCall(boolean doNotCall) {
        this.doNotCall = doNotCall;
    }

    public boolean isDoNotCallHome() {
        return doNotCallHome;
    }

    protected void setDoNotCallHome(boolean doNotCallHome) {
        this.doNotCallHome = doNotCallHome;
    }

    public boolean isDoNotWriteWork() {
        return doNotWriteWork;
    }

    protected void setDoNotWriteWork(boolean doNotWriteWork) {
        this.doNotWriteWork = doNotWriteWork;
    }

    public boolean isDoNotCallWork() {
        return doNotCallWork;
    }

    protected void setDoNotCallWork(boolean doNotCallWork) {
        this.doNotCallWork = doNotCallWork;
    }

    public boolean isDebtReturned() {
        return debtReturned;
    }

    protected void setDebtReturned(boolean debtReturned) {
        this.debtReturned = debtReturned;
    }

    public boolean isEverNSF() {
        return everNSF;
    }

    protected void setEverNSF(boolean everNSF) {
        this.everNSF = everNSF;
    }

    public boolean isEverSkipTracedPhone() {
        return everSkipTracedPhone;
    }

    protected void setEverSkipTracedPhone(boolean everSkipTracedPhone) {
        this.everSkipTracedPhone = everSkipTracedPhone;
    }

    public boolean isEverSkipTracedAddress() {
        return everSkipTracedAddress;
    }

    protected void setEverSkipTracedAddress(boolean everSkipTracedAddress) {
        this.everSkipTracedAddress = everSkipTracedAddress;
    }

    public boolean isEverSkipTracedOther() {
        return everSkipTracedOther;
    }

    protected void setEverSkipTracedOther(boolean everSkipTracedOther) {
        this.everSkipTracedOther = everSkipTracedOther;
    }

    public boolean isEverMailReturn() {
        return everMailReturn;
    }

    protected void setEverMailReturn(boolean everMailReturn) {
        this.everMailReturn = everMailReturn;
    }

    public boolean isPreCollect() {
        return preCollect;
    }

    protected void setPreCollect(boolean preCollect) {
        this.preCollect = preCollect;
    }

    public boolean isMergeInProgress() {
        return mergeInProgress;
    }

    protected void setMergeInProgress(boolean mergeInProgress) {
        this.mergeInProgress = mergeInProgress;
    }

    public boolean isSplitInProgress() {
        return splitInProgress;
    }

    protected void setSplitInProgress(boolean splitInProgress) {
        this.splitInProgress = splitInProgress;
    }

    public boolean isDebtsCanAccrueInterest() {
        return debtsCanAccrueInterest;
    }

    protected void setDebtsCanAccrueInterest(boolean debtsCanAccrueInterest) {
        this.debtsCanAccrueInterest = debtsCanAccrueInterest;
    }

    public AttorneyForwarder getAttorneyForwarder() {
        return attorneyForwarder;
    }

    protected void setAttorneyForwarder(AttorneyForwarder attorneyForwarder) {
        this.attorneyForwarder = attorneyForwarder;
    }

    public GregorianCalendar getDateSentOut() {
        return dateSentOut;
    }

    protected void setDateSentOut(GregorianCalendar dateSentOut) {
        this.dateSentOut = dateSentOut;
    }

    public GregorianCalendar getDateLastPaid() {
        return dateLastPaid;
    }

    protected void setDateLastPaid(GregorianCalendar dateLastPaid) {
        this.dateLastPaid = dateLastPaid;
    }

    public GregorianCalendar getDateLastSeen() {
        return dateLastSeen;
    }

    protected void setDateLastSeen(GregorianCalendar dateLastSeen) {
        this.dateLastSeen = dateLastSeen;
    }

    public GregorianCalendar getDateLastNewbiz() {
        return dateLastNewbiz;
    }

    protected void setDateLastNewbiz(GregorianCalendar dateLastNewbiz) {
        this.dateLastNewbiz = dateLastNewbiz;
    }

    public GregorianCalendar getDateOriginallyReceived() {
        return dateOriginallyReceived;
    }

    protected void setDateOriginallyReceived(GregorianCalendar dateOriginallyReceived) {
        this.dateOriginallyReceived = dateOriginallyReceived;
    }

    public GregorianCalendar getDateClosed() {
        return dateClosed;
    }

    protected void setDateClosed(GregorianCalendar dateClosed) {
        this.dateClosed = dateClosed;
    }

    public GregorianCalendar getDateLastUpdated() {
        return dateLastUpdated;
    }

    protected void setDateLastUpdated(GregorianCalendar dateLastUpdated) {
        this.dateLastUpdated = dateLastUpdated;
    }

    public int getCollectorRetrySendDays() {
        return collectorRetrySendDays;
    }

    protected void setCollectorRetrySendDays(int collectorRetrySendDays) {
        this.collectorRetrySendDays = collectorRetrySendDays;
    }

    public int getLettersLeft() {
        return lettersLeft;
    }

    protected void setLettersLeft(int lettersLeft) {
        this.lettersLeft = lettersLeft;
    }

    public Priority getPriority() {
        return priority;
    }

    protected void setPriority(Priority priority) {
        this.priority = priority;
    }

    public CollectionUnit getPriorCollector() {
        return priorCollector;
    }

    protected void setPriorCollector(CollectionUnit priorCollector) {
        this.priorCollector = priorCollector;
    }

    public Promise getPaymentPromise() {
        return paymentPromise;
    }

    protected void setPaymentPromise(Promise paymentPromise) {
        this.paymentPromise = paymentPromise;
    }

    public AccountStatus getStatus() {
        return status;
    }

    protected void setStatus(AccountStatus status) {
        this.status = status;
    }

    public int getKeptPromises() {
        return keptPromises;
    }

    protected void setKeptPromises(int keptPromises) {
        this.keptPromises = keptPromises;
    }

    public int getBrokenPromises() {
        return brokenPromises;
    }

    protected void setBrokenPromises(int brokenPromises) {
        this.brokenPromises = brokenPromises;
    }

    public boolean isMatchable() {
        return matchable;
    }

    protected void setMatchable(boolean matchable) {
        this.matchable = matchable;
    }

    public boolean isMergeable() {
        return mergeable;
    }

    protected void setMergeable(boolean mergeable) {
        this.mergeable = mergeable;
    }

    public boolean isLocked() {
        return locked;
    }

    protected void setLocked(boolean locked) {
        this.locked = locked;
    }

    public DemographicField<String> getLastName() {
        return lastName;
    }


    public HashMap<String, SupplementalData> getAncil() {
        return ancil;
    }

    public void setAncil(HashMap<String, SupplementalData> ancil) {
        this.ancil = ancil;
    }

    public HashMap<Integer, Debt> getDebt() {
        return debt;
    }

    public void setDebt(HashMap<Integer, Debt> debt) {
        this.debt = debt;
    }

    public HashMap<Integer, History> getHistory() {
        return history;
    }

    public void setHistory(HashMap<Integer, History> history) {
        this.history = history;
    }

    public HashMap<Integer, Payment> getPayment() {
        return payment;
    }

    public void setPayment(HashMap<Integer, Payment> payment) {
        this.payment = payment;
    }

    public HashMap<Integer, Legal> getLegal() {
        return legal;
    }

    public void setLegal(HashMap<Integer, Legal> legal) {
        this.legal = legal;
    }

    public MessageQueue getActivity() {
        return activity;
    }

    public void setActivity(MessageQueue activity) {
        this.activity = activity;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    
    
}
