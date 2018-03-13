/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg6_slidinggame;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author Borislav
 */

public class Solver {

    Queue<Configuration> toExamine;
    Configuration solution;

    public Solver(Configuration g) {
        // init toExamine and add g as a start value
        toExamine = new PriorityQueue<>(); // may need to change to PriorityQueue when going for best first
        toExamine.add(g);
        solution = null;
    }
    
    
    // implementing the BFS
    public String solve() {
        while (!toExamine.isEmpty()) {
            Configuration next = toExamine.remove();
            if (next.isSolution()) {
                this.solution = next;
                return "Success!";
            } else {
                for (Configuration succ : next.successors()) {
                    toExamine.add(succ);
                }
            }
        }
        return "Failure!";
    }
    
    public List<Configuration> getPath(){
        List<Configuration> path = this.solution.pathFromRoot();
        path.add(this.solution);
        return path;
    }
}

