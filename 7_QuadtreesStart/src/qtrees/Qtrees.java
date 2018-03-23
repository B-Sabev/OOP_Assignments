package qtrees;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;


/**
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */

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
        
        Writer output = new StringWriter();
        qt.writeQTree(output);
        System.out.println(output.toString());
        System.out.println(test_tekst);
        
    }

}
