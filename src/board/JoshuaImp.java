package board;
/**
 * Very limited whiteboard implementation, as a starting point.
 * Limited functionality: draw rectangle, ellipse and line.
 * Inefficient at the moment as
 *
 * TO DO:
 * Drawn shapes cannot be selected/manipulated
 * colour cannot be picked.
 * File I/O
 *
 * @author: Joshua Clark
 * modified: 18th September 2017
 */



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;

public class whiteboard extends JFrame { //implements MouseListener { //, MouseMotionListener {
	private int startX = -1;
	private int startY = -1;
	public static final int WIDTH = 900;
    public static final int HEIGHT = 500;
	private ArrayList<Rectangle2D> rects = new ArrayList<Rectangle2D>();
    private ArrayList<Ellipse2D> circs = new ArrayList<Ellipse2D>();
    private ArrayList<Line2D> lines = new ArrayList<Line2D>();
	
    private enum BrushStyle {
        ELLIPSE,
        RECTANGLE,
        LINE,
        ERASER
    };

    private BrushStyle activeStyle = BrushStyle.valueOf("ELLIPSE");

    public static void main(String[] args) {
    	whiteboard wb = new whiteboard();
    }


	public whiteboard() {
		super("whiteboard");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        BrushPanel brushes = new BrushPanel();
        add(brushes, BorderLayout.WEST);
        CanvasPanel canvas = new CanvasPanel();
        add(canvas, BorderLayout.CENTER);
		
        setVisible(true);
	}


    
    /**
     * Panel for selecting brushes.
     *
     */
    private class BrushPanel extends JPanel implements ActionListener {
        public BrushPanel() {
            setSize(100,200);
            setLayout(new GridLayout(10,1));

            //ELLIPSE
            JButton circButton = new JButton("Ellipse");
            circButton.addActionListener(this);
            add(circButton);
            //RECTANGLE
            JButton rectButton = new JButton("Rectangle");
            rectButton.addActionListener(this);
            add(rectButton);
            //LINE
            JButton lineButton = new JButton("Line");
            lineButton.addActionListener(this);
            add(lineButton);
            //FREEHAND
                // TO DO

            //ERASER
                // TO DO
        }

        public void actionPerformed(ActionEvent e) {
            activeStyle = BrushStyle.valueOf(e.getActionCommand().toUpperCase());
        }
    } // end of BrushPanel class


    /**
     * Panel which acts as the drawing surface for a single client whiteboard.
     *
     */
    private class CanvasPanel extends JPanel implements MouseListener {
        public CanvasPanel() {
            setSize(800,500);
            setBackground(Color.WHITE);
            addMouseListener(this);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); //paints the background and image
            Graphics2D g2 = (Graphics2D) g;

            for (Rectangle2D rect : rects)
                g2.draw(rect);
            for (Ellipse2D circ : circs)
                g2.draw(circ);
            for (Line2D line : lines)
                g2.draw(line);
        }

        public void mousePressed(MouseEvent e) {
            startX = e.getX();
            startY = e.getY();
            System.out.println("Mouse pressed: (" + startX + ", " + startY + ")");
        }
    
        public void mouseReleased(MouseEvent e) {
            int finX = e.getX();
            int finY = e.getY();
            int topX = Math.min(startX, finX);
            int topY = Math.min(startY, finY);
            int rectWidth = Math.abs(startX-finX);
            int rectHeight = Math.abs(startY-finY);
            System.out.println("Mouse released: (" + finX + ", " + finY + ")");

            //switch on active brush
            switch(activeStyle) {
                case ELLIPSE:
                    circs.add(new Ellipse2D.Double(topX, topY, rectWidth, rectHeight));
                    break;

                case RECTANGLE:
                    rects.add(new Rectangle2D.Double(topX, topY, rectWidth, rectHeight));
                    break;
                    
                case LINE:
                    lines.add(new Line2D.Double(startX, startY, finX, finY));
                    break;
            }

            repaint();
        }
    
        public void mouseEntered(MouseEvent e) {
            
        }
    
        public void mouseExited(MouseEvent e) {
            
        }
        
        public void mouseClicked(MouseEvent e) {
            
        }
    } // end of CanvasPanel class

}

