package pkg6_slidinggame;


import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Sjaak Smetsers
 */
public class Main
{
    public static void main(String[] args) {
        int [] game = {1,2,9, 4,5,3, 7,8,6};

        SlidingGame s = new SlidingGame (game);
        System.out.println(s);
        

        Solver solver = new Solver(s);
        System.out.println(solver.solve());
        List<Configuration> path = solver.getPath();
        
        for(Configuration p : path)
            System.out.println(p);
        /*
        TODO
            - add our names
            - implement visited as a HashSet to speed up comparison
            - maybe rework pathFromRoot to include the object itself
            - write View class - print the start state, then solve and present the whole path
            - re-organize methods
            - add comments
            - clear unused imports
        */
    }
}
