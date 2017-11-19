package my.ftp.client.Comands;

import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;

public class PASV implements Comand {
    FTPClient client;

    public PASV (FTPClient client) {
        this.client = client;
    }

    public void execute () throws IOException {
        client.enterLocalPassiveMode ();
    }
}
