package qtrees;

/**
 * Bitmap: A class for representing bitmap;
 * @author Sjaak Smetsers
 * @version 15-03-2016
 */
public class Bitmap {
    // each bit is stored into an two dimensional array
    private final boolean[][] raster;
    private final int size;
    
    /**
     * Creates an empty bitmap of size * size
     * @param size - size of the square map
     */
    public Bitmap( int size ) {
        raster   = new boolean[size][size];
        this.size = size;
    }

    /**
     * Gets a bit at the specified position
     * @param x: x coordinate
     * @param y: y coordinate
     * @return : truth value of the given coordinate
     */
    public boolean getBit( int x, int y ) {
        return raster[x][y];
    }
    
    /**
     * Sets a bit at the specified position
     * @param x: x coordinate
     * @param y: y coordinate
     * @param val: the bit value 
     */
    public void setBit( int x, int y, boolean val ){
        raster[x][y] = val;
    }
    
    /**
     * Converts a bitmap into a string
     * 1 is represented by '*'; 0 by 'O'
     * @return the string representation
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
               sb.append( raster[x][y] ?  '*' : 'O' );
            }
            sb.append( '\n' );
        }
        return sb.toString();
    }

    public int getSize() {
        return size;
    }

 
    /**
     * Fills a square area of a bitmap with value val
     * @param x: x coordinate of upper-left corner
     * @param y: y coordinate of upper-left corner
     * @param size: size of the square
     * @param val: the bit value 
      */
    public void fillArea( int x, int y, int size, boolean val ){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                setBit(x+i, y+j, val);
            }
        }
    }
    
    public boolean isVal( int x, int y, int size, boolean val){
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) 
                if(raster[x+i][y+j] != val)
                    return false;
        return true;
    }
    
    public Bitmap copyPart(int x1, int y1, int size){
        Bitmap map = new Bitmap( size );
        for(int i=0; i<size-x1; i++){
            for(int j=0; j<size-y1; j++){
                map.setBit(i, j, this.getBit(i+x1, j+y1));
            }
        }
        return map;
    }
    

}
