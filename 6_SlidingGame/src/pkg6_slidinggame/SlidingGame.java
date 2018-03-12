/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg6_slidinggame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Borislav
 */
public class SlidingGame implements Configuration{ 
    
    public static final int N = 3, SIZE = N * N, HOLE = SIZE;
    private int[][] board;
    private int holeX, holeY;
    private Configuration parent;

    public SlidingGame(int[] start) {
        board = new int[N][N];
        fillBoard(start);
        parent = null;
    } 
    
    public SlidingGame(int[] start, Configuration parent) {
        board = new int[N][N];
        fillBoard(start);
        this.parent = parent;
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
    
    public int[] flattenBoard(){
        // Makes this.board as a 1d array, same as start
        int[] flatBoard = new int[N*N];
        int ind = 0;
        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++){
                flatBoard[ind] = this.board[j][i];
                ind++;
            }
        return flatBoard;
    }
    
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++)
                if(i == this.holeY && j == this.holeX)
                    s.append("_ ");
                else 
                    s.append(board[i][j]).append(" ");  
            s.append("\n");
        }
        return s.toString();
    }

    public int[][] getBoard() {
        return board;
    }

    public Configuration getParent() {
        return parent;
    }
    
    
    
    public boolean isValidMove(Move move){
        int[] dxdy = move.toIndex();
        int x = holeX + dxdy[0];
        int y = holeY + dxdy[1];
        return x >= 0 && x < N && y >= 0 && y < N;
    }
    
    // plays the move and returns an array as the start format
    public int[] playMove(Move move){
        int[] flat_board;
        int[] dxdy;
        int oldHoleInd, newHoleInd;
        flat_board = flattenBoard();
        // make the move
        dxdy = move.toIndex();
        oldHoleInd = holeX + N * holeY;
        newHoleInd = holeX + dxdy[0] + N * (holeY + dxdy[1]);

        // swap the 2 values 
        int temp = flat_board[oldHoleInd]; // current hole
        flat_board[oldHoleInd] = flat_board[newHoleInd];
        flat_board[newHoleInd] = temp;
        
        return flat_board;
    }
    
    @Override
    public boolean isSolution() {
        for(int i=0; i<N; i++)
            for(int j=0;j<N;j++)
                if(board[i][j] != 3*i+j+1)
                    return false;
        return true;
    }
    
    @Override
    public Collection<Configuration> successors() {
        Collection<Configuration> successors = new ArrayList<>();
        Move[] moves = Move.getMoves();
        int[] new_start;
        
        for(int i=0; i<moves.length; i++){
            if(isValidMove(moves[i])){
                new_start = playMove(moves[i]);
                successors.add(new SlidingGame(new_start, this));
            }
        }
        return successors;
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
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Arrays.deepHashCode(this.board);
        return hash;
    }

    @Override
    public int compareTo(Configuration o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
