/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9_logicalformulas;

import java.util.Map;

/**
 *
 * @author Borislav
 */
public class EvalFromVisitor implements FormVisitor {
    
    
    private Map<String, Boolean> e;  //: assignment from the name of the atomic prop to its value

    public EvalFromVisitor(Map<String, Boolean> e) {
        this.e = e;
    }
    
    
    
    
    /// Evalue the 
    
    // apply operator and accept the arguments 
    @Override
    public void visit(BinOpForm form) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(NotForm form) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(AtomForm form) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(ConstForm form) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
