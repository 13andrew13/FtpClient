package my.ftp.client.Comands;

import java.io.IOException;

public class HELP implements Comand {
    private final String manual = "All available commands:\n" +
            "cwd   - Change working directory\n" +
            "dele  - Delete file\n" +
            "help  - Get information about commands\n" +
            "list  - Returns information of a file or directory\n" +
            "nlist - Lists the contents of a directory\n" +
            "pasv  - Enter passive mode\n" +
            "pwd   - Print working directory\n" +
            "quit  - End programs work\n" +
            "close - Disconnect\n" +
            "stor  - Accept the data and to store the data as a file at the server site\n" +
            "retr  - Retrieve a copy of the file\n" +
            "port  - Enter active mode\n";
    public void execute () throws IOException {
        System.out.println (manual);

    }
}
