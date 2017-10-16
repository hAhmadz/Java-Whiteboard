package Client;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Stack;

import Misc.ColoredShape;
import java.util.Vector;

public interface PanelExInt extends Remote
{
    void updatePanel(Stack<ColoredShape> shapes) throws RemoteException;
    void updateChatPanel(Vector<PanelExInt> drawClients) throws RemoteException;
}
