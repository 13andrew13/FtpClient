package my.ftp.client;

import my.ftp.client.Comands.*;
import org.apache.commons.net.ftp.FTPClient;

public class ComandFactory {
    static FTPClient FTP_CLIENT;

    public ComandFactory(FTPClient ftpClient) {
        FTP_CLIENT = ftpClient;
    }

    public static Comand getComand(String comand)throws  Exception{
        Comand c;
        String[] comands = comand.split(" ");
        if(comands[0].equals("quit")){
            c = new QUIT(FTP_CLIENT);
        } else if(comands[0].equals("list")){
            c = new LIST(FTP_CLIENT,comands[0]);
        }else if(comands[0].equals ("cwd")){
            c = new CWD (FTP_CLIENT,comands[1]);
        }else if(comands[0].equals ("help")){
            c = new HELP ();
        }else if(comands[0].equals ("nlist")){
            c = new NLIST (FTP_CLIENT,comands[1]);
        }else if(comands[0].equals ("dele")){
            c = new DELE (FTP_CLIENT,comands[0]);
        }else if(comands[0].equals ("pasv")){
            c = new PASV (FTP_CLIENT);
        }else if(comands[0].equals ("port")){
            c = new ACTIVE (FTP_CLIENT);
        }else if(comands[0].equals ("close")){
            c= new CLOSE (FTP_CLIENT);
        }else if(comands[0].equals ("pwd")){
            c = new PWD (FTP_CLIENT);
        }
        else { return null;}
        return c;
    }
}
