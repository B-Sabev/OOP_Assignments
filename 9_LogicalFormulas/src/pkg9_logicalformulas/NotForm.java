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
class NotForm {
    
    private Form operand;

    public NotForm(Form operand) {
        this.operand = operand;
    }
   
    public boolean accept(FormVisitor v) {
        return v.visit(this);
    }

    public Form getOperand() {
        return operand;
    }
    
}
