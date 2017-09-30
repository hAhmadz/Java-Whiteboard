package Client;
import Client.jiconfont.FontAwesome;
import Client.jiconfont.IconFontSwing;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.JLabel;

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
    private javax.swing.JColorChooser jColorChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JButton lineBtn;
    private javax.swing.JButton openBtn;
    private javax.swing.JButton rectangleBtnFilled;
    private javax.swing.JButton rectangleBtnHollow;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton sendMsgBtn;
    private javax.swing.JButton textDrawBtn;
    // End of variables declaration//GEN-END:variables
    private DrawingPanel drawingPanel;
    private Icon icon;
    public ClientWhiteboard()
    {
        IconFontSwing.register(FontAwesome.getIconFont());
        initComponents(); //Auto generated UI ONLY
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
    
    //old drawing panel components that have to be integrated instead of the WhitePanel
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
        icon = IconFontSwing.buildIcon(FontAwesome.SQUARE_O, 28);
        rectangleBtnHollow = new javax.swing.JButton(icon);
        icon = IconFontSwing.buildIcon(FontAwesome.CIRCLE_O, 28);
        circleBtnHollow = new javax.swing.JButton(icon);
        icon = IconFontSwing.buildIcon(FontAwesome.LONG_ARROW_RIGHT, 28);
        lineBtn = new javax.swing.JButton(icon);
        jColorChooser = new javax.swing.JColorChooser();
        jPanel2 = new javax.swing.JPanel();
        jSlider1 = new javax.swing.JSlider();
        clearBtn = new javax.swing.JButton();
        icon = IconFontSwing.buildIcon(FontAwesome.ERASER, 30);
        eraseBtn = new javax.swing.JButton(icon);
        icon = IconFontSwing.buildIcon(FontAwesome.SQUARE, 28);
        rectangleBtnFilled = new javax.swing.JButton(icon);
        icon = IconFontSwing.buildIcon(FontAwesome.CIRCLE, 28);
        circleBtnFilled = new javax.swing.JButton(icon);
        textDrawBtn = new javax.swing.JButton();
        icon = IconFontSwing.buildIcon(FontAwesome.PENCIL, 28);
        drawFreeHandBtn = new javax.swing.JButton(icon);
        icon = IconFontSwing.buildIcon(FontAwesome.FOLDER_OPEN_O, 28);
        openBtn = new javax.swing.JButton(icon);
        icon = IconFontSwing.buildIcon(FontAwesome.FILE, 28);
        saveBtn = new javax.swing.JButton(icon);
        jLabel1 = new javax.swing.JLabel();
        WhitePanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatHistoryTextArea = new javax.swing.JTextArea();
        chatTextField = new javax.swing.JTextField();
        sendMsgBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setSize(new java.awt.Dimension(0, 0));

        jPanel1.setBackground(new java.awt.Color(223, 223, 223));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Toolbar"));

        rectangleBtnHollow.setBackground(new java.awt.Color(207, 207, 207));
        rectangleBtnHollow.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rectangleBtnHollow.setForeground(new java.awt.Color(102, 102, 102));
        rectangleBtnHollow.setToolTipText("Creates a hollow rectangle");
        rectangleBtnHollow.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                brushBtnActionPerformed(evt);
            }
        });

        circleBtnHollow.setBackground(new java.awt.Color(207, 207, 207));
        circleBtnHollow.setFont(new java.awt.Font("Tahoma", 0, 18));
        circleBtnHollow.setForeground(new java.awt.Color(102, 102, 102));
        circleBtnHollow.setToolTipText("Creates a hollow circle");
        circleBtnHollow.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                brushBtnActionPerformed(evt);
            }
        });

        lineBtn.setBackground(new java.awt.Color(207, 207, 207));
        lineBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lineBtn.setForeground(new java.awt.Color(102, 102, 102));
        lineBtn.setToolTipText("Creates a line");
        lineBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                brushBtnActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(223, 223, 223));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Size"));

        jSlider1.setBackground(new java.awt.Color(223, 223, 223));
        jSlider1.setForeground(new java.awt.Color(102, 102, 102));
        jSlider1.setMajorTickSpacing(1);
        jSlider1.setMaximum(9);
        jSlider1.setMinimum(1);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setSnapToTicks(true);
        jSlider1.setValue(5);
        jSlider1.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        clearBtn.setBackground(new java.awt.Color(207, 207, 207));
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
        eraseBtn.setToolTipText("Erases the content");
        eraseBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                brushBtnActionPerformed(evt);
            }
        });

        rectangleBtnFilled.setBackground(new java.awt.Color(207, 207, 207));
        rectangleBtnFilled.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rectangleBtnFilled.setForeground(new java.awt.Color(102, 102, 102));
        rectangleBtnFilled.setToolTipText("Creates a filled rectangle");
        rectangleBtnFilled.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rectangleBtnFilled.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                brushBtnActionPerformed(evt);
            }
        });

        circleBtnFilled.setBackground(new java.awt.Color(207, 207, 207));
        circleBtnFilled.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        circleBtnFilled.setForeground(new java.awt.Color(102, 102, 102));
        circleBtnFilled.setToolTipText("Creates a filled circle");
        circleBtnFilled.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                brushBtnActionPerformed(evt);
            }
        });

        textDrawBtn.setBackground(new java.awt.Color(207, 207, 207));
        textDrawBtn.setFont(new java.awt.Font("Times New Roman", 1, 28));
        textDrawBtn.setForeground(new java.awt.Color(102, 102, 102));
        textDrawBtn.setText("T");
        textDrawBtn.setToolTipText("Creates a text box");

        drawFreeHandBtn.setBackground(new java.awt.Color(207, 207, 207));
        drawFreeHandBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        drawFreeHandBtn.setForeground(new java.awt.Color(102, 102, 102));
        drawFreeHandBtn.setToolTipText("Enables the  freehand drawing mode");

        openBtn.setBackground(new java.awt.Color(207, 207, 207));
        openBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        openBtn.setForeground(new java.awt.Color(102, 102, 102));
        openBtn.setToolTipText("Open a file");
        openBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                openBtnbrushBtnActionPerformed(evt);
            }
        });

        saveBtn.setBackground(new java.awt.Color(207, 207, 207));
        saveBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(102, 102, 102));
        saveBtn.setToolTipText("Save file");
        saveBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                saveBtnbrushBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(textDrawBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eraseBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(337, 337, 337))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rectangleBtnHollow, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rectangleBtnFilled, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(drawFreeHandBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lineBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(circleBtnHollow, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(circleBtnFilled, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(openBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(clearBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jColorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(drawFreeHandBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(lineBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(circleBtnHollow, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(circleBtnFilled, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(openBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rectangleBtnHollow, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rectangleBtnFilled, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textDrawBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eraseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jColorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Whiteboard");

        WhitePanel.setBackground(new java.awt.Color(255, 255, 255));
        WhitePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        WhitePanel.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));

        javax.swing.GroupLayout WhitePanelLayout = new javax.swing.GroupLayout(WhitePanel);
        WhitePanel.setLayout(WhitePanelLayout);
        WhitePanelLayout.setHorizontalGroup(
            WhitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        WhitePanelLayout.setVerticalGroup(
            WhitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        chatHistoryTextArea.setEditable(false);
        chatHistoryTextArea.setBackground(new java.awt.Color(249, 249, 249));
        chatHistoryTextArea.setColumns(20);
        chatHistoryTextArea.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        chatHistoryTextArea.setLineWrap(true);
        chatHistoryTextArea.setRows(7);
        chatHistoryTextArea.setToolTipText("");
        chatHistoryTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(chatHistoryTextArea);

        chatTextField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        chatTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        sendMsgBtn.setBackground(new java.awt.Color(207, 207, 207));
        sendMsgBtn.setForeground(new java.awt.Color(0, 51, 0));
        sendMsgBtn.setText("Send");
        sendMsgBtn.setToolTipText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(chatTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sendMsgBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(WhitePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
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

    private void openBtnbrushBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_openBtnbrushBtnActionPerformed
    {//GEN-HEADEREND:event_openBtnbrushBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_openBtnbrushBtnActionPerformed

    private void saveBtnbrushBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_saveBtnbrushBtnActionPerformed
    {//GEN-HEADEREND:event_saveBtnbrushBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveBtnbrushBtnActionPerformed

}
