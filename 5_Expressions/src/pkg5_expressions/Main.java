/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg5_expressions;
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
       Expression x = mul(neg(con(10)), add(var("x"), var("y")));
       
       
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
