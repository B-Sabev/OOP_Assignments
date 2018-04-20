package pkg9_logicalformulas;

/**
 * Interface to represent logical formulas
 * 
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */


public interface Form {

    /**
     * Accept a visit from a FormVisitor class
     * @param <R> - generic return type
     * @param v - visitor
     * @return
     */
    public <R> R accept ( FormVisitor<R> v); 
}
