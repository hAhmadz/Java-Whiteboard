/**
 * Distributed Individuals
 *	David William Ripper	694807
 *	Haaris Nazir Ahmad 		869969
 *	Luis Jason Jacildo		907034
 *	Joshua James Clark		537660
 *
 * */

package Misc;

import java.awt.Color;
import java.awt.Shape;
import java.io.Serializable;

/** The shape which will be printed on the Whiteboard. */
public class ColoredShape implements Cloneable, Serializable
{
    private Shape shape = null;
    // text for a text object (so that drawn shapes and drawn text can both live in the ArrayList)
    private TextShape2D text = null;
    private Color color;
    private int weight;
    // default for fill is false
    private boolean filled = false;
    

    /** constructor for a SHAPE to be drawn */
    // text is null
    public ColoredShape(Shape shape, Color color, int weight)
    {
        this.shape = shape;
        this.color = color;
        this.weight = weight;
    }

    /** constructor for a STRING to be drawn */
    // shape is null
    public ColoredShape(TextShape2D text, Color color, int weight)
    {
        this.text = text;
        this.color = color;
        this.weight = weight;
    }

    /** Four argument constructor to specify fill value for the SHAPE. */
    // text is null
    public ColoredShape(Shape shape, Color color, int weight, boolean filled)
    {
        this.shape = shape;
        this.color = color;
        this.weight = weight;
        this.filled = filled;
    }

    /** Copy constructor for clone */
    public ColoredShape(ColoredShape other)
    {
        this.shape = other.getShape();
        this.text = other.getTextShape();
        this.color = other.getColor();
        this.weight = other.getWeight();
        this.filled = other.getFilled();
    }

    public Shape getShape()
    {
        return shape;
    }

    public TextShape2D getTextShape()
    {
        return text;
    }

    public Color getColor()
    {
        return color;
    }

    public int getWeight()
    {
        return weight;
    }

    public boolean getFilled()
    {
        return filled;
    }

    public ColoredShape clone()
    {
        ColoredShape clone = new ColoredShape(this);
        return clone;
    }
}
