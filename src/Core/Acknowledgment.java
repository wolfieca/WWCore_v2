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
 * A newbiz account acknowledgment. An Acknowledgment typically consists of some
 * boilerplate text and a brief summary of the accounts that were recently sent
 * to the Company's newbiz processor. Depending on the medium of transmission,
 * there may also be a cover letter (if printing or if sending via fax), or text
 * greeting (via email).
 * @author rserrano
 */
public class Acknowledgment extends WWDocument{
    private Form ackForm;
    private Form ackLetter;
}
