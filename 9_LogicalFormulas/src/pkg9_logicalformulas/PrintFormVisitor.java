/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9_logicalformulas;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class PrintFormVisitor implements FormVisitor<Void>{

    private PriorityVisitor priorityVisitor;

    public PrintFormVisitor() {
        priorityVisitor = new PriorityVisitor();
    }
    
    @Override
    public Void visit(BinOpForm form) {
        
        Form leftOp = form.getLeftOperand();
        Form rightOp = form.getRightOperand();
        // get the priority of the argument and its operants
        Integer formPriority = form.accept(priorityVisitor);
        Integer leftPriority = leftOp.accept(priorityVisitor);
        Integer rightPriority = rightOp.accept(priorityVisitor);
        
        boolean printLeftBrackets = leftPriority < formPriority;
        boolean printRightBrackets = rightPriority < formPriority;
        
        
        if(printLeftBrackets)
            System.out.print("(");
        form.getLeftOperand().accept(this);
        if(printLeftBrackets)
            System.out.print(")");
        
        
        System.out.print(" " + form.getOp().getString() + " ");
        
        if(printRightBrackets)
            System.out.print("(");
        form.getRightOperand().accept(this);
        if(printRightBrackets)
            System.out.print(")");
        return null;    
    }

    @Override
    public Void visit(NotForm form) {
        
        boolean printBrackets = form.getOperand().accept(priorityVisitor) < form.accept(priorityVisitor);
        
        System.out.print(" ~");
        if(printBrackets)
            System.out.print("(");
        form.getOperand().accept(this);
        if(printBrackets)
            System.out.print(")");
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
