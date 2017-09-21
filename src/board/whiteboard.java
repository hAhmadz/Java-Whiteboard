//Integration of Joshua's implementation and some GUI changes.
//Pending Stuff: no images are drawing at the moment due to no paint override method implementation

package board;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.MouseInputAdapter;

public class whiteboard extends javax.swing.JFrame
{
    private int startX = -1;
    private int startY = -1;
    private BrushStyle activeStyle = BrushStyle.valueOf("RECTANGLE");
    private Color activeColor = Color.BLACK;
    private ArrayList<ColoredShape> shapes = new ArrayList<ColoredShape>();
    
    private enum BrushStyle
    {
        CIRCLE,
        RECTANGLE,
        LINE,
        ERASER
    };

    public whiteboard()
    {
        initComponents();
        jColorChooser.setColor(activeColor);
    }


    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new whiteboard().setVisible(true);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        RectangleBtn = new javax.swing.JButton();
        CircleBtn = new javax.swing.JButton();
        lineBtn = new javax.swing.JButton();
        jColorChooser = new javax.swing.JColorChooser();
        jPanel2 = new javax.swing.JPanel();
        lgrdBtn = new javax.swing.JRadioButton();
        mmrdBtn = new javax.swing.JRadioButton();
        smrdBtn = new javax.swing.JRadioButton();
        clearBtn = new javax.swing.JButton();
        selectionLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        WhitePanel = new WhitePanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Toolbar"));

        RectangleBtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        RectangleBtn.setText("Rectangle");
        RectangleBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                RectangleBtnActionPerformed(evt);
            }
        });

        CircleBtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        CircleBtn.setText("Circle");
        CircleBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                CircleBtnActionPerformed(evt);
            }
        });

        lineBtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lineBtn.setText("Line");
        lineBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                lineBtnActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Brush Size"));

        buttonGroup1.add(lgrdBtn);
        lgrdBtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lgrdBtn.setText("Large");

        buttonGroup1.add(mmrdBtn);
        mmrdBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        mmrdBtn.setText("Medium");

        buttonGroup1.add(smrdBtn);
        smrdBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        smrdBtn.setText("Small");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lgrdBtn)
                    .addComponent(smrdBtn)
                    .addComponent(mmrdBtn))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(smrdBtn)
                .addGap(18, 18, 18)
                .addComponent(mmrdBtn)
                .addGap(18, 18, 18)
                .addComponent(lgrdBtn)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        clearBtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        clearBtn.setForeground(new java.awt.Color(253, 8, 8));
        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                clearBtnActionPerformed(evt);
            }
        });

        selectionLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        selectionLabel.setText("Selection");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jColorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(clearBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lineBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CircleBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RectangleBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(RectangleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CircleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lineBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jColorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Distributed Whiteboard");

        WhitePanel.setBackground(new java.awt.Color(255, 255, 255));
        WhitePanel.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        WhitePanel.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                WhitePanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt)
            {
                WhitePanelMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout WhitePanelLayout = new javax.swing.GroupLayout(WhitePanel);
        WhitePanel.setLayout(WhitePanelLayout);
        WhitePanelLayout.setHorizontalGroup(
            WhitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 939, Short.MAX_VALUE)
        );
        WhitePanelLayout.setVerticalGroup(
            WhitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(WhitePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(WhitePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RectangleBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_RectangleBtnActionPerformed
    {//GEN-HEADEREND:event_RectangleBtnActionPerformed
        activeStyle = BrushStyle.valueOf(evt.getActionCommand().toUpperCase());
        String value = BrushStyle.valueOf(evt.getActionCommand().toUpperCase()).toString(); 
        selectionLabel.setText(value);
    }//GEN-LAST:event_RectangleBtnActionPerformed
    
    private void lineBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_lineBtnActionPerformed
    {//GEN-HEADEREND:event_lineBtnActionPerformed
        activeStyle = BrushStyle.valueOf(evt.getActionCommand().toUpperCase());
        String value = BrushStyle.valueOf(evt.getActionCommand().toUpperCase()).toString(); 
        selectionLabel.setText(value);
    }//GEN-LAST:event_lineBtnActionPerformed

    private void CircleBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_CircleBtnActionPerformed
    {//GEN-HEADEREND:event_CircleBtnActionPerformed
        activeStyle = BrushStyle.valueOf(evt.getActionCommand().toUpperCase());
        String value = BrushStyle.valueOf(evt.getActionCommand().toUpperCase()).toString(); 
        selectionLabel.setText(value);
          
    }//GEN-LAST:event_CircleBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_clearBtnActionPerformed
    {//GEN-HEADEREND:event_clearBtnActionPerformed
        selectionLabel.setText("Cleared");
        shapes = new ArrayList<ColoredShape>();
        WhitePanel.updateUI();
    }//GEN-LAST:event_clearBtnActionPerformed

    private void WhitePanelMousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_WhitePanelMousePressed
    {//GEN-HEADEREND:event_WhitePanelMousePressed
        //Color newColor = jColorChooser.getColor();
        startX = evt.getX();
        startY = evt.getY();
    
    }//GEN-LAST:event_WhitePanelMousePressed

    private void WhitePanelMouseReleased(java.awt.event.MouseEvent evt)//GEN-FIRST:event_WhitePanelMouseReleased
    {//GEN-HEADEREND:event_WhitePanelMouseReleased
        int finX = evt.getX();
        int finY = evt.getY();
        int topX = Math.min(startX, finX);
        int topY = Math.min(startY, finY);
        int rectWidth = Math.abs(startX - finX);
        int rectHeight = Math.abs(startY - finY);
        activeColor = jColorChooser.getColor();
        switch(activeStyle) {
            case CIRCLE:
                shapes.add(new ColoredShape(
                    new Ellipse2D.Double(topX, topY, rectWidth, rectHeight),
                    activeColor));
                break;

            case RECTANGLE:
                shapes.add(new ColoredShape(
                    new Rectangle2D.Double(topX, topY, rectWidth, rectHeight),
                    activeColor));
                break;
                
            case LINE:
                shapes.add(new ColoredShape(
                    new Line2D.Double(startX, startY, finX, finY),
                    activeColor));
                break;
        }
        repaint();
    }//GEN-LAST:event_WhitePanelMouseReleased

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CircleBtn;
    private javax.swing.JButton RectangleBtn;
    private WhitePanel WhitePanel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton clearBtn;
    private javax.swing.JColorChooser jColorChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton lgrdBtn;
    private javax.swing.JButton lineBtn;
    private javax.swing.JRadioButton mmrdBtn;
    private javax.swing.JLabel selectionLabel;
    private javax.swing.JRadioButton smrdBtn;
    // End of variables declaration//GEN-END:variables



    private class WhitePanel extends JPanel {
        
        public WhitePanel() 
        {
            super();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); //paints the background and image
            Graphics2D g2 = (Graphics2D) g;

            for (ColoredShape shape : shapes) {
                g2.setColor(shape.getColor());
                g2.draw(shape.getShape());
            }
        }
    } // end of WhitePanel class

    private class ColoredShape {
        Shape shape;
        Color color;

        public ColoredShape(Shape shape, Color color) {
            this.shape = shape;
            this.color = color;
        }

        public Shape getShape() { return shape; };
        public Color getColor() { return color; };
    }
}