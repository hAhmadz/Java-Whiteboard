package Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import Misc.ColoredShape;
import java.io.File;
import java.io.IOException;
import java.io.*;
import java.util.Stack;
import java.util.Vector;

import Client.MessagingInt;
import Client.PanelExInt;

public class RemoteShapeListServant extends UnicastRemoteObject implements RemoteShapeList
{
    /**
     * Contains a list of all the DrawingPanels clients
     */
    private Vector<PanelExInt> drawClients = new Vector<PanelExInt>();
    /**
     * Contains a list of all the Messaging clients
     */
    private Vector<MessagingInt> chatClients = new Vector<MessagingInt>();
    private Stack<ColoredShape> shapes = new Stack<ColoredShape>();
    private Stack<ColoredShape> tempShapes = new Stack<ColoredShape>();
    private ArrayList<String> messages = new ArrayList<String>();
    private Stack<ColoredShape> undoClear = new Stack<ColoredShape>();
    private boolean undoClearStatus = false;

    public RemoteShapeListServant() throws RemoteException
    {
        super();
    }

    @Override
    public void addColoredShape(ColoredShape shape) throws RemoteException
    {
        shapes.push(shape);
        publish();
        tempShapes.clear();
        undoClear.clear();
        undoClearStatus = false;
    }

    @Override
    public void clear() throws RemoteException
    {
        tempShapes.clear();
        undoClearStatus = true;
        while (!shapes.isEmpty())
        {
        	undoClear.push(shapes.pop());
        }
        publish();
    }

    @Override
    public void newDiagram() throws RemoteException
    {
        shapes.clear();
        publish();
        tempShapes.clear();
    }

    @Override
    public synchronized void undoDrawing() throws RemoteException
    {
        if (!shapes.isEmpty() && undoClearStatus == false)
        {
            ColoredShape temp = shapes.pop();
            if (tempShapes.size() > 20)
            {
                tempShapes.remove(0);
            }
            tempShapes.push(temp);
        } else if(!undoClear.isEmpty() && undoClearStatus == true) {
        	shapes.push(undoClear.pop());
        }
        publish();
    }

    @Override
    public synchronized void redoDrawing() throws RemoteException
    {
        if (!tempShapes.isEmpty() && undoClearStatus == false)
        {
            shapes.push(tempShapes.pop());
        } else if (!shapes.isEmpty() && undoClearStatus == true) {
        	undoClear.push(shapes.pop());
        }
        publish();
    }

    @Override
    public void saveDrawing(String filename)
    {
        try
        {
            ObjectOutputStream shapesWriter
                    = new ObjectOutputStream(new FileOutputStream(filename));
            shapesWriter.writeObject(shapes);
            shapesWriter.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Problem writing to " + filename);
        }
        catch (IOException e)
        {
            System.out.println("Problem writing file");
        }
    }

    @Override
    public void openDrawing(String filename) throws RemoteException
    {
        Stack<ColoredShape> temp = new Stack<ColoredShape>();
        try
        {
            File file = new File(filename);
            if (file.exists())
            {
                ObjectInputStream shapesReader
                        = new ObjectInputStream(new FileInputStream(file));

                temp = (Stack<ColoredShape>) shapesReader.readObject();
                shapesReader.close();
            }

        }
        catch (FileNotFoundException e)
        {
            System.out.println("Problem reading from " + filename);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Problem reading file.");
        }
        catch (IOException e)
        {
            System.out.println("Problem reading file.");
        }

        this.shapes = temp;
        publish();
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

    @Override
    public ArrayList<String> getMsgs() throws RemoteException
    {
        return messages;
    }
    
    /**
     * adds the client to a list of chat subscribers
     */
    public boolean subscribeChat(MessagingInt chatClient) throws RemoteException
    {
        chatClients.add(chatClient);
        chatClient.updateChat(messages);
        System.out.println("client added");
        return true;
    }
    

    /**
     * adds the client to a list of subscribers
     */
    public boolean subscribe(PanelExInt drawClient) throws RemoteException
    {
        drawClients.add(drawClient);
        drawClient.updatePanel(shapes);
        System.out.println("client added");
        drawClient.updateChatPanel(drawClients);
        return true;
    }

    /**
     * Updates the clients with shapelist changes.
     */
    public void publish() throws RemoteException
    {

        for (int i = 0; i < drawClients.size(); i++)
        {
            try
            {
                PanelExInt tmp = (PanelExInt) drawClients.get(i);
                tmp.updatePanel(shapes);
            }
            catch (Exception e)
            {
                //problem with the client not connected; so remove it		    	
                drawClients.remove(i);

            }
        }
    }

    
    /**
     * Updates the clients with chat changes.
     */
    public void publishChat() throws RemoteException
    {

        for (int i = 0; i < chatClients.size(); i++)
        {
            try
            {
                MessagingInt tmp = (MessagingInt) chatClients.get(i);
                tmp.updateChat(messages);
            }
            catch (Exception e)
            {
                //problem with the client not connected; so remove it		    	
                chatClients.remove(i);

            }
        }
    }
    
    
    /**
     * Adds a message to the list of messages
     * @throws RemoteException 
     * */
    public void addMessage(String message) throws RemoteException{
    	messages.add(message);
    	publishChat();
    }
}
