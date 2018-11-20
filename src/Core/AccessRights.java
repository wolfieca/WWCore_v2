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

    /**
     *
     * @param module
     * @param right
     * @return
     */
    public boolean addRight(String module, String right);

    /**
     *
     * @param module
     * @param right
     * @return
     */
    public boolean removeRight(String module, String right);

    /**
     *
     * @param module
     * @param right
     * @return
     */
    public boolean hasRight(String module, String right);

    /**
     *
     * @param module
     * @param right
     */
    public void allow(String module, String right);

    /**
     *
     * @param module
     * @param right
     */
    public void deny(String module, String right);

    /**
     *
     * @return
     */
    public Set<String> listModules();

    /**
     *
     * @param module
     * @return
     */
    public Set<String> listRights(String module);

    /**
     *
     * @return
     */
    public Set<String> listRights();
}
