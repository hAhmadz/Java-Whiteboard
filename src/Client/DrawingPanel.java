package Client;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import Misc.TextShape2D;
import Server.RemoteShapeList;

public class DrawingPanel extends JPanel
{
    private int startX = -1;
    private int startY = -1;
    private BrushStyle activeStyle = BrushStyle.valueOf("FREEHAND");
    private int activeWeight = 5;
    private Font defaultFont = new Font("TimesRoman", Font.PLAIN, 10);
    private Color activeColor = Color.BLACK;
    private Color backgroundColor = Color.WHITE;
    private ColoredShape dragShape;
    private TextShape2D typedText;
    RemoteShapeList shapes;
    DrawingListener drawing = new DrawingListener();
    TypingListener typing = new TypingListener();

    private enum BrushStyle
    {
        FREEHAND,
        RECTANGLEHOLLOW,
        RECTANGLEFILLED,
        CIRCLEHOLLOW,
        CIRCLEFILLED,
        LINE,
        TEXT,
        ERASER
    };

    /**
     * handles drawing related mouse events
     */
    public DrawingPanel()
    {
        addMouseListener(drawing);
        addMouseMotionListener(drawing);
        addKeyListener(typing);

        try
        {
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
    public int getStartX()
    {
        return startX;
    }

    public void setStartX(int x)
    {
        startX = x;
    }

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

    public void setActiveWeight(int weight)
    {
        activeWeight = weight;
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
    }

    public void saveDrawing(String filename)
    {
        try
        {
            shapes.saveDrawing(filename);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
    }

    public void openDrawing(String filename)
    {
        try
        {
            shapes.openDrawing(filename);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
        finally
        {
            repaint();
        }
    }

    public ArrayList<String> messageStream(String message)
    {
        ArrayList<String> OutputArr = new ArrayList<String>();
        if (!message.equals(""))
        {
            try
            {
                OutputArr = shapes.messageStream(message);
            }
            catch (RemoteException e)
            {
                e.printStackTrace();
            }
        }
        return OutputArr;
    }

    /**
     * Remove all currently drawn shapes from the drawn collection. Repaint the
     * drawing panel as well
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
            g2.setStroke(new BasicStroke(shape.getWeight()));
            g2.setFont(defaultFont.deriveFont(7.0f * shape.getWeight()));

            // check if the ColoredShape is text or a shape
            if (shape.getTextShape() != null) 
            {
                TextShape2D text = shape.getTextShape();
                g2.drawString(text.getText(), text.getX(), text.getY());
            }
            else // i.e. it is a SHAPE shape, not a text shape
            {
                if (shape.getFilled())
                    g2.fill(shape.getShape());
                else
                    g2.draw(shape.getShape());
            }
        }

        // display text as it is being typed
        if (typedText != null)
        {
            g2.setColor(activeColor);
            g2.setFont(defaultFont.deriveFont(7.0f * activeWeight));
            g2.drawString(typedText.getText(), typedText.getX(), typedText.getY());
        }

        // display the shape as it is being dragged, before the mouse is released
        if (dragShape != null)
        {
            g2.setColor(dragShape.getColor());
            g2.setStroke(new BasicStroke(dragShape.getWeight()));
            if (dragShape.getFilled())
                g2.fill(dragShape.getShape());
            else
                g2.draw(dragShape.getShape());

        }
    }

    private class TypingListener extends KeyAdapter
    {
        boolean active = false;
        public void keyTyped(KeyEvent e) 
        {
            if (active) 
            {
                Character c = e.getKeyChar();
                typedText.append(c.toString());
                repaint();
            }
        }

        public void keyPressed(KeyEvent e) 
        {
            if (active && e.getKeyCode() == KeyEvent.VK_ENTER) 
            {
                ColoredShape shape = new ColoredShape(typedText, activeColor, activeWeight);
                addColoredShape(shape.clone());
                typedText = null;
                active = false;
                repaint();
            }
        }

        public void setActive(boolean status)
        {
            this.active = status;
        }

    }

    /**
     * DrawingListener is a listener class to handle drawing related mouse
     * events
     */
    private class DrawingListener extends MouseInputAdapter
    {
        public void mousePressed(MouseEvent e)
        {
            requestFocusInWindow();
            startX = e.getX();
            startY = e.getY();
            if (typedText != null) 
            {
                ColoredShape shape = new ColoredShape(typedText, activeColor, activeWeight);
                addColoredShape(shape.clone());
            }
            if (activeStyle.equals(BrushStyle.valueOf("TEXT"))) 
            {
                typing.setActive(true);
                typedText = new TextShape2D("", startX, startY);
            }

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
                            activeColor,
                            activeWeight);
                    addColoredShape(dragShape);
                    repaint();
                    startX = finX;
                    startY = finY;
                    break;

                case CIRCLEHOLLOW:
                    dragShape = new ColoredShape(
                            new Ellipse2D.Double(topX, topY, rectWidth, rectHeight),
                            activeColor,
                            activeWeight);
                    break;

                case CIRCLEFILLED:
                    dragShape = new ColoredShape(
                            // set shape
                            new Ellipse2D.Double(topX, topY, rectWidth, rectHeight),
                            // set color
                            activeColor,
                            // set weight
                            activeWeight,
                            //set fill
                            true);
                    break;

                case RECTANGLEHOLLOW:
                    dragShape = new ColoredShape(
                            new Rectangle2D.Double(topX, topY, rectWidth, rectHeight),
                            activeColor,
                            activeWeight);
                    break;

                case RECTANGLEFILLED:
                    dragShape = new ColoredShape(
                            // set shape
                            new Rectangle2D.Double(topX, topY, rectWidth, rectHeight),
                            // set color
                            activeColor,
                            // set weight
                            activeWeight,
                            // set fill
                            true);
                    break;

                case LINE:
                    dragShape = new ColoredShape(
                            new Line2D.Double(startX, startY, finX, finY),
                            activeColor,
                            activeWeight);
                    break;
            }
            repaint();
        }

        public void mouseReleased(MouseEvent e)
        {
            if (dragShape != null)
            {
                addColoredShape(dragShape.clone());
                dragShape = null;
            }
        }
    }
}
