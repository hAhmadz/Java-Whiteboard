package Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import Misc.ColoredShape;
import java.io.File;
import java.io.IOException;
import java.io.*;
import java.util.Stack;

public class RemoteShapeListServant extends UnicastRemoteObject implements RemoteShapeList
{
    private Stack<ColoredShape> shapes = new Stack<ColoredShape>();
    private Stack<ColoredShape> tempShapes = new Stack<ColoredShape>();
    private ArrayList<String> messages = new ArrayList<String>();

    public RemoteShapeListServant() throws RemoteException
    {
        super();
    }

    @Override
    public void addColoredShape(ColoredShape shape)
    {
        shapes.push(shape);
    }

    @Override
    public void clear()
    {
        shapes.clear();
        tempShapes.clear();
    }

    @Override
    public Stack<ColoredShape> getShapes()
    {
        return shapes;
    }
    
    @Override
    public synchronized void undoDrawing()
    {
        if(!shapes.isEmpty())
        {
            ColoredShape temp = shapes.pop();
            if(tempShapes.size()>20)
                tempShapes.remove(0);
            tempShapes.push(temp);
        }
    }
    
    @Override
    public synchronized void redoDrawing()
    {
        if(!tempShapes.isEmpty())
            shapes.push(tempShapes.pop());
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
        Stack<ColoredShape> temp = new Stack<ColoredShape>();
        try 
        {
            File file = new File(filename);
            if (file.exists()) {
                ObjectInputStream shapesReader =
                    new ObjectInputStream(new FileInputStream(file));
        
                temp = (Stack<ColoredShape>) shapesReader.readObject();
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
