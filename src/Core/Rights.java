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

import java.util.HashMap;
import java.util.Map;
/**
 * The Rights class enumerates rights that an Actor is granted to the
 * system and specified subsystems (run-time modules, for example). Note that
 * Rights are a configurable specification mechanism, there is not enforcement
 * of the rights here. Enforcement is up to individual modules.
 * @author Robert Serrano <wolfieca.rs@gmail.com>
 */
public class Rights {
    //System rights    
    private boolean localLogin;
    private boolean backup;
    private boolean remoteLogin;
    private boolean shutdown;
    private boolean monitor;
    private boolean grantAccess;
    private boolean revokeAccess;
    private boolean takeOwnership;
    private boolean startServices;
    private boolean stopServices;
    private boolean createUsers;
    private boolean deleteUsers;
    private boolean registerModules;
    private boolean unregisterModules;
    private boolean print;
    private boolean documentRequest;
    private boolean eventListener;
    private boolean reassignThreads;
    private boolean impersonateUser;
    private boolean viewPHI;
    private boolean updatePHI;
    private boolean addSupplementalCategory;
    private boolean deleteSupplementalCategory;
    private boolean alterSupplementalCategory;
    private Map<String,Boolean> rightSet;
    private Long rightSet1;
    private Long rightSet2;
    private Long rightSet3;
    private Long rightSet4;
    private final Map<String,Integer> loginHours;
    private final Map<String,Integer> rightNames;
    private int lastPosition;

    /**
     * Default constructor
     */
    public Rights (){
         // Initialize the rightNames
         //The default rightNames will not change order after release. 
         rightNames = new HashMap<>();
         
         //System rights
        this.localLogin=false;
        this.backup=false;
        this.remoteLogin=false;
        this.shutdown=false;
        this.monitor=false;
        this.grantAccess=false;
        this.revokeAccess=false;
        this.takeOwnership=false;
        this.startServices=false;
        this.stopServices=false;
        this.createUsers=false;
        this.deleteUsers=false;
        this.registerModules=false;
        this.unregisterModules=false;
        this.print=false;
        this.documentRequest=false;
        this.eventListener=false;
        this.reassignThreads=false;
        this.impersonateUser=false;
        this.viewPHI=false;
        this.updatePHI=false;
        this.addSupplementalCategory=false;
        this.deleteSupplementalCategory=false;
        this.alterSupplementalCategory=false;

        //Base Right Definitions should be constant
         
        //Rights Definitions for built-in objects
        rightSet = new HashMap();
        rightSet.put("Debtor.Merge", false);
        rightSet.put("Debtor.Split", false);
        rightSet.put("Debtor.Delete", false);
        rightSet.put("Debtor.PHI.Read", false);
        rightSet.put("Debtor.PHI.Write", false);
        rightSet.put("Debtor.Supp.Read", false);
        rightSet.put("Debtor.Supp.Write", false);
        rightSet.put("Debtor.Lookup.ByHistory", false);
        rightSet.put("Debtor.Lookup.ByQueue", false);
        rightSet.put("Debtor.Lookup.ByGeneral", false);
        rightSet.put("Debtor.Lookup.ByUnit", false);
        rightSet.put("Debtor.Lookup.Blitz", false);
        rightSet.put("Debtor.Lookup.ByTag", false);
        rightSet.put("Debtor.Access.LegalActions", false);
        rightSet.put("Debtor.Access.Precollect", false);
        rightSet.put("Debtor.Update.Telephone", false);
        rightSet.put("Debtor.Update.Collector",false);
        rightSet.put("Debtor.Update.MailReturn",false);
        rightSet.put("Debtor.Update.StrategyStatus", false);
        rightSet.put("Debtor.Update.StatusWithinType", false);
        rightSet.put("Debtor.Update.LettersLeft", false);
        rightSet.put("Debtor.Update.Indicators", false);
        rightSet.put("Debtor.Update.LegalScreen",false);
        rightSet.put("Debt.Read", false);
        rightSet.put("Debt.Write", false);
        rightSet.put("Debt.CRStatus.Write", false);
        rightSet.put("Debt.CRStatus.Read", false);
        rightSet.put("Debt.Update.OrigBalance", false);
        rightSet.put("Debt.Update.For", false);
        rightSet.put("Debt.Update.CliRef", false);
        rightSet.put("Debt.Update.SvcType", false);
        rightSet.put("Debt.Update.DLC", false);
        rightSet.put("Debt.Update.DLP", false);
        rightSet.put("Debt.Update.FeeSched", false);
        rightSet.put("Debt.Update.CredirBureauFields", false);
        rightSet.put("Debt.Update.ReturnStatus", false);
        rightSet.put("Debt.Update.Client", false);
        rightSet.put("Debt.Update.Comments", false);
        rightSet.put("Debt.Update.Tags", false);
        rightSet.put("Bank.Setup.Read", false);
        rightSet.put("Bank.Setup.Write", false);
        rightSet.put("Fee.Setup.Read", false);
        rightSet.put("Fee.Setup.Write", false);
        rightSet.put("Invoice.Setup.Read", false);
        rightSet.put("Invoice.Setup.Write", false);
        rightSet.put("Attorney.Setup.Read", false);
        rightSet.put("Attorney.Setup.Write", false);
        rightSet.put("Lead.Add", false);
        rightSet.put("Lead.Update", false);
        rightSet.put("Lead.Read", false);
        rightSet.put("LetterSeries.Read", false);
        rightSet.put("LetterSeries.Write", false);
        rightSet.put("Match.Setup.Read", false);
        rightSet.put("Match.Match.Setup.Write", false);
        rightSet.put("Misc.Read", false);
        rightSet.put("Misc.Write", false);
        rightSet.put("Newbiz.Read", false);
        rightSet.put("Newbiz.Write", false);
        rightSet.put("Newbiz.Add", false);
        rightSet.put("Newbiz.Update.AccountName", false);
        rightSet.put("Newbiz.Update.GeneralInformation", false);
        rightSet.put("Newbiz.Update.SkipTraceInfo", false);
        rightSet.put("Newbiz.Update.CrossReference", false);
        rightSet.put("Newbiz.Update.Historical", false);
        rightSet.put("Newbiz.Update.CollectorNotes", false);
        rightSet.put("Office.Setup.Read", false);
        rightSet.put("Office.Setup.Write", false);
        rightSet.put("Payments.Read", false);
        rightSet.put("Payments.Add", false);
        rightSet.put("Payments.Write", false);
        rightSet.put("Priority,Setup.Read", false);
        rightSet.put("Priority.Setup.Write", false);
        rightSet.put("Strategy.Planning.Read", false);
        rightSet.put("Strategy.Planning.Write", false);
        rightSet.put("User.Setup.Read", false);
        rightSet.put("User.Setup.Write", false);
        rightSet.put("User.ObserveUser", false);
        rightSet.put("User.AdviseUser", false);
        rightSet.put("User.MonitorUsers", false);
        rightSet.put("Supplemental.Category.Read", false);
        rightSet.put("Supplemental.Category.Write", false);
        rightSet.put("Misc.CollectorPaymentStats.Read", false);
        rightSet.put("Misc.ReverseUnmatchedPayments", false);
        rightSet.put("Misc.MultipleOfficeAcccess", false);
        rightSet.put("Misc.ElevatePrivilege", false);
        rightSet.put("Misc.SendAnnouncements", false);
        rightSet.put("Misc.SuperCollector", false);
        rightSet.put("Misc.TriggerEvents", false);
        rightSet.put("Misc.CreateNewTags", false);
        rightSet.put("Misc.InhibitAuditing", false);
        rightSet.put("Report.Run", false);
        rightSet.put("Queue.Merge", false);
        rightSet.put("Account.Reinstate", false);     

        // loginHours by default are cleared (no hours allowed
         // loginHours defaults to having 24 members (ie one element for each
         // hour of the day).
         loginHours = new HashMap<>();
         loginHours.put("Sun", 0);
         loginHours.put("Mon", 0);
         loginHours.put("Tue", 0);
         loginHours.put("Wed", 0);
         loginHours.put("Thu", 0);
         loginHours.put("Fri", 0);
         loginHours.put("Sat", 0);
    }

    /**
     * Explicit full constructor. Creates a new Rights Object with the 
     * parameters specified.
     * @param localLogin
     * @param backup
     * @param remoteLogin
     * @param shutdown
     * @param monitor
     * @param grantAccess
     * @param revokeAccess
     * @param takeOwnership
     * @param startServices
     * @param stopServices
     * @param createUsers
     * @param deleteUsers
     * @param registerModules
     * @param unregisterModules
     * @param print
     * @param documentRequest
     * @param eventListener
     * @param reassignThreads
     * @param impersonateUser
     * @param viewPHI
     * @param updatePHI
     * @param addSupplementalCategory
     * @param deleteSupplementalCategory
     * @param alterSupplementalCategory
     * @param rightSet
     * @param rightSet1
     * @param rightSet2
     * @param rightSet3
     * @param rightSet4
     * @param loginHours
     * @param rightNames
     * @param lastPosition 
     */
    public Rights(boolean localLogin, boolean backup, boolean remoteLogin, boolean shutdown, boolean monitor, boolean grantAccess, boolean revokeAccess, boolean takeOwnership, boolean startServices, boolean stopServices, boolean createUsers, boolean deleteUsers, boolean registerModules, boolean unregisterModules, boolean print, boolean documentRequest, boolean eventListener, boolean reassignThreads, boolean impersonateUser, boolean viewPHI, boolean updatePHI, boolean addSupplementalCategory, boolean deleteSupplementalCategory, boolean alterSupplementalCategory, Map<String, Boolean> rightSet, Long rightSet1, Long rightSet2, Long rightSet3, Long rightSet4, Map<String, Integer> loginHours, Map<String, Integer> rightNames, int lastPosition) {
        this.localLogin = localLogin;
        this.backup = backup;
        this.remoteLogin = remoteLogin;
        this.shutdown = shutdown;
        this.monitor = monitor;
        this.grantAccess = grantAccess;
        this.revokeAccess = revokeAccess;
        this.takeOwnership = takeOwnership;
        this.startServices = startServices;
        this.stopServices = stopServices;
        this.createUsers = createUsers;
        this.deleteUsers = deleteUsers;
        this.registerModules = registerModules;
        this.unregisterModules = unregisterModules;
        this.print = print;
        this.documentRequest = documentRequest;
        this.eventListener = eventListener;
        this.reassignThreads = reassignThreads;
        this.impersonateUser = impersonateUser;
        this.viewPHI = viewPHI;
        this.updatePHI = updatePHI;
        this.addSupplementalCategory = addSupplementalCategory;
        this.deleteSupplementalCategory = deleteSupplementalCategory;
        this.alterSupplementalCategory = alterSupplementalCategory;
        this.rightSet = rightSet;
        this.rightSet1 = rightSet1;
        this.rightSet2 = rightSet2;
        this.rightSet3 = rightSet3;
        this.rightSet4 = rightSet4;
        this.loginHours = loginHours;
        this.rightNames = rightNames;
        this.lastPosition = lastPosition;
    }

    /**
     * Copy Constructor. Create a Rights object that is an exact copy of the 
     * source Rights object
     * @param source 
     */
    public Rights (Rights source){
             // Initialize the rightNames
         //The default rightNames will not change order after release. 
         rightNames = new HashMap<>();
         
         //System rights
        this.localLogin=source.localLogin;
        this.backup=source.backup;
        this.remoteLogin=source.remoteLogin;
        this.shutdown=source.shutdown;
        this.monitor=source.monitor;
        this.grantAccess=source.grantAccess;
        this.revokeAccess=source.revokeAccess;
        this.takeOwnership=source.takeOwnership;
        this.startServices=source.startServices;
        this.stopServices=source.stopServices;
        this.createUsers=source.createUsers;
        this.deleteUsers=source.deleteUsers;
        this.registerModules=source.registerModules;
        this.unregisterModules=source.unregisterModules;
        this.print=source.print;
        this.documentRequest=source.documentRequest;
        this.eventListener=source.eventListener;
        this.reassignThreads=source.reassignThreads;
        this.impersonateUser=source.impersonateUser;
        this.viewPHI=source.viewPHI;
        this.updatePHI=source.updatePHI;
        this.addSupplementalCategory=source.addSupplementalCategory;
        this.deleteSupplementalCategory=source.deleteSupplementalCategory;
        this.alterSupplementalCategory=source.alterSupplementalCategory;

        //Base Right Definitions should be constant
        
        //Rights Definitions for built-in objects
        rightSet = new HashMap(source.rightSet);

        // loginHours by default are cleared (no hours allowed
        // loginHours defaults to having 24 members (ie one element for each
        // hour of the day).
        loginHours = new HashMap(source.loginHours);
    }
}
