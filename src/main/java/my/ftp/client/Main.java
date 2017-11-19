package my.ftp.client;

import my.ftp.client.Comands.Comand;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FTPClient client = new FTPClient();
        String hostName;

            try {
                do{
                    System.out.println("Print the server");
                    hostName = reader.readLine();
                    hostName = "ftp.cse.buffalo.edu";
                    client.connect(hostName);
                } while (!client.isConnected ());
                System.out.println(client.getReplyString());
                do {
                    System.out.println("Print user name");
                    String userName = reader.readLine();
                    userName = "anonymous";
                    System.out.println("Print user password");
                    String password = reader.readLine();
                    client.user (userName);
                    client.pass (password);
                }while (client.getReplyCode ()==530);

                System.out.println(client.getReplyString());
                while (client.isConnected ()) {
                    ComandFactory factory = new ComandFactory(client);
                    Comand c;
                    do {
                        System.out.print ("ftp>");
                        String comand = reader.readLine ();
                         c = factory.getComand (comand);
                    }while (c == null);
                    c.execute();
                    client.getReplyString ();
                }
            }catch (QuitException e){
                return;
            }
            catch (Exception e){
                System.out.println ("Something went wrong");

            }finally {
                if(!client.isConnected ()){
                    client.logout ();
                    client.disconnect ();
                }

            }
    }
}
