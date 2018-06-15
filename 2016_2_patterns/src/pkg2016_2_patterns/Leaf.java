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
public class Leaf<E> extends Node<E> {
    protected E value;
    
    public Leaf(String name, E value){
        super(name);
        this.value = value;
    }
    @Override
    public void accept(Visitor<E> v) {
        v.visit(this);
    }
    
}
