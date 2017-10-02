package Client;

import Client.jiconfont.FontAwesome;
import Client.jiconfont.IconFontSwing;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ClientWhiteboard extends javax.swing.JFrame
{
    // Variables declaration - do not modify//GEN-BEGIN:variables
    //private javax.swing.JPanel drawingPanel;
    private DrawingPanel drawingPanel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextArea chatHistoryTextArea;
    private javax.swing.JTextField chatTextField;
    private javax.swing.JButton circleBtnFilled;
    private javax.swing.JButton circleBtnHollow;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton freehandBtn;
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
    private javax.swing.JSlider brushSizeSlider;
    private javax.swing.JButton lineBtn;
    private javax.swing.JMenuItem openBtn;
    private javax.swing.JButton rectangleBtnFilled;
    private javax.swing.JButton rectangleBtnHollow;
    private javax.swing.JMenuItem saveBtn;
    private javax.swing.JButton sendMsgBtn;
    private javax.swing.JButton textDrawBtn;
    // End of variables declaration//GEN-END:variables
  
    private Icon icon;

    public ClientWhiteboard()
    {
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

    /*
    //old drawing panel components that have to be integrated instead of the drawingPanel
    public void myComp()
    {
        //another method to initialise custom components -- only cuz my netbeans does not allow me to handle default components easily :P
        drawingPanel = new DrawingPanel();
        drawingPanel.setBackground(new java.awt.Color(255, 255, 255));
        drawingPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        javax.swing.GroupLayout drawingPanelLayout = new javax.swing.GroupLayout(drawingPanel);
        drawingPanel.setLayout(drawingPanelLayout);
        drawingPanelLayout.setHorizontalGroup(
                drawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 0, Short.MAX_VALUE)
        );
        drawingPanelLayout.setVerticalGroup(
                drawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 445, Short.MAX_VALUE)
        );

    }*/

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        IconFontSwing.register(FontAwesome.getIconFont());
        drawingPanel = new DrawingPanel();
        icon = IconFontSwing.buildIcon(FontAwesome.SQUARE_O, 28);
        rectangleBtnHollow = new javax.swing.JButton(icon);
        icon = IconFontSwing.buildIcon(FontAwesome.CIRCLE_O, 28);
        circleBtnHollow = new javax.swing.JButton(icon);
        icon = IconFontSwing.buildIcon(FontAwesome.MINUS, 28);
        lineBtn = new javax.swing.JButton(icon);
        jColorChooser = new javax.swing.JColorChooser();
        jPanel2 = new javax.swing.JPanel();
        brushSizeSlider = new javax.swing.JSlider();
        clearBtn = new javax.swing.JButton();
        icon = IconFontSwing.buildIcon(FontAwesome.ERASER, 30);
        eraseBtn = new javax.swing.JButton(icon);
        icon = IconFontSwing.buildIcon(FontAwesome.SQUARE, 28);
        rectangleBtnFilled = new javax.swing.JButton(icon);
        icon = IconFontSwing.buildIcon(FontAwesome.CIRCLE, 28);
        circleBtnFilled = new javax.swing.JButton(icon);
        textDrawBtn = new javax.swing.JButton();
        icon = IconFontSwing.buildIcon(FontAwesome.PENCIL, 28);
        freehandBtn = new javax.swing.JButton(icon);
        jLabel1 = new javax.swing.JLabel();
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

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setSize(new java.awt.Dimension(0, 0));

        jPanel1.setBackground(new java.awt.Color(223, 223, 223));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Toolbar"));

        freehandBtn.setBackground(new java.awt.Color(207, 207, 207));
        freehandBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        freehandBtn.setForeground(new java.awt.Color(102, 102, 102));
        freehandBtn.setActionCommand("FREEHAND");
        freehandBtn.setToolTipText("Freehand drawing mode");
        freehandBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                brushBtnActionPerformed(evt);
            }
        });

        circleBtnHollow.setBackground(new java.awt.Color(207, 207, 207));
        circleBtnHollow.setFont(new java.awt.Font("Tahoma", 0, 18));
        circleBtnHollow.setForeground(new java.awt.Color(102, 102, 102));
        circleBtnHollow.setActionCommand("CIRCLEHOLLOW");
        circleBtnHollow.setToolTipText("Creates a hollow circle");
        circleBtnHollow.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                brushBtnActionPerformed(evt);
            }
        });

        circleBtnFilled.setBackground(new java.awt.Color(207, 207, 207));
        circleBtnFilled.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        circleBtnFilled.setForeground(new java.awt.Color(102, 102, 102));
        circleBtnFilled.setActionCommand("CIRCLEFILLED");
        circleBtnFilled.setToolTipText("Creates a filled circle");
        circleBtnFilled.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                brushBtnActionPerformed(evt);
            }
        });

        lineBtn.setBackground(new java.awt.Color(207, 207, 207));
        lineBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lineBtn.setForeground(new java.awt.Color(102, 102, 102));
        lineBtn.setActionCommand("LINE");
        lineBtn.setToolTipText("Creates a line");
        lineBtn.addActionListener(new java.awt.event.ActionListener()
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
        textDrawBtn.setActionCommand("TEXT");
        textDrawBtn.setToolTipText("Creates a text box");
        textDrawBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                brushBtnActionPerformed(evt);
            }
        });

        rectangleBtnHollow.setBackground(new java.awt.Color(207, 207, 207));
        rectangleBtnHollow.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rectangleBtnHollow.setForeground(new java.awt.Color(102, 102, 102));
        rectangleBtnHollow.setActionCommand("RECTANGLEHOLLOW");
        rectangleBtnHollow.setToolTipText("Creates a hollow rectangle");
        rectangleBtnHollow.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                brushBtnActionPerformed(evt);
            }
        });


        rectangleBtnFilled.setBackground(new java.awt.Color(207, 207, 207));
        rectangleBtnFilled.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rectangleBtnFilled.setForeground(new java.awt.Color(102, 102, 102));
        rectangleBtnFilled.setActionCommand("RECTANGLEFILLED");
        rectangleBtnFilled.setToolTipText("Creates a filled rectangle");
        rectangleBtnFilled.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rectangleBtnFilled.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                brushBtnActionPerformed(evt);
            }
        });


        eraseBtn.setBackground(new java.awt.Color(207, 207, 207));
        eraseBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        eraseBtn.setForeground(new java.awt.Color(102, 102, 102));
        eraseBtn.setActionCommand("ERASER");
        eraseBtn.setToolTipText("Erases the content");
        eraseBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                brushBtnActionPerformed(evt);
            }
        });

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

        // display only swatch panel
        AbstractColorChooserPanel[] customPanels = jColorChooser.getChooserPanels();
        for (AbstractColorChooserPanel accp : customPanels) {
            if(!accp.getDisplayName().equals("Swatches"))
                jColorChooser.removeChooserPanel(accp);
        }
        // black is the default color
        jColorChooser.setColor(new java.awt.Color(0, 0, 0));
        jColorChooser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        // send color selections to the drawing panel instance.
        ColorSelectionModel model = jColorChooser.getSelectionModel();
        ChangeListener colorChangeListener = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                drawingPanel.setActiveColor(jColorChooser.getColor());
            }
        };
        model.addChangeListener(colorChangeListener);

        jPanel2.setBackground(new java.awt.Color(223, 223, 223));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Size"));

        brushSizeSlider.setBackground(new java.awt.Color(223, 223, 223));
        brushSizeSlider.setForeground(new java.awt.Color(102, 102, 102));
        brushSizeSlider.setMajorTickSpacing(1);
        brushSizeSlider.setMaximum(9);
        brushSizeSlider.setMinimum(1);
        brushSizeSlider.setPaintLabels(true);
        brushSizeSlider.setPaintTicks(true);
        brushSizeSlider.setSnapToTicks(true);
        brushSizeSlider.setValue(5);
        brushSizeSlider.setBorder(javax.swing.BorderFactory.createCompoundBorder());


        // send size selections to the drawing panel instance.
        ChangeListener sizeChangeListener = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                drawingPanel.setActiveWeight(source.getValue());
            }
        };
        brushSizeSlider.addChangeListener(sizeChangeListener);


        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(brushSizeSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(brushSizeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jColorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(textDrawBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rectangleBtnHollow, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(freehandBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(circleBtnHollow, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(circleBtnFilled, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lineBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(rectangleBtnFilled, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(eraseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(freehandBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(lineBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(circleBtnHollow, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(circleBtnFilled, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rectangleBtnHollow, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rectangleBtnFilled, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textDrawBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eraseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jColorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(260, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Whiteboard");

        drawingPanel.setBackground(Color.WHITE);
        drawingPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        drawingPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));

        javax.swing.GroupLayout drawingPanelLayout = new javax.swing.GroupLayout(drawingPanel);
        drawingPanel.setLayout(drawingPanelLayout);
        drawingPanelLayout.setHorizontalGroup(
            drawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        drawingPanelLayout.setVerticalGroup(
            drawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
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
        messageAction("ClientJoined123");

        chatTextField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        chatTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        chatTextField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                sendMsgBtnActionPerformed(evt);
            }
        });

        sendMsgBtn.setBackground(new java.awt.Color(207, 207, 207));
        sendMsgBtn.setForeground(new java.awt.Color(0, 51, 0));
        sendMsgBtn.setText("Send");
        sendMsgBtn.setToolTipText("");
        sendMsgBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                sendMsgBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(chatTextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sendMsgBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 952, Short.MAX_VALUE))
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

        jMenu1.setText("File");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        openBtn.setText("Open");
        openBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuBarAction(evt);
            }
        });
        jMenu1.add(openBtn);

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuBarAction(evt);
            }
        });
        jMenu1.add(saveBtn);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(drawingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(drawingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void menuBarAction(java.awt.event.ActionEvent evt)//GEN-FIRST:event_menuBarAction
    {//GEN-HEADEREND:event_menuBarAction
        String menuAction = evt.getActionCommand().toUpperCase();
        switch (menuAction)
        {
            case "SAVE": //no check yet for: if user is client A, then only save.
                drawingPanel.saveDrawing("image.dat");
                break;
            case "OPEN": //no check yet for: if user is client A, then only open.
                drawingPanel.openDrawing("image.dat");
                break;
            case "EXIT":
                System.exit(0);
                break;
        }
    }//GEN-LAST:event_menuBarAction

    private void messageAction(String message)
    {
        ArrayList<String> OutputStream = drawingPanel.messageStream(message);
        chatTextField.setText("");
        String OutputString = "";
        if (!OutputStream.isEmpty())
        {
            for (String msg : OutputStream)
            {
                OutputString += msg + "\n";
            }
        }
        chatHistoryTextArea.setText(OutputString);
    }


    private void sendMsgBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_sendMsgBtnActionPerformed
    {//GEN-HEADEREND:event_sendMsgBtnActionPerformed
        String message = chatTextField.getText();
        messageAction(message);
    }//GEN-LAST:event_sendMsgBtnActionPerformed
}
