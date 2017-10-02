package Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import Misc.ColoredShape;
import java.io.File;
import java.io.IOException;
import java.io.*;

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
    public void saveDrawing(String filename)
    {
        try 
        {
            ObjectOutputStream shapesWriter =
                new ObjectOutputStream(new FileOutputStream(filename));
            shapesWriter.writeObject(shapes);
            shapesWriter.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Problem writing to " + filename);
        }
        catch(IOException e)
        {
            System.out.println("Problem writing file");
        }
    }

    @Override
    public void openDrawing(String filename)
    {
        ArrayList<ColoredShape> temp = new ArrayList<ColoredShape>();
        try 
        {
            File file = new File(filename);
            if (file.exists()) {
                ObjectInputStream shapesReader =
                    new ObjectInputStream(new FileInputStream(file));
        
                temp = (ArrayList<ColoredShape>) shapesReader.readObject();
                shapesReader.close();
            }
            
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Problem reading from " + filename);
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Problem reading file.");
        }
        catch(IOException e)
        {
            System.out.println("Problem reading file.");
        }

        this.shapes = temp;
    }
    

    @Override
    public synchronized ArrayList<String> messageStream(String newMessage)
    {
        if (!newMessage.equals("ClientJoined123"))
            messages.add(newMessage);
        return messages;
    }

}
