/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg5_expressions;

/**
 *
 * @author Borislav
 */
public class ExpressionFactory {
    
    public static Expression con(double x){
        return new Constant(x);
    }
    
}
