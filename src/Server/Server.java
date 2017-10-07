/** What I've done/found out.
 * - tried setting up DrawingPanel et al like Haaris' sample code. Didn't work since
 * 		DrawingPanel needs to extend UnicastRemoteObject (can't since already extending a class. It could also use
 * 		UnicastRemoteObject.exportObject() but I couldn't get this to fully work.
 * 		- when setting a port with this, it would work for one client, but then lock out
 * 			the other client.
 * - Ergo, I decided to move registry from drawingPanel to clientWhiteboard and try it from
 * 	there... haven't had much success either.
 * - I believe, in effect, Haaris' sample code is trying to do the remote object on each side thing
 * 		- can't do this the way I was thinking to do it either since I can't extend UnicastremoteObject
 * 			(a second extended class)
 * 
 * I don't think we'll be able to get the above ways to work. So, other options. 
 * - create another class which extends UnicastRemoteObject and does what we wanted drawingPanel to
 * 		do with the remote link.
 * - Maybe use JMS (Java Messenging Service) instead * 
 * - as a backup, we can do Jason's way (it's not the most efficient, but it works which is the
 * 		key part). 
 * 
 *  */

package Server;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server
{
    public static void main(String args[])
    {
        try
        {
            System.setProperty("java.rmi.server.hostname", "localhost");
            RemoteShapeList shapeList = new RemoteShapeListServant();
            Registry registry = LocateRegistry.createRegistry(6000);
            registry.bind("shapeList", shapeList);
            System.out.println("server ready");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
