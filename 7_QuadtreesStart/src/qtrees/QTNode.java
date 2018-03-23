package qtrees;

import java.io.Writer;


/**
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 * 
 * adapted from: 
 *  Sjaak Smetsers
 */
public interface QTNode {
    public void fillBitmap( int x, int y, int width, Bitmap bitmap );
    public void writeNode( Writer out );
}
