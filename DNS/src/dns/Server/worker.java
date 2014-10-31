/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dns.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alfred
 */
public class worker {

    public worker(Socket client) {
        PrintWriter writer = null;
        BufferedReader reader = null;
        try {
            InputStream input = client.getInputStream();
            reader = new BufferedReader(new InputStreamReader(input));
            String hostAddress = reader.readLine();
            reader.close();

            writer = new PrintWriter(client.getOutputStream(), true);
            try {
                InetAddress address = InetAddress.getByName(hostAddress);
                writer.println(hostAddress + ": " + address.getHostAddress());
            } catch (UnknownHostException ex) {
                Logger.getLogger(worker.class.getName()).log(Level.SEVERE, null, ex);
                writer.println("ERROR: Unable to resolve host, please try again.");
            }
            writer.close();

        } catch (IOException ex) {
            Logger.getLogger(worker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
