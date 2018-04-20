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
public class ConstForm implements Form{
    private boolean value; 

    public ConstForm(boolean value) {
        this.value = value;
    }

    public boolean isValue() {
        return value;
    }
    
    @Override
    public <R> R accept ( FormVisitor<R> v) {
        return v.visit(this);
    }
}
