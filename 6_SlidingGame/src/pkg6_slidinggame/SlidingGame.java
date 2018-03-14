package pkg6_slidinggame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * A template implementation of a sliding game 
 * implementing the Graph interface
 * 
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 * modified the provided code written by:
 * author Pieter Koopman, Sjaak Smetsers
 * @version 1.3
 * @date 07-03-2016
 * 
 */
public class SlidingGame implements Configuration {

    public static final int N = 3, SIZE = N * N, HOLE = SIZE;
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
    
    
    // CLEAN-UP methods from here...
    
    
    
    public int[][] getBoard() {
        return board;
    }
  
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
    
    public boolean isValidMove(Direction dir){
        int x = holeX + dir.GetDX();
        int y = holeY + dir.GetDY();
        return x >= 0 && x < N && y >= 0 && y < N;
    }
    
    public int[][] copyBoard(){
        int[][] copy = new int[N][N];
        for (int row = 0; row < N; row++) 
            for (int col = 0; col < N; col++) 
                copy[row][col] = this.board[row][col];
        return copy;
    }   
    
     // plays the move and returns an array as the start format
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
                buf.append(puzzel == HOLE ? "  " : puzzel + " ");
            }
            buf.append("\n");
        }
        return buf.toString();
    }

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
                if(board[row][col] != 3*col+row+1)
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
        List<Configuration> path;
        if(this.parent.parent() == null){
            // base case, parent is root
            path = new ArrayList<>();
        } else {
            // get the parent's path
            path = this.parent.pathFromRoot();
        }
        path.add(this.parent);
        return path;
    }
    
    
    
    @Override
     public int eval() {
        int num, dist, total_dist=0;
        int solve_row, solve_col;
        for(int row=0; row<N; row++){
            for(int col=0;col<N;col++){
                num = this.board[row][col];
                solve_row = (num-1) % 3; // get the position the number should be in
                solve_col = (num-1) / 3;
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
    
    
    @Override
    public int hashCode(){
        // implement the hashCode
        return 0;
    }

}
