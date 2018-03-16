package pkg6_slidinggame;

/**
 * An interface for representing nodes in a state space.
 * 
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 * modified the provided code from:
 * author Sjaak Smetsers
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Borislav
 */
public interface Configuration extends Comparable<Configuration> {
   /**
     * To obtain the parent of the current configuration, i.e.
     * the configuration which had this as one of its successors
     *
     * @return a reference to the parent
     */
    public abstract Configuration parent();
    
    /**
     * To obtain the successors for a specific configuration
     *
     * @return a collection of configurations containing the successors
     */
    public abstract Collection<Configuration> successors();

    /**
     * For marking final / solution configurations.
     * 
     * @return true if a this is a solution, false otherwise
     */
    public abstract boolean isSolution();
        
    /**
     * To build a path from the root configuration to the current one.
     *
     * @return a list of successive configurations from the root to 'this'
     */
    public default List<Configuration> pathFromRoot(){
        return new ArrayList<>();
    }
    
    /**
     * Compute the heuristic value of the board using the Manhattan heuristic
     * @return
     */
    public abstract int eval();
    
    /**
     * Compute the hash code of the Configuration for fast HashSet check
     * @return
     */
    @Override
    public abstract int hashCode();
}
