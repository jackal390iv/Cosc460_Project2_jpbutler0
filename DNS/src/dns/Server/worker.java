/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dns.Server;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author alfred
 */
public class worker {

    private DataOutputStream sendData = null;
    private DataInputStream receiveData = null;

    public worker(Socket client) {
        try {
            receiveData = new DataInputStream(new BufferedInputStream(client.getInputStream()));
            String temp = receiveData.readUTF();
            sendData = new DataOutputStream(client.getOutputStream());
            InetAddress address = InetAddress.getByName(temp);
            sendData.writeUTF(temp + ": " + address.getHostAddress());
            sendData.flush();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Cause: " + ex.getCause() + "\n" + "Message: " + ex.getMessage() + "\n" + "Local Message: " + ex.getLocalizedMessage(), "Error", 0);
            System.exit(0);
        }
    }
}
