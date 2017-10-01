package Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import Misc.ColoredShape;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class RemoteShapeListServant extends UnicastRemoteObject implements RemoteShapeList
{
    private ArrayList<ColoredShape> shapes = new ArrayList<ColoredShape>();
    private ArrayList<String> messages = new ArrayList<String>();

    public RemoteShapeListServant() throws RemoteException
    {
        super();
    }

    @Override
    public void addColoredShape(ColoredShape shape)
    {
        shapes.add(shape);
    }

    @Override
    public void clear()
    {
        shapes = new ArrayList<ColoredShape>();
    }

    @Override
    public ArrayList<ColoredShape> getShapes()
    {
        return shapes;
    }

    @Override
    public void saveDrawing()
    {
        //
    }

    @Override
    public void openDrawing()
    {
        //
    }

    @Override
    public synchronized ArrayList<String> messageStream(String newMessage)
    {
        if (!newMessage.equals("ClientJoined123"))
        {
            messages.add(newMessage);
        }

        return messages;
    }

}
