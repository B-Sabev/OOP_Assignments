/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class Gallows {
    private String word;
    private String userGuess;
    private int numTried;
    private GameState gameState;
    private final int TOTAL_GUESSES = 10;

    public Gallows(String word) {
        this.word = word;
        this.userGuess = createEmptyWord();
        this.numTried = 0;
        this.gameState = GameState.TRY_AGAIN;
    }
    
    public Gallows(){
        // absolute path to the words.txt file, change if needed
        String fileName = "C:/Users/Borislav/GoogleDrive/Radboud/OOP/Exercises/2_Hangman/src/hangman/words.txt";
        WordReader reader = new WordReader(fileName);
        this.word = reader.getWord();
        this.userGuess = createEmptyWord();
        this.numTried = 0;
        this.gameState = GameState.TRY_AGAIN;
    }
    
    public final String createEmptyWord(){
        StringBuilder userGuessBuild = new StringBuilder(this.word.length());
        for(int i=0;i<this.word.length();i++)
            userGuessBuild.append(".");
        return userGuessBuild.toString();
    }
    
    public void guess(char letter){
        StringBuilder userGuessBuild = new StringBuilder(this.userGuess);
        int index = this.word.indexOf(letter); // find index of the letter
        if(index == -1){ // the guess is not in the word
            this.numTried++;
        }
        while (index >= 0) {
            userGuessBuild.setCharAt(index, letter); // update the Guess if letter is found
            index = this.word.indexOf(letter, index + 1); // repeat until no more matches
        }
        this.userGuess = userGuessBuild.toString();
        updateGameState();
    }
    
    public void updateGameState(){
        if(this.numTried <= this.TOTAL_GUESSES){
            if(this.word.equals(this.userGuess))
                gameState = GameState.WIN;
            else
                gameState = GameState.TRY_AGAIN;
        } else {
            gameState = GameState.LOSE;
        }
    }
    
    
    // getters
    public String getWord() {
        return word;
    }

    public String getUserGuess() {
        return userGuess;
    }

    public int getNumTried() {
        return numTried;
    }

    public GameState getGameState() {
        return gameState;
    }

    public int getTOTAL_GUESSES() {
        return TOTAL_GUESSES;
    }
    
    
 
    
    


}
