package Client;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Stack;

import Misc.ColoredShape;

public interface PanelExInt extends Remote{

	void updatePanel(Stack<ColoredShape> shapes) throws RemoteException;

}
