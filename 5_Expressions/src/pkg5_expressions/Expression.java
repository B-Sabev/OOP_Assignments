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

// Should this be an interface ???, then you can't use the isConstant
public abstract class Expression {
   
    public abstract double eval(Map<String, Double> store);
    
    
    // use return this as default??
    // Optimize is just eval without the variables ??, can you reuse??
    public abstract Expression optimize();
    
    
    // Put this with Constant as static method
    public boolean isConstant(){
        return this.getClass() == Constant.class;
    }
    
}
