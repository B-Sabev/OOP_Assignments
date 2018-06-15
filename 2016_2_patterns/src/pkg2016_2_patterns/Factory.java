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
public class Factory {
    public static Node<Integer> point (String name, int x, int y){
        return new Sequence<>("Point", name, 
                                    new Node[]{new Leaf<>("x", x), 
                                                new Leaf<> ("y",y)});
    }
    
    public static void test(){
        Node<Integer> tree = point("Name", 10, 10);
        Visitor v = new ToStringVisitor();
        tree.accept(v);
        
        System.out.println(v.toString());
    }
}
