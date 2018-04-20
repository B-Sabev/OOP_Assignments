package pkg9_logicalformulas;

/**
 * class for representing constant expressions in logic - true and false
 * 
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class ConstForm implements Form{
    private boolean value; 

    public ConstForm(boolean value) {
        this.value = value;
    }

    public boolean isValue() {
        return value;
    }

    @Override
    public <R> R accept ( FormVisitor<R> v) {
        return v.visit(this);
    }
}
