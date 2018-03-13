/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg6_slidinggame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Borislav
 */
public interface Configuration extends Comparable<Configuration>{
    
    public abstract Configuration parent();
    public abstract Collection<Configuration> successors();
    public abstract boolean isSolution();
    public default List<Configuration> pathFromRoot(){
        return new ArrayList<>(); // there is no path because this is root
    }
    public abstract int eval();
    
}
