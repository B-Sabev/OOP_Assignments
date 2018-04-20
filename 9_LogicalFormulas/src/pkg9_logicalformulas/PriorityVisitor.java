package pkg9_logicalformulas;

/**
 * Visit classes implementing Form returning the priority of their operation
 * 
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class PriorityVisitor implements FormVisitor<Integer> {
    
    /*
    * Define the priority of an operation as an integer, where larger int means
    * the operator binds stronger
    */
    public static final int CONST_PRIORITY = 5,
                            ATOM_PRIORITY = 4,
                            NOT_PRIORITY = 3,
                            AND_PRIORITY = 2,
                            OR_PRIORITY = 1,
                            IMPLIES_PRIORITY = 0;
  
    @Override
    public Integer visit(BinOpForm form) {
        switch(form.getOp()){
            case AndOp:
                return AND_PRIORITY;
            case OrOp:
                return OR_PRIORITY;
            case ImpliesOp:
                return IMPLIES_PRIORITY;
            default:  
        }
        return -1;
    }

    @Override
    public Integer visit(NotForm form) {
        return NOT_PRIORITY;
    }

    @Override
    public Integer visit(AtomForm form) {
        return ATOM_PRIORITY;
    }

    @Override
    public Integer visit(ConstForm form) {
        return CONST_PRIORITY;
    }
    
}
