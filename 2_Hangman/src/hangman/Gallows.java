/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

/**
 *
 * @author Borislav
 */
public class Gallows {
    private String word;
    private StringBuilder userGuess;
    private int numTried;
    private GameState gameState;
    private final int TOTAL_GUESSES = 10;

    

    public Gallows(String word) {
        this.word = word;
        this.userGuess = new StringBuilder(this.word.length());
        for(int i=0;i<this.word.length();i++)
            this.userGuess.append(".");
        this.numTried = 0;
    }
    
    /**
     * Takes a guessed letter and updates userGuess 
     * @param letter guessed letter
     */
    public void guess(char letter){
        int index = this.word.indexOf(letter); // find index of the letter
        while (index >= 0) {
            this.userGuess.setCharAt(index, letter); // update the Guess if letter is found
            index = this.word.indexOf(letter, index + 1); // repeat until no more matches
        }       
    }
    
    public void updateGameState(){
        if(this.numTried <= this.TOTAL_GUESSES){
            if(this.word.equals(this.userGuess.toString()))
                gameState = GameState.WIN;
            else
                gameState = GameState.TRY_AGAIN;
        } else {
            gameState = GameState.LOSE;
        }
    }
    
    
    // Setters and getters
    
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
        this.userGuess = new StringBuilder(this.word.length());
        for(int i=0;i<this.word.length();i++)
            this.userGuess.append(".");
    }

    public int getNumTried() {
        return numTried;
    }
    
    public StringBuilder getUserGuess() {
        return userGuess;
    }
}
