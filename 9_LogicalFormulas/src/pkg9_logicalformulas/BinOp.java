/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9_logicalformulas;

import java.util.function.BinaryOperator;

/**
 *
 * @author Borislav
 */
public enum BinOp implements BinaryOperator<Boolean>{
    /*
    Replace with generics
    */
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

    
    
}
