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
public abstract class Expression {
   
    public abstract double eval(Map<String, Double> store);
    
    public abstract Expression optimize();
    
}
