package Project7;

import java.math.BigInteger;

public class Call {
    BigInteger _First;
    BigInteger _Second;
    public Call(BigInteger F, BigInteger S)
    {
        _First=F;
        _Second=S;
    }
    public boolean IsCorrect()
    {
        if(_First==null||_Second==null)
        {
            return false;
        }
        else {
            return true;
        }
    }
}
