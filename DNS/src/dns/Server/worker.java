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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author alfred
 */
public class worker implements Runnable {

    private DataOutputStream sendData = null;
    private DataInputStream receiveData = null;
    private Socket client = null;

    public worker(Socket client) {
        this.client = client;
    }

    public void run() {
        do {
            try {
                receiveData = new DataInputStream(new BufferedInputStream(client.getInputStream()));
                String temp = receiveData.readUTF();
                sendData = new DataOutputStream(client.getOutputStream());
                try {
                    InetAddress address = InetAddress.getByName(temp);
                    sendData.writeUTF(temp + ": " + address.getHostAddress());
                    sendData.flush();
                } catch (IOException ex) {
                    sendData.writeUTF("ERROR: could not resolve host, please try again.");
                    sendData.flush();
                }
            } catch (IOException ex) {
                Logger.getLogger(worker.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (client.isConnected());
    }
}
