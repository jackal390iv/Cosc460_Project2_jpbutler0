/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dns;

import javax.swing.JOptionPane;

/**
 *
 * @author alfred
 */
public class main {

    private int optionPanel;

    public static void main(String[] args) {
        new main();
    }

    public main() {
        chooseType();

        if (optionPanel == 0) {
            dns.Server.serverHub server = new dns.Server.serverHub();
            //server.start();
        } else if (optionPanel == 1) {
            dns.Client.connectionHelper connection = new dns.Client.connectionHelper();
        }
    }

    private void chooseType() {
        String[] jButtons = {"Host Server", "Client"};
        optionPanel = JOptionPane.showOptionDialog(null, "Host Sever or Client?", "Welcome", JOptionPane.INFORMATION_MESSAGE, 1, null, jButtons, jButtons[1]);
    }
}
