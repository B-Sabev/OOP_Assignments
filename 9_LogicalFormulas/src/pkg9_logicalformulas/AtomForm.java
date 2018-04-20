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
class AtomForm implements Form {
    private String symbol;

    public AtomForm(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public <R> R accept ( FormVisitor<R> v) {
        return v.visit(this);
    }
    
    @Override
    public String toString(){
        return symbol;
    }
    
    
}
