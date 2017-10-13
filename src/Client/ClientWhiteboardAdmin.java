package Client;

import java.io.File;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ClientWhiteboardAdmin extends ClientWhiteboard
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

    //to be implemented
    private boolean unsavedChanges;
    static ArrayList<String> OutputStreamtest = null;
    int login = 0;

    public ClientWhiteboardAdmin()
    {
        super.myPublicComponents();
        this.myAdminPublicComponents();//Auto generated UI ONLY
    }

    public void myAdminPublicComponents()
    {
        initComponents();
    }

    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ClientWhiteboard().setVisible(true);
            }
        });

        java.awt.EventQueue.invokeLater(
                new Runnable()
        {
            public void run()
            {
                Runnable test = new Runnable()
                {
                    public void run()
                    {
                        ArrayList<String> OutputStream = null;
                        try
                        {
                            OutputStream = drawingPanel.getMsg();
                        }
                        catch (RemoteException e)
                        {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        String OutputString = "";
                        if (!OutputStream.isEmpty())
                        {
                            for (String msg : OutputStream)
                            {
                                OutputString += msg + "\n";
                            }
                            chatHistoryTextArea.setText(OutputString);
                        }
                    }
                };

                ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
                executor.scheduleAtFixedRate(test, 0, 500, TimeUnit.MILLISECONDS);
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setSize(new java.awt.Dimension(0, 0));

        jPanel1.setBackground(new java.awt.Color(223, 223, 223));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Toolbar"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 468, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 846, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 974, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 287, Short.MAX_VALUE)
        );

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

        connectBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        connectBtn.setText("Connect");
        connectBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                connectBtnActionPerformed(evt);
            }
        });
        jMenu1.add(connectBtn);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

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

    private void connectBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_connectBtnActionPerformed
    {//GEN-HEADEREND:event_connectBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_connectBtnActionPerformed
}
