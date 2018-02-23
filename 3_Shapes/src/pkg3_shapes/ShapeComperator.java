/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_shapes;

import java.util.Comparator;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class ShapeComperator implements Comparator<Shape>{
    
    public enum SortingMode{ X, Y, Area };
    private SortingMode mode;
    
    public ShapeComperator(SortingMode mode) {
        this.mode = mode;
    }

    public ShapeComperator() {
        this.mode = SortingMode.Area;
    }
    
     /**
     * Compares 2 shapes, comparison based on a private variable mode
     *
     * @param  o1 first shape
     * @param  o2 second shape
     * @return      negative int if o1<o2, 0 if o1==o2, positive int if o1>o2
     */
    @Override
    public int compare(Shape o1, Shape o2) {
        if(this.mode.equals(SortingMode.X))
            return (int) (o1.getLeftBorder() - o2.getLeftBorder());
        if(this.mode.equals(SortingMode.Y))
            return (int) (o1.getBottomBorder() - o2.getBottomBorder());
        return (int) (o1.getArea() - o2.getArea());
    }
    
    public SortingMode getMode() {
        return mode;
    }

    public void setMode(SortingMode mode) {
        this.mode = mode;
    }
    
}
