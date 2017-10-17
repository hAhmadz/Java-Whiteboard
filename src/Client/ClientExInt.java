package Client;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Stack;
import java.util.ArrayList;

import Misc.ColoredShape;
import java.util.Vector;

public interface ClientExInt extends Remote
{
    void updatePanel(Stack<ColoredShape> shapes) throws RemoteException;
    void updateClientList(Vector<ClientExInt> clients) throws RemoteException;
    void updateChat(ArrayList<String> messages) throws RemoteException;
    public String getName() throws RemoteException;
    public void kick() throws RemoteException;
}
}

