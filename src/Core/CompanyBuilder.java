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
import java.util.TreeSet;

/**
 *
 * @author odin
 */
public class CompanyBuilder {

    private TreeSet<String> moneyNames;
    private HashMap<String, Boolean> simpleInterest;
    private HashMap<String, Boolean> compoundInterest;
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
    private Company.QuotaBase collectorQuotaBase;
    private boolean reorderDebtsOnMerge;
    private int keptMinPerc;
    private boolean inhibitMultiRoll;
    private int reminderLetterDays;
    private boolean reminderNSF;
    private TreeSet<String> restrictedStates;
    private Company.Forms statements;
    private Company.Forms invoices;

    /**
     *
     */
    public CompanyBuilder() {
    }

    /**
     *
     * @param moneyNames
     * @return
     */
    public CompanyBuilder setMoneyNames(TreeSet<String> moneyNames) {
        this.moneyNames = moneyNames;
        return this;
    }

    /**
     *
     * @param simpleInterest
     * @return
     */
    public CompanyBuilder setSimpleInterest(HashMap<String, Boolean> simpleInterest) {
        this.simpleInterest = simpleInterest;
        return this;
    }

    /**
     *
     * @param compoundInterest
     * @return
     */
    public CompanyBuilder setCompoundInterest(HashMap<String, Boolean> compoundInterest) {
        this.compoundInterest = compoundInterest;
        return this;
    }

    /**
     *
     * @param collectionCharge
     * @return
     */
    public CompanyBuilder setCollectionCharge(int collectionCharge) {
        this.collectionCharge = collectionCharge;
        return this;
    }

    /**
     *
     * @param accumulatedInterest
     * @return
     */
    public CompanyBuilder setAccumulatedInterest(int accumulatedInterest) {
        this.accumulatedInterest = accumulatedInterest;
        return this;
    }

    /**
     *
     * @param billableCourtCosts
     * @return
     */
    public CompanyBuilder setBillableCourtCosts(int billableCourtCosts) {
        this.billableCourtCosts = billableCourtCosts;
        return this;
    }

    /**
     *
     * @param internalCourtCosts
     * @return
     */
    public CompanyBuilder setInternalCourtCosts(int internalCourtCosts) {
        this.internalCourtCosts = internalCourtCosts;
        return this;
    }

    /**
     *
     * @param closedAccountInterest
     * @return
     */
    public CompanyBuilder setClosedAccountInterest(boolean closedAccountInterest) {
        this.closedAccountInterest = closedAccountInterest;
        return this;
    }

    /**
     *
     * @param fiscalMonth
     * @return
     */
    public CompanyBuilder setFiscalMonth(GregorianCalendar fiscalMonth) {
        this.fiscalMonth = fiscalMonth;
        return this;
    }

    /**
     *
     * @param lastDebtorNumber
     * @return
     */
    public CompanyBuilder setLastDebtorNumber(Long lastDebtorNumber) {
        this.lastDebtorNumber = lastDebtorNumber;
        return this;
    }

    /**
     *
     * @param lastInvoiceNumber
     * @return
     */
    public CompanyBuilder setLastInvoiceNumber(Long lastInvoiceNumber) {
        this.lastInvoiceNumber = lastInvoiceNumber;
        return this;
    }

    /**
     *
     * @param lastInternalBatchNumber
     * @return
     */
    public CompanyBuilder setLastInternalBatchNumber(Long lastInternalBatchNumber) {
        this.lastInternalBatchNumber = lastInternalBatchNumber;
        return this;
    }

    /**
     *
     * @param validInvoiceCycles
     * @return
     */
    public CompanyBuilder setValidInvoiceCycles(String validInvoiceCycles) {
        this.validInvoiceCycles = validInvoiceCycles;
        return this;
    }

    /**
     *
     * @param collectorQuotaBase
     * @return
     */
    public CompanyBuilder setCollectorQuotaBase(Company.QuotaBase collectorQuotaBase) {
        this.collectorQuotaBase = collectorQuotaBase;
        return this;
    }

    /**
     *
     * @param reorderDebtsOnMerge
     * @return
     */
    public CompanyBuilder setReorderDebtsOnMerge(boolean reorderDebtsOnMerge) {
        this.reorderDebtsOnMerge = reorderDebtsOnMerge;
        return this;
    }

    /**
     *
     * @param keptMinPerc
     * @return
     */
    public CompanyBuilder setKeptMinPerc(int keptMinPerc) {
        this.keptMinPerc = keptMinPerc;
        return this;
    }

    /**
     *
     * @param inhibitMultiRoll
     * @return
     */
    public CompanyBuilder setInhibitMultiRoll(boolean inhibitMultiRoll) {
        this.inhibitMultiRoll = inhibitMultiRoll;
        return this;
    }

    /**
     *
     * @param reminderLetterDays
     * @return
     */
    public CompanyBuilder setReminderLetterDays(int reminderLetterDays) {
        this.reminderLetterDays = reminderLetterDays;
        return this;
    }

    /**
     *
     * @param reminderNSF
     * @return
     */
    public CompanyBuilder setReminderNSF(boolean reminderNSF) {
        this.reminderNSF = reminderNSF;
        return this;
    }

    /**
     *
     * @param restrictedStates
     * @return
     */
    public CompanyBuilder setRestrictedStates(TreeSet<String> restrictedStates) {
        this.restrictedStates = restrictedStates;
        return this;
    }

    /**
     *
     * @param statements
     * @return
     */
    public CompanyBuilder setStatements(Company.Forms statements) {
        this.statements = statements;
        return this;
    }

    /**
     *
     * @param invoices
     * @return
     */
    public CompanyBuilder setInvoices(Company.Forms invoices) {
        this.invoices = invoices;
        return this;
    }

    /**
     *
     * @return
     */
    public Company createCompany() {
        return new Company(moneyNames, simpleInterest, compoundInterest, collectionCharge, accumulatedInterest, billableCourtCosts, internalCourtCosts, closedAccountInterest, fiscalMonth, lastDebtorNumber, lastInvoiceNumber, lastInternalBatchNumber, validInvoiceCycles, collectorQuotaBase, reorderDebtsOnMerge, keptMinPerc, inhibitMultiRoll, reminderLetterDays, reminderNSF, restrictedStates, statements, invoices);
    }
    
}
