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
public class PriorityVisitor implements FormVisitor<Integer> {

    @Override
    public Integer visit(BinOpForm form) {
        switch(form.getOp()){
            case AndOp:
                return 2;
            case OrOp:
                return 1;
            case ImpliesOp:
                return 0;
            default:  
        }
        return -1;
    }

    @Override
    public Integer visit(NotForm form) {
        return 3;
    }

    @Override
    public Integer visit(AtomForm form) {
        return 4;
    }

    @Override
    public Integer visit(ConstForm form) {
        return 5;
    }


    
}
