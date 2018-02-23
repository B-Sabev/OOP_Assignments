/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_shapes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import pkg3_shapes.ShapeComperator.SortingMode;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        // Array of shapes
        // asking the user for input
        // performing the action
        
        
        
        Shape[] shapes = {new Circle(4,4,2),
                          new Rectangle(1,2,5,7),
                          new Rectangle(2,1,5,5),
                          new Rectangle(3,0,5,9)
        };
        
        for(Shape sh : shapes){
            System.out.println(sh.toString());
        }
        
        Shape[] subset = Arrays.copyOfRange(shapes, 1, shapes.length);
      
      
        ShapeComperator comperator = new ShapeComperator(SortingMode.Y);
        Arrays.sort(shapes, comperator);

       
    }
    
    
    
}
