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
    
    
    private Map<String, Boolean> atomicAssignment;  //: assignment from the name of the atomic prop to its value

    public EvalFromVisitor(Map<String, Boolean> atomicAssignment) {
        this.atomicAssignment = atomicAssignment;
    }
    
    // apply operator and accept the arguments 
    @Override
    public boolean visit(BinOpForm form) {
        return  form.getOp().apply( 
                    form.getLeftOperand().accept(this), 
                    form.getRightOperand().accept(this));
    }

    @Override
    public boolean visit(NotForm form) {
        return ! form.getOperand().accept(this);
    }

    @Override
    public boolean visit(AtomForm form) {
        // return the truth value of the atomic given the map
        return atomicAssignment.get(form.getSymbol());
    }

    @Override
    public boolean visit(ConstForm form) {
        // return the value of the ConstForm
        return form == ConstForm.TRUE;
    }
    
}
