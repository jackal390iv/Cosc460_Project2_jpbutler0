/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dns.Server;

import java.net.InetAddress;
import java.net.ServerSocket;
import javax.swing.JOptionPane;

/**
 *
 * @author alfred
 */
public class serverHub {

    private ServerSocket socket;

    public serverHub() {
        startServer();
    }

    private void startServer() {
        String hostName = null;
        String ipAdress = null;
        int portAdress = -1;
        try {
            socket = new ServerSocket(0);
            //hostName = socket.getInetAddress().getHostName();
            ipAdress = InetAddress.getLocalHost().getHostAddress();
            portAdress = socket.getLocalPort();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Cause: " + ex.getCause() + "\n" + "Message: " + ex.getMessage() + "\n" + "Local Message: " + ex.getLocalizedMessage(), "Error", 0);
            System.exit(0);
        }
        //new recieveData().start();
        //new sendData().start();
        JOptionPane.showMessageDialog(null, "IP-Address: " + ipAdress + "\n" + "Port-Address: " + portAdress, "Server Hub", 1);
    }
}
