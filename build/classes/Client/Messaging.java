package Client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Vector;

public class Messaging extends UnicastRemoteObject implements MessagingInt{

	/**
     * The drawingPanel which this object will be connected to.
     */
    private ClientWhiteboard gui;
	
	protected Messaging() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateChat(ArrayList<String> messages) throws RemoteException {
		// TODO Auto-generated method stub
		gui.updateChatHistory(messages);
	}

	public void setGui(ClientWhiteboard gui) {
		this.gui = gui;
	}

}
