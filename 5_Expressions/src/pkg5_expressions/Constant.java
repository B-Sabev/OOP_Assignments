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
public class Constant extends NoArgsExpression{
    
    private double value;

    public Constant(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
    @Override
    public double eval(Map<String, Double> store) {
        return this.value;
    }

    @Override
    public Expression optimize() {
        return this;
    }
    
    @Override
    public String toString(){
        return String.valueOf(value);
    }
    
}
