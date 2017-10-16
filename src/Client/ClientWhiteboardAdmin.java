package Client;

import Client.jiconfont.FontAwesome;
import Client.jiconfont.IconFontSwing;
import Misc.ColoredShape;
import Server.RemoteShapeList;

import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.net.ServerSocketFactory;
import javax.swing.Icon;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ClientWhiteboardAdmin extends Whiteboard
{
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem connectBtn;
    private javax.swing.JMenuItem exitBtn;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JMenuItem newBtn;
    private javax.swing.JMenuItem openBtn;
    private javax.swing.JMenuItem saveAsBtn;
    private javax.swing.JMenuItem saveBtn;
    // End of variables declaration//GEN-END:variables
    private File currentFile;
    private PanelEx panelex;
    private Messaging chatPanel;
    private RemoteShapeList shapes = null;


    public ClientWhiteboardAdmin()
    {
        super();
        this.initAdminComponents();//Auto generated UI ONLY
        this.connect();
    }

    public static void main(String[] args)
    {
        ClientWhiteboardAdmin admin = new ClientWhiteboardAdmin();
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                admin.setVisible(true);
            }
        });
        
        admin.startServer();
    }

    public void connect()
    {
        try
        {
            panelex = new PanelEx();
            panelex.setDrawPan(drawingPanel);
            
            /*TODO insert messaginInt here*/
            chatPanel = new Messaging();
            chatPanel.setGui(this);

            Registry registry = LocateRegistry.getRegistry("localhost", 6000);
            //Registry registry = LocateRegistry.getRegistry(ip, port);
            shapes = (RemoteShapeList) registry.lookup("shapeList");

            shapes.subscribe(panelex);
            boolean chatResult = shapes.subscribeChat(chatPanel);
            System.out.println(chatResult);
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
            if (shapes != null)
                shapes.addMessage(message);
            else
                System.out.println("nully wully");
        }
        catch (RemoteException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initAdminComponents()
    {
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        newBtn = new javax.swing.JMenuItem();
        openBtn = new javax.swing.JMenuItem();
        saveAsBtn = new javax.swing.JMenuItem();
        saveBtn = new javax.swing.JMenuItem();
        connectBtn = new javax.swing.JMenuItem();
        exitBtn = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        newBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        newBtn.setText("New");
        newBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuBarAction(evt);
            }
        });
        jMenu1.add(newBtn);

        openBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        openBtn.setText("Open");
        openBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuBarAction(evt);
            }
        });
        jMenu1.add(openBtn);

        saveAsBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        saveAsBtn.setText("Save As");
        saveAsBtn.setActionCommand("SAVEAS");
        saveAsBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuBarAction(evt);
            }
        });
        jMenu1.add(saveAsBtn);

        saveBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        saveBtn.setText("Save");
        saveBtn.setActionCommand("SAVE");
        saveBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuBarAction(evt);
            }
        });
        jMenu1.add(saveBtn);

        exitBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        exitBtn.setText("Exit");
        exitBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuBarAction(evt);
            }
        });
        jMenu1.add(exitBtn);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuBarAction(java.awt.event.ActionEvent evt)//GEN-FIRST:event_menuBarAction
    {//GEN-HEADEREND:event_menuBarAction
        String menuAction = evt.getActionCommand().toUpperCase();
        switch (menuAction)
        {
            case "SAVE":
                if (currentFile != null)
                {
                    drawingPanel.saveDrawing(currentFile.getPath());
                    break;
                    // break only if current file != null
                }

            case "SAVEAS":
                JFileChooser saveChooser = new JFileChooser();
                int saveValue = saveChooser.showSaveDialog(drawingPanel);
                if (saveValue == JFileChooser.APPROVE_OPTION)
                {
                    currentFile = saveChooser.getSelectedFile();
                    String filename = currentFile.getPath();
                    drawingPanel.saveDrawing(filename);
                }
                break;

            case "OPEN":
                JFileChooser openChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        ".dat files", "dat");
                openChooser.setFileFilter(filter);
                int openValue = openChooser.showOpenDialog(drawingPanel);
                if (openValue == JFileChooser.APPROVE_OPTION)
                {
                    currentFile = openChooser.getSelectedFile();
                    String filename = currentFile.getPath();
                    drawingPanel.openDrawing(filename);
                }
                break;

            case "NEW":
                currentFile = null;
                drawingPanel.newDiagram();
                break;

            case "EXIT":
                System.exit(0);
                break;
        }
    }//GEN-LAST:event_menuBarAction
    
    /* Below bits based off code from:
     * https://stackoverflow.com/questions/15541804/creating-the-serversocket-in-a-separate-thread */
    
    public void startServer() {
        final ExecutorService clientProcessingPool = Executors.newFixedThreadPool(10);

        Runnable serverTask = new Runnable() {
            @Override
            public void run() {
                try {
                    ServerSocket serverSocket = new ServerSocket(8000);
                    System.out.println("Waiting for clients to connect...");
                    while (true) {
                        Socket clientSocket = serverSocket.accept();
                        clientProcessingPool.submit(new ClientTask(clientSocket));
                    }
                } catch (IOException e) {
                    System.err.println("Unable to process client request");
                    e.printStackTrace();
                }
            }
        };
        Thread serverThread = new Thread(serverTask);
        serverThread.start();

    }



    private class ClientTask implements Runnable {
        private final Socket clientSocket;

        private ClientTask(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() 
        {
            System.out.println("Got a client !");
            DataInputStream input;
            try 
            {
                input = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());
                
                if (input.readUTF().equals("connect")) {
                    String clientUsername = input.readUTF();
                    int n = JOptionPane.showConfirmDialog(
                            null, clientUsername + " would like to join.",
                            "Join Request",
                            JOptionPane.YES_NO_OPTION);
                    if (n == JOptionPane.YES_OPTION) 
                    {
                        output.writeUTF("accept");
                        output.flush();
                        output.writeUTF("6000");
                        output.flush();
                        output.writeUTF("localhost");
                        output.flush();
                    } 
                    else if (n == JOptionPane.NO_OPTION) 
                    {
                        output.writeUTF("reject");
                        output.flush();
                    } else {
                        // to do?
                    }       
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            
            try 
            {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}

