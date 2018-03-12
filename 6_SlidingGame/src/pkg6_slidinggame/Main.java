/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg6_slidinggame;

/**
 *
 * @author Borislav
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] start = {4,9,7,2,1,8,3,6,5};
        
        SlidingGame game = new SlidingGame(start);
        System.out.println(game.toString());
        
        System.out.println(game.isSolution());
        
        Move[] moves = Move.getMoves();
        for(int i=0; i<4; i++){
            System.out.println("Move " + moves[i] + " is " + game.isValidMove(moves[i]));
        }
    }
    
}
