package Misc;

import java.awt.Color;
import java.awt.Shape;
import java.io.Serializable;


public class ColoredShape implements Cloneable, Serializable {
    Shape shape;
    Color color;

    public ColoredShape(Shape shape, Color color) {
        this.shape = shape;
        this.color = color;
    }

    public Shape getShape() {
        return shape;
    }

    public Color getColor() {
        return color;
    }

    public ColoredShape clone() {
    	ColoredShape clone = new ColoredShape(this.getShape(), this.getColor());
    	return clone;
    }
}

