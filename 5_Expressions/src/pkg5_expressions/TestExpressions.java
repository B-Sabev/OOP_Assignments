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
public class TestExpressions {
    
    private ArrayList<Expression> exprs;
    private Map<String, Double> store;
    private Scanner scan;

    public TestExpressions() {
        scan = new Scanner(System.in); 
        exprs = null;
        store = null;
    }
    
    public void createExpressions(){
       ArrayList<Expression> expressions = new ArrayList<>();
       
       expressions.add( mul(con(10), con(20)) );
       expressions.add( mul(con(1), var("x")) );
       expressions.add( mul(con(0), var("x")) );
       expressions.add( mul(var("y"), con(1)) );
       expressions.add( mul(var("y"), con(0)) );
       expressions.add( neg(var("x")) );
       expressions.add( mul(var("x"), var("y")) );   
       expressions.add( add(add(con(10), con(20)), add(con(20), con(10))));
       expressions.add( neg(add(con(10), con(20))));
       expressions.add( add(con(10), con(20)) );
       expressions.add( add(neg(con(10)), neg(con(20))));
       expressions.add( add( add(add(con(10),con(10)), add(add(add(con(10), con(20)), add(con(10), con(20))), con(10))), con(10)));
       expressions.add( mul(con(20), neg(add(mul(con(20), con(10)),add(con(20), con(10))))) );   
       expressions.add( add(con(0), add(con(20), con(10))));
       expressions.add( add(var("x"), add(var("y"), con(10))));
       expressions.add( add(add(var("x"), con(10)), add(var("y"), con(20))));
       expressions.add( mul(var("x"), mul(add(con(20), con(20)) , con(10))));
       expressions.add( mul(var("x"), mul(mul(con(20), con(20)) , con(10))));
       expressions.add( mul(mul(con(20), con(20)), mul( con(20) , con(10))));
       
       this.exprs = expressions;
    }
    
    public void addStore(){
       this.store = new HashMap<>();
       this.store.put("x", 12.);
       this.store.put("y", 3.);
    }
    
    public void test(){
        createExpressions();
        addStore();
        for(Expression e : this.exprs){
            System.out.println(printTestExpression(e));
        }
    }
    
    
    public void runUserLoop() {
        boolean run = true;
        int choice;

        while (run) {
            System.out.print("\nWould you like to evaluate your own expression(1), see examples(2), or quit(3)?  ");
            choice = this.scan.nextInt();
            System.out.print("\n");

            switch (choice) {
                case 1:
                    Expression e = parseExpression();
                    System.out.println(printTestExpression(e));
                    break;
                case 2:
                    test();
                    break;
                case 3:
                    run = false;
                    System.exit(0);
                default:
                    System.out.println("Invalid choice, please select 1-3");
                    break;
            }
        }
    }
    
    
    public Expression parseExpression(){
        System.out.println("Example: add(mul(2, 3), x)\n");
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
        
        
        
        return new Constant(10);
    }
    
    public String printTestExpression(Expression e){
        return  "toString: " + e.toString() + "\n" +
                "optimize: " + e.optimize() + "\n" + 
                "eval:     " + e.eval(this.store) + "\n";// +
                //"with store: " + this.store.toString() + "\n"; 
    }

    public ArrayList<Expression> getExprs() {
        return exprs;
    }

    public void setExprs(ArrayList<Expression> exprs) {
        this.exprs = exprs;
    }

    public Map<String, Double> getStore() {
        return store;
    }

    public void setStore(Map<String, Double> store) {
        this.store = store;
    }
    
    
}
