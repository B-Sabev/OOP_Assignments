/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg5_expressions;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class ExpressionFactory {
    
    public static Expression con(double value){
        return new Constant(value);
    }
    
    public static Expression var(String name){
        return new Variable(name);
    }
    
    public static Expression neg(Expression arg){
        return new Negation(arg);
    }
    
    public static Expression add(Expression arg1, Expression arg2){
        return new Add(arg1, arg2);
    }
    
    public static Expression mul(Expression arg1, Expression arg2){
        return new Multiply(arg1, arg2);
    }
    
}
