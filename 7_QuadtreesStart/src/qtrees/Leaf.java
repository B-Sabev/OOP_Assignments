package qtrees;

import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public enum Leaf implements QTNode {

    /**
     * A leaf with false bit value
     */
    BLACK,

    /**
     * A leaf with true bit value
     */
    WHITE;
    
    /**
     * Converts the enum to boolean
     * @return true for WHITE, false for BLACK
     */
    public boolean toVal(){
        return this == WHITE;
    }

    /**
     * Fill the bitmap with the given color
     * @param x - upper left coordinate
     * @param y - upper left coordinate
     * @param size - size of the map
     * @param bitmap - the given map
     */
    @Override
    public void fillBitmap(int x, int y, int size, Bitmap bitmap) {
        bitmap.fillArea(x, y, size, this.toVal());
    }

    /**
     * Write the given node to a writer
     * @param out - an initialized writer
     */
    @Override
    public void writeNode(Writer out) {
        try {
            // if white add 01, if black 00
            out.write(this.toVal() ? "01" : "00");            
        } catch (IOException ex) {
            Logger.getLogger(Leaf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
