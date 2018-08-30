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
 * Module is a loadable plugin module that can be used to add functionality to the 
 * system as a whole. This allows non-Core units to access Core functionality
 * (such as the message queues). The ModuleLoader and SecurityManager are the
 * units of Core responsible for loading Modules into the system (Module provides
 * the means of registering so that they can be loaded and properly restricted).
 * @author Robert Serrano <wolfieca.rs@gmail.com>
 */
public class Module {
    
}
