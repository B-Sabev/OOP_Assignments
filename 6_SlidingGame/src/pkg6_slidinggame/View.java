/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg6_slidinggame;

import java.util.Scanner;
import static pkg6_slidinggame.SlidingGame.N;
import static pkg6_slidinggame.SlidingGame.randomGame;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class View {
    
    public static final int HARD_CODED = 1, 
                            RANDOM = 2, 
                            PARSE_INPUT = 3, 
                            QUIT = 4;
    private Scanner scan;

    public View() {
       scan = new Scanner(System.in);
    }

    public void initGame() {
        System.out.println("Welcome to the Sliding Game!");
        Configuration game;
        int choice;
        
        while(true){
            help();
            choice = scan.nextInt();
            switch(choice) {
                case HARD_CODED:     
                    game = getHardCodedGame();
                    showGameSolving(game);
                    break;
                case RANDOM:
                    game = getRandomGame();
                    showGameSolving(game);
                    break;
                case PARSE_INPUT:
                    game = parseGameFromInput();
                    if(game != null)
                        showGameSolving(game);
                    break;
                case QUIT:     
                    System.out.println("Quitting...");
                    System.exit(0);
                    break;
                default:    
                    System.out.println("Please enter a valid choice between 1 and 4");
                    break;
                }
        }
    }
    
    public void help() {
        System.out.print("Select command:\n"
                        +"pre-built boards        (1)\n"
                        +"a random board          (2)\n"
                        +"create your own board   (3)\n"
                        +"quit                    (4)\n");
        System.out.print("> ");
    }

    private Configuration parseGameFromInput() {
        System.out.println("Please enter 1-16 in the order you want them to appear starting from the top left, 16 is for the hole");
        System.out.println("Seperate your numbers with a , (1,2,3,...) : ");
        
        int[] board = new int[N * N];
        // take the user input
        String  nums = scan.next();
        // split by ,
        String[] numbers = nums.trim().split(",");
        if(numbers.length != N*N){ // interrupt if numbers are not the right number
            System.out.println("Numbers should be exactly " + N*N +
                               "Please try again\n");
            return null;
        }
        // parse to int
        for(int i=0; i<numbers.length; i++)
            try{
                board[i] = Integer.parseInt(numbers[i]);
            } catch(Exception e){
                System.out.println("You must enter only numbers, please try again\n");
                return null;
            }
        
        // check if the numbers are valid
        for(int num=0; num<board.length; num++){
            // check if number is in range
            if (board[num] < 0 || board[num] > N*N){
                System.out.println("There is a number too big or too small " +
                                   "\nPlease enter numbers only from 1 to "+N*N);
                return null;
            }
            // check that there are no duplicates
            for(int i=0; i<board.length; i++){
                if(num != i && board[num] == board[i]){
                    System.out.println("No repeating numbers allowed ");
                    return null;
                }
            }
        }
            
        // create new game out of it and return it
        return new SlidingGame(board);
    }
    
    
    public void showGameSolving(Configuration game){
        System.out.println(game.toString());
        Solver solver = new Solver(game);
        
        long time = System.nanoTime();
        Configuration solution = solver.solve();
        if(solution == null){
            System.out.println("The current game cannot be solved."
                            + "\nTime elapsed " + (System.nanoTime() - time) / 1000000 + " ms");
        } else {
            System.out.println("Found path with " + (solution.pathFromRoot().size()-1) + " steps" +
                               "\nTime elapsed " + (System.nanoTime() - time) / 1000000 + " ms" );
            for(Configuration s : solution.pathFromRoot())
                System.out.println(s.toString());
        }
    }

    private Configuration getHardCodedGame() {
        int [] game = {16, 15, 4, 5,
                        1, 10, 13, 11,
                        8, 12, 9, 2,
                        6, 7, 3, 14};
        
        return new SlidingGame(game);
    }

    private Configuration getRandomGame() {
        return SlidingGame.randomGame(SlidingGame.N);
    }
}
