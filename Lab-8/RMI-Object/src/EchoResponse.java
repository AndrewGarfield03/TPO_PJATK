import java.io.Serializable;

public final class EchoResponse implements Serializable {
    public final Message message;
    public EchoResponse(Message message) {
        this.message = message;
    }
}
