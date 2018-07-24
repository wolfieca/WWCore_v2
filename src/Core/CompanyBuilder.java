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

    public CompanyBuilder() {
    }

    public CompanyBuilder setMoneyNames(TreeSet<String> moneyNames) {
        this.moneyNames = moneyNames;
        return this;
    }

    public CompanyBuilder setSimpleInterest(HashMap<String, Boolean> simpleInterest) {
        this.simpleInterest = simpleInterest;
        return this;
    }

    public CompanyBuilder setCompoundInterest(HashMap<String, Boolean> compoundInterest) {
        this.compoundInterest = compoundInterest;
        return this;
    }

    public CompanyBuilder setCollectionCharge(int collectionCharge) {
        this.collectionCharge = collectionCharge;
        return this;
    }

    public CompanyBuilder setAccumulatedInterest(int accumulatedInterest) {
        this.accumulatedInterest = accumulatedInterest;
        return this;
    }

    public CompanyBuilder setBillableCourtCosts(int billableCourtCosts) {
        this.billableCourtCosts = billableCourtCosts;
        return this;
    }

    public CompanyBuilder setInternalCourtCosts(int internalCourtCosts) {
        this.internalCourtCosts = internalCourtCosts;
        return this;
    }

    public CompanyBuilder setClosedAccountInterest(boolean closedAccountInterest) {
        this.closedAccountInterest = closedAccountInterest;
        return this;
    }

    public CompanyBuilder setFiscalMonth(GregorianCalendar fiscalMonth) {
        this.fiscalMonth = fiscalMonth;
        return this;
    }

    public CompanyBuilder setLastDebtorNumber(Long lastDebtorNumber) {
        this.lastDebtorNumber = lastDebtorNumber;
        return this;
    }

    public CompanyBuilder setLastInvoiceNumber(Long lastInvoiceNumber) {
        this.lastInvoiceNumber = lastInvoiceNumber;
        return this;
    }

    public CompanyBuilder setLastInternalBatchNumber(Long lastInternalBatchNumber) {
        this.lastInternalBatchNumber = lastInternalBatchNumber;
        return this;
    }

    public CompanyBuilder setValidInvoiceCycles(String validInvoiceCycles) {
        this.validInvoiceCycles = validInvoiceCycles;
        return this;
    }

    public CompanyBuilder setCollectorQuotaBase(Company.QuotaBase collectorQuotaBase) {
        this.collectorQuotaBase = collectorQuotaBase;
        return this;
    }

    public CompanyBuilder setReorderDebtsOnMerge(boolean reorderDebtsOnMerge) {
        this.reorderDebtsOnMerge = reorderDebtsOnMerge;
        return this;
    }

    public CompanyBuilder setKeptMinPerc(int keptMinPerc) {
        this.keptMinPerc = keptMinPerc;
        return this;
    }

    public CompanyBuilder setInhibitMultiRoll(boolean inhibitMultiRoll) {
        this.inhibitMultiRoll = inhibitMultiRoll;
        return this;
    }

    public CompanyBuilder setReminderLetterDays(int reminderLetterDays) {
        this.reminderLetterDays = reminderLetterDays;
        return this;
    }

    public CompanyBuilder setReminderNSF(boolean reminderNSF) {
        this.reminderNSF = reminderNSF;
        return this;
    }

    public CompanyBuilder setRestrictedStates(TreeSet<String> restrictedStates) {
        this.restrictedStates = restrictedStates;
        return this;
    }

    public CompanyBuilder setStatements(Company.Forms statements) {
        this.statements = statements;
        return this;
    }

    public CompanyBuilder setInvoices(Company.Forms invoices) {
        this.invoices = invoices;
        return this;
    }

    public Company createCompany() {
        return new Company(moneyNames, simpleInterest, compoundInterest, collectionCharge, accumulatedInterest, billableCourtCosts, internalCourtCosts, closedAccountInterest, fiscalMonth, lastDebtorNumber, lastInvoiceNumber, lastInternalBatchNumber, validInvoiceCycles, collectorQuotaBase, reorderDebtsOnMerge, keptMinPerc, inhibitMultiRoll, reminderLetterDays, reminderNSF, restrictedStates, statements, invoices);
    }
    
}
