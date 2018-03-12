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
public class TestExpressions_unfinished_1 {
    
    private ArrayList<Expression> exprs;
    private Map<String, Double> store;
    private Scanner scan;

    public TestExpressions_unfinished_1() {
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
       expressions.add( add(var("x"), con(0)));
       expressions.add( add(con(0), var("y")));
       expressions.add( add(add(con(10), con(20)), add(con(20), con(10))));
       expressions.add( neg(add(con(10), con(20))));
       expressions.add( add(con(10), con(20)) );
       expressions.add( add(con(10), neg(con(20))));
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
        //System.out.println("Example: add(mul(2, 3), x)\n");
        System.out.println("Example: add(2, 3)\n");
        System.out.print("Please input the expression you wish to evaluate:  ");
        scan.nextLine();
        String exp = scan.nextLine();
        System.out.print(exp);
        System.out.print("\n");
        Scanner s = new Scanner(exp);
        s.useDelimiter("\\s+|(?=\\()|(?=\\))|(?=,)|(?<=\\()|(?<=\\)|(?<=,))");
        ArrayList<String> tokens = new ArrayList<>();
        Expression result = null;
        int firstValue = Integer.parseInt(s.findInLine("[0-9]*"));
        int secondValue = Integer.parseInt(s.findInLine("[0-9]*"));
        while (s.hasNext()) {
            System.out.println(s.next());
      
        }
        if (tokens.get(0).equals("add")) {
            //result = add();
            //result = firstValue + secondValue;  //not right
            //result = add(firstValue, secondValue);
        }
        
//    public Add(Expression arg1, Expression arg2) {
//        super(arg1, arg2);
//    }
//            if(tokens.get(tokens.indexOf("add"))) {
//                
//            }
            //tokens.add(s.next());
//            String target = tokens.get(0);
//            
//            for (Expression e : tokens) {
//                if (target.equals("add")) {
//                    result = tokens.add( add(tokens.get(0)));
//                    break;
//                }
//            }
//            

        
        //result = 

//        ArrayList<Integer> arrayOfInts = new ArrayList<Integer>();
//        for (Object str : tokens) {
//            arrayOfInts.add(Integer.parseInt((String) str));
//        }        
//        if(tokens.get(2) instanceof String){
//            int i = (int)tokens.get(2);
//        }
//        if (tokens.get(0) == "add") {
//            result = tokens.get(2) + tokens.get(4);
//        }
        System.out.print("\n");
//        expressions.add( mul(con(10), con(20)) );
//        expressions.add( mul(con(1), var("x")) );
        
        
        return result;
        //return new Constant(10);
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
