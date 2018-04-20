package pkg9_logicalformulas;

/**
 * Represents a formula of logical not
 * 
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
class NotForm implements Form{
    
    private Form operand;

    public NotForm(Form operand) {
        this.operand = operand;
    }
   
    @Override
    public <R> R accept ( FormVisitor<R> v) {
        return v.visit(this);
    }

    public Form getOperand() {
        return operand;
    }
    
}
