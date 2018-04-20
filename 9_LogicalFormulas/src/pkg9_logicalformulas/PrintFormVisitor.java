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
public class PrintFormVisitor implements FormVisitor<Void>{

    @Override
    public Void visit(BinOpForm form) {
        form.getLeftOperand().accept(this);
        System.out.print(" " + form.getOp().getString() + " ");
        form.getRightOperand().accept(this);
        return null;    
    }

    @Override
    public Void visit(NotForm form) {
        System.out.print(" ~");
        form.getOperand().accept(this);
        return null;
    }

    @Override
    public Void visit(AtomForm form) {
        System.out.print(form.toString());
        return null;
    }

    @Override
    public Void visit(ConstForm form) {
        String toPrint = form.isValue() ? "1" : "0";
        System.out.print(toPrint);
        return null;
    }
    
}
