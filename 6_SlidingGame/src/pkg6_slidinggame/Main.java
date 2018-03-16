package pkg6_slidinggame;


import java.util.ArrayList;
import java.util.List;
import static pkg6_slidinggame.SlidingGame.randomGame;
import static pkg6_slidinggame.View.initGame;


/**
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class Main
{
    public static void main(String[] args) {
        int [] game = {1,2,3,4,
                       5,6,7,8,
                       9,11,10,12,
                       14,13,15,16};
        


        //SlidingGame s = new SlidingGame (game);
        
        View.initGame();
        for(int i=0; i<20; i++){
            SlidingGame s = randomGame(SlidingGame.N);
            System.out.println(s);
            System.out.println("Is solvable " + s.isSolvable());

            Solver solver = new Solver(s);
            System.out.println(solver.solve());
            List<Configuration> path = solver.getPath();

            System.out.println("Found solution of length " + path.size());
        }
        
        
        
        
        //for(Configuration p : path)
        //   System.out.println(p);
        /*
        TODO
            - check the isSolvable function
            - if it is not solvable, it is very slow on 4x4
            - write View class - print the start state, then solve and present the whole path
                - Give user the choice between hard-coded, random, or entering himself (optional)
                - hard-code 1 solvable, 1 unsolvable
                - measure the time
                - (Optional) add parsing
            - (Optional) store Manhattan dist for all configurations to ease computing
            - re-organize methods
            - add comments
            - clear unused imports
        */
    }
}
