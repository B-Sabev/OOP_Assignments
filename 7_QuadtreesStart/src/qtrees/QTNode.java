package qtrees;

import java.io.Writer;


/**
 * QTNode interface to be implemented by all node is QTree
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 * 
 * adapted from: 
 *  Sjaak Smetsers
 */
public interface QTNode {

    /**
     * Fill a bitmap given the node value
     * @param x - upper left coordinate
     * @param y - upper left coordinate
     * @param size - size of the map
     * @param bitmap - the given map
     */
    public void fillBitmap( int x, int y, int size, Bitmap bitmap );

    /**
     * Write the given node to a writer
     * @param out - an initialized writer
     */
    public void writeNode( Writer out );
}
