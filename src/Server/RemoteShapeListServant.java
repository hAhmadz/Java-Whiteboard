package Server;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import Misc.ColoredShape;

public class RemoteShapeListServant extends UnicastRemoteObject implements RemoteShapeList
{
    private ArrayList<ColoredShape> shapes = new ArrayList<ColoredShape>();
    private ArrayList<String> messages = new ArrayList<String>();
    public RemoteShapeListServant() throws RemoteException
    {
        super();
    }

    @Override
    public void addColoredShape(ColoredShape shape)
    {
        shapes.add(shape);
    }

    @Override
    public void clear()
    {
        shapes = new ArrayList<ColoredShape>();
    }

    @Override
    public ArrayList<ColoredShape> getShapes()
    {
        return shapes;
    }
    
    @Override
    public void saveDrawing()
    {
        //
    }
    
    @Override
    public void openDrawing()
    {
        //
    }
    
    @Override
    public ArrayList<String> messageStream(String newMessage)
    {
        messages.add(newMessage);
        return messages;
    }
    
}
