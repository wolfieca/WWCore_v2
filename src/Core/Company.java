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
import java.util.Set;

/**
 * Company-specific information. This was formerly a part of the System record.
 * But with the migration of a variety of System management-related data to the
 * System object, I'm moving them to a separate Company Object, which is also
 * part of the System object.
 * @author Robert Serrano <wolfieca.rs@gmail.com>
 */
public class Company {
    private Set<String> moneyNames;
    private HashMap<String,Boolean> simpleInterest;
    private HashMap<String,Boolean> compoundInterest;
    private int collectionCharge;
    private int accumulatedInterest;
    private int billableCourtCosts;
    private int internalCourtCosts;
    private boolean closedAccountInterest;
    private GregorianCalendar fiscalMonth;
    private Long lastDebtorNumber;
    private Long lastInvoiceNumber;
    private Long lastInternalBatchNumber;
    private String validInvoiceCycles;
    public enum QuotaBase{
        GROSS,
        NET
    };
    private QuotaBase collectorQuotaBase;
    private boolean reorderDebtsOnMerge;
    private int keptMinPerc;
    private boolean inhibitMultiRoll;
    private int reminderLetterDays;
    private boolean reminderNSF;
    private Set<String> restrictedStates;
    public enum Forms{
        WIDE,
        NARROW,
        OTHER,
        LASER
    }
    private Forms statements;
    private Forms invoices;
    
    public Set<String> getMoneyNames(){
        return moneyNames;
    }
    public HashMap<String,Boolean> getSimpleInterest(){
        return simpleInterest;
    }
    public Boolean getSimpleInterest(String moneyName){
        return simpleInterest.get(moneyName);
    }
    public HashMap<String,Boolean> getCompoundInterest(){
        return compoundInterest;
    }
    public Boolean getCompoundInterest(String moneyName){
        return compoundInterest.get(moneyName);
    }

    public int getCollectionCharge() {
        return collectionCharge;
    }

    protected void setCollectionCharge(int collectionCharge) {
        this.collectionCharge = collectionCharge;
    }

    public int getAccumulatedInterest() {
        return accumulatedInterest;
    }

    protected void setAccumulatedInterest(int accumulatedInterest) {
        this.accumulatedInterest = accumulatedInterest;
    }

    public int getBillableCourtCosts() {
        return billableCourtCosts;
    }

    protected void setBillableCourtCosts(int billableCourtCosts) {
        this.billableCourtCosts = billableCourtCosts;
    }

    public int getInternalCourtCosts() {
        return internalCourtCosts;
    }

    protected void setInternalCourtCosts(int internalCourtCosts) {
        this.internalCourtCosts = internalCourtCosts;
    }

    public boolean isClosedAccountInterest() {
        return closedAccountInterest;
    }

    protected void setClosedAccountInterest(boolean closedAccountInterest) {
        this.closedAccountInterest = closedAccountInterest;
    }

    public GregorianCalendar getFiscalMonth() {
        return fiscalMonth;
    }

    protected void setFiscalMonth(GregorianCalendar fiscalMonth) {
        this.fiscalMonth = fiscalMonth;
    }

    public Long getLastDebtorNumber() {
        return lastDebtorNumber;
    }

    protected void setLastDebtorNumber(Long lastDebtorNumber) {
        this.lastDebtorNumber = lastDebtorNumber;
    }

    public Long getLastInvoiceNumber() {
        return lastInvoiceNumber;
    }

    protected void setLastInvoiceNumber(Long lastInvoiceNumber) {
        this.lastInvoiceNumber = lastInvoiceNumber;
    }

    public Long getLastInternalBatchNumber() {
        return lastInternalBatchNumber;
    }

    protected void setLastInternalBatchNumber(Long lastInternalBatchNumber) {
        this.lastInternalBatchNumber = lastInternalBatchNumber;
    }

    public String getValidInvoiceCycles() {
        return validInvoiceCycles;
    }

    protected void setValidInvoiceCycles(String validInvoiceCycles) {
        this.validInvoiceCycles = validInvoiceCycles;
    }

    public QuotaBase getCollectorQuotaBase() {
        return collectorQuotaBase;
    }

    protected void setCollectorQuotaBase(QuotaBase collectorQuotaBase) {
        this.collectorQuotaBase = collectorQuotaBase;
    }

    public boolean isReorderDebtsOnMerge() {
        return reorderDebtsOnMerge;
    }

    protected void setReorderDebtsOnMerge(boolean reorderDebtsOnMerge) {
        this.reorderDebtsOnMerge = reorderDebtsOnMerge;
    }

    public int getKeptMinPerc() {
        return keptMinPerc;
    }

    protected void setKeptMinPerc(int keptMinPerc) {
        this.keptMinPerc = keptMinPerc;
    }

    public boolean isInhibitMultiRoll() {
        return inhibitMultiRoll;
    }

    protected void setInhibitMultiRoll(boolean inhibitMultiRoll) {
        this.inhibitMultiRoll = inhibitMultiRoll;
    }

    public int getReminderLetterDays() {
        return reminderLetterDays;
    }

    protected void setReminderLetterDays(int reminderLetterDays) {
        this.reminderLetterDays = reminderLetterDays;
    }

    public boolean isReminderNSF() {
        return reminderNSF;
    }

    protected void setReminderNSF(boolean reminderNSF) {
        this.reminderNSF = reminderNSF;
    }

    public Set<String> getRestrictedStates() {
        return restrictedStates;
    }

    protected void setRestrictedStates(Set<String> restrictedStates) {
        this.restrictedStates = restrictedStates;
    }

    public Forms getStatements() {
        return statements;
    }

    protected void setStatements(Forms statements) {
        this.statements = statements;
    }

    public Forms getInvoices() {
        return invoices;
    }

    protected void setInvoices(Forms invoices) {
        this.invoices = invoices;
    }
    
}
