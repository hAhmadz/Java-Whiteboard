package ChatWindow;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer
{

    private static int port;

    private static int counter = 0;

    private static ArrayList<ClientThread> clients;

    public static void main(String[] args)
    {
        //ServerSocketFactory factory = ServerSocketFactory.getDefault();
        port = 3000;

        try (ServerSocket server = new ServerSocket(port))
        {
            while (true)
            {
                Socket socket = server.accept();
                counter++;

                ClientThread client = new ClientThread(socket);
                Thread thread = new Thread(client);
                thread.start();
                clients.add(client);

                //Thread t = new Thread(() -> serveClient(client));
                //t.start();
            } // while(true)
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // try(ServerSocket...
    } // main(...

    public static class ClientThread implements Runnable
    {
        private Socket socket;

        public ClientThread(Socket socket)
        {
            this.socket = socket;
        }

        @Override
        public void run()
        {
            // TODO make thread relay messages
        }
    }

    private static void serveClient(Socket client)
    {
        int curClient = counter;
        String curMessage;

        try (Socket clientSocket = client)
        {
            DataInputStream input = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

            while (true)
            {
                curMessage = "Client " + curClient + " : " + input.readUTF();
                System.out.println(curMessage);
            }
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
