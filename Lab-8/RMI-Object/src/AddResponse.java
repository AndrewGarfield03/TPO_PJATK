import java.io.Serializable;
import java.math.BigInteger;

public final class AddResponse implements Serializable {
    public final Sum sum;
    public AddResponse(Sum sum) {
        this.sum = sum;
    }
}
