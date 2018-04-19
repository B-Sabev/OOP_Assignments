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
class AtomForm implements Form {
    private String symbol;

    public AtomForm(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean accept(FormVisitor v) {
        return v.visit(this);
    }

    public String getSymbol() {
        return symbol;
    }
    
    @Override
    public String toString(){
        return symbol;
    }
    
    
}
