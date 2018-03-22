package qtrees;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QTree {
    QTNode root;
    
    public QTree( Reader input ) {
        try {
            root = readQTree( input );
        } catch (IOException ex) {
            Logger.getLogger(QTree.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public QTree( Bitmap bitmap ) {
        root = bitmap2QTree( 0, 0,  bitmap.getSize(), bitmap );
    }

    public void fillBitmap ( Bitmap bitmap ) {
        root.fillBitmap(0, 0, bitmap.getSize(), bitmap);
    }

    public void writeQTree( Writer sb ) {
        root.writeNode( sb );
    }
    
    private static QTNode readQTree( Reader input ) throws IOException {
        // Read the first bit
        int bit = input.read();
        while(bit != -1) { // while there is still something to read
            if(bit == '1'){ // if not leaf
                // create a gray node and fill it with 4 children
                QTNode node = new GrayNode();
                ((GrayNode) node).addChild(readQTree(input));
                ((GrayNode) node).addChild(readQTree(input));
                ((GrayNode) node).addChild(readQTree(input));
                ((GrayNode) node).addChild(readQTree(input));
                return node;
            } else {
                // bit is 0, take next bit to determine white or black leaf
                bit = input.read();
                if(bit == '1'){
                    return new WhiteLeaf();
                }
                if(bit == '0'){
                    return new BlackLeaf();
                }
            }
            bit = input.read();
        }
        return null;
    }
    
    
    public static QTNode bitmap2QTree( int x, int y, int size, Bitmap bitmap ) {
        // Split the bitmap into 4 parts
        // if in the split are one color use Leaf, else Node
        if(bitmap.getSize() == 1){
            // return the root node
        } else {
            Bitmap[] parts4 = {bitmap.copyPart(0,       0,      size/2),
                               bitmap.copyPart(size/2,  0,      size/2),
                               bitmap.copyPart(0,       size/2, size/2),
                               bitmap.copyPart(size/2,  size/2, size/2)};
            QTNode gray = new GrayNode();
        }
        
        
       
        return null;
    }

    public QTNode getRoot() {
        return root;
    }

    
    
}
