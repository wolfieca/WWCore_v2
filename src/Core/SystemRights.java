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
 * The available System Rights (ie things users have access to). May be 
 * supplanted or incorporated into other systems.
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class SystemRights {
    /**
     *
     */
    public enum Base {

        /**
         * User can login to the system locally (ie via command-line on the 
         * server)
         */
        LOCALLOGIN,

        /**
         * User can login to the system remotely (i.e. via a remote client user
         * interface)
         */
        REMOTELOGIN,

        /**
         * User is allowed to initiate backups, this also permits access to 
         * records/objects on the system that are currently locked.
         */
        BACKUP,

        /**
         * User is allowed to initiate system shutdown routines.
         */
        SHUTDOWN,

        /**
         * User is allowed to monitor (watch) other users on the system.
         */
        MONITOR,

        /**
         * User is allowed to grant access to system functionality to other users.
         */
        GRANT,

        /**
         * User can revoke previously granted access from other users.
         */
        REVOKE,

        /**
         * User is allowed to take ownership of objects on the system.
         */
        TAKEOWNERSHIP,

        /**
         * User is allowed to start system services.
         */
        STARTSERVICES,

        /**
         * User is allowed to stop system services.
         */
        STOPSERVICES,

        /**
         * User can create other system users.
         */
        CREATEUSERS,

        /**
         * User can delete other system users.
         */
        DELETEUSERS,

        /**
         * User can register system modules.
         */
        REGISTERMODULES,

        /**
         * User can un-register system modules.
         */
        UNREGISTERMODULES,

        /**
         * User can print documents to a printer.
         */
        PRINT,

        /**
         * User is allowed to request 
         */
        REQUESTDOCUMENTS,

        /**
         * User is allowed to listen to events.
         */
        EVENTLISTENER,

        /**
         * User can re-purpose threads.
         */
        REASSIGNTHREADS,

        /**
         * User is allowed to impersonate another user on the system.
         */
        IMPERSONATEUSER,
    }

    /**
     *
     */
    public enum Debtor {

        /**
         *
         */
        MERGE,

        /**
         *
         */
        SPLIT,

        /**
         *
         */
        DELETE
    }

    /**
     *
     */
    public enum DebtorLookup {

        /**
         *
         */
        HISTORY,

        /**
         *
         */
        QUEUE,

        /**
         *
         */
        GENERAL,

        /**
         *
         */
        UNIT,

        /**
         *
         */
        BLITZ,

        /**
         *
         */
        TAG
    }

    /**
     *
     */
    public enum DebtorAccess {

        /**
         *
         */
        LEGALACTIONS,

        /**
         *
         */
        PRECOLLECT
    }

    /**
     *
     */
    public enum DebtorUpdate {

        /**
         *
         */
        TELEPHONE,

        /**
         *
         */
        COLLECTOR,

        /**
         *
         */
        MAILRETURN,

        /**
         *
         */
        STRATEGYSTATUS,

        /**
         *
         */
        STATUSBYTYPE,

        /**
         *
         */
        LETTERSLEFT,

        /**
         *
         */
        INDICATORS,

        /**
         *
         */
        LEGALSCREEN
    }

    /**
     *
     */
    public enum Debt {

        /**
         *
         */
        VIEW,

        /**
         *
         */
        UPDATE,

        /**
         *
         */
        CRSTATUSREAD,

        /**
         *
         */
        CRSTATUSWRITE
    }

    /**
     *
     */
    public enum DebtUpdate {

        /**
         *
         */
        ORIGBALANCE,

        /**
         *
         */
        FORWHAT,

        /**
         *
         */
        CLIREF,

        /**
         *
         */
        SVCTYPE,

        /**
         *
         */
        DLC,

        /**
         *
         */
        DLP,

        /**
         *
         */
        FEESCHED,

        /**
         *
         */
        CREDITBUREAUFIELDS,

        /**
         *
         */
        RETURNSTATUS,

        /**
         *
         */
        CLIENT,

        /**
         *
         */
        COMMENTS,

        /**
         *
         */
        TAGS
    }

    /**
     *
     */
    public enum BankSetup {

        /**
         *
         */
        READ,

        /**
         *
         */
        WRITE
    }

    /**
     *
     */
    public enum ClientSetup {

        /**
         *
         */
        READ,

        /**
         *
         */
        WRITE
    }

    /**
     *
     */
    public enum FeeSetup {

        /**
         *
         */
        READ,

        /**
         *
         */
        WRITE
    }

    /**
     *
     */
    public enum InvoiceSetup {

        /**
         *
         */
        READ,

        /**
         *
         */
        WRITE
    }

    /**
     *
     */
    public enum AttorneySetup {

        /**
         *
         */
        READ,

        /**
         *
         */
        WRITE
    }

    /**
     *
     */
    public enum Lead {

        /**
         *
         */
        ADD,

        /**
         *
         */
        READ,

        /**
         *
         */
        UPDATE
    }

    /**
     *
     */
    public enum LetterSeries {

        /**
         *
         */
        READ,

        /**
         *
         */
        WRITE
    }

    /**
     *
     */
    public enum MatchSetup {

        /**
         *
         */
        READ,

        /**
         *
         */
        WRITE
    }

    /**
     *
     */
    public enum Misc {

        /**
         *
         */
        READ,

        /**
         *
         */
        WRITE
    }

    /**
     *
     */
    public enum Newbiz {

        /**
         *
         */
        READ,

        /**
         *
         */
        ADD,

        /**
         *
         */
        WRITE,

        /**
         *
         */
        DELETE
    }

    /**
     *
     */
    public enum NewbizUpdate {

        /**
         *
         */
        ACCOUNTNAME,

        /**
         *
         */
        GENERALINFORMATION,

        /**
         *
         */
        SKIPTRACEINFO,

        /**
         *
         */
        CROSSREFERENCE,

        /**
         *
         */
        HISTORICAL,

        /**
         *
         */
        COLLECTORNOTES
    }

    /**
     *
     */
    public enum OfficeSetup {

        /**
         *
         */
        READ,

        /**
         *
         */
        WRITE
    }

    /**
     *
     */
    public enum Payment {

        /**
         *
         */
        READ,

        /**
         *
         */
        ADD,

        /**
         *
         */
        WRITE
    }

    /**
     *
     */
    public enum PrioritySetup {

        /**
         *
         */
        READ,

        /**
         *
         */
        WRITE
    }

    /**
     *
     */
    public enum StrategyPlanning {

        /**
         *
         */
        READ,

        /**
         *
         */
        WRITE
    }

    /**
     *
     */
    public enum UserSetup {

        /**
         *
         */
        READ,

        /**
         *
         */
        WRITE
    }

    /**
     *
     */
    public enum Supplemental {

        /**
         *
         */
        READ,

        /**
         *
         */
        WRITE,

        /**
         *
         */
        ADDCATEGORY,

        /**
         *
         */
        DELETECATEGORY
    }

    /**
     *
     */
    public enum Report {

        /**
         *
         */
        RUN
    }

    /**
     *
     */
    public enum Queue {

        /**
         *
         */
        MERGE
    }

    /**
     *
     */
    public enum PHI {

        /**
         *
         */
        VIEW,

        /**
         *
         */
        UPDATE
    }
 
}
