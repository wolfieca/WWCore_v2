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
 * (Possible) A User's desk phone. This would potentially allow the system to
 * interact with the local phone system (esp if dealing with a SIP setup or other
 * kind of PBX with an API that can be accessed via Java). Potentially, this 
 * could greatly increase accuracy of the system as notes could be brought up 
 * as soon as a call arrives at a collector's desk, with the actual time and date
 * at which the call began and ended, and a link to retrieve the recording 
 * directly from the note. So, a call comes in. The system checks to see if the
 * number is recognized as belonging to a known debtor. A window pops up on the 
 * screen with the number calling to which the user is allowed to pick up or 
 * decline the call. Once the user accepts the call, the system puts a note entry 
 * screen for the user to type their notes. If no debtor was determined by the 
 * system, the user is also given a point to look up the account so that the
 * note comments get attributed correctly. From there, all the important stuff
 * has been finished, so the collector can enter their notes.
 * Some of this would also be enabled for outbound calling (the debtor information
 * should already be known when making an outbound call). This would replace
 * the current TR/(NA, etc) cycle we currently have with a user opening a call,
 * identifying the called party, if the system hasn't figured out the callee
 * already, and then note the time the call started and the time the call ended,
 * with final disposition provided directly by the phone system and final notes
 * provided by the collector/calling party.
 * Ultimately, this class (and the PBX class) would allow better record-keeping
 * of the phone-call volume, as well as facilitating an audit process
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class Phone {

}
