package com.mycompany;

import java.math.BigInteger;

public class Model {
    private BigInteger _result;


    public Model(BigInteger result) {
        this._result = result;
    }

    public BigInteger getResult() {
        return this._result;
    }
}
