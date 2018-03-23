package qtrees;

import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public enum Leaf implements QTNode {

    BLACK, WHITE;
    
    public boolean toVal(){
        return this == WHITE;
    }

    @Override
    public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
        bitmap.fillArea(x, y, width, this.toVal());
    }

    @Override
    public void writeNode(Writer out) {
        try {
            out.write(this.toVal() ? "01" : "00");            
        } catch (IOException ex) {
            Logger.getLogger(Leaf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
