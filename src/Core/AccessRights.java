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

import java.util.Set;

/**
 *
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public interface AccessRights {
    public boolean addRight(String module, String right);
    public boolean removeRight(String module, String right);
    public boolean hasRight(String module, String right);
    public void allow(String module, String right);
    public void deny(String module, String right);
    public Set<String> listModules();
    public Set<String> listRights(String module);
    public Set<String> listRights();
}
