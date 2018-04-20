package pkg9_logicalformulas;

/**
 * Visitor class for printing realizations of Form to the command line
 * 
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class PrintFormVisitor implements FormVisitor<Void>{

    private PriorityVisitor priorityVisitor;

    /**
     * Initialize with a PriorityVisitor, which checks the 
     * priority of the formulas
     */
    public PrintFormVisitor() {
        priorityVisitor = new PriorityVisitor();
    }

    @Override
    public Void visit(BinOpForm form) {

        // get the priority of the formula and its operants
        Integer formPriority = form.accept(priorityVisitor);
        Integer leftPriority = form.getLeftOperand().accept(priorityVisitor);
        Integer rightPriority = form.getRightOperand().accept(priorityVisitor);
        // print brackets only if the priority of the operand is less than that of the formula
        boolean printLeftBrackets = leftPriority < formPriority;
        boolean printRightBrackets = rightPriority < formPriority;
        
        if(printLeftBrackets)
            System.out.print("(");
        form.getLeftOperand().accept(this);
        if(printLeftBrackets)
            System.out.print(")");
        
        System.out.print(" " + form.getOp().toString() + " ");
        
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
        System.out.print("~");
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
        System.out.print(form.isValue() ? "1" : "0");
        return null;
    }
}
