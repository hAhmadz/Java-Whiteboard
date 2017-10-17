package Server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.net.Inet4Address;

public class Server
{
    // arguments: <port>
    public static void main(String args[])
    {
        if (args.length != 1)
        {
            System.out.println("usage: Server <port>");
            System.exit(0);
        }

        try 
        {
            int port = Integer.parseInt(args[0]);
            
            String hostname = Inet4Address.getLocalHost().getHostAddress();
            System.setProperty("java.rmi.server.hostname", hostname);
            Registry registry = LocateRegistry.createRegistry(port);
            RemoteShapeList shapeList = new RemoteShapeListServant(port);
            registry.bind("shapeList", shapeList);
            System.out.println("server ready");
        }
        catch (NumberFormatException ex)
        {
            System.out.println("Port must be an integer in the range 0 to 65535");
            System.out.println("Server is quitting.");
            System.exit(1);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
