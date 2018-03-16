package pkg6_slidinggame;


import java.util.*;


/**
 * A class that implements a breadth-first search algorithm
 * for finding the Configurations for which the isSolution predicate holds
 * 
 * 
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 * modified the provided code from:
 * author Pieter Koopman, Sjaak Smetsers
 */
public class Solver
{
   // A queue for maintaining graphs that are not visited yet.
    Queue<Configuration> toExamine;
   // List to keep the all visited states
    Collection<Configuration> visited;
   // Configuration object that is solution to the problem, used to return the path to root
    Configuration solution;

    /**
     * Constructor for the solver given root Configuration
     * @param g - root Configuration
     */
    public Solver( Configuration g ) {
        toExamine = new PriorityQueue<>();
        toExamine.add(g);
        solution = null;
        visited = new HashSet<>();
    }

    /**
     * Implements a best-first search to find the goal state of the configuration
     *
     * @return Configuration that is solution to SlidingGame or null
     */
    public Configuration solve() {
        while ( ! toExamine.isEmpty() ) {
            Configuration next = toExamine.remove();
            visited.add(next);
            if ( next.isSolution() ) {
                solution = next;
                return solution;
            } else {
                for ( Configuration succ : next.successors() ) {
                    // if the successor is not visited before, add for examination
                    if ( !visited.contains(succ) )
                        toExamine.add(succ);
                }
            }
        }
        return null;
    }
    
    /**
     * Gets a list of all Configuration from the solution to root
     * @return
     */
    public List<Configuration> getPath(){
        List<Configuration> path = new ArrayList<>();
        if(this.solution != null){
            path = this.solution.pathFromRoot();
        } 
        return path;
    }
    
}
