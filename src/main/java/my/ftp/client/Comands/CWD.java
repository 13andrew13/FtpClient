package my.ftp.client.Comands;


import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;

public class CWD implements Comand {
    String directoryName;
    FTPClient ftpClient;
    public CWD(FTPClient ftpClient,String directoryName ) {
        this.ftpClient = ftpClient;
        this.directoryName = directoryName;
    }

    public void execute() throws IOException {

        boolean success = ftpClient.changeWorkingDirectory(directoryName);
        String[] replies = ftpClient.getReplyStrings();
        if (replies != null && replies.length > 0) {
            for (String aReply : replies) {
                System.out.println("SERVER: " + aReply);
            }
        }

        if (success) {
            System.out.println("Successfully changed working directory.");
        } else {
            System.out.println("Failed to change working directory. See server's reply.");
        }
    }
}
