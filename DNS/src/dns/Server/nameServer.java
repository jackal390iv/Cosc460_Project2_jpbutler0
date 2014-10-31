/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dns.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alfred
 */
public class nameServer{

    private Socket client = null;

    public nameServer(ServerSocket socket) {
       
        ExecutorService executor = Executors.newCachedThreadPool();
        
        do {
            try {
                client = socket.accept();
            } catch (IOException ex) {
                Logger.getLogger(worker.class.getName()).log(Level.SEVERE, null, ex);
            }
            worker worker=new worker(client);
            executor.submit((Runnable) worker);
            
        } while (true);
    }
}
