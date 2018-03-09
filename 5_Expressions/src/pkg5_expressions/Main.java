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
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*
        ArrayList<String> s = new ArrayList<>();
        
        s.add("Something");
        s.add("Something else");
       
        s.get(s.size()-1);
        */
        
       Expression e = add(add(con(10), con(20)), add(con(10), con(20)));
       System.out.println(e.toString());
       e.optimize();
       (new TestExpressions()).test();
       
       /*
       TODO 
       
        Optional
            - add more expressions 
            - Add all extra constructors into the Static Package
            - parse expressions from the command line
       */
    }
    
}
