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
            - class and sequence diagram
            - add more static methods that return Form to test EvalFormVisitor and PrintFormVisitor
            - PrintFormVisitor when to use brackets ??
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
        return and( 
                   implies(
                           not(True()), 
                           False()), 
                   or(
                            atom("A"), 
                            atom("B")));
    }
    
}
