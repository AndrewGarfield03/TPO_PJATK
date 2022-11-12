import java.io.Serializable;

public final class EchoRequest implements Serializable {
    public final Message message;
    public EchoRequest(Message message) {
        this.message = message;
    }
}
