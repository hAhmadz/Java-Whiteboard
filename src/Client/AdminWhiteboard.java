/**
 * Distributed Individuals
 *	David William Ripper	694807
 *	Haaris Nazir Ahmad 		869969
 *	Luis Jason Jacildo		907034
 *	Joshua James Clark		537660
 *
 * */

package Client;

import Server.RemoteShapeList;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.Inet4Address;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ListModel;


/** User interface for the Manager. Has special powers over the normal client
 * including the ability to save the images, or kick clients off the server. */
public class AdminWhiteboard extends Whiteboard
{
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
    private ClientEx clientEx;
    private static RemoteShapeList shapes = null;

    private int serverPort;
    private int managerPort;

    public AdminWhiteboard()
    {
        super();
        this.initAdminComponents();
    }


    // args: <port>
    public static void main(String[] args)
    {
        AdminWhiteboard admin = new AdminWhiteboard();
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                admin.setVisible(true);
            }
        });


        if (args.length != 2)
        {
            System.out.println("usage: AdminWhiteboard <server port> <manager port>");
            System.exit(0);
        }

    if (args[0] == args[1])
        {
            System.out.println("the manager and server ports must be different. exiting.");
            System.exit(1);
        }

        try
        {
            admin.serverPort = Integer.parseInt(args[0]);
            admin.connect("localhost", admin.serverPort);
            admin.managerPort = Integer.parseInt(args[1]);
            admin.startServer(admin.managerPort);
        }
        catch (NumberFormatException ex)
        {
            System.out.println("Port must be an integer in the range 0 to 65535");
            System.out.println("Client is quitting.");
            System.exit(1);
        }

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                System.out.println("shutting down");
                try 
                {
                    ListModel clientLM = admin.clientList.getModel();
                    for (int i = 0; i < clientLM.getSize(); i++)
                    {
                        String target = (String) clientLM.getElementAt(i);
                        shapes.unsubscribe(target);    
                    } 
                }
                catch (RemoteException e) {
                    //theres no server so this will be called
                }
            }
        },"Shutdown-thread"));
        
    }

    public void connect(String serverHost, int serverPort)
    {
        try
        {

            clientEx = new ClientEx();
            clientEx.setDrawPan(drawingPanel);
            clientEx.setGui(this);

            Registry registry = LocateRegistry.getRegistry(serverHost, serverPort);
            //Registry registry = LocateRegistry.getRegistry(ip, port);
            shapes = (RemoteShapeList) registry.lookup("shapeList");

            shapes.subscribe(clientEx);
            //shapes.subscribeChat(chatPanel);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this,
                "There was an issue connecting to the server.\n Please check your settings and try again.",
                "Connection error",
                JOptionPane.ERROR_MESSAGE);
            System.exit(101);
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
            System.out.println("Problem adding message to server");
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

        kickBtn.setBackground(new java.awt.Color(207, 207, 207));
        kickBtn.setText("Kick");
        kickBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                kickBtnActionPerformed(evt);
            }
        });
        

        pack();
    }// </editor-fold>//GEN-END:initComponents// </editor-fold>//GEN-END:initComponents

    private void kickBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_undoBtnActionPerformed
    {
        String kickUsername = clientList.getSelectedValue();

        // don't kick yourself!
        if (kickUsername != null)
        { 
            if (!(kickUsername.equals(getUsername())))
            {
                System.out.println("kicking " + kickUsername);
                try
                {
                    shapes.unsubscribe(kickUsername);
                }
                catch (Exception e)
                {
                	System.out.println("problem unsubscribing client. Exiting");
                	System.exit(0);
                }
            }
        }


    }

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
    
      
    public void startServer(int port) {
        final ExecutorService clientProcessingPool = Executors.newFixedThreadPool(10);

        Runnable serverTask = new Runnable() {
            @Override
            public void run() {
                try {
                    ServerSocket serverSocket = new ServerSocket(port);
                    System.out.println("Waiting for clients to connect...");
                    while (true) {
                        Socket clientSocket = serverSocket.accept();
                        clientProcessingPool.submit(new ClientTask(clientSocket));
                    }
                } catch (IOException e) {
                    System.err.println("Unable to process client request");
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
                    boolean nameOK;
                    String clientUsername;
                    do
                    {
                        nameOK = true;
                        clientUsername = input.readUTF();
                        ListModel clientLM = clientList.getModel();
                        for (int i = 0; i < clientLM.getSize(); i++)
                        {
                            String target = (String) clientLM.getElementAt(i);

                            if (clientUsername.equals(target))
                            {
                                nameOK = false;
                                output.writeUTF("nametaken");
                                output.flush();
                            }
                        }
                    } while (!nameOK);


                    int n = JOptionPane.showConfirmDialog(
                            null, clientUsername + " would like to join.",
                            "Join Request",
                            JOptionPane.YES_NO_OPTION);
                    if (n == JOptionPane.YES_OPTION) 
                    {
                        output.writeUTF("accept");
                        output.flush();
                        output.writeUTF(String.valueOf(serverPort));
                        output.flush();
                        String serverHost = Inet4Address.getLocalHost().getHostAddress();
                        output.writeUTF(serverHost);
                        output.flush();
                    } 
                    else if (n == JOptionPane.NO_OPTION) 
                    {
                        output.writeUTF("reject");
                        output.flush();
                    } else {
                        output.writeUTF("reject");
                        output.flush();
                    }       
                }
                clientSocket.close();
            } 
            catch (IOException e1) 
            {
                System.out.println("issue connecting");
                System.exit(0);
            }
            
        }
    }


    public void kick()
    {
        // can't kick the manager
    }
}

