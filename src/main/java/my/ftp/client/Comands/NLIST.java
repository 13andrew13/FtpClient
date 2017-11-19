package my.ftp.client.Comands;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import sun.net.ftp.FtpClient;

import java.io.IOException;

public class NLIST implements Comand {

    private FTPClient client;
    String directory;

    public NLIST (FTPClient client,String directory) {
        this.client = client;
        this.directory = directory;
    }

    public void execute () throws IOException {
        String[] files = client.listNames (directory);
        for (String file : files) {
            System.out.println (file);
        }
    }
}
