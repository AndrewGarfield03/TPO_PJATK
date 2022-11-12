import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public final class RemoteObject extends UnicastRemoteObject implements  IEcho, IAddition {
    public RemoteObject() throws RemoteException { }

    @Override
    public EchoResponse echo(EchoRequest request) throws RemoteException {
        return new EchoResponse(request.message);
    }

    @Override
    public AddResponse add(AddRequest request) throws RemoteException {
        return new AddResponse(request.sum);
    }
}
