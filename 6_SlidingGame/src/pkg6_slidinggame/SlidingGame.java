package pkg6_slidinggame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * A template implementation of a sliding game 
 * implementing the Graph interface
 * 
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 * modified the provided code written by:
 * author Pieter Koopman, Sjaak Smetsers
 * 
 */
public class SlidingGame implements Configuration {


    public static final int N = 4, SIZE = N * N, HOLE = SIZE;
    /**
     * The board is represented by a 2-dimensional array; the position of the
     * hole is kept in 2 variables holeX and holeY
     */
    private int[][] board;
    private int holeX, holeY;
    private Configuration parent;

    /**
     * A constructor that initializes the board with the specified array
     *
     * @param start: a one dimensional array containing the initial board. The
     * elements of start are stored row-wise.
     */
    public SlidingGame(int[] start) {
        board = new int[N][N];
        fillBoard(start);
        parent = null;
    }
    
    /**
     * A constructor that initializes the board with the specified array
     *  and initializes the parent of the configuration 
     *
     * @param start: a one dimensional array containing the initial board. The
     * elements of start are stored row-wise.
     * @param parent: a parent Configuration of the current configuration
     */
    public SlidingGame(int[] start, Configuration parent) {
        board = new int[N][N];
        fillBoard(start);
        this.parent = parent;
    }
    
    public int[][] getBoard() {
        return board;
    }
  
    /**
     * Fill this.board with a 1d array, used only in the constructor
     * @param start - 1d array of numbers 1 to N*N
     */
    public final void fillBoard(int[] start){
        assert start.length == N * N : "Length of specified board incorrect";
        for (int p = 0; p < start.length; p++) {
            board[p % N][p / N] = start[p];
            if (start[p] == HOLE) {
                holeX = p % N;
                holeY = p / N;
            }
        }
    }
    
    /**
     * From a 2d board, transform to its 1d representation
     * flattenBoard(this.board) == start if fillBoard(start) called at the constructor
     * @param b - 2d board
     * @return - 1d representation of the board
     */
    public static int[] flattenBoard(int[][] b){
        int[] flat = new int[N*N];
        int i = 0;
        
        for (int col = 0; col < N; col++) 
            for (int row = 0; row < N; row++){
                flat[i] = b[row][col];
                i++;
            }
        return flat;            
    }

    
    /**
     * Check if the given direction for moving the blank space is a valid move
     * @param dir - the direction in which to move the hole
     * @return - boolean true if the move is valid
     */
    public boolean isValidMove(Direction dir){
        int x = holeX + dir.GetDX();
        int y = holeY + dir.GetDY();
        return x >= 0 && x < N && y >= 0 && y < N;
    }
    
    /**
     * Make a copy of this.board
     * @return - copy of the board
     */
    public int[][] copyBoard(){
        int[][] copy = new int[N][N];
        for (int row = 0; row < N; row++) 
            for (int col = 0; col < N; col++) 
                copy[row][col] = this.board[row][col];
        return copy;
    }   
    
    /**
     * Play the move and return the resulting board
     * @param dir - direction in which to move the empty space
     * @return - updated 2d board
     */
    public int[][] moveDir(Direction dir){
        // get new indecies
        int nextHoleX = this.holeX + dir.GetDX();
        int nextHoleY = this.holeY + dir.GetDY();
        int[][] nextBoard = copyBoard();
        // swap the 2 values 
        int temp = nextBoard[nextHoleX][nextHoleY];
        nextBoard[nextHoleX][nextHoleY] = nextBoard[holeX][holeY];
        nextBoard[holeX][holeY] = temp; 
        return nextBoard;
    }

    /**
     * Converts a board into a printable representation. The hole is displayed
     * as a space
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                int puzzel = board[col][row];
                if(puzzel == HOLE)
                    buf.append("   ");
                else if(puzzel < 10)
                    buf.append(puzzel).append("  ");
                else 
                    buf.append(puzzel).append(" ");
            }
            buf.append("\n");
        }
        return buf.toString();
    }
    
    
    // TODO clean up methods from here
    
    @Override
    public boolean equals(Object o) {
        if(o.getClass() == this.getClass()){
            SlidingGame g = (SlidingGame) o;
            for(int i=0; i<N; i++)
                for(int j=0; j<N; j++)
                    if(g.getBoard()[i][j] != this.board[i][j])
                        return false;
            return true; // only if the same class and in board all elements are the same
        }
        return false;
    }

    @Override
    public boolean isSolution() {
        for(int row=0; row<N; row++)
            for(int col=0;col<N;col++)
                if(board[row][col] != N*col+row+1)
                    return false;       
        return true;
    }

    @Override
    public Collection<Configuration> successors() {
        Collection<Configuration> successors = new ArrayList<>();
        Direction[] dirs = Direction.getAllDirs();
        int[] new_start;
        
        for(int i=0; i<dirs.length; i++){
            if(isValidMove(dirs[i])){
                new_start = flattenBoard(moveDir(dirs[i]));
                successors.add(new SlidingGame(new_start, this));
            }
        }
        return successors;
    }

    @Override
    public int compareTo(Configuration g) {
        return this.eval() - g.eval();
    }

    @Override
    public Configuration parent() {
        return this.parent;
    }
    
    @Override
    public List<Configuration> pathFromRoot() {
        List<Configuration> path = new ArrayList<>();
        
        if(this.parent == null){
            // base case, this is root
        } else if(this.parent.parent() == null){
            // base case, if parent is root
            path.add(this.parent);
        } else {
            // get the path of the parent
            path = this.parent.pathFromRoot();
        }
        path.add(this);
        return path;
    }
    
    /**
     *
     * @return
     */
    @Override
     public int eval() {
        int num, dist, total_dist=0;
        int solve_row, solve_col;
        for(int row=0; row<N; row++){
            for(int col=0;col<N;col++){
                num = this.board[row][col];
                solve_row = (num-1) % N; // get the position the number should be in
                solve_col = (num-1) / N;
                dist = manhattanDist(row,col,solve_row,solve_col); // compute dist
                total_dist += dist;   
            }
        }
        return total_dist;
    }

    private static int manhattanDist(int x1, int y1, int x2, int y2) {
        // compute the manhattan dist 
        return Math.abs(x1-x2) + Math.abs(y1-y2); 
    }
    
    /**
     *
     * @param N
     * @return
     */
    public static SlidingGame randomGame(int N){
        ArrayList<Integer> board = new ArrayList<>();
        for(int i=1;i<=N*N;i++)
            board.add(i);
        // shuffle the filled board
        Collections.shuffle(board);
        
        // covert arrayList of Integers into array of int
        int[] board_arr = new int[board.size()]; 
        for(int i=0;i<board.size();i++)
            board_arr[i] = (int) board.get(i);
        
        // init a SlidingGame with the board
        return new SlidingGame(board_arr);
    }
    
    
    @Override
    public int hashCode(){
        // implement the hashCode
        int code = 0;
        for(int x=N-1; x>=0; x--)
            for(int y=N-1; y>=0; y--)
                code = 31*code + board[x][y];
        return code;
    }
    
    
        
    /**
     * UNDER DEVELOPMENT, DOESN'T WORK PROPERLY
     * Check if the current sliding puzzle is solvable using the parity argument
     * @return boolean true if solvable
     */
    public boolean isSolvable(){
        int[] b = flattenBoard(this.board);
        int inversions = 0;
        
        
        for (int x = 0; x < b.length; x++) 
            for (int y = 0; y < b.length; y++){
                // an inversion is a pair of tiles (x,y) such that x appears before y, but a>b
                if(x < y && b[x] > b[y] && b[x] != N*N)
                    inversions++;
            }
        
        
        
        /*
        If the grid width is odd, then the number of inversions in a solvable situation is even.
        If the grid width is even, and the blank is on an even row counting from the bottom (second-last, fourth-last etc), 
            then the number of inversions in a solvable situation is odd.
        If the grid width is even, and the blank is on an odd row counting from the bottom (last, third-last, fifth-last etc) 
            then the number of inversions in a solvable situation is even.
        */
        System.out.println("Number of inversions is " + inversions);
        boolean gridWidthIsOdd = N % 2 == 1;
        boolean invAreOdd = inversions % 2 == 1;
        boolean blankOnOddRow = holeX % 2 == 0; // counting from bottom

        
        
        
        return      ((gridWidthIsOdd && !invAreOdd) 
                || 
                        (!gridWidthIsOdd 
                    && 
                            ((blankOnOddRow && !invAreOdd) 
                        || 
                            (!blankOnOddRow && invAreOdd))));
    }

}
