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

    public TestExpressions() {
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
