package pkg13_filefinder2;

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
    private String fileName;
    
    public FileFinder(String root, String file) throws IOException {
        rootDir = new File(root);
        if (!(rootDir.exists() && rootDir.isDirectory())) {
            throw new IOException(root + " is not a directory");
        }
        fileName = file;
    }
    
    /**
     * Find a file in the system, initializes a run thread
     * @param file - name of the file
     * @throws IOException 
     */
    public void findFile() throws IOException {
        run();
    }
    
    /**
     * Private method to find a file from a root directory.
     * Called by run(), initializing new thread every time it finds a directory
     * @param rootDir - the initial directory to start searching
     * @param fileName - the name of the file to look for
     * @throws IOException 
     */
    private void find (File rootDir, String fileName) throws IOException {
        File [] files = rootDir.listFiles();
        if (files != null) {
            for (File file: files) {
                if (file.getName().equals(fileName)) {
                    System.out.println("Found at: " + file.getAbsolutePath());
                    return;
                } else if (file.isDirectory()) {
                    Thread t1 = new Thread(new FileFinder(file.getAbsolutePath(), fileName)); 
                    new Thread(t1).start();
                }
            }
        }
    }
    @Override
    public void run() {
        try {
            find(rootDir, fileName);
        } catch (IOException ex) {
            Logger.getLogger(FileFinder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    
    
}
