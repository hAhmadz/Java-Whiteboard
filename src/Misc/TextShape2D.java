/**
 * Distributed Individuals
 *	David William Ripper	694807
 *	Haaris Nazir Ahmad 		869969
 *	Luis Jason Jacildo		907034
 *	Joshua James Clark		537660
 *
 * */

package Misc;
import java.io.Serializable;


/** A 2D shape version of text. */
public class TextShape2D implements Serializable
{
    private String text = "";
    private int x;
    private int y;
    
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

    public void backspace()
    {
        int len = text.length();
        if (len > 0)
            text = text.substring(0, len-1);
    }
}
