/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2016_2_patterns;

import java.util.Arrays;
import java.util.List;

/**For the internal (recursive) nodes of the tree, define the class Sequence <E> .
4 points
Each Sequence object contains a string name and a List of Nodes . In the above
examples are the Polygon and the Point and Sequence nodes. Also create a constructor
Sequence (String child, String name, Node <E> ... children) 
 *
 * @author Borislav
 */
public class Sequence<E> extends Node{
    protected List<Node> nodes;
    protected String child;
    
    public Sequence(String child, String name, List<Node> nodes){
        super(name);
        this.child = child;
        this.nodes = nodes;
    }
    
    public Sequence(String child, String name, Node[] nodes){
        super(name);
        this.child = child;
        this.nodes = Arrays.asList(nodes);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
