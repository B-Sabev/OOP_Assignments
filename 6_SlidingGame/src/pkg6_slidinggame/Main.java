/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg6_slidinggame;

import java.util.Collection;
import java.util.List;

/**
 *
 * @author Borislav
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] start = {9,2,3,4,1,6,7,8,5};
        
        SlidingGame game = new SlidingGame(start);
        System.out.println(game.toString());
        
        System.out.println("Successors");
        
        Collection<Configuration> successors = game.successors();
        for(Configuration s : successors){
            System.out.println(s.toString());
            
            SlidingGame g = (SlidingGame) s;
            System.out.println(g.pathFromRoot());
        }
        
        
        
        Solver solver = new Solver(game);
        System.out.println(solver.solve());
        /*
            TODO
                - test pathFromRoot
        
        
        */
    }
    
}
