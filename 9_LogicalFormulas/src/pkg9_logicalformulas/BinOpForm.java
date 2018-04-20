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
public class BinOpForm implements Form {
    
    private BinOp op;
    private Form leftOperand;
    private Form rightOperand;

    public BinOpForm(BinOp op, Form leftOperand, Form rightOperand) {
        this.op = op;
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }
    
    public <R> R accept ( FormVisitor<R> v) {
        return v.visit(this);
    }

    public BinOp getOp() {
        return op;
    }

    public Form getLeftOperand() {
        return leftOperand;
    }

    public Form getRightOperand() {
        return rightOperand;
    }
    
    
}
