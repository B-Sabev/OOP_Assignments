package pkg9_logicalformulas;

/**
 * Factory for shortening the writing of formulas
 * 
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class FormFactory {
    
    public static Form True(){
        return new ConstForm(true);
    }
    
    public static Form False() {
        return new ConstForm(false);
    }

    public static Form atom(String symbol){
        return new AtomForm(symbol);
    }

    public static Form not(Form arg){
        return new NotForm(arg);
    }

    public static Form and(Form arg1, Form arg2){
        return new BinOpForm(BinOp.AndOp, arg1, arg2);
    }

    public static Form or(Form arg1, Form arg2){
        return new BinOpForm(BinOp.OrOp, arg1, arg2);
    }

    public static Form implies(Form arg1, Form arg2){
        return new BinOpForm(BinOp.ImpliesOp, arg1, arg2);
    }
}
