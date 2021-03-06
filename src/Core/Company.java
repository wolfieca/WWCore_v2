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
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Company-specific information. This was formerly a part of the System record.
 * But with the migration of a variety of System management-related data to the
 * System object, I'm moving them to a separate Company Object, which is also
 * part of the System object.
 * Needs to be revised.
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class Company extends WWObject implements Reportable{
    private String companyName;
    private Set<Office> offices;
    
    private TreeSet<String> moneyNames;

    /**
     *
     */
    public enum Interest {

        /**
         *
         */
        NONE,

        /**
         *
         */
        SIMPLE,

        /**
         *
         */
        COMPOUND,

        /**
         *
         */
        EITHER
    }
    
    private HashMap<String,Interest> accrueInterest;
    //private HashMap<String,Boolean> compoundInterest;
    private int collectionCharge;
    private int accumulatedInterest;
    private int billableCourtCosts;
    private long internalCourtCosts;
    private boolean closedAccountInterest;
    private LocalDateTime fiscalMonth;
    private long lastDebtorNumber;
    private long lastInvoiceNumber;
    private long lastInternalBatchNumber;
    private String validInvoiceCycles;
    /**
     *
     */
    public enum QuotaBase{

        /**
         *
         */
        GROSS,

        /**
         *
         */
        NET
    };
    private QuotaBase collectorQuotaBase;
    private boolean reorderDebtsOnMerge;
    private int keptMinPerc;
    private boolean inhibitMultiRoll;
    private int reminderLetterDays;
    private boolean reminderNSF;
    private TreeSet<String> restrictedStates;

    /**
     *
     */
    public enum Forms{

        /**
         *
         */
        WIDE,

        /**
         *
         */
        NARROW,

        /**
         *
         */
        OTHER,

        /**
         *
         */
        LASER
    }
    private Forms statements;
    private Forms invoices;

    /**
     *
     */
    public Company() {
    }

    /**
     *
     * @param moneyNames
     * @param simpleInterest
     * @param compoundInterest
     * @param collectionCharge
     * @param accumulatedInterest
     * @param billableCourtCosts
     * @param internalCourtCosts
     * @param closedAccountInterest
     * @param fiscalMonth
     * @param lastDebtorNumber
     * @param lastInvoiceNumber
     * @param lastInternalBatchNumber
     * @param validInvoiceCycles
     * @param collectorQuotaBase
     * @param reorderDebtsOnMerge
     * @param keptMinPerc
     * @param inhibitMultiRoll
     * @param reminderLetterDays
     * @param reminderNSF
     * @param restrictedStates
     * @param statements
     * @param invoices
     */
    public Company(TreeSet<String> moneyNames, HashMap<String, Boolean> 
            simpleInterest, HashMap<String, Boolean> compoundInterest, 
            int collectionCharge, int accumulatedInterest, int billableCourtCosts, 
            int internalCourtCosts, boolean closedAccountInterest, 
            LocalDateTime fiscalMonth, Long lastDebtorNumber, 
            Long lastInvoiceNumber, Long lastInternalBatchNumber, 
            String validInvoiceCycles, QuotaBase collectorQuotaBase, 
            boolean reorderDebtsOnMerge, int keptMinPerc, boolean inhibitMultiRoll, 
            int reminderLetterDays, boolean reminderNSF, 
            TreeSet<String> restrictedStates, Forms statements, Forms invoices) {
        this.moneyNames = moneyNames;
        this.collectionCharge = collectionCharge;
        this.accumulatedInterest = accumulatedInterest;
        this.billableCourtCosts = billableCourtCosts;
        this.internalCourtCosts = internalCourtCosts;
        this.closedAccountInterest = closedAccountInterest;
        this.fiscalMonth = fiscalMonth;
        this.lastDebtorNumber = lastDebtorNumber;
        this.lastInvoiceNumber = lastInvoiceNumber;
        this.lastInternalBatchNumber = lastInternalBatchNumber;
        this.validInvoiceCycles = validInvoiceCycles;
        this.collectorQuotaBase = collectorQuotaBase;
        this.reorderDebtsOnMerge = reorderDebtsOnMerge;
        this.keptMinPerc = keptMinPerc;
        this.inhibitMultiRoll = inhibitMultiRoll;
        this.reminderLetterDays = reminderLetterDays;
        this.reminderNSF = reminderNSF;
        this.restrictedStates = restrictedStates;
        this.statements = statements;
        this.invoices = invoices;
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
     * @param caller
     * @return
     */
    @Override
    public Report produceReportFor(Session caller) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param caller
     * @return
     */
    @Override
    public Report produceReportFor(User caller) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    @Override
    public Map<String, Object> reportParameters() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param parameters
     */
    @Override
    public void reportParameters(Map<String, Object> parameters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    /**
     * @return the moneyNames
     */
    public Set<String> getMoneyNames() {
        return new TreeSet<>(moneyNames);
    }

    /**
     * @return the simpleInterest
     */

    /**
     * @return the collectionCharge
     */
    public int getCollectionCharge() {
        return collectionCharge;
    }

    /**
     * @return the accumulatedInterest
     */
    public int getAccumulatedInterest() {
        return accumulatedInterest;
    }

    /**
     * @return the billableCourtCosts
     */
    public int getBillableCourtCosts() {
        return billableCourtCosts;
    }

    /**
     * @return the internalCourtCosts
     */
    public long getInternalCourtCosts() {
        return internalCourtCosts;
    }

    /**
     * @return the closedAccountInterest
     */
    public boolean isClosedAccountInterest() {
        return closedAccountInterest;
    }

    /**
     * @return the fiscalMonth
     */
    public LocalDateTime getFiscalMonth() {
        return fiscalMonth;
    }

    /**
     * @return the lastDebtorNumber
     */
    public Long getLastDebtorNumber() {
        return new Long(lastDebtorNumber);
    }

    /**
     * @return the lastInvoiceNumber
     */
    public Long getLastInvoiceNumber() {
        return new Long(lastInvoiceNumber);
    }

    /**
     * @return the lastInternalBatchNumber
     */
    public Long getLastInternalBatchNumber() {
        return new Long(lastInternalBatchNumber);
    }

    /**
     * @return the validInvoiceCycles
     */
    public String getValidInvoiceCycles() {
        return new String(validInvoiceCycles);
    }

    /**
     * @return the collectorQuotaBase
     */
    public QuotaBase getCollectorQuotaBase() {
        return collectorQuotaBase;
    }

    /**
     * @return the reorderDebtsOnMerge
     */
    public boolean isReorderDebtsOnMerge() {
        return reorderDebtsOnMerge;
    }

    /**
     * @return the keptMinPerc
     */
    public int getKeptMinPerc() {
        return keptMinPerc;
    }

    /**
     * @return the inhibitMultiRoll
     */
    public boolean isInhibitMultiRoll() {
        return inhibitMultiRoll;
    }

    /**
     * @return the reminderLetterDays
     */
    public int getReminderLetterDays() {
        return reminderLetterDays;
    }

    /**
     * @return the reminderNSF
     */
    public boolean isReminderNSF() {
        return reminderNSF;
    }

    /**
     * @return the restrictedStates
     */
    public TreeSet<String> getRestrictedStates() {
        return new TreeSet<>(restrictedStates);
    }

    /**
     * @return the statements
     */
    public Forms getStatements() {
        return statements;
    }

    /**
     * @return the invoices
     */
    public Forms getInvoices() {
        return invoices;
    }

    /**
     * @param moneyNames the moneyNames to set
     */
    protected void setMoneyNames(TreeSet<String> moneyNames) {
        this.moneyNames = moneyNames;
    }


    /**
     * @param collectionCharge the collectionCharge to set
     */
    protected void setCollectionCharge(int collectionCharge) {
        this.collectionCharge = collectionCharge;
    }

    /**
     * @param accumulatedInterest the accumulatedInterest to set
     */
    protected void setAccumulatedInterest(int accumulatedInterest) {
        this.accumulatedInterest = accumulatedInterest;
    }

    /**
     * @param billableCourtCosts the billableCourtCosts to set
     */
    protected void setBillableCourtCosts(int billableCourtCosts) {
        this.billableCourtCosts = billableCourtCosts;
    }

    /**
     * @param internalCourtCosts the internalCourtCosts to set
     */
    protected void setInternalCourtCosts(int internalCourtCosts) {
        this.internalCourtCosts = internalCourtCosts;
    }

    /**
     * @param closedAccountInterest the closedAccountInterest to set
     */
    protected void setClosedAccountInterest(boolean closedAccountInterest) {
        this.closedAccountInterest = closedAccountInterest;
    }

    /**
     * @param fiscalMonth the fiscalMonth to set
     */
    protected void setFiscalMonth(LocalDateTime fiscalMonth) {
        this.fiscalMonth = fiscalMonth;
    }

    /**
     * @param lastDebtorNumber the lastDebtorNumber to set
     */
    protected void setLastDebtorNumber(Long lastDebtorNumber) {
        this.lastDebtorNumber = lastDebtorNumber;
    }

    /**
     * @param lastInvoiceNumber the lastInvoiceNumber to set
     */
    protected void setLastInvoiceNumber(Long lastInvoiceNumber) {
        this.lastInvoiceNumber = lastInvoiceNumber;
    }

    /**
     * @param lastInternalBatchNumber the lastInternalBatchNumber to set
     */
    protected void setLastInternalBatchNumber(Long lastInternalBatchNumber) {
        this.lastInternalBatchNumber = lastInternalBatchNumber;
    }

    /**
     * @param validInvoiceCycles the validInvoiceCycles to set
     */
    protected void setValidInvoiceCycles(String validInvoiceCycles) {
        this.validInvoiceCycles = validInvoiceCycles;
    }

    /**
     * @param collectorQuotaBase the collectorQuotaBase to set
     */
    protected void setCollectorQuotaBase(QuotaBase collectorQuotaBase) {
        this.collectorQuotaBase = collectorQuotaBase;
    }

    /**
     * @param reorderDebtsOnMerge the reorderDebtsOnMerge to set
     */
    protected void setReorderDebtsOnMerge(boolean reorderDebtsOnMerge) {
        this.reorderDebtsOnMerge = reorderDebtsOnMerge;
    }

    /**
     * @param keptMinPerc the keptMinPerc to set
     */
    protected void setKeptMinPerc(int keptMinPerc) {
        this.keptMinPerc = keptMinPerc;
    }

    /**
     * @param inhibitMultiRoll the inhibitMultiRoll to set
     */
    protected void setInhibitMultiRoll(boolean inhibitMultiRoll) {
        this.inhibitMultiRoll = inhibitMultiRoll;
    }

    /**
     * @param reminderLetterDays the reminderLetterDays to set
     */
    protected void setReminderLetterDays(int reminderLetterDays) {
        this.reminderLetterDays = reminderLetterDays;
    }

    /**
     * @param reminderNSF the reminderNSF to set
     */
    protected void setReminderNSF(boolean reminderNSF) {
        this.reminderNSF = reminderNSF;
    }

    /**
     * @param restrictedStates the restrictedStates to set
     */
    protected void setRestrictedStates(TreeSet<String> restrictedStates) {
        this.restrictedStates = restrictedStates;
    }

    /**
     * @param statements the statements to set
     */
    protected void setStatements(Forms statements) {
        this.statements = statements;
    }

    /**
     * @param invoices the invoices to set
     */
    protected void setInvoices(Forms invoices) {
        this.invoices = invoices;
    }
    
    // Utility methods

    /**
     *
     * @param theState
     */
    public void addRestrictedState(String theState){
        
    }

    /**
     *
     * @param theState
     */
    public void delRestrictedState(String theState){
        
    }
}
