/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg5_expressions;
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
       Expression x = mul(con(10), add(var("x"), var("y")));
       Map<String, Double> store = new HashMap<>();
       store.put("x", 12.);
       store.put("y", 3.);
       
       System.out.println(x.eval(store));
       
       System.out.println(x.toString());
       
       /*
       TODO 
            - improve the toString
            - implement eval, optimize
            - write the test class
       
       
        Optional
            - add more expressions 
            - Add all extra constructors into the Static Package
       */
    }
    
}
