/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg5_expressions;

import java.util.Map;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class Add extends DoubleArgsExpression{

    public Add(Expression arg1, Expression arg2) {
        super(arg1, arg2);
    }

    @Override
    public double eval(Map<String, Double> store) {
        return super.getArg1().eval(store) + super.getArg2().eval(store);
    }

    @Override
    public Expression optimize() {
        // if both are const eval the expression
        if(super.getArg1().isConstant() && super.getArg2().isConstant())
            return new Constant(this.eval(null));
        // if arg1 is constant and equal to 0, return arg2
        if(super.getArg1().isConstant() && super.getArg1().eval(null) == 0)
            return super.getArg2();
        // if arg2 is constant and equal to 0, return arg1
        if(super.getArg2().isConstant() && super.getArg2().eval(null) == 0)
            return super.getArg1();
        // if there is no way to reduce it, return the expression itself with optimized args
        return new Add(super.getArg1().optimize(), super.getArg2().optimize()).optimize();
    }

    @Override
    public String toString() {
        return String.format("(%s + %s)", super.getArg1().toString(), super.getArg2().toString());
    }
    
}
