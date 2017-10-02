package Server;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import Misc.ColoredShape;

public interface RemoteShapeList extends Remote
{
    public void addColoredShape(ColoredShape shape) throws RemoteException;
    public void clear() throws RemoteException;
    public ArrayList<ColoredShape> getShapes() throws RemoteException;
    public void saveDrawing(String filename) throws RemoteException;
    public void openDrawing(String filename) throws RemoteException;
    public ArrayList<String> messageStream(String message) throws RemoteException;
}
