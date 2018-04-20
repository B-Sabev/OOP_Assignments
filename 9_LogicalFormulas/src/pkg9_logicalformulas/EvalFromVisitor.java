package pkg9_logicalformulas;

import java.util.Map;

/**
 * Visitor that evaluates the truth of a given Form
 * 
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class EvalFromVisitor implements FormVisitor<Boolean>{
    
     // maps from the name of the atomic proposition to its truth value
    private Map<String, Boolean> atomicAssignment; 

    public EvalFromVisitor(Map<String, Boolean> atomicAssignment) {
        this.atomicAssignment = atomicAssignment;
    }
 
    @Override
    public Boolean visit(BinOpForm form) {
        return  form.getOp().apply( 
                    form.getLeftOperand().accept(this), 
                    form.getRightOperand().accept(this));
    }

    @Override
    public Boolean visit(NotForm form) {
        return ! form.getOperand().accept(this);
    }

    @Override
    public Boolean visit(AtomForm form) {
        // return the truth value of the atomic formula from the map
        return atomicAssignment.get(form.toString());
    }

    @Override
    public Boolean visit(ConstForm form) {
        return form.isValue();
    }

}
