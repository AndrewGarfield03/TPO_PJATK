package com.mycompany;

import java.math.BigInteger;

public class LogicCall {
    private BigInteger _operand1;
    private BigInteger _operand2;

    public LogicCall(BigInteger operand1, BigInteger operand2) {
        this._operand1 = operand1;
        this._operand2 = operand2;
    }

    public boolean validate() {
        return this._operand1 != null && this._operand2 != null;
    }

    public BigInteger getOperand1() {
        return this._operand1;
    }

    public BigInteger getOperand2() {
        return this._operand2;
    }
}
