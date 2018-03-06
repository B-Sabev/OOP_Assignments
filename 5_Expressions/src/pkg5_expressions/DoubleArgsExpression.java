/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg5_expressions;

/**
 *
 * @author Borislav
 */
public abstract class DoubleArgsExpression extends Expression{
    
    private Expression arg1;
    private Expression arg2;

    public DoubleArgsExpression(Expression arg1, Expression arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    public Expression getArg1() {
        return arg1;
    }

    public void setArg1(Expression arg1) {
        this.arg1 = arg1;
    }

    public Expression getArg2() {
        return arg2;
    }

    public void setArg2(Expression arg2) {
        this.arg2 = arg2;
    }
}
