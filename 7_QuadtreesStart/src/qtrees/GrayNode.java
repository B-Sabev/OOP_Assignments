package qtrees;

import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * GrayNode: class for representing a node with children in a QTree 
 * 
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class GrayNode implements QTNode{
    
    /**
     * Every node that is not leaf must have 4 children
     */
    public static final int MAX_CHILDREN = 4;
    private final QTNode[] children;
    private int numChildren;
    
    /**
     * initializes the children as empty array, 0 children
     */
    public GrayNode() {
        this.children = new QTNode[MAX_CHILDREN];
        this.numChildren = 0;
    }
    
    /**
     * Add a child to the node if the children are less than MAX_CHILDREN
     * @param child - a QTNode child to be added to the children array
     */
    public void addChild(QTNode child){
        if(numChildren < MAX_CHILDREN){
            children[numChildren] = child;
            numChildren++;
        }       
    }
    
    /**
     * Fill a bitmap given the node value
     * @param x - upper left coordinate
     * @param y - upper left coordinate
     * @param size - size of the map
     * @param bitmap - the given map
     */
    @Override
    public void fillBitmap(int x, int y, int size, Bitmap bitmap) {
        this.children[0].fillBitmap(x,          y,          size/2, bitmap);
        this.children[1].fillBitmap(x + size/2, y,          size/2, bitmap);
        this.children[2].fillBitmap(x + size/2, y + size/2, size/2, bitmap);
        this.children[3].fillBitmap(x,          y + size/2, size/2, bitmap);
    }

    /**
     * Write the given node to a writer
     * @param out - an initialized writer
     */
    @Override
    public void writeNode(Writer out) {
        try {
            out.write('1'); // write that the node is not leaf node
            // recusrivly call all the children of this node 
            for(QTNode child : children){
                child.writeNode(out);
            }
        } catch (IOException ex) {
            Logger.getLogger(GrayNode.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
