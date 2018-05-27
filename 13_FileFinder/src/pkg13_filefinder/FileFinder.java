package pkg13_filefinder;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 * adapted from: pieterkoopman
 */
public class FileFinder implements Runnable {
    private final File rootDir;
    private final String fileName;
    
    public FileFinder(String root) throws IOException {
//        Thread t1 = new Thread(new FileFinder(root));
//        t1.start();
        rootDir = new File(root);
        if (!(rootDir.exists() && rootDir.isDirectory())) {
            throw new IOException(root + " is not a directory");
        }
        this.fileName = "FileFinder.java";
    }
    
    public void findFile(String file) throws IOException {
        //find(rootDir, file);
        run();
    }
    
    private void find (File rootDir, String fileName) throws IOException {
        File [] files = rootDir.listFiles();
        if (files != null) {
            for (File file: files) {
                if (file.getName().equals(fileName)) {
                    System.out.println("Found at: " + file.getAbsolutePath());
                    return;
                } else if (file.isDirectory()) {
                    Thread t1 = new Thread(new FileFinder(file.getAbsolutePath())); 
                    new Thread(t1).start();
                    //t1.start();
                    //find(file, fileName);                                       //Replace
                    //run();
                }
            }
        }
    }
//Your task is to speed-up the search for a file by creating a new searching thread for each directory encountered.
//In the code above you have to replace the recursive call find(file, fileName) by the creation of a
//thread that tries to find the file fileName in the directory file.
    @Override
    public void run() {
        try {
            find(rootDir, fileName);
            //findFile(fileName);
        } catch (IOException ex) {
            Logger.getLogger(FileFinder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
