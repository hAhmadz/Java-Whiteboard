/**
 * Distributed Individuals
 *	David William Ripper	694807
 *	Haaris Nazir Ahmad 		869969
 *	Luis Jason Jacildo		907034
 *	Joshua James Clark		537660
 *
 * */

package Client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Stack;
import java.util.ArrayList;

import Misc.ColoredShape;
import java.util.Vector;

/**
 * Since DrawingPanel cannot extend UnicastRemoteObject (it already extends a
 * class), this class handles the RMI side of things which DrawingPanel would
 * have used.
 */
public class ClientEx extends UnicastRemoteObject implements ClientExInt
{

    /**
     * The drawingPanel which this object will be connected to.
     */
    private DrawingPanel drawPan;
    private Whiteboard gui;

    protected ClientEx() throws RemoteException
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

    @Override
    public void updateClientList(Vector<ClientExInt> clients) throws RemoteException
    {
        gui.updateClientList(clients);
    }
    
    
    /**
     * Sets the drawPan.
     */
    public void setDrawPan(DrawingPanel drawPan)
    {
        this.drawPan = drawPan;
    }


    @Override
    public void updateChat(ArrayList<String> messages) throws RemoteException {
        gui.updateChatHistory(messages);
    }

    public void setGui(Whiteboard gui) {
        this.gui = gui;
    }

    public Whiteboard getGui() 
    {
        return gui;
    }
    
    
    public String getName() throws RemoteException{
    	return gui.getUsername();
    }

    public void kick() throws RemoteException
    {
        gui.kick(); 
    }   
    

}
