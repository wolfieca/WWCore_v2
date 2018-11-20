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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * The Rights class enumerates rights that an Actor is granted to the
 * system and specified subsystems (run-time modules, for example). Note that
 * Rights are a configurable specification mechanism, there is not enforcement
 * of the rights here. Enforcement is up to individual modules. 
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class Rights implements AccessRights{
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
    private Map<String,Map<String,Boolean>> rightSet;
   
    //private Long rightSet1;
    //private Long rightSet2;
    //private Long rightSet3;
    //private Long rightSet4;
    private Map<String,Map<String,Boolean>> loginHours;
    private Map<String,Integer> rightNames;
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
        //rightSet.put("Debtor",)
        HashMap<String,Boolean> subTree = new HashMap();  
        
        
        /**
         * System Rights. These rights allow the user to interact with the system
         * itself in controlled ways.
         */
        subTree.put("LocalLogin", false);
        /**
         * PHI Rights. What interaction with PHI is the user allowed?
         */
        subTree.put("Read", false); 
        subTree.put("Write", false);
        subTree.put("Update", false);
        rightSet.put("PHI", subTree);
        subTree.clear();

        /**
         * Debtor Rights. What rights does the user have to Debtor objects and
         * sub-parts thereof?
         */
        subTree.put("Merge", false);
        subTree.put("Split", false);
        subTree.put("Delete", false);
        subTree.put("Demographics.Read", false);
        subTree.put("Demographics.Write", false);
        subTree.put("Lookup.ByHistory", false);
        subTree.put("Lookup.ByQueue", false);
        subTree.put("Lookup.ByGeneral", false);
        subTree.put("Lookup.ByUnit", false);
        subTree.put("Lookup.Blitz", false);
        subTree.put("Lookup.ByTag", false);
        subTree.put("Access.LegalActions", false);
        subTree.put("Access.Precollect", false);
        subTree.put("Update.Telephone", false);
        subTree.put("Update.Collector",false);
        subTree.put("Update.MailReturn",false);
        subTree.put("Update.StrategyStatus", false);
        subTree.put("Update.StatusWithinType", false);
        subTree.put("Update.LettersLeft", false);
        subTree.put("Update.Indicators", false);
        subTree.put("Update.LegalScreen",false);
        subTree.put("Lock", false);
        rightSet.put("Debtor", subTree);
        subTree.clear();
        
        /**
         * Debt rights. What access does the user have to debts. 
         */
        subTree.put("Read", false);
        subTree.put("Write", false);
        subTree.put("CRStatus.Write", false);
        subTree.put("CRStatus.Read", false);
        subTree.put("Update.OrigBalance", false);
        subTree.put("Update.For", false);
        subTree.put("Update.CliRef", false);
        subTree.put("Update.SvcType", false);
        subTree.put("Update.DLC", false);
        subTree.put("Update.DLP", false);
        subTree.put("Update.FeeSched", false);
        subTree.put("Update.CreditBureauFields", false);
        subTree.put("Update.ReturnStatus", false);
        subTree.put("Update.Client", false);
        subTree.put("Update.Comments", false);
        subTree.put("Update.Tags", false);
        rightSet.put("Debt", subTree);
        subTree.clear();
        
        /**
         * Bank setup. 
         */
        subTree.put("Bank.Setup.Read", false);
        subTree.put("Bank.Setup.Write", false);
        rightSet.put("Bank", subTree);
        subTree.clear();
        
        /**
         * Fee setup.
         */
        subTree.put("Setup.Read", false);
        subTree.put("Setup.Write", false);
        subTree.put("Setup.Add", false);
        subTree.put("Setup.Delete", false);
        rightSet.put("Fee", subTree);
        subTree.clear();
        
        /**
         * Invoice setup.
         */
        subTree.put("Setup.Read", false);
        subTree.put("Setup.Write", false);
        rightSet.put("Invoice", subTree);
        subTree.clear();
        
        /**
         * Attorney setup.
         */
        subTree.put("Setup.Read", false);
        subTree.put("Setup.Write", false);
        rightSet.put("Attorney", subTree);
        subTree.clear();        
        
        /**
         * Lead setup.
         */
        subTree.put("Add", false);
        subTree.put("Update", false);
        subTree.put("Read", false);
        rightSet.put("Lead", subTree);
        subTree.clear();       
        
        subTree.put("Read", false);
        subTree.put("Write", false);
        subTree.put("Create", false);
        subTree.put("Cancel", false);
        rightSet.put("LetterSeries", subTree);
        subTree.clear();        
        
        subTree.put("Setup.Read", false);
        subTree.put("Setup.Write", false);
        rightSet.put("Match", subTree);
        subTree.clear();        
        
        subTree.put("Read", false);
        subTree.put("Write", false);
        subTree.put("Add", false);
        subTree.put("Update.AccountName", false);
        subTree.put("Update.GeneralInformation", false);
        subTree.put("Update.SkipTraceInfo", false);
        subTree.put("Update.CrossReference", false);
        subTree.put("Update.Historical", false);
        subTree.put("Update.CollectorNotes", false);
        rightSet.put("Newbiz", subTree);
        subTree.clear();        
        
        subTree.put("Setup.Read", false);
        subTree.put("Setup.Write", false);
        rightSet.put("Office", subTree);
        subTree.clear();        
        
        subTree.put("Read", false);
        subTree.put("Add", false);
        subTree.put("Write", false);
        rightSet.put("Payments", subTree);
        
        subTree.clear();
        subTree.put("Setup.Read", false);
        subTree.put("Setup.Write", false);
        rightSet.put("Priority", subTree);
        subTree.clear();    
        
        subTree.put("Planning.Read", false);
        subTree.put("Planning.Write", false);
        rightSet.put("Strategy", subTree);
        subTree.clear();       
        
        subTree.put("Setup.Read", false);
        subTree.put("Setup.Write", false);
        subTree.put("ObserveUser", false);
        subTree.put("AdviseUser", false);
        subTree.put("MonitorUsers", false);
        subTree.put("Login", false);
        rightSet.put("User", subTree);
        subTree.clear();        
        
        subTree.put("Category.Read", false);
        subTree.put("Category.Write", false);
        rightSet.put("Supplemental", subTree);
        subTree.clear();        
        
        subTree.put("CollectorPaymentStats.Read", false);
        subTree.put("ReverseUnmatchedPayments", false);
        subTree.put("MultipleOfficeAcccess", false);
        subTree.put("ElevatePrivilege", false);
        subTree.put("SendAnnouncements", false);
        subTree.put("SuperCollector", false);
        subTree.put("TriggerEvents", false);
        subTree.put("CreateNewTags", false);
        subTree.put("InhibitAuditing", false);
        subTree.put("Read", false);
        subTree.put("Write", false);
        rightSet.put("Misc", subTree);
        subTree.clear();        
        
        subTree.put("Run", false);
        rightSet.put("Report", subTree);
        subTree.clear();        
        
        subTree.put("Merge", false);
        rightSet.put("Queue", subTree);
        subTree.clear();        
        
        subTree.put("Reinstate", false);     
        subTree.put("Delete", false);
        rightSet.put("Account", subTree);
        subTree.clear();
        
        subTree.put("Print", false);
        subTree.put("Reassign", false);
        subTree.put("Backup", false);
        subTree.put("Initialize", false);
        subTree.put("Rollback", false);
        subTree.put("Grant", false);
        subTree.put("Revoke", false);
        subTree.put("Pause", false);
        subTree.put("Terminate", false);
        rightSet.put("System", subTree);
        subTree.clear();
        
        subTree.put("Send", false);
        subTree.put("Broadcast", false);
        subTree.put("Email.Send", false);
        subTree.put("Email.Receive", false);
        rightSet.put("Messages", subTree);
        subTree.clear();
        
        subTree.put("View",false);
        subTree.put("Start", false);
        subTree.put("Stop", false);
        rightSet.put("Logger", subTree);
        subTree.clear();
        
        subTree.put("View", false);
        subTree.put("Change", false);
        rightSet.put("Statistics", subTree);
        

/* Old implementation        
        rightSet.put("Debtor.Merge", false);
        rightSet.put("Debtor.Split", false);
        rightSet.put("Debtor.Delete", false);
        rightSet.put("Debtor.PHI.Read", false);
        rightSet.put("Debtor.PHI.Write", false);
        rightSet.put("Debtor.Demographics.Read", false);
        rightSet.put("Debtor.Demographics.Write", false);
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
        rightSet.put("Debtor.Lock", false);
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
        rightSet.put("Match.Setup.Write", false);
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
*/
        // loginHours by default are cleared (no hours allowed
         // loginHours defaults to having 24 members (ie one element for each
         // hour of the day).
         HashMap<String, Boolean> hourList = new HashMap<>();
         hourList.put("00:00",false);
         hourList.put("00:15",false);
         hourList.put("00:30",false);
         hourList.put("00:45",false);
         hourList.put("01:00",false);
         hourList.put("01:15",false);
         hourList.put("01:30",false);
         hourList.put("01:45",false);
         hourList.put("02:00",false);
         hourList.put("02:15",false);
         hourList.put("02:30",false);
         hourList.put("02:45",false);
         hourList.put("03:00",false);
         hourList.put("03:15",false);
         hourList.put("03:30",false);
         hourList.put("03:45",false);
         hourList.put("04:00",false);
         hourList.put("04:15",false);
         hourList.put("04:30",false);
         hourList.put("04:45",false);
         hourList.put("05:00",false);
         hourList.put("05:15",false);
         hourList.put("05:30",false);
         hourList.put("05:45",false);
         hourList.put("06:00",false);
         hourList.put("06:15",false);
         hourList.put("06:30",false);
         hourList.put("06:45",false);
         hourList.put("07:00",false);
         hourList.put("07:15",false);
         hourList.put("07:30",false);
         hourList.put("07:45",false);
         hourList.put("08:00",false);
         hourList.put("08:15",false);
         hourList.put("08:30",false);
         hourList.put("08:45",false);
         hourList.put("09:00",false);
         hourList.put("09:15",false);
         hourList.put("09:30",false);
         hourList.put("09:45",false);
         hourList.put("10:00",false);
         hourList.put("10:15",false);
         hourList.put("10:30",false);
         hourList.put("10:45",false);
         hourList.put("11:00",false);
         hourList.put("11:15",false);
         hourList.put("11:30",false);
         hourList.put("11:45",false);
         hourList.put("12:00",false);
         hourList.put("12:15",false);
         hourList.put("12:30",false);
         hourList.put("12:45",false);
         hourList.put("13:00",false);
         hourList.put("13:15",false);
         hourList.put("13:30",false);
         hourList.put("13:45",false);
         hourList.put("14:00",false);
         hourList.put("14:15",false);
         hourList.put("14:30",false);
         hourList.put("14:45",false);
         hourList.put("15:00",false);
         hourList.put("15:15",false);
         hourList.put("15:30",false);
         hourList.put("15:45",false);
         hourList.put("16:00",false);
         hourList.put("16:15",false);
         hourList.put("16:30",false);
         hourList.put("16:45",false);
         hourList.put("17:00",false);
         hourList.put("17:15",false);
         hourList.put("17:30",false);
         hourList.put("17:45",false);
         hourList.put("18:00",false);
         hourList.put("18:15",false);
         hourList.put("18:30",false);
         hourList.put("18:45",false);
         hourList.put("19:00",false);
         hourList.put("19:15",false);
         hourList.put("19:30",false);
         hourList.put("19:45",false);
         hourList.put("20:00",false);
         hourList.put("20:15",false);
         hourList.put("20:30",false);
         hourList.put("20:45",false);
         hourList.put("21:00",false);
         hourList.put("21:15",false);
         hourList.put("21:30",false);
         hourList.put("21:45",false);
         hourList.put("22:00",false);
         hourList.put("22:15",false);
         hourList.put("22:30",false);
         hourList.put("22:45",false);
         hourList.put("23:00",false);
         hourList.put("23:15",false);
         hourList.put("23:30",false);
         hourList.put("23:45",false);
         
         HashMap<String, Boolean> hours2;
         hours2 = (HashMap<String, Boolean>)hourList.clone();
         loginHours = new HashMap<>();
         loginHours.put("Sun", (HashMap<String,Boolean>)hourList.clone());
         loginHours.put("Mon", (HashMap<String,Boolean>)hourList.clone());
         loginHours.put("Tue", (HashMap<String,Boolean>)hourList.clone());
         loginHours.put("Wed", (HashMap<String,Boolean>)hourList.clone());
         loginHours.put("Thu", (HashMap<String,Boolean>)hourList.clone());
         loginHours.put("Fri", (HashMap<String,Boolean>)hourList.clone());
         loginHours.put("Sat", (HashMap<String,Boolean>)hourList.clone());
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
    public Rights(boolean localLogin, boolean backup, boolean remoteLogin, boolean shutdown, boolean monitor, boolean grantAccess, boolean revokeAccess, boolean takeOwnership, boolean startServices, boolean stopServices, boolean createUsers, boolean deleteUsers, boolean registerModules, boolean unregisterModules, boolean print, boolean documentRequest, boolean eventListener, boolean reassignThreads, boolean impersonateUser, boolean viewPHI, boolean updatePHI, boolean addSupplementalCategory, boolean deleteSupplementalCategory, boolean alterSupplementalCategory, Map<String, Map<String,Boolean>> rightSet, Long rightSet1, Long rightSet2, Long rightSet3, Long rightSet4, Map<String, Map<String,Boolean>> loginHours, Map<String, Integer> rightNames, int lastPosition) {
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
//        this.rightSet1 = rightSet1;
//        this.rightSet2 = rightSet2;
//        this.rightSet3 = rightSet3;
//        this.rightSet4 = rightSet4;
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
    
        /**
     *
     * @return
     */
    protected int getLastPosition() {
        return lastPosition;
    }

    /**
     *
     * @param lastPosition
     */
    protected void setLastPosition(int lastPosition) {
        this.lastPosition = lastPosition;
    }
    
    /**
     * Creates a new Right in the system
     * @param module
     * @param right
     * @return
     */
    @Override
    public boolean addRight(String module, String right) {
         String rightName = module+"."+right;
         if ( rightNames.containsKey(rightName))
             return false;
         else {
             if ( rightNames.put(rightName, lastPosition) != null) {
                 lastPosition++;
                 return true;
             } else
                 return false;
         }
         //rightNames.put(rightName, rightNames.size()+1);
         //return true;
     }

    /**
     *
     * @param module
     * @param right
     * @param position
     * @return
     */
    public boolean addRight(String module, String right, int position){
         if ( rightNames.putIfAbsent(module+"."+right, position) == null){
             if ( lastPosition < position ) 
                lastPosition = position+1;
             return true;
         } else {
             return false;
         }
         //return rightNames.putIfAbsent(module+"."+right, position) != null;
     }
    
    /**
     *
     * @param module
     * @param right
     * @return
     */
    @Override
    public boolean removeRight(String module, String right){
        return false;
    }

    /**
     *
     * @param module
     * @param right
     * @return
     */
    @Override
    public boolean hasRight(String module, String right) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param module
     * @param right
     */
    @Override
    public void allow(String module, String right) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param module
     * @param right
     */
    @Override
    public void deny(String module, String right) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    @Override
    public Set<String> listModules() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param module
     * @return
     */
    @Override
    public Set<String> listRights(String module) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    @Override
    public Set<String> listRights() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    /**
     *
     * @param module
     * @param right
     */
/*    public void allow(String module, String right){
         if ( rightNames.get(module+"."+right) != null ){
             if(rightNames.get(module+"."+right) <= 63)
                rightSet1 |= 1 << (rightNames.get(module+"."+right));
             else if (rightNames.get(module+"."+right) <= 127)
                 rightSet2 |= 1 << (rightNames.get(module+"."+right));
             else if (rightNames.get(module+"."+right) <= 191)
                 rightSet3 |= 1 << (rightNames.get(module+"."+right));
             else if (rightNames.get(module+"."+right) <= 255)
                 rightSet4 |= 1 << (rightNames.get(module+"."+right));
         }
     }
*/
    /**
     *
     * @param module
     * @param right
     */
/*    public void deny(String module, String right){
         if ( rightNames.get(module+"."+right) != null ){
             if(rightNames.get(module+"."+right) <= 63)
                rightSet1 &= 0 << (rightNames.get(module+"."+right));
             else if (rightNames.get(module+"."+right) <= 127)
                 rightSet2 &= 0 << (rightNames.get(module+"."+right));
             else if (rightNames.get(module+"."+right) <= 191)
                 rightSet3 &= 0 << (rightNames.get(module+"."+right));
             else if (rightNames.get(module+"."+right) <= 255)
                 rightSet4 &= 0 << (rightNames.get(module+"."+right));
         }
     }
*/

    
    /**
     *
     * @param day
     * @return
     */
    public Map<String,Boolean> getHours(String day){
         return loginHours.get(day);
     }

    /**
     *
     * @param day
     * @param hours
     */
    public void setHours(String day, Map<String,Boolean> hours){
         loginHours.put(day, hours);
     }

    /**
     *
     * @param day
     */
    public void clearHours(String day){
         
     }

    /**
     *
     * @param day
     * @param hour
     */
    public void setHour(String day, int hour){
         loginHours.get(day);
     }

    /**
     *
     * @param day
     * @param hour
     * @return
     */
    public boolean getHour(String day, int hour){
         return true;
     }

    /**
     * @return the localLogin
     */
    public boolean allowLocalLogin() {
        return localLogin;
    }

    /**
     * @return the backup
     */
    public boolean canBackup() {
        return backup;
    }

    /**
     * @return the remoteLogin
     */
    public boolean canRemoteLogin() {
        return remoteLogin;
    }

    /**
     * @return the shutdown
     */
    public boolean canShutdown() {
        return shutdown;
    }

    /**
     * @return the monitor
     */
    public boolean canMonitor() {
        return monitor;
    }

    /**
     * @return the grantAccess
     */
    public boolean canGrantAccess() {
        return grantAccess;
    }

    /**
     * @return the revokeAccess
     */
    public boolean canRevokeAccess() {
        return revokeAccess;
    }

    /**
     * @return the takeOwnership
     */
    public boolean canTakeOwnership() {
        return takeOwnership;
    }

    /**
     * @return the startServices
     */
    public boolean canStartServices() {
        return startServices;
    }

    /**
     * @return the stopServices
     */
    public boolean canStopServices() {
        return stopServices;
    }

    /**
     * @return the createUsers
     */
    public boolean canCreateUsers() {
        return createUsers;
    }

    /**
     * @return the deleteUsers
     */
    public boolean canDeleteUsers() {
        return deleteUsers;
    }

    /**
     * @return the registerModules
     */
    public boolean canRegisterModules() {
        return registerModules;
    }

    /**
     * @return the unregisterModules
     */
    public boolean canUnregisterModules() {
        return unregisterModules;
    }

    /**
     * @return the print
     */
    public boolean canPrint() {
        return print;
    }

    /**
     * @return the documentRequest
     */
    public boolean canDocumentRequest() {
        return documentRequest;
    }

    /**
     * @return the eventListener
     */
    public boolean canEventListener() {
        return eventListener;
    }

    /**
     * @return the reassignThreads
     */
    public boolean canReassignThreads() {
        return reassignThreads;
    }

    /**
     * @return the impersonateUser
     */
    public boolean canImpersonateUser() {
        return impersonateUser;
    }

    /**
     * @return the viewPHI
     */
    public boolean canViewPHI() {
        return viewPHI;
    }

    /**
     * @return the updatePHI
     */
    public boolean canUpdatePHI() {
        return updatePHI;
    }

    /**
     * @return the addSupplementalCategory
     */
    public boolean canAddSupplementalCategory() {
        return addSupplementalCategory;
    }

    /**
     * @return the deleteSupplementalCategory
     */
    public boolean canDeleteSupplementalCategory() {
        return deleteSupplementalCategory;
    }

    /**
     * @return the alterSupplementalCategory
     */
    public boolean canAlterSupplementalCategory() {
        return alterSupplementalCategory;
    }

    /**
     * @param localLogin the localLogin to set
     */
    protected void allowLocalLogin(boolean localLogin) {
        this.localLogin = localLogin;
    }

    /**
     * @param backup the backup to set
     */
    protected void allowBackup(boolean backup) {
        this.backup = backup;
    }

    /**
     * @param remoteLogin the remoteLogin to set
     */
    protected void allowRemoteLogin(boolean remoteLogin) {
        this.remoteLogin = remoteLogin;
    }

    /**
     * @param shutdown the shutdown to set
     */
    protected void allowShutdown(boolean shutdown) {
        this.shutdown = shutdown;
    }

    /**
     * @param monitor the monitor to set
     */
    protected void allowMonitor(boolean monitor) {
        this.monitor = monitor;
    }

    /**
     * @param grantAccess the grantAccess to set
     */
    protected void allowGrantAccess(boolean grantAccess) {
        this.grantAccess = grantAccess;
    }

    /**
     * @param revokeAccess the revokeAccess to set
     */
    protected void allowRevokeAccess(boolean revokeAccess) {
        this.revokeAccess = revokeAccess;
    }

    /**
     * @param takeOwnership the takeOwnership to set
     */
    protected void allowTakeOwnership(boolean takeOwnership) {
        this.takeOwnership = takeOwnership;
    }

    /**
     * @param startServices the startServices to set
     */
    protected void allowStartServices(boolean startServices) {
        this.startServices = startServices;
    }

    /**
     * @param stopServices the stopServices to set
     */
    protected void allowStopServices(boolean stopServices) {
        this.stopServices = stopServices;
    }

    /**
     * @param createUsers the createUsers to set
     */
    protected void allowCreateUsers(boolean createUsers) {
        this.createUsers = createUsers;
    }

    /**
     * @param deleteUsers the deleteUsers to set
     */
    protected void allowDeleteUsers(boolean deleteUsers) {
        this.deleteUsers = deleteUsers;
    }

    /**
     * @param registerModules the registerModules to set
     */
    protected void allowRegisterModules(boolean registerModules) {
        this.registerModules = registerModules;
    }

    /**
     * @param unregisterModules the unregisterModules to set
     */
    protected void allowUnregisterModules(boolean unregisterModules) {
        this.unregisterModules = unregisterModules;
    }

    /**
     * @param print the print to set
     */
    protected void allowPrint(boolean print) {
        this.print = print;
    }

    /**
     * @param documentRequest the documentRequest to set
     */
    protected void allowDocumentRequest(boolean documentRequest) {
        this.documentRequest = documentRequest;
    }

    /**
     * @param eventListener the eventListener to set
     */
    protected void allowEventListener(boolean eventListener) {
        this.eventListener = eventListener;
    }

    /**
     * @param reassignThreads the reassignThreads to set
     */
    protected void allowReassignThreads(boolean reassignThreads) {
        this.reassignThreads = reassignThreads;
    }

    /**
     * @param impersonateUser the impersonateUser to set
     */
    protected void allowImpersonateUser(boolean impersonateUser) {
        this.impersonateUser = impersonateUser;
    }

    /**
     * @param viewPHI the viewPHI to set
     */
    protected void allowViewPHI(boolean viewPHI) {
        this.viewPHI = viewPHI;
    }

    /**
     * @param updatePHI the updatePHI to set
     */
    protected void allowUpdatePHI(boolean updatePHI) {
        this.updatePHI = updatePHI;
    }

    /**
     * @param addSupplementalCategory the addSupplementalCategory to set
     */
    protected void allowAddSupplementalCategory(boolean addSupplementalCategory) {
        this.addSupplementalCategory = addSupplementalCategory;
    }

    /**
     * @param deleteSupplementalCategory the deleteSupplementalCategory to set
     */
    protected void allowDeleteSupplementalCategory(boolean deleteSupplementalCategory) {
        this.deleteSupplementalCategory = deleteSupplementalCategory;
    }

    /**
     * @param alterSupplementalCategory the alterSupplementalCategory to set
     */
    protected void allowAlterSupplementalCategory(boolean alterSupplementalCategory) {
        this.alterSupplementalCategory = alterSupplementalCategory;
    }

}
