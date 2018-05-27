package pkg13_filefinder2;

import java.io.IOException;

/**
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 * adapted from: pieterkoopman
 */
public class FileFinderTest {

    public static void main(String[] args) {
        testFileFinder();
    }
        
    /**
     * Test the FileFinder class
     * print the path of a filename, starting for directory root
     */
    public static void testFileFinder() {
        try {
            String filename = "FileFinder.java";
            //String root = "C://";
            String root = "/Users/Borislav/GoogleDrive/Radboud";
            FileFinder ff = new FileFinder(root, filename);
            ff.findFile();
            ff.setFileName("FileFinderTest.java");
            ff.findFile();
        } catch (IOException e) {
        }
    }
}