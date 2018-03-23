/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qtrees;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/**
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class View {
    
    public static void demo(){
        readWriteQTree(); // quad tree to string and string to quad tree
        System.out.println("\n\n\n");
        bitmapToQTreeAndBack(); // bitmap to quad tree and quad tree to bitmap
    }

    public static void readWriteQTree() {
        String test_str = "10011010001010010001010101100011000101000000";
        StringReader input = new StringReader(test_str);
        Writer output = new StringWriter();
        
        // Make QTree from the reader and write it on the writer
        QTree qt = new QTree( input );
        qt.writeQTree(output);
        
        // Show result
        System.out.println("Test string to create tree      " + test_str);
        System.out.println("String written from tree        " + output.toString());
        System.out.println("Read and write strings  are equal: " + test_str.equals(output.toString()));
    }

    public static void bitmapToQTreeAndBack() {
        // Create example tree
        String test_str = "10011010001010010001010101100011000101000000";
        StringReader input = new StringReader(test_str);
        QTree qt = new QTree( input );
        // convert tree to bitmap
        Bitmap bitmap = new Bitmap(8);
        qt.fillBitmap( bitmap );
        // create and new tree from bitmap
        QTree qt2 = new QTree( bitmap );
        // fill bitmap2 from the new tree
        Bitmap bitmap2 = new Bitmap(8);
        qt2.fillBitmap( bitmap2 );
        // compare both bitmaps
        
        System.out.println("Bitmap from sample tree:\n" + bitmap.toString());
        System.out.println("Bitmap from tree initialized with the previous bitmap:\n" + bitmap2.toString());
        System.out.println("Both bitmaps look the same: " + bitmap.toString().equals(bitmap2.toString()));
    
    
    }
}
