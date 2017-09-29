package Server;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import Misc.ColoredShape;

public interface RemoteShapeList extends Remote
{

    //ArrayList<ColoredShape> shapes = new ArrayList<ColoredShape>();
    public void addColoredShape(ColoredShape shape) throws RemoteException;
    //public void update();
    public void clear() throws RemoteException;
    public ArrayList<ColoredShape> getShapes() throws RemoteException;
}
