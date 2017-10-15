//package Client;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

public interface MessagingInt  extends Remote{
	void updateChat(ArrayList<String> messages) throws RemoteException;
	
}
