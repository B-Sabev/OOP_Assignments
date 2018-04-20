package pkg9_logicalformulas;

/**
 * Class for representing binary operators in logic, such as and, or and implication
 * 
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class BinOpForm implements Form {
    
    private BinOp op;
    private Form leftOperand;
    private Form rightOperand;

    /**
     *
     * @param op - the sign between the arguments
     * @param leftOperand - first arg
     * @param rightOperand - second arg
     */
    public BinOpForm(BinOp op, Form leftOperand, Form rightOperand) {
        this.op = op;
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }
    
    @Override
    public <R> R accept ( FormVisitor<R> v) {
        return v.visit(this);
    }

    public BinOp getOp() {
        return op;
    }

    public Form getLeftOperand() {
        return leftOperand;
    }

    public Form getRightOperand() {
        return rightOperand;
    }
    
    
}
