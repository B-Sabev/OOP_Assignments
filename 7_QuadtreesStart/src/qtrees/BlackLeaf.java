/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qtrees;

import java.io.Writer;

/**
 *
 * @author Borislav
 */
public class BlackLeaf implements QTNode{
    
    private int size;

    @Override
    public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
        bitmap.fillArea(x, y, width, false);
    }

    @Override
    public void writeNode(Writer out) {
        // fill the size of the leaf with 0s
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
