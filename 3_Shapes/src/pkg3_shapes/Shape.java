/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_shapes;

/**
 *
 * @author Borislav
 */
public interface Shape {
    
    // should i add other methods here?
    double getLeftBorder();
    double getRightBorder();
    double getTopBorder();
    double getBottomBorder();
    double getArea();
    void moveTo(double dx, double dy);
    
}
