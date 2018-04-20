package pkg9_logicalformulas;

/**
 * Represents an atomic proposition in logic formulas
 * 
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
class AtomForm implements Form {
    private String symbol;

    public AtomForm(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public <R> R accept ( FormVisitor<R> v) {
        return v.visit(this);
    }
    
    @Override
    public String toString(){
        return symbol;
    }
    
    
}
