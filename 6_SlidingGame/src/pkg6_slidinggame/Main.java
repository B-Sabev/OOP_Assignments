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
                       2,5,6,
                       3,9,8};
        SlidingGame game = new SlidingGame(start);
        System.out.println(game.toString());
        
        /*
        for(int i=0; i<N; i++)
            for(int j=0;j<N;j++)
                System.out.println(game.getBoard()[i][j] + "at position " + "("+i+", "+j+")");
        */
        
        
        System.out.println();
        System.out.println(game.eval());
        
        
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
                - change the puzzle to 4x4
        */ 
    }
    
}
