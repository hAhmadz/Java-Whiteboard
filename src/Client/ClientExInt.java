/**
 * Distributed Individuals
 *	David William Ripper	694807
 *	Haaris Nazir Ahmad 		869969
 *	Luis Jason Jacildo		907034
 *	Joshua James Clark		537660
 *
 * */

package Client;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Stack;
import java.util.ArrayList;

import Misc.ColoredShape;
import java.util.Vector;

/** Interface for ClientEx */
public interface ClientExInt extends Remote
{
    public void updatePanel(Stack<ColoredShape> shapes) throws RemoteException;
    public void updateClientList(Vector<ClientExInt> clients) throws RemoteException;
    public void updateChat(ArrayList<String> messages) throws RemoteException;
    public String getName() throws RemoteException;
    public void kick() throws RemoteException;
}


