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
       Expression x = new Multiply(con(10), con(20));
       
       
       System.out.println(x.toString());
    }
    
}
