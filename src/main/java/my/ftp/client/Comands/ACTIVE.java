package my.ftp.client.Comands;

import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;

public class ACTIVE implements Comand {
    FTPClient client;

    public ACTIVE (FTPClient client) {
        this.client = client;
    }

    public void execute () throws IOException {
        client.enterLocalActiveMode ();
    }
}
