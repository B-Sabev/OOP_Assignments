package qtrees;

import java.io.IOException;
import java.io.StringReader;
import java.nio.CharBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Qtrees {

    public static void main(String[] args) throws IOException {
        String test_tekst = "10011010001010010001010101100011000101000000";
        StringReader input = new StringReader(test_tekst);
        // Make QTree from reader and fill bitmap with it
        QTree qt = new QTree( input );
        Bitmap bitmap = new Bitmap(8);
        qt.fillBitmap( bitmap );
        System.out.println(bitmap.toString());
        
        
        // Make QTree from bitmap
        QTree qtFromBit = new QTree( bitmap );
        Bitmap bm = new Bitmap(8);
        qtFromBit.fillBitmap( bm );
        System.out.println("\n"+bm.toString());  // this should be the same as the previous bitmap
        
        /*
        Implement the QTNode interface
            - BlackLeaf, WhiteLeaf, GrayNode
        
        (1) as a bitmap, (2) as a quad tree and (3) string of 1s and 0s.
        implement conversions between ( (1) <-> (3) is already defined ): 
            -  (1) -> (2), (2) -> (1)
            -  (2) -> (3), (3) -> (2)
        
        Add student names and numbers in every file
        */
    }

}
