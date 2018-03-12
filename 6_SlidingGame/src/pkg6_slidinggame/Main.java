/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg6_slidinggame;

import java.util.Collection;
import java.util.List;
import static pkg6_slidinggame.SlidingGame.N;

/**
 *
 * @author Borislav
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        int[] start = {1,4,7,
                       2,5,8,
                       3,6,9};
        SlidingGame game = new SlidingGame(start);
        System.out.println(game.toString());
        
        for(int i=0; i<N; i++)
            for(int j=0;j<N;j++)
                System.out.println(game.getBoard()[i][j] + "at position " + "("+i+", "+j+")");
        
        // Use this for manhattan
        // number - get real position, get true position, compute manhattan, add to all the rest
        //ind -> correct position
        //(ind-1) / 3, (ind-1) % 3
        
        System.out.println();
        
        
        /*
        Solver solver = new Solver(game);
        System.out.println(solver.solve());
        List<Configuration> path = solver.getPath();
        
        System.out.println("Print path");
        for(Configuration p : path)
            System.out.println(p.toString());
        */
        
        
        /*
            TODO
                - Solver - keep track of visited to prevent cycles
                - compare visited with a HashSet
                - use best first search by implementing Manhattan distance as heuristic
                    - implement CompareTo with the manhattan value
                    - change to PriorityQueue
                - change the puzzle to 4x4
        */ 
    }
    
}
