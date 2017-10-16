package Client;

import Client.jiconfont.FontAwesome;
import Client.jiconfont.IconFontSwing;
import Server.RemoteShapeList;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.Icon;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ClientWhiteboard extends Whiteboard
{ 
    // End of variables declaration//GEN-END:variables
    private Icon icon;
    private File currentFile;
    //private PanelEx panelex;
    //private Messaging chatPanel;
    private ClientEx clientEx;
    private RemoteShapeList shapes = null;
    
    //to be implemented
    private boolean unsavedChanges;
    static ArrayList<String> OutputStreamtest = null;
    int login = 0;

    public ClientWhiteboard()
    {
        super(); //Auto generated UI ONLY
    }

    // arg format:
    public static void main(String[] args)
    {

        ClientWhiteboard client = new ClientWhiteboard();
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                client.setVisible(true);
            }
        });

        if (args.length != 2)
        {
            System.out.println("Usage: ClientWhiteboard <managerHost> <managerPort>");
            System.exit(0);
        }

        String managerHost = args[0];
        try
        {
            int managerPort = Integer.parseInt(args[1]);
            client.connect(managerHost, managerPort);
        }
        catch (NumberFormatException ex)
        {
            System.out.println("Port must be an integer in the range 0 to 65535");
            System.out.println("Client is quitting.");
            System.exit(1);
        }
        
    }

 
    public void connect(String managerHost, int managerPort)
    {
        /* Get permission from manager to access Whiteboard.*/
        String serverHost = null;
        int serverPort = 0;
        try 
        {
            Socket socket = new Socket(managerHost, managerPort);
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            
            output.writeUTF("connect");
            output.flush();
            output.writeUTF(getUsername());
            output.flush();
            
            /* TODO: handle the case where Manager denies access */
            String response = input.readUTF();
            if (response.equals("accept"))
            {
                String tmp = input.readUTF();
                serverPort = Integer.parseInt(tmp);
                serverHost = input.readUTF();
            }
            else
            {
                JOptionPane.showMessageDialog(this,
                    "Your request has been rejected.",
                    "Join Request Rejected",
                    JOptionPane.ERROR_MESSAGE);
                // close the client
                System.exit(1);
            }
            
            
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        try
        {
            clientEx = new ClientEx();
            clientEx.setDrawPan(drawingPanel);
            clientEx.setGui(this);

            //Registry registry = LocateRegistry.getRegistry("localhost", 6000);
            Registry registry = LocateRegistry.getRegistry(serverHost, serverPort);
            shapes = (RemoteShapeList) registry.lookup("shapeList");

            shapes.subscribe(clientEx);
            //shapes.subscribeChat(chatPanel);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        drawingPanel.setShapes(shapes);
    }

    public void messageAction(String message)
    {
        try 
        {
            shapes.addMessage(message);
        }
        catch (RemoteException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }        
    }


    public void kick()
    {
        JOptionPane.showMessageDialog(this,
            "The Whiteboard Manager has removed you!",
            "Goodbye!",
            JOptionPane.ERROR_MESSAGE);
        System.exit(1);
    }

}

