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

/**
 * Server represents a server process for the system. It is basically a proxy
 * object to serve as the communication channel between the core objects and
 * the system itself. Server also is the primary communication channel with the
 * back-end database. No other system entity should have any cause to ever touch
 * the database, instead sending messages to request objects, which are then
 * materialized from the database on an as-needed basis. This is accomplished by
 * creating an instance of the requested object and sending the initialization 
 * code a database connection to work with, which is then used to perform the
 * queries needed to populate the object (this may propagate on nested objects,
 * depending on whether they are accessible on an as-needed basis). Once the
 * initialization code is done, the connection is released until the object needs
 * to either update it's data, or change the database's data. 
 * On the client side, Server is an opaque object that responds to data sent to 
 * the WWSocket object. WWClient objects only know that there is a Server object
 * that they can communicate with via the WWSocket object, and that provides
 * complete objects on request (pursuant to normal security limitations).
 * @author Robert Serrano <wolfieca.rs@gmail.com>
 */
public class Server {
    
}
