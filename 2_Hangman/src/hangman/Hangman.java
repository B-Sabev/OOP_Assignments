package hangman;

/**
 *
 * @author Borislav
 */
public class Hangman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // absolute path to the words.txt file, change if needed
        String fileName = "C:/Users/Borislav/GoogleDrive/Radboud/OOP/Exercises/2_Hangman/src/hangman/words.txt";
        WordReader reader = new WordReader(fileName);
        
        // start new game of hangman
        Gallows gallows = new Gallows(reader.getWord());
        
        /*
        ask user for input
        guess 
        update game state
        print message
        */
      
        
        
        
        
        
    }
    
}
