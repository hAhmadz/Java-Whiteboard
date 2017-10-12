package ChatWindow;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatClient
{

    private static int port;
    private static String ip = "localhost";

    public static void main(String[] args)
    {
        port = 3000;
        Scanner s = new Scanner(System.in);
        String msg;

        try (Socket socket = new Socket(ip, port);)
        {
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            /*while(true) {
				msg = s.nextLine();
				output.writeUTF(msg);
			}*/
        }
        catch (UnknownHostException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
