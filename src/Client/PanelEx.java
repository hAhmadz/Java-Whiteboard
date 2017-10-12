package Client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Stack;

import Misc.ColoredShape;

/**
 * Since DrawingPanel cannot extend UnicastRemoteObject (it already extends a
 * class), this class handles the RMI side of things which DrawingPanel would
 * have used.
 */
public class PanelEx extends UnicastRemoteObject implements PanelExInt
{

    /**
     * The drawingPanel which this object will be connected to.
     */
    private DrawingPanel drawPan;

    protected PanelEx() throws RemoteException
    {
        super();

    }

    /**
     * Updates the DrawingPanel's list fo shapes.
     */
    @Override
    public void updatePanel(Stack<ColoredShape> shapes) throws RemoteException
    {
        drawPan.update(shapes);
    }

    /**
     * Sets the drawPan.
     */
    public void setDrawPan(DrawingPanel drawPan)
    {
        this.drawPan = drawPan;
    }

}
