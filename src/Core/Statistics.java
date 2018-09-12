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
 * Statistical data. This is a largely free-form dataset defined by whatever is
 * using it. The base Statistics object is temporally tied, with statistics 
 * maintained for appropriate time periods. Depending on the particular class,
 * this data may be maintained indefinitely, over a fixed duration, summarized
 * after a certain duration (i.e. the last 13 months, including the current one,
 * maintained in full, with older ones summarized), instantaneous (only the last
 * iteration's statistics are kept), summarized only, or some other interval. It 
 * is up to the calling class to maintain its own statistical data and the set
 * up the parameters for the statistical collection.
 * @author rserrano
 */
public class Statistics {
    
}
