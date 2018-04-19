/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9_logicalformulas;

/**
 *
 * @author Borislav
 */
public enum ConstForm implements Form {
    
    TRUE {
        public boolean accept(FormVisitor v) {
            return v.visit(this);
        }
    },
    FALSE {
        @Override
        public boolean accept(FormVisitor v) {
            return v.visit(this);
        }
    };
}
