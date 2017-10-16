package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import Misc.ColoredShape;
import Client.ClientEx;

public interface RemoteShapeList extends Remote
{
    public void addColoredShape(ColoredShape shape) throws RemoteException;

    public void clear() throws RemoteException;

    public void newDiagram() throws RemoteException;

    public void undoDrawing() throws RemoteException;

    public void redoDrawing() throws RemoteException;

    public void saveDrawing(String filename) throws RemoteException;

    public void openDrawing(String filename) throws RemoteException;

    public ArrayList<String> messageStream(String message) throws RemoteException;

    public ArrayList<String> getMsgs() throws RemoteException;
    
    public boolean subscribe(ClientExInt clientEx) throws RemoteException;
    
    // public boolean subscribeChat(MessagingInt chatClient) throws RemoteException;
    
    public void publishChat() throws RemoteException;
    
    public void addMessage(String message) throws RemoteException;
    
}
