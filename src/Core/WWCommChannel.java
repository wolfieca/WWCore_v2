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
 * WWCommChannel is a generic communications channel. It's an abstract base class
 * and so, can't be instantiated except through it's children, WWClient and 
 * WWServer. The specific WWCommChannel subclass that is attached to the System
 * object controls the role this WolffeWare instance plays in the whole system.
 * A WWClient is a client node. Client nodes have no direct access to the backing
 * databases, and are only able to affect them by sending messages to a WWServer
 * instance.
 * @author rserrano
 */
public abstract class WWCommChannel {
    public abstract void init(int portNumber);
}
