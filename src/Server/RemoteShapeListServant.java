package Server;

/**The Subject for the observers
 * The skeleton/servant for the RMI server
 * 
 * */

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Misc.ColoredShape;

public class RemoteShapeListServant extends UnicastRemoteObject implements RemoteShapeList{

	private ArrayList<ColoredShape> shapes = new ArrayList<ColoredShape>();
	
	public RemoteShapeListServant() throws RemoteException {
		super();
		
	}

	@Override
	public void addColoredShape(ColoredShape shape) {
		shapes.add(shape);		
	}

	@Override
	public void clear() {
		shapes = new ArrayList<ColoredShape>();
		
	}

	@Override
	public ArrayList<ColoredShape> getShapes() {
		// TODO Auto-generated method stub
		return shapes;
	}

}
