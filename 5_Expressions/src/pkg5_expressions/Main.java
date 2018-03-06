/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg5_expressions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static pkg5_expressions.ExpressionFactory.*;
/**
 *
 * @author Borislav
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Expression x = add(var("x"), var("y"));
       
       ArrayList<Expression> expressions = new ArrayList<>();
       expressions.add( mul(con(10), con(20)) );
       expressions.add( mul(con(1), var("x")) );
       expressions.add( mul(con(0), var("x")) );
       expressions.add( mul(var("y"), con(1)) );
       expressions.add( mul(var("y"), con(0)) );
       expressions.add( neg(var("x")) );
       expressions.add( neg(add(con(10), con(20))));
       
       
       Map<String, Double> store = new HashMap<>();
       store.put("x", 12.);
       store.put("y", 3.);
       
       
       for(Expression e : expressions){
           System.out.println("toString: " + e.toString());
           System.out.println("eval:     " + e.eval(store));
           System.out.println("optimize: " + e.optimize());
       }
       
       
       
       /*
       TODO 
            - implement optimize
            - write the test class
       
        Optional
            - add more expressions 
            - Add all extra constructors into the Static Package
       */
    }
    
}
