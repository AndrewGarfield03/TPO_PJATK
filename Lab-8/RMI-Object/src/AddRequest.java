import java.io.Serializable;
import java.math.BigInteger;

public final class AddRequest implements Serializable {

    public final Sum sum;
    public AddRequest(Sum sum) {
        this.sum = sum;
    }
}
