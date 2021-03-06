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

/**
 * A single Account Status, including all the attributes and actions applied to
 * accounts that are set to this status.
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class AccountStatus extends WWObject{
    private String status;
    private String description;
    private AccountStatusType type;
    private AccountStatusGroup group;
    private Boolean bankrupt;

    /**
     * Enum representing the various types of bankruptcy.
     */
    public enum BankruptcyChapter {

        /**
         *
         */
        CHAPTER07,

        /**
         *
         */
        CHAPTER11,

        /**
         *
         */
        CHAPTER13
    }
    private BankruptcyChapter bankruptcyType;
    private Boolean debtsAccrueInterest;
    private Boolean creditReportable;
    private Boolean putOnReturnReport;
    private Boolean allowLetters;
    private Boolean changeStatusIfPayment;
    private AccountStatus statusChangeTarget;
    private Strategy strategyChangeTarget;

    /**
     *
     * @return
     */
    @Override
    protected WWObject init() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the type
     */
    public AccountStatusType getType() {
        return type;
    }

    /**
     * @return the group
     */
    public AccountStatusGroup getGroup() {
        return group;
    }

    /**
     * @return the bankrupt
     */
    public Boolean getBankrupt() {
        return bankrupt;
    }

    /**
     * @return the bankruptcyType
     */
    public BankruptcyChapter getBankruptcyType() {
        return bankruptcyType;
    }

    /**
     * @return the debtsAccrueInterest
     */
    public Boolean getDebtsAccrueInterest() {
        return debtsAccrueInterest;
    }

    /**
     * @return the creditReportable
     */
    public Boolean getCreditReportable() {
        return creditReportable;
    }

    /**
     * @return the putOnReturnReport
     */
    public Boolean getPutOnReturnReport() {
        return putOnReturnReport;
    }

    /**
     * @return the allowLetters
     */
    public Boolean getAllowLetters() {
        return allowLetters;
    }

    /**
     * @return the changeStatusIfPayment
     */
    public Boolean getChangeStatusIfPayment() {
        return changeStatusIfPayment;
    }

    /**
     * @return the statusChangeTarget
     */
    public AccountStatus getStatusChangeTarget() {
        return statusChangeTarget;
    }

    /**
     * @return the strategyChangeTarget
     */
    public Strategy getStrategyChangeTarget() {
        return strategyChangeTarget;
    }

    /**
     * @param status the status to set
     */
    protected void setStatus(String status) {
        this.status = status;
    }

    /**
     * @param description the description to set
     */
    protected void setDescription(String description) {
        this.description = description;
    }

    /**
     * @param type the type to set
     */
    protected void setType(AccountStatusType type) {
        this.type = type;
    }

    /**
     * @param group the group to set
     */
    protected void setGroup(AccountStatusGroup group) {
        this.group = group;
    }

    /**
     * @param bankrupt the bankrupt to set
     */
    protected void setBankrupt(Boolean bankrupt) {
        this.bankrupt = bankrupt;
    }

    /**
     * @param bankruptcyType the bankruptcyType to set
     */
    protected void setBankruptcyType(BankruptcyChapter bankruptcyType) {
        this.bankruptcyType = bankruptcyType;
    }

    /**
     * @param debtsAccrueInterest the debtsAccrueInterest to set
     */
    protected void setDebtsAccrueInterest(Boolean debtsAccrueInterest) {
        this.debtsAccrueInterest = debtsAccrueInterest;
    }

    /**
     * @param creditReportable the creditReportable to set
     */
    protected void setCreditReportable(Boolean creditReportable) {
        this.creditReportable = creditReportable;
    }

    /**
     * @param putOnReturnReport the putOnReturnReport to set
     */
    protected void setPutOnReturnReport(Boolean putOnReturnReport) {
        this.putOnReturnReport = putOnReturnReport;
    }

    /**
     * @param allowLetters the allowLetters to set
     */
    protected void setAllowLetters(Boolean allowLetters) {
        this.allowLetters = allowLetters;
    }

    /**
     * @param changeStatusIfPayment the changeStatusIfPayment to set
     */
    protected void setChangeStatusIfPayment(Boolean changeStatusIfPayment) {
        this.changeStatusIfPayment = changeStatusIfPayment;
    }

    /**
     * @param statusChangeTarget the statusChangeTarget to set
     */
    protected void setStatusChangeTarget(AccountStatus statusChangeTarget) {
        this.statusChangeTarget = statusChangeTarget;
    }

    /**
     * @param strategyChangeTarget the strategyChangeTarget to set
     */
    protected void setStrategyChangeTarget(Strategy strategyChangeTarget) {
        this.strategyChangeTarget = strategyChangeTarget;
    }
    

}
