/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg5_expressions;

import java.util.Map;
import static pkg5_expressions.Constant.isConstant;
import static pkg5_expressions.Variable.isVariable;

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
        
        if(!this.isReducable())
            return this;
        
        // the first is constant
        if(isConstant(super.getArg1())){
            // both const - eval
            if(isConstant(super.getArg2()))
                return new Constant(this.eval(null));
            
            // if 0
            if(super.getArg1().eval(null) == 0)
                return super.getArg2().optimize();
            else 
                return new Add(super.getArg1(), super.getArg2().optimize()).optimize();
        }
        
        
         // the second is constant
        if(isConstant(super.getArg2())){
            // both const is already checked for
            
            // if 0
            if(super.getArg2().eval(null) == 0)
                return super.getArg1().optimize();
            else 
                return new Add(super.getArg1().optimize(), super.getArg2()).optimize();
        }
        
        
        return new Add(super.getArg1().optimize(), super.getArg2().optimize()).optimize();
        
        
    }
    
    /*
    @Override
    public Expression optimize() {
        
        if(isConstant(super.getArg1())){
            // both const - eval
            if(isConstant(super.getArg2()))
                return new Constant(this.eval(null));
            
            // second is variable
            if(isVariable(super.getArg2())){
                // if const=0, return variable, else return the expression
                if(super.getArg1().eval(null) == 0)
                    return super.getArg2();
                else
                    return this;
            }
                
            // second is a complex expression
            if(super.getArg1().eval(null) == 0)
                return super.getArg2().optimize();
            else
                return new Add(super.getArg1(), super.getArg2().optimize()).optimize();
        }
        
        
        if(isConstant(super.getArg2())){
            // both const - eval
            if(isConstant(super.getArg1()))
                return new Constant(this.eval(null));
            
            // second is variable
            if(isVariable(super.getArg1())){
                // if const=0, return variable, else return the expression
                if(super.getArg2().eval(null) == 0)
                    return super.getArg1();
                else
                    return this;
            }
                
            // second is a complex expression
            if(super.getArg2().eval(null) == 0)
                return super.getArg1().optimize();
            else
                return new Add(super.getArg1().optimize(), super.getArg2()).optimize();
        }
        
        return new Add(super.getArg1().optimize(), super.getArg2().optimize());
    }
    */
    @Override
    public boolean isReducable(){
        // An addition is reducable if any of its arguments are reducable or if it is composed of 2 constants
        return super.getArg1().isReducable() || super.getArg2().isReducable() || 
                (isConstant(super.getArg1()) && isConstant(super.getArg2()));
    }
    
    @Override
    public String toString() {
        return String.format("(%s + %s)", super.getArg1().toString(), super.getArg2().toString());
    }
    
}
