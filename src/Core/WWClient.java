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
import java.net.*;
import java.io.*;


/**
 * An outbound socket intended to be sent to client processes from the Server
 * @author Robert Serrano (wolfieca.rs at gmail.com)
 */
public class WWClient extends WWCommChannel{
    Socket speaker;
    Long written;
    User user;
    
    /**
     *
     */
    public WWClient(){
        speaker = new Socket();
        user=null;
    }
    
    /**
     *
     * @param portNum
     * @throws UnknownHostException
     * @throws IOException
     */
    public WWClient(short portNum) throws UnknownHostException, IOException{
        speaker = new Socket("localhost", portNum);
    }
    
    /**
     *
     * @param hostName
     * @param portNum
     * @throws UnknownHostException
     * @throws IOException
     */
    public WWClient(String hostName, short portNum) throws UnknownHostException,
            IOException {
        speaker = new Socket(hostName, portNum);
    }
    
    /**
     *
     * @param portNumber
     */
    public void init (int portNumber){
        
    }
}
