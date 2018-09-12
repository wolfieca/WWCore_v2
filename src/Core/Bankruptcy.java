/*
 * Copyright (C) 2018 rserrano
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

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Bankruptcy is a modifier to a debtor or debt. It is produced in response to a
 * BankruptcyClaim message and is attached to the relevant debtor and the included
 * debts. The Bankruptcy remains on the debtor unless a BankruptcyClaim dismissal
 * message is received, at which time, the Bankruptcy may be removed from the 
 * Debtor/Debts, depending on Company Policy.
 * @author rserrano
 */
public class Bankruptcy {
    public enum Type {
        CHAPTER7,
        CHAPTER11,
        CHAPTER12,
        CHAPTER13
    }
    public enum Status {
        ADJUDICATED,
        DISCHARGED,
        DISMISSED
    }
    private Type chapter;
    private Status status;
    private LocalDate fileDate;
    private LocalDate statusDate;
    private Set<Debtor> debtor;
    private Set<Debt> includedDebts;
    private boolean verified;
    private User verifier;
    
    public Bankruptcy(){
        chapter=null;
        status = null;
        fileDate = null;
        statusDate = null;
        debtor = null;
        includedDebts = null;
        verified = false;
        verifier = null;
    }
    
    public Bankruptcy(Type type, Status status, Debtor debtor){
        this.chapter = type;
        this.status = status;
        this.debtor = new HashSet<Debtor>();
        this.debtor.add(debtor);
        this.fileDate = LocalDate.now();
        this.includedDebts = includeDebts(fileDate);
    }
    
    private Set<Debt> includeDebts(){
        return null;
    }
    private Set<Debt> includeDebts(LocalDate theDate){
        return null;
    }
}
