package Misc;
import java.io.Serializable;

public class TextShape2D implements Serializable
{
    String text = "";
    int x;
    int y;
    
    public TextShape2D(String text, int x, int y)
    {
        this.text = text;
        this.x = x;
        this.y = y;
    }

    public String getText()
    {
        return text;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void append(String str)
    {
        text = text + str;
    }
}
