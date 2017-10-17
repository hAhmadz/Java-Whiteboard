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

import Client.ClientEx;
import Client.ClientExInt;

public class RemoteShapeListServant extends UnicastRemoteObject implements RemoteShapeList
{
    

    private Vector<ClientExInt> clients = new Vector<ClientExInt>();
    private Stack<ColoredShape> shapes = new Stack<ColoredShape>();
    private Stack<ColoredShape> tempShapes = new Stack<ColoredShape>();
    private ArrayList<String> messages = new ArrayList<String>();

    public RemoteShapeListServant(int port) throws RemoteException
    {
        super(port);
    }

    @Override
    public void addColoredShape(ColoredShape shape) throws RemoteException
    {
        shapes.push(shape);
        publish();
        tempShapes.clear();
    }

    @Override
    public void clear() throws RemoteException
    {
        tempShapes.clear();
        while (!shapes.isEmpty())
        {
            tempShapes.push(shapes.pop());
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
        if (!shapes.isEmpty())
        {
            ColoredShape temp = shapes.pop();
            if (tempShapes.size() > 20)
            {
                tempShapes.remove(0);
            }
            tempShapes.push(temp);
        }
        publish();
    }

    @Override
    public synchronized void redoDrawing() throws RemoteException
    {
        if (!tempShapes.isEmpty())
        {
            shapes.push(tempShapes.pop());
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
     * adds the client to a list of subscribers
     */
    public boolean subscribe(ClientExInt clientEx) throws RemoteException
    {
        clients.add(clientEx);
        clientEx.updatePanel(shapes);
        clientEx.updateChat(messages);

        System.out.println("client added");
        //clientEx.updateClientList(clients);
        publishClientList();
        
        //TODO: When client connects up, need to update everyone's local list of clients
        //publishNames
        //calls an updateClientList on each client, passing clients as a param
        // clientWhite reads each client's drawpan to get name and prints name to Whiteboard's Jlist ClientList

        return true;
    }

    public boolean unsubscribe(String username) throws RemoteException
    {
        Vector<ClientExInt> removals = new Vector<ClientExInt>();
        
        try
        {
            for (ClientExInt client : clients)
            {
                if (client.getName().equals(username))
                    removals.add(client);
            }

            for (ClientExInt removal : removals)
            {
                removal.kick();
            }
        }
        catch (Exception e) { }
        finally
        {
            clients.removeAll(removals);

            System.out.println("client removed");
            publishClientList();

            return true;
        }
    }

    /**
     * Updates the clients with shapelist changes.
     */
    public void publish() throws RemoteException
    {

        for (int i = 0; i < clients.size(); i++)
        {
            try
            {
                ClientExInt tmp = (ClientExInt) clients.get(i);
                tmp.updatePanel(shapes);
            }
            catch (Exception e)
            {
                //problem with the client not connected; so remove it               
                clients.remove(i);

            }
        }
    }

    
    /**
     * Updates the clients with chat changes.
     */
    public void publishChat() throws RemoteException
    {

        for (int i = 0; i < clients.size(); i++)
        {
            try
            {
                ClientExInt tmp = (ClientExInt) clients.get(i);
                tmp.updateChat(messages);
            }
            catch (Exception e)
            {
                //problem with the client not connected; so remove it               
                clients.remove(i);

            }
        }
    }
    
    
    /**
     * Updates the clients with clientList changes.
     */
    public void publishClientList() throws RemoteException
    {

        for (int i = 0; i < clients.size(); i++)
        {
            try
            {
                ClientExInt tmp = (ClientExInt) clients.get(i);
                tmp.updateClientList(clients);
            }
            catch (Exception e)
            {
                //problem with the client not connected; so remove it               
                clients.remove(i);

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

