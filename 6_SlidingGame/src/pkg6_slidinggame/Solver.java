/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg6_slidinggame;

import java.util.Queue;

/**
 *
 * @author Borislav
 */

public class Solver {

    Queue<Configuration> toExamine;

    public Solver(Configuration g) {
        // init toExamine and add g as a start value
    }
    
    
    // implementing the BFS
    public String solve() {
        while (!toExamine.isEmpty()) {
            Configuration next = toExamine.remove();
            if (next.isSolution()) {
                return "Success!";
            } else {
                for (Configuration succ : next.successors()) {
                    toExamine.add(succ);
                }
            }
        }
        return "Failure!";
    }
}

