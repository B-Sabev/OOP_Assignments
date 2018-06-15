/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2016_2_patterns;

/**
 *
 * @author Borislav
 */
public class ToStringVisitor<E> implements Visitor{
    
    private StringBuilder sb = new StringBuilder();
    
    public void visit(Sequence<E> seq) {
        sb.append(seq.child);
        for(Node node: seq.nodes)
            node.accept(this);
    }
    
    public void visit(Leaf<E> leaf){
        sb.append(leaf.value);
    }

    @Override
    public void visit(Visitable visitable) {
        if(visitable instanceof Leaf )
            visit((Leaf) visitable);
        if(visitable instanceof Sequence)
            visit((Sequence) visitable);
    }
    
    
    public String toString(){
        return sb.toString();
    }
}
