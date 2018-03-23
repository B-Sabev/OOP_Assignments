/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qtrees;

import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Borislav
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
