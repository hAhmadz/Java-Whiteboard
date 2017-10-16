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
    private PanelEx panelex;
    private Messaging chatPanel;
    private RemoteShapeList shapes = null;
    
    //to be implemented
    private boolean unsavedChanges;
    static ArrayList<String> OutputStreamtest = null;
    int login = 0;

    public ClientWhiteboard()
    {
        super(); //Auto generated UI ONLY
    }

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

        if (args.length < 1)
            client.setUsername("toolazy");
        else
            client.setUsername(args[0]);

        client.connect();
    }

 
    public void connect()
    {
        /* Get permission from manager to access Whiteboard.*/
        int port = 0;
        String ip = null;
        try(Socket socket = new Socket("localhost", 8000);)
        {
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
                port = Integer.parseInt(tmp);
                ip = input.readUTF();
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
            panelex = new PanelEx();
            panelex.setDrawPan(drawingPanel);
            
            /*TODO insert messaginInt here*/
            chatPanel = new Messaging();
            chatPanel.setGui(this);
            //Registry registry = LocateRegistry.getRegistry("localhost", 6000);
            Registry registry = LocateRegistry.getRegistry(ip, port);
            shapes = (RemoteShapeList) registry.lookup("shapeList");

            shapes.subscribe(panelex);
            shapes.subscribeChat(chatPanel);
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
}

