package qtrees;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Bitmap: A class for representing bitmap;
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 * 
 * adapted from: 
 *  Sjaak Smetsers
 */

public class QTree {
    QTNode root;
    
    /**
     * Init a QTree from Reader String
     * @param input - a Reader
     */
    public QTree( Reader input ) {
        try {
            root = readQTree( input );
        } catch (IOException ex) {
            Logger.getLogger(QTree.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Init a QTree from a Bitmap
     * @param bitmap - bitmap to be converted to tree
     */
    public QTree( Bitmap bitmap ) {
        root = bitmap2QTree( 0, 0,  bitmap.getSize(), bitmap );
    }

    /**
     * Fill a bitmap with the tree representation
     * @param bitmap
     */
    public void fillBitmap ( Bitmap bitmap ) {
        root.fillBitmap(0, 0, bitmap.getSize(), bitmap);
    }

    /**
     * Write a QTree to writer as String
     * @param sb - an initialized Writer object
     */
    public void writeQTree( Writer sb ) {
        root.writeNode( sb );
    }
    
    
    
    /**
     * Read a QTree from reader
     * @param input - reader with sample string to create a tree from
     */
    private static QTNode readQTree( Reader input ) throws IOException {
        // Read the first bit
        int bit = input.read();
        while(bit != -1) { // while there is still something to read
            if(bit == '1'){ // if not leaf
                // create a gray node and fill it with 4 children
                QTNode node = new GrayNode();
                for(int i=0; i<GrayNode.MAX_CHILDREN; i++){
                    ((GrayNode) node).addChild(readQTree(input));
                }
                return node;
            } else {
                // bit is 0, take next bit to determine white or black leaf
                bit = input.read();
                if(bit == '1'){
                    return Leaf.WHITE;
                }
                if(bit == '0'){
                    return Leaf.BLACK;
                }
            }
            bit = input.read();
        }
        return null; // should happen only if reader is empty
    }
    
    /**
     * Create a QTree from a bitmap
     * @param x - upper left coordinate
     * @param y - upper left coordinate
     * @param size - size of the bitmap
     * @param bitmap - the given bitmap
     * @return - the root node
     */
    public static QTNode bitmap2QTree( int x, int y, int size, Bitmap bitmap ) {
        if(bitmap.isVal(true)){ // if all pixels in the map are white
            return Leaf.WHITE;
        }
        if(bitmap.isVal(false)){ // if all pixels in the map are black
            return Leaf.BLACK;
        }
        // If the code reaches here, the bitmap is gray
        //System.out.println(x);
        //System.out.println(y);
        int[] xs = {0, 0+size/2, 0+size/2, 0};
        int[] ys = {0, 0,        0+size/2, 0+size/2};
        
        Bitmap bm;
        QTNode gray = new GrayNode();
        for(int i=0; i<GrayNode.MAX_CHILDREN; i++){
            bm = bitmap.copyPart(xs[i], ys[i], size/2);
            ((GrayNode) gray).addChild(bitmap2QTree(xs[i], ys[i], size/2, bm));
            
        }
        return gray;
    }

    public QTNode getRoot() {
        return root;
    }

}
