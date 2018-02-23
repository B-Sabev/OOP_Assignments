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
       
        View view = new View();
        view.userInteraction();
        
        
      
    }
    
    public static double[] subset(double[] array, int i1, int i2){
        assert i2 > i1 : "Last index must be bigger than first";
        double[] subarray = new double[i2-i1];
        for(int i=i1;i<i2;i++){
            subarray[i-i1] = array[i];
        }
        return subarray;
        
    }
    
    
    
}
