package my.ftp.client.Comands;

import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;

public class PWD implements Comand {
    FTPClient client;

    public PWD (FTPClient client) {
        this.client = client;
    }

    public void execute () throws IOException {
        System.out.println ( client.printWorkingDirectory ());
    }
}
