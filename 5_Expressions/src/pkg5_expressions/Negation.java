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
public class Negation extends SingleArgExpression{

    public Negation(Expression arg) {
        super(arg);
    }

    @Override
    public double eval(Map<String, Double> store) {
        return - super.getArg().eval(store);
    }

    @Override
    public Expression optimize() {
        if(isConstant(super.getArg())) // if constant, return its negative
            return new Constant(-super.getArg().eval(null));
        else                            // else optimize its argument
            return new Negation(super.getArg().optimize());
    }

    @Override
    public String toString(){
        // if it's an expression without arguments print without brackets, else include brackets
        if(isConstant(super.getArg()) || isVariable(super.getArg()))
            return "-" + super.getArg().toString();
        else 
            return "(-" + super.getArg().toString()+")";
    }
    
}
