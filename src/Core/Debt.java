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
 * A single debt on the System. Typically subordinate to a Debtor object, but 
 * independently addressable for purposes of individual history, manipulation (i.e.
 * splitting or merging debts), and reporting (for cases where clients' debts are
 * allowed to merge together). Credit Reporting is controlled on a Debt basis
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class Debt implements Reportable, Securable{
    private Debtor debtor;
    private Client debtClient;
    private DemographicField<String> cliRefNumber;
    private boolean canAccrueInterest;
    private History debtHistory;
    private DemographicField<String> forWhat;
    private SupplementalData Notes;
    private PaymentHistory debtPayments;
}
