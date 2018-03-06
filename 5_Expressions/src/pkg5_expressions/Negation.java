/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg5_expressions;

import java.util.Map;
import pkg5_expressions.NoArgsExpression;
/**
 *
 * @author Borislav
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString(){
        // if it is a NoArgsExpression print without brackets, else include brackets
        if(super.getArg().getClass().getSuperclass() == NoArgsExpression.class)
            return "-" + super.getArg().toString();
        else 
            return "(-" + super.getArg().toString()+")";
        
    }
    
}
