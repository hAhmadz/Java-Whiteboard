package Client;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JColorChooser;
import javax.swing.colorchooser.ColorSelectionModel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MouseInputAdapter;

public class ClientWhiteboard extends javax.swing.JFrame
{
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel WhitePanel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextArea chatHistoryTextArea;
    private javax.swing.JTextField chatTextField;
    private javax.swing.JButton circleBtnFilled;
    private javax.swing.JButton circleBtnHollow;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton drawFreeHandBtn;
    private javax.swing.JButton eraseBtn;
    private javax.swing.JMenuItem exitBtn;
    private javax.swing.JColorChooser jColorChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JButton lineBtn;
    private javax.swing.JMenuItem openBtn;
    private javax.swing.JButton rectangleBtnFilled;
    private javax.swing.JButton rectangleBtnHollow;
    private javax.swing.JMenuItem saveBtn;
    private javax.swing.JButton sendMsgBtn;
    private javax.swing.JButton textDrawBtn;
    // End of variables declaration//GEN-END:variables
    private DrawingPanel drawingPanel;
    
    public ClientWhiteboard()
    {
        initComponents(); // Auto generated for GUI.
        //selectionLabel.setText("\uf0c0");
        myComp();
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
    }
    
    public void myComp()
    {
        //another method to initialise custom components -- only cuz my netbeans does not allow me to handle default components easily :P
        drawingPanel = new DrawingPanel();
        drawingPanel.setBackground(new java.awt.Color(255, 255, 255));
        drawingPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        javax.swing.GroupLayout WhitePanelLayout = new javax.swing.GroupLayout(WhitePanel);
        drawingPanel.setLayout(WhitePanelLayout);
        WhitePanelLayout.setHorizontalGroup(
            WhitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        WhitePanelLayout.setVerticalGroup(
            WhitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
        );
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        rectangleBtnHollow = new javax.swing.JButton();
        circleBtnHollow = new javax.swing.JButton();
        lineBtn = new javax.swing.JButton();
        jColorChooser = new javax.swing.JColorChooser();
        jPanel2 = new javax.swing.JPanel();
        jSlider1 = new javax.swing.JSlider();
        clearBtn = new javax.swing.JButton();
        eraseBtn = new javax.swing.JButton();
        rectangleBtnFilled = new javax.swing.JButton();
        circleBtnFilled = new javax.swing.JButton();
        textDrawBtn = new javax.swing.JButton();
        drawFreeHandBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        WhitePanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatHistoryTextArea = new javax.swing.JTextArea();
        chatTextField = new javax.swing.JTextField();
        sendMsgBtn = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        openBtn = new javax.swing.JMenuItem();
        saveBtn = new javax.swing.JMenuItem();
        exitBtn = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setSize(new java.awt.Dimension(0, 0));

        jPanel1.setBackground(new java.awt.Color(223, 223, 223));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Toolbar"));

        rectangleBtnHollow.setBackground(new java.awt.Color(207, 207, 207));
        rectangleBtnHollow.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rectangleBtnHollow.setForeground(new java.awt.Color(102, 102, 102));
        rectangleBtnHollow.setText("Rectangle");
        rectangleBtnHollow.setToolTipText("Creates a hollow rectangle");

        circleBtnHollow.setBackground(new java.awt.Color(207, 207, 207));
        circleBtnHollow.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        circleBtnHollow.setForeground(new java.awt.Color(102, 102, 102));
        circleBtnHollow.setText("Circle");
        circleBtnHollow.setToolTipText("Creates a hollow circle");

        lineBtn.setBackground(new java.awt.Color(207, 207, 207));
        lineBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lineBtn.setForeground(new java.awt.Color(102, 102, 102));
        lineBtn.setText("Line");
        lineBtn.setToolTipText("Creates a line");

        jPanel2.setBackground(new java.awt.Color(223, 223, 223));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Size"));

        jSlider1.setBackground(new java.awt.Color(223, 223, 223));
        jSlider1.setForeground(new java.awt.Color(102, 102, 102));
        jSlider1.setMajorTickSpacing(10);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setSnapToTicks(true);
        jSlider1.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        clearBtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        clearBtn.setForeground(new java.awt.Color(253, 8, 8));
        clearBtn.setText("Clear");
        clearBtn.setToolTipText("Clear All");
        clearBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                clearBtnActionPerformed(evt);
            }
        });

        eraseBtn.setBackground(new java.awt.Color(207, 207, 207));
        eraseBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        eraseBtn.setForeground(new java.awt.Color(102, 102, 102));
        eraseBtn.setText("Erase");
        eraseBtn.setToolTipText("Erases the content");

        rectangleBtnFilled.setBackground(new java.awt.Color(207, 207, 207));
        rectangleBtnFilled.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rectangleBtnFilled.setForeground(new java.awt.Color(102, 102, 102));
        rectangleBtnFilled.setText("Filled Rec");
        rectangleBtnFilled.setToolTipText("Creates a filled rectangle");
        rectangleBtnFilled.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        circleBtnFilled.setBackground(new java.awt.Color(207, 207, 207));
        circleBtnFilled.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        circleBtnFilled.setForeground(new java.awt.Color(102, 102, 102));
        circleBtnFilled.setText("Filled Cir");
        circleBtnFilled.setToolTipText("Creates a filled circle");

        textDrawBtn.setBackground(new java.awt.Color(207, 207, 207));
        textDrawBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textDrawBtn.setForeground(new java.awt.Color(102, 102, 102));
        textDrawBtn.setText("Text");
        textDrawBtn.setToolTipText("Creates a text box");

        drawFreeHandBtn.setBackground(new java.awt.Color(207, 207, 207));
        drawFreeHandBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        drawFreeHandBtn.setForeground(new java.awt.Color(102, 102, 102));
        drawFreeHandBtn.setText("Draw");
        drawFreeHandBtn.setToolTipText("Enables the  freehand drawing mode");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(drawFreeHandBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(lineBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(circleBtnHollow, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(circleBtnFilled, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(rectangleBtnHollow, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rectangleBtnFilled, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eraseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textDrawBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jColorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rectangleBtnHollow, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(circleBtnHollow, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(drawFreeHandBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textDrawBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(circleBtnFilled, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rectangleBtnFilled, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lineBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eraseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(clearBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jColorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Distributed Whiteboard");

        WhitePanel.setBackground(new java.awt.Color(255, 255, 255));
        WhitePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        javax.swing.GroupLayout WhitePanelLayout = new javax.swing.GroupLayout(WhitePanel);
        WhitePanel.setLayout(WhitePanelLayout);
        WhitePanelLayout.setHorizontalGroup(
            WhitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        WhitePanelLayout.setVerticalGroup(
            WhitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        chatHistoryTextArea.setColumns(20);
        chatHistoryTextArea.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        chatHistoryTextArea.setRows(5);
        chatHistoryTextArea.setToolTipText("Add Input Box");
        chatHistoryTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(chatHistoryTextArea);

        sendMsgBtn.setBackground(new java.awt.Color(207, 207, 207));
        sendMsgBtn.setForeground(new java.awt.Color(102, 102, 102));
        sendMsgBtn.setText("Send");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(chatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sendMsgBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chatTextField)
                    .addComponent(sendMsgBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jMenu1.setBackground(new java.awt.Color(153, 153, 153));
        jMenu1.setText("File");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenu1.setPreferredSize(new java.awt.Dimension(50, 35));

        openBtn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openBtn.setBackground(new java.awt.Color(204, 204, 204));
        openBtn.setText("Open");
        openBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                openBtnActionPerformed(evt);
            }
        });
        jMenu1.add(openBtn);

        saveBtn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                saveBtnActionPerformed(evt);
            }
        });
        jMenu1.add(saveBtn);

        exitBtn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        exitBtn.setText("Exit");
        exitBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                exitBtnActionPerformed(evt);
            }
        });
        jMenu1.add(exitBtn);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(933, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(WhitePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(WhitePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void brushBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_RectangleBtnActionPerformed
    {//GEN-HEADEREND:event_RectangleBtnActionPerformed
        String style = evt.getActionCommand();
        drawingPanel.setActiveStyle(style);
        drawingPanel.setActiveColor(jColorChooser.getColor());
    }//GEN-LAST:event_RectangleBtnActionPerformed


    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_clearBtnActionPerformed
    {//GEN-HEADEREND:event_clearBtnActionPerformed
        drawingPanel.clear();
    }//GEN-LAST:event_clearBtnActionPerformed

    private void openBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_openBtnActionPerformed
    {//GEN-HEADEREND:event_openBtnActionPerformed
        //open a file button
    }//GEN-LAST:event_openBtnActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_exitBtnActionPerformed
    {//GEN-HEADEREND:event_exitBtnActionPerformed
        //exit
    }//GEN-LAST:event_exitBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_saveBtnActionPerformed
    {//GEN-HEADEREND:event_saveBtnActionPerformed
        // save
    }//GEN-LAST:event_saveBtnActionPerformed

}
