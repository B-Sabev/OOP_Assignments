/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9_logicalformulas;

import java.util.HashMap;
import java.util.Map;
import static pkg9_logicalformulas.FormFactory.False;
import static pkg9_logicalformulas.FormFactory.True;
import static pkg9_logicalformulas.FormFactory.and;
import static pkg9_logicalformulas.FormFactory.atom;
import static pkg9_logicalformulas.FormFactory.implies;
import static pkg9_logicalformulas.FormFactory.not;
import static pkg9_logicalformulas.FormFactory.or;

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
        TODO
            - finish the sequence diagram
            - clean the code and add comments
        */
        
        Map<String, Boolean> m = new HashMap<>();
        m.put("A", Boolean.FALSE);
        m.put("B", Boolean.TRUE);
        m.put("C", Boolean.TRUE);
        m.put("D", Boolean.FALSE);
        EvalFromVisitor eval = new EvalFromVisitor(m);
        PrintFormVisitor printForm = new PrintFormVisitor();

        
        System.out.println("All formulas should be true, checked by hand\n");
        Form[] testCases = {f1(), f2(), f3(), f4(), f5(), f6()};
         
        for(Form f : testCases){
            // Print the formula and its evaluation
            f.accept(printForm);
            System.out.print(" = " + f.accept(eval) + "\n");
        }
        
        
    }
    
    public static Form f1(){
        return and( 
                   implies(
                           not(True()), 
                           False()), 
                   or(
                            atom("A"), 
                            atom("B")));
    }
    
    
    public static Form f2(){
        return or(atom("A"), and(atom("B"), or(atom("C"), atom("D"))));
    }

    
    public static Form f3(){
        return  
                   implies(
                           and(atom("A"), or(atom("B"), and(atom("C"), atom("D")))), 
                           and(atom("A"), and(atom("B"), and(atom("C"), atom("D")))));
    }
    
    public static Form f4(){
        return implies(
                        and(
                            atom("A"), 
                            atom("B")), 
                        or(
                            atom("A"), 
                            atom("B")));
    }
    
    
    public static Form f5(){
        return implies(
                    atom("A"),
                    implies(
                        atom("B"),
                        implies(
                            atom("C"),
                            not(atom("D"))))
                    );
    }
    
    
    public static Form f6(){
        return or(
                    implies(
                        and(
                            True(), 
                            False()), 
                        True()),
                    implies(
                        True(),
                        False())
                );
    }
    
    
    
    
    
}
