/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg5_expressions;

import java.util.Map;
import static pkg5_expressions.Constant.isConstant;

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
    public Expression optimize(){ 
        
        // the first is constant
        if(isConstant(super.getArg1())){
            // both const - eval
            if(isConstant(super.getArg2()))
                return new Constant(this.eval(null));
            
            // if 0
            if(super.getArg1().eval(null) == 0)
                return super.getArg2().optimize();
            else if(this.isReducable())
                return new Add(super.getArg1(), super.getArg2().optimize()).optimize();
            else
                return new Add(super.getArg1(), super.getArg2().optimize());
        }
         // the second is constant
        if(isConstant(super.getArg2())){
            // both const is already checked for
            // if 0
            if(super.getArg2().eval(null) == 0)
                return super.getArg1().optimize();
            else if(this.isReducable())
                return new Add(super.getArg1().optimize(), super.getArg2()).optimize();
            else
                return new Add(super.getArg1().optimize(), super.getArg2());
        }
        if(!this.isReducable())
            return this;
        // if nothing else, optimize the arugments and the expression on its way back
        return new Add(super.getArg1().optimize(), super.getArg2().optimize()).optimize();
    }
    
    @Override
    public String toString() {
        return String.format("(%s + %s)", super.getArg1().toString(), super.getArg2().toString());
    }
    
}
