package Client;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import Misc.ColoredShape;
import Server.RemoteShapeList;

public class DrawingPanel extends JPanel
{
    private int startX = -1;
    private int startY = -1;
    private BrushStyle activeStyle = BrushStyle.valueOf("FREEHAND");
    private Color activeColor = Color.BLACK;
    private Color backgroundColor = Color.WHITE;
    private ColoredShape dragShape;
    //private ArrayList<ColoredShape> shapes = new ArrayList<ColoredShape>();
    RemoteShapeList shapes;

    private enum BrushStyle
    {
        FREEHAND,
        RECTANGLEHOLLOW,
        RECTANGLESOLID,
        CIRCLEHOLLOW,
        CIRCLESOLID,
        LINE,
        TEXT,
        ERASER
    };

    /**
     * No-argument constructor creates an instance of DrawingListener to handle
     * drawing related mouse events
     */
    public DrawingPanel()
    {
        DrawingListener listener = new DrawingListener();
        addMouseListener(listener);
        addMouseMotionListener(listener);

        try
        {
            // if(System.getSecurityManager() == null) {
            // 	   System.setSecurityManager(new SecurityManager());
            // }
            //LocateRegistry.getRegistry("localhost");
            //Registry registry = LocateRegistry.getRegistry(null); 
            Registry registry = LocateRegistry.getRegistry("localhost", 6000);
            shapes = (RemoteShapeList) registry.lookup("shapeList");

        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }

    // these co-ordinate getters and setters aren't necessary at the moment,
    // but might come in handy for when we're dealing with multiple clients.
    /**
     * return the starting x-coordinate of the most recently drawn shape
     */
    public int getStartX()
    {
        return startX;
    }

    public void setStartX(int x)
    {
        startX = x;
    }

    /**
     * return the starting y-coordinate of the most recently drawn shape
     */
    public int getStartY()
    {
        return startY;
    }

    public void setStartY(int y)
    {
        startY = y;
    }

    public void setActiveStyle(String style)
    {
        activeStyle = BrushStyle.valueOf(style.toUpperCase());
    }

    public void setActiveColor(Color color)
    {
        activeColor = color;
    }

    public void setBackgroundColor(Color color)
    {
        backgroundColor = color;
    }

    /**
     * Adds a colored shape object to the collection of drawn shapes.
     *
     * @param: the shape to be added.
     */
    public void addColoredShape(ColoredShape shape)
    {
        try
        {
            shapes.addColoredShape(shape);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
        //shapes.add(shape);
    }

    /**
     * Remove all currently drawn shapes from the drawn collection. Repaint the
     * drawing panel as well
     *
     */
    public void clear()
    {
        try
        {
            shapes.clear();
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g); //paints the background and image
        Graphics2D g2 = (Graphics2D) g;

        ArrayList<ColoredShape> shapeList = null;
        try
        {
            shapeList = shapes.getShapes();
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }

        for (ColoredShape shape : shapeList)
        {
            g2.setColor(shape.getColor());
            g2.draw(shape.getShape());
        }

        // display the shape as it is being dragged, before the mouse is released
        if (dragShape != null)
        {
            // activeColor??
            g2.setColor(dragShape.getColor());
            g2.draw(dragShape.getShape());
        }
    }

    /**
     * DrawingListener is a listener class to handle drawing related mouse
     * events
     *
     */
    private class DrawingListener extends MouseInputAdapter
    {
        public void mousePressed(MouseEvent e)
        {
            startX = e.getX();
            startY = e.getY();
        }

        public void mouseDragged(MouseEvent e)
        {
            int finX = e.getX();
            int finY = e.getY();
            int topX = Math.min(startX, finX);
            int topY = Math.min(startY, finY);
            int rectWidth = Math.abs(startX - finX);
            int rectHeight = Math.abs(startY - finY);

            switch (activeStyle)
            {
                // no break between eraser and freehand, because eraser is just implemented as 
                // a freehand drawing the same color as the background.
                case ERASER:
                    setActiveColor(backgroundColor);

                case FREEHAND:
                    dragShape = new ColoredShape(
                            new Line2D.Double(startX, startY, finX, finY),
                            activeColor);
                    addColoredShape(dragShape);
                    repaint();
                    startX = finX;
                    startY = finY;
                    break;

                case CIRCLEHOLLOW:
                    dragShape = new ColoredShape(
                            new Ellipse2D.Double(topX, topY, rectWidth, rectHeight),
                            activeColor);
                    break;
                    
                case CIRCLESOLID:
                    dragShape = new ColoredShape(
                            new Ellipse2D.Double(topX, topY, rectWidth, rectHeight),
                            activeColor);
                    break;

                case RECTANGLEHOLLOW:
                    dragShape = new ColoredShape(
                            new Rectangle2D.Double(topX, topY, rectWidth, rectHeight),
                            activeColor);
                    break;
                
                case RECTANGLESOLID:
                    dragShape = new ColoredShape(
                            new Rectangle2D.Double(topX, topY, rectWidth, rectHeight),
                            activeColor);
                    break;

                case LINE:
                    dragShape = new ColoredShape(
                            new Line2D.Double(startX, startY, finX, finY),
                            activeColor);
                    break;
                case TEXT:
                    //Text Implementation
                    break;
            }
            repaint();
        }

        public void mouseReleased(MouseEvent e)
        {
            if (dragShape != null)
            {
                // add the most recently dragged shape
                addColoredShape(dragShape.clone());
                dragShape = null;
            }
        }
    }
}
