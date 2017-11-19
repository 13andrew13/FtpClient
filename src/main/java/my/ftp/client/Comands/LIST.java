package my.ftp.client.Comands;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class LIST implements  Comand{
    String name = "LIST";
    String directoryName;
    FTPClient client;

    public LIST(FTPClient client, String directoryName) {
        this.directoryName = directoryName;
        this.client = client;
    }

    public void execute() throws IOException {

        String[] files = client.listNames ();
        if (files != null && files.length > 0) {
            for (String aFile: files) {
                System.out.println(aFile);
            }
        }
    }
}
