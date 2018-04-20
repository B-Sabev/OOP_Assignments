/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9_logicalformulas;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Borislav
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        TODO
            - class and sequence diagram
            - add more static methods that return Form to test EvalFormVisitor and PrintFormVisitor
            - use generics in the interfaces and adjust the classes
            - PrintFormVisitor when to use brackets ??

        
        Bonus - make a factory for the classes
        */
        
        Map<String, Boolean> m = new HashMap<>();
        m.put("A", Boolean.FALSE);
        m.put("B", Boolean.TRUE);
        EvalFromVisitor eval = new EvalFromVisitor(m);
        Form f = f1();
        ///eval.visit(f);
        System.out.println(f.accept(eval));
        
        System.out.println(BinOp.AndOp);
        
        PrintFormVisitor printForm = new PrintFormVisitor();
        f.accept(printForm);
        
    }
    
    
    
    public static Form f1(){
        return new BinOpForm(BinOp.AndOp, 
                        new BinOpForm(BinOp.ImpliesOp,
                                new NotForm(new ConstForm(true)), new ConstForm(false)), 
                        new BinOpForm(BinOp.OrOp,
                                new AtomForm("A"), new AtomForm("B")));
    }
    
}
