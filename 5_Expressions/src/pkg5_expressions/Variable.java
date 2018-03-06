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
public class Variable extends NoArgsExpression{
    
    private String name;

    public Variable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double eval(Map<String, Double> store) {
        return store.get(this.name);
    }

    @Override
    public Expression optimize() {
        return this;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
    
}
