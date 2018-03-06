/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg5_expressions;

import java.util.Map;

/**
 *
 * @author Borislav
 */
public class Constant extends Expression{
    
    private double value;

    public Constant(double value) {
        this.value = value;
    }
    
    @Override
    public double eval(Map<String, Double> store) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Expression optimize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString(){
        return String.valueOf(value);
    }
    
}
