/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg5_expressions;

import static pkg5_expressions.Constant.isConstant;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public abstract class DoubleArgsExpression extends Expression{
    
    private Expression arg1;
    private Expression arg2;
    
    protected DoubleArgsExpression(Expression arg1, Expression arg2) {
        super();
        this.arg1 = arg1;
        this.arg2 = arg2;
    }
    
    @Override
    public boolean isReducable(){
        // two args expression is reducable 
        // if any of its arguments are reducable or if it is composed of 2 constants
        return this.arg1.isReducable() || this.arg2.isReducable() || 
                (isConstant(this.arg1) && isConstant(this.arg2));
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
