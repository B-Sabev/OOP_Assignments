package hangman;

import java.util.Scanner;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class Hangman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //TODO
        // does this comply to the model-view way of programming?
        // fill the whole word
        // maybe make stickman
       
        Scanner scan = new Scanner(System.in);
        Gallows gallows = initGallows();
        playHangman(gallows);
        endMessage(gallows.getGameState());
        System.out.println("The word is " + gallows.getWord());
         
    }
    
    public static Gallows initGallows(){
        Scanner scan = new Scanner(System.in);
        String word;
        Gallows gallows;
        System.out.print("Enter word for hangman or leave empty for default word: ");
        word = scan.nextLine();
        if(word.length() == 0){
            gallows = new Gallows();
        } else {
            gallows = new Gallows(word);
        }
        return gallows;
    }
    
    public static void playHangman(Gallows gallows){
        Scanner scan = new Scanner(System.in);
        char letter;
        
        while(gallows.getGameState() == GameState.TRY_AGAIN){
            System.out.println("\nWord is: " + gallows.getUserGuess());
            System.out.printf("Guess a letter(%d tries remaining): ", 
                              gallows.getTOTAL_GUESSES() - gallows.getNumTried());
            letter = scan.next().charAt(0);
            gallows.guess(letter);
        }
    }
    
    public static void endMessage(GameState gameState){
        if(gameState == GameState.LOSE)
            System.out.println("You have been hanged. Better luck next time");
        if(gameState == GameState.WIN)
            System.out.println("Congratulations, you win");
    }
    
}
