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
 * @version 1.5
 * @date 25-02-2017
 */
public class Solver
{
   // A queue for maintaining graphs that are not visited yet.
    Queue<Configuration> toExamine;
    Collection<Configuration> visited;
    Configuration solution;

    public Solver( Configuration g ) {
        // init toExamine and add g as a start value
        toExamine = new PriorityQueue<>();
        toExamine.add(g);
        solution = null;
        visited = new HashSet<>(181440, 1);
    }

    /**
     * A skeleton implementation of the solver
     *
     * @return a string representation of the solution
     */
    public String solve() {
        while ( ! toExamine.isEmpty() ) {
            Configuration next = toExamine.remove();
            visited.add(next);
      
            //if(visited.size() > 50000){
            //    System.out.println("More than 5000 conf visited, breaking");
            //    break;
            //}
            
            
            if ( next.isSolution() ) {
                solution = next;
                return "Success!";
            } else {
                for ( Configuration succ : next.successors() ) {
                    // if the successor is not visited before, add for examination
                    if ( !visited.contains(succ) )
                        toExamine.add(succ);
                }
            }
        }
        return "Failure!";
    }
    
    
    public List<Configuration> getPath(){
        List<Configuration> path = new ArrayList<>();
        if(this.solution != null){
            path = this.solution.pathFromRoot();
        } 
        return path;
    }
    
}
