package pkg13_filefinder;

import java.io.IOException;

/**
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 * adapted from: pieterkoopman
 */
public class FileFinderTest1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //OO15FileFinderTest fft = new OO15FileFinderTest();
         FileFinderTest1();
    }

    public static void FileFinderTest1() {
        try {
            String goal = "FileFinder.java";
            //String root = "C://";
            //String root = "/Users/Austin/Documents";
            String root = "/Users/Borislav/GoogleDrive/Radboud";
            FileFinder ff = new FileFinder(root);
            //FileFinder f2 = new FileFinder(root);
            //Thread t1 = new Thread(ff);
            //t1.start();
//            FileFinderSeq ff = new FileFinderSeq(root);
            ff.findFile(goal);
            //f2.findFile(goal);
//            System.out.println(goal + " not found");
        } catch (IOException e) {
            //System.err.println( e );
            e.printStackTrace();
        }
    }
    /*
    public OO15FileFinderTest() {
        try {
            String goal = "FileFinderSeq.java";
            FileFinderSeq ff = new FileFinderSeq("/Users/pieterkoopman/Documents/onderwijs/OO/OO 2015/OO 2015 projects");
            File file = ff.findFile(goal);
            if (file != null) {
                System.out.println("found: " + file.getAbsolutePath());
            } else {
                System.out.println(goal + " not found.");
            }
        } catch (IOException e) {
            System.err.println( e );
        }
    }
    
    
        public FileFinderTest() {
        try {
            String goal = "FileFinder.java";
            String root = "/Users/pieterkoopman/Documents";
            FileFinder ff = new FileFinder(root);
//            FileFinderSeq ff = new FileFinderSeq(root);
            ff.findFile(goal);
//            System.out.println(goal + " not found");
        } catch (IOException e) {
            //System.err.println( e );
            e.printStackTrace();
        }
    }
*/
}
