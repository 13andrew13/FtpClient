package my.ftp.client.Comands;

import my.ftp.client.QuitException;
import org.apache.commons.net.ftp.FTPClient;

public class QUIT implements Comand {
    String name = "QUIT";
    FTPClient client;

    public QUIT(FTPClient client) {
        this.client = client;
    }
    public void execute() throws Exception {

        if(client.isConnected()){
            System.out.println(client.getReplyString());
        }
        try {
            if(client.isConnected()){
                client.logout();
                client.disconnect();
            }
        }catch (Exception e){
            throw new QuitException ();
        }
        for (String o : client.getReplyStrings()) {
            System.out.println(o);
        }
    }
}
