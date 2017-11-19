package my.ftp.client.Comands;

import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;

public class DELE implements Comand{
    String filename;
    FTPClient client;

    public DELE (FTPClient client, String filename) {
        this.filename = filename;
        this.client = client;
    }

    public void execute () throws IOException {
        try {
            boolean deleted = client.deleteFile(filename);
            if (deleted) {
                System.out.println("The file was deleted successfully.");
            } else {
                System.out.println("Could not delete the file.");
            }
        } catch (IOException ex) {
            System.out.println("Oh no, there was an error: " + ex.getMessage());
        }
    }
}
