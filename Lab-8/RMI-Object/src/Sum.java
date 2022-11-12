import java.io.Serializable;
import java.math.BigInteger;

public final class Sum implements Serializable {
    public BigInteger getSumValue() {
        return this.sumValue;
    }

    public final BigInteger sumValue;
    public final BigInteger parameter1;

    public BigInteger getParameter1() {
        return this.parameter1;
    }

    public BigInteger getParameter2() {
        return this.parameter2;
    }

    public final BigInteger parameter2;
    private static BigInteger sumTwoValues(BigInteger parameter1, BigInteger parameter2) {
        if (parameter1 != null && parameter2 != null) {
            return parameter1.add(parameter2);
        }
        if (parameter1 != null) {
            return parameter1;
        }
        if (parameter2 != null) {
            return parameter2;
        }
        return null;
    }

    public Sum(BigInteger parameter1, BigInteger parameter2) {
        this.parameter1 = parameter1;
        this.parameter2 = parameter2;
        this.sumValue = sumTwoValues(parameter1, parameter2);
    }
}
