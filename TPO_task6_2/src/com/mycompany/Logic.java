package com.mycompany;

import java.math.BigInteger;

public final class Logic {


    public Model add(LogicCall call) {

        if (!call.validate()) {
            return null;
        }
        BigInteger result = call.getOperand1().add(call.getOperand2());
        return new Model(result);
    }

}
