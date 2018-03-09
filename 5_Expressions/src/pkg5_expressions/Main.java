/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg5_expressions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
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
      
       boolean run = true;
       int choice;
       
       while (run) {
            System.out.print("\nWould you like to evaluate your own expression(1), see examples(2), or quit(3)?  ");
            Scanner scan = new Scanner(System.in);
            //scan.useDelimiter();
            choice = scan.nextInt();
            //scan.close();
            System.out.print("\n");

            switch (choice) {
                 case 1:     System.out.println("Example: add(mul(2, 3), x)\n");
                             System.out.print("Please input the expression you wish to evaluate:  ");
                             scan.nextLine();
                             String exp = scan.nextLine();
                             System.out.print(exp);
                             System.out.print("\n");
                             Scanner s = new Scanner(exp);
                             s.useDelimiter("\\s+|(?=\\()|(?=\\))|(?=,)|(?<=\\()|(?<=\\)|(?<=,))");
                             ArrayList<String> tokens = new ArrayList<>();
                             while (s.hasNext()) {
                                 tokens.add(s.next());                             
                             }
                             System.out.print("\n");
                             break;
                 case 2:     ArrayList<Expression> expressions = new ArrayList<>();
                             expressions.add( mul(con(10), con(20)) );
                             expressions.add( mul(con(1), var("x")) );
                             expressions.add( mul(con(0), var("x")) );
                             expressions.add( mul(var("y"), con(1)) );
                             expressions.add( mul(var("y"), con(0)) );
                             //expressions.add( mul(var("x"), var("y")) );
                             expressions.add( neg(var("x")) );
                             expressions.add( neg(add(con(10), con(20))));
                             expressions.add( add(add(con(10), con(20)), add(con(10), con(20))));
                             expressions.add( add(neg(con(10)), neg(con(20))));
                             expressions.add( add( add(add(con(10),con(10)), add(add(add(con(10), con(20)), add(con(10), con(20))), con(10))), con(10)));
                             expressions.add( mul(con(20), neg(add(mul(con(20), con(10)),add(con(20), con(10))))) );

                             Map<String, Double> store = new HashMap<>();
                             store.put("x", 12.);
                             store.put("y", 3.);

//                             for (int i = 0, i<expressions.length(), i++ ) {
//                                 e=expressions[i];
//                             }
                             for(Expression e : expressions){
                                 System.out.println("toString: " + e.toString());
                                 System.out.println("eval:     " + e.eval(store));
                                 System.out.println("optimize: " + e.optimize());
                                 System.out.println();
                             }
                             System.out.println(store.toString());
                             break;
                 case 3:     System.exit(0);
                 default:    System.out.println("Invalid choice, please select 1-3");
                             break;
             } 
       }
       
       /*
       TODO 
            - Try the program with Expression as Interface and
                the other 3 as classes implementing the Expression
            - write the test class
       
        Optional
            - add more expressions 
            - Add all extra constructors into the Static Package
            - parse expressions from the command line
       */
    }
    
}
