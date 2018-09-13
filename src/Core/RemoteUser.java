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

/**
 * A RemoteUser refers to a user that is allowed limited
 * access to the Company's system. Typically, this will be a user working for a
 * Client, who has access to certain reports, and can upload/enter new business
 * to the Company for processing. A remote user generally cannot be messaged 
 * using the normal messaging mechanisms, so there is often a need for an
 * interface to an external system to communicate with them. This can also
 * represent users who are Debtors and Vendors. Normal users who are logging in
 * from untrusted networks have their access limited until the security of their
 * location has been attested to.
 * @author rserrano
 */
public class RemoteUser extends Actor implements Reportable, Securable{
 
}
