/**
 * Distributed Individuals
 *	David William Ripper	694807
 *	Haaris Nazir Ahmad 		869969
 *	Luis Jason Jacildo		907034
 *	Joshua James Clark		537660
 *
 * */

package Client;

import Client.jiconfont.FontAwesome;
import Client.jiconfont.IconFontSwing;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;
import java.io.Serializable;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/** Abstact class containing the details for the GUI and the whiteboard. */
public abstract class Whiteboard extends javax.swing.JFrame implements Serializable
{
    private javax.swing.JSlider brushSizeSlider;
    private static javax.swing.JTextArea chatHistoryTextArea;
    private static javax.swing.JTextField chatTextField;
    private javax.swing.JButton circleBtnFilled;
    private javax.swing.JButton circleBtnHollow;
    private javax.swing.JButton clearBtn;
    public javax.swing.JList<String> clientList;
    public static DrawingPanel drawingPanel;
    private javax.swing.JButton eraseBtn;
    private javax.swing.JButton freeHandBtn;
    private javax.swing.JColorChooser jColorChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton lineBtn;
    private javax.swing.JButton rectangleBtnFilled;
    private javax.swing.JButton rectangleBtnHollow;
    private javax.swing.JButton redoBtn;
    private javax.swing.JButton sendMsgBtn;
    private javax.swing.JButton textDrawBtn;
    private javax.swing.JButton undoBtn;
    public javax.swing.JButton kickBtn;
    // End of variables declaration//GEN-END:variables
    private String username;
    private Icon icon;
    private DefaultListModel<String> dlm;


    public Whiteboard()
    {
        initComponents(); //Auto generated UI ONLY
        String prompt = "Please enter your username";
        
        do
        {
            username = JOptionPane.showInputDialog(prompt);
            username = username.trim();
            prompt = "Username must be provided!";

            if (username == null)
            {
                System.out.println("Username selection cancelled. System exiting.");
                System.exit(1);
            }
        
        } while(username.equals(""));
    }


    public abstract void connect(String host, int port);

    public abstract void messageAction(String message);

    public abstract void kick();

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }


    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    public void initComponents()
    {
        jPanel1 = new javax.swing.JPanel();
        IconFontSwing.register(FontAwesome.getIconFont());
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
        freeHandBtn = new javax.swing.JButton(icon);
        icon = IconFontSwing.buildIcon(FontAwesome.UNDO, 28);
        undoBtn = new javax.swing.JButton(icon);
        icon = IconFontSwing.buildIcon(FontAwesome.REPEAT, 28);
        redoBtn = new javax.swing.JButton(icon);
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatHistoryTextArea = new javax.swing.JTextArea();
        chatTextField = new javax.swing.JTextField();
        //icon = IconFontSwing.buildIcon(FontAwesome.REPLY_ALL, 28);
        sendMsgBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        dlm = new DefaultListModel<String>();
        clientList = new javax.swing.JList<>(dlm);
        icon = IconFontSwing.buildIcon(FontAwesome.REPLY_ALL, 28);
        drawingPanel = new DrawingPanel();
        kickBtn = new javax.swing.JButton();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setMinimumSize(new java.awt.Dimension(1280, 800));
        setPreferredSize(new java.awt.Dimension(1280, 800)); 
        setSize(new java.awt.Dimension(0, 0));

        jPanel1.setBackground(new java.awt.Color(223, 223, 223));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Toolbar"));

        rectangleBtnHollow.setBackground(new java.awt.Color(207, 207, 207));
        rectangleBtnHollow.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rectangleBtnHollow.setForeground(new java.awt.Color(102, 102, 102));
        rectangleBtnHollow.setToolTipText("Creates a hollow rectangle");
        rectangleBtnHollow.setActionCommand("RECTANGLEHOLLOW");
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
        circleBtnHollow.setActionCommand("CIRCLEHOLLOW");
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
        lineBtn.setActionCommand("LINE");
        lineBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                brushBtnActionPerformed(evt);
            }
        });

        AbstractColorChooserPanel[] customPanels = jColorChooser.getChooserPanels();
        for (AbstractColorChooserPanel accp : customPanels)
        if(!accp.getDisplayName().equals("Swatches"))
        jColorChooser.removeChooserPanel(accp);
        jColorChooser.setColor(new java.awt.Color(0, 0, 0));
        jColorChooser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ColorSelectionModel model = jColorChooser.getSelectionModel();
        ChangeListener colorChangeListener = new ChangeListener()
        {
            public void stateChanged(ChangeEvent e)
            {
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
        ChangeListener sizeChangeListener = new ChangeListener()
        {
            public void stateChanged(ChangeEvent e)
            {
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(brushSizeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        eraseBtn.setActionCommand("ERASER");
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
        rectangleBtnFilled.setActionCommand("RECTANGLEFILLED");
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
        circleBtnFilled.setActionCommand("CIRCLEFILLED");
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
        textDrawBtn.setActionCommand("TEXT");
        textDrawBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                brushBtnActionPerformed(evt);
            }
        });

        freeHandBtn.setBackground(new java.awt.Color(207, 207, 207));
        freeHandBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        freeHandBtn.setForeground(new java.awt.Color(102, 102, 102));
        freeHandBtn.setToolTipText("Freehand drawing mode");
        freeHandBtn.setActionCommand("FREEHAND");
        freeHandBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                brushBtnActionPerformed(evt);
            }
        });

        undoBtn.setBackground(new java.awt.Color(207, 207, 207));
        undoBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        undoBtn.setForeground(new java.awt.Color(102, 102, 102));
        undoBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                undoBtnActionPerformed(evt);
            }
        });

        redoBtn.setBackground(new java.awt.Color(207, 207, 207));
        redoBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        redoBtn.setForeground(new java.awt.Color(102, 102, 102));
        redoBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                redoBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jColorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(textDrawBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(rectangleBtnHollow, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(freeHandBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(circleBtnHollow, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(circleBtnFilled, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lineBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(rectangleBtnFilled, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(eraseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(undoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(redoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(circleBtnFilled, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(undoBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(lineBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eraseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rectangleBtnFilled, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(redoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(freeHandBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(circleBtnHollow, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rectangleBtnHollow, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textDrawBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(32,32,32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43) 
                .addComponent(jColorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 300, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
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
        chatTextField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                sendMsgBtnActionPerformed(evt);
            }
        });

        sendMsgBtn.setBackground(new java.awt.Color(153, 153, 153));
        sendMsgBtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        sendMsgBtn.setForeground(new java.awt.Color(0, 51, 0));
        sendMsgBtn.setText(" Send");
        sendMsgBtn.setToolTipText("");
        sendMsgBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                sendMsgBtnActionPerformed(evt);
            }
        });

        clientList.setBackground(new java.awt.Color(240, 240, 240));
        jScrollPane2.setViewportView(clientList);

        kickBtn.setBackground(new java.awt.Color(204, 204, 204));
        kickBtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        kickBtn.setForeground(new java.awt.Color(0, 51, 0));
        kickBtn.setText(" ");
        kickBtn.setToolTipText("");
        kickBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                kickBtnActionPerformed(evt);
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
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(chatTextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sendMsgBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(kickBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(kickBtn)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(chatTextField)
                        .addComponent(sendMsgBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
            );

        drawingPanel.setBackground(new java.awt.Color(255, 255, 255));
        drawingPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));

        javax.swing.GroupLayout drawingPanelLayout = new javax.swing.GroupLayout(drawingPanel);
        drawingPanel.setLayout(drawingPanelLayout);
        drawingPanelLayout.setHorizontalGroup(
            drawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 778, Short.MAX_VALUE)
        );
        drawingPanelLayout.setVerticalGroup(
            drawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(drawingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addComponent(drawingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents// </editor-fold>//GEN-END:initComponents


    private void kickBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_undoBtnActionPerformed
    {
        // DO NOTHING
    }

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
    
    private void sendMsgBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_sendMsgBtnActionPerformed
    {//GEN-HEADEREND:event_sendMsgBtnActionPerformed
        String message = username + ": " + chatTextField.getText();
        messageAction(message);
        chatTextField.setText("");
    }//GEN-LAST:event_sendMsgBtnActionPerformed

    private void undoBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_undoBtnActionPerformed
    {//GEN-HEADEREND:event_undoBtnActionPerformed
        drawingPanel.undoDraw();
    }//GEN-LAST:event_undoBtnActionPerformed

    private void redoBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_redoBtnActionPerformed
    {//GEN-HEADEREND:event_redoBtnActionPerformed
        drawingPanel.redoDraw();
    }//GEN-LAST:event_redoBtnActionPerformed
    
    public void updateChatHistory(ArrayList<String> OutputStream) {
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

    
    public void updateClientList(Vector<ClientExInt> clients) {
        dlm.clear();
        for (int i = 0; i < clients.size(); i++)
        {
            
            ClientExInt tmp = (ClientExInt) clients.get(i);
            try {
                    
                dlm.addElement(tmp.getName());
            } catch (RemoteException e) {
                System.out.println("Could not get client's name from server");
            }
            
        }
        
    }
}

