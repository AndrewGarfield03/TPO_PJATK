package Project7;

import java.math.BigInteger;

public class Logic {
    public Model Add(Call Lcall)
    {
        if(Lcall.IsCorrect())
        {
            BigInteger Sum=Lcall._First.add(Lcall._Second);
            return new Model(Sum);
        }
return null;
    }
}
