package pkg9_logicalformulas;

import java.util.function.BinaryOperator;

/**
 * Enumerator of logical operators: and, or and implication
 * 
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public enum BinOp implements BinaryOperator<Boolean>{
 
    AndOp   ("/\\") {
        @Override
        public Boolean apply(Boolean a1, Boolean a2) {
            return a1 && a2;
        }
    },

    OrOp    ("\\/") {
        @Override
        public Boolean apply(Boolean a1, Boolean a2) {
            return a1 || a2;
        }
    },

    ImpliesOp("->"){
        @Override
        public Boolean apply(Boolean a1, Boolean a2) {
            return !a1 || a2;
        }
    }
    ;
       
    private String string;
    
    private BinOp( String string ){
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }

    
    

    
    
}
