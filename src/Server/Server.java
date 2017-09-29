package Server;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server
{

    public static void main(String args[])
    {

        //System.setSecurityManager(new SecurityManager());
        try
        {
            System.setProperty("java.rmi.server.hostname", "localhost");
            RemoteShapeList shapeList = new RemoteShapeListServant();
            //Registry registry = LocateRegistry.getRegistry();
            Registry registry = LocateRegistry.createRegistry(6000);
            registry.bind("shapeList", shapeList);
            System.out.println("server ready");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        // https://stackoverflow.com/questions/15685686/java-rmi-connectexception-connection-refused-to-host-127-0-1-1
    }
}
