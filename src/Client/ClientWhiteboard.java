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
    private javax.swing.JButton circleBtn;
	private javax.swing.JButton rectangleBtn;
    //private javax.swing.JPanel WhitePanel;
    private javax.swing.ButtonGroup buttonGroup1;
	private DrawingPanel drawingPanel;
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

    public ClientWhiteboard()
    {
        initComponents(); // Auto generated for GUI.
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

       buttonGroup1 = new ButtonGroup();
       jPanel1 = new JPanel();
       rectangleBtn = new JButton();
       circleBtn = new JButton();
       lineBtn = new JButton();
       jColorChooser = new JColorChooser(Color.BLACK);
       jPanel2 = new JPanel();
       lgrdBtn = new JRadioButton();
       mmrdBtn = new JRadioButton();
       smrdBtn = new JRadioButton();
       clearBtn = new JButton();
       selectionLabel = new JLabel();
       jLabel1 = new JLabel();
       drawingPanel = new DrawingPanel();

       setDefaultCloseOperation(EXIT_ON_CLOSE);

       jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Toolbar"));


       rectangleBtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
       rectangleBtn.setText("Rectangle");
       rectangleBtn.addActionListener(new java.awt.event.ActionListener()
       {
           public void actionPerformed(java.awt.event.ActionEvent evt)
           {
               brushBtnActionPerformed(evt);
           }
       });

       circleBtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
       circleBtn.setText("Circle");
       circleBtn.addActionListener(new java.awt.event.ActionListener()
       {
           public void actionPerformed(java.awt.event.ActionEvent evt)
           {
               brushBtnActionPerformed(evt);
           }
       });

       lineBtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
       lineBtn.setText("Line");
       lineBtn.addActionListener(new java.awt.event.ActionListener()
       {
           public void actionPerformed(java.awt.event.ActionEvent evt)
           {
               brushBtnActionPerformed(evt);
           }
       });


       // send color selections to the drawing panel instance.
       ColorSelectionModel model = jColorChooser.getSelectionModel();
       ChangeListener changeListener = new ChangeListener() {
           public void stateChanged(ChangeEvent changeEvent) {
               drawingPanel.setActiveColor(jColorChooser.getColor());
           }
       };
       model.addChangeListener(changeListener);

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
                           .addComponent(circleBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                           .addComponent(rectangleBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
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
                       .addComponent(rectangleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addGap(18, 18, 18)
                       .addComponent(circleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
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

       drawingPanel.setBackground(Color.WHITE);
       drawingPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder());


       javax.swing.GroupLayout drawingPanelLayout = new javax.swing.GroupLayout(drawingPanel);
       drawingPanel.setLayout(drawingPanelLayout);
       drawingPanelLayout.setHorizontalGroup(
           drawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGap(0, 939, Short.MAX_VALUE)
       );
       drawingPanelLayout.setVerticalGroup(
           drawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                       .addComponent(drawingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                       .addComponent(drawingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
               .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
       );

       pack();
   }// </editor-fold>//GEN-END:initComponents

    private void brushBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_RectangleBtnActionPerformed
    {//GEN-HEADEREND:event_RectangleBtnActionPerformed
        String style = evt.getActionCommand();
        drawingPanel.setActiveStyle(style);
        selectionLabel.setText(style);
        drawingPanel.setActiveColor(jColorChooser.getColor());
    }//GEN-LAST:event_RectangleBtnActionPerformed


    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_clearBtnActionPerformed
    {//GEN-HEADEREND:event_clearBtnActionPerformed
        selectionLabel.setText("Cleared");
        drawingPanel.clear();
    }//GEN-LAST:event_clearBtnActionPerformed

}
