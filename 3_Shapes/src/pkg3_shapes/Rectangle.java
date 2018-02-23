/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_shapes;

import java.util.Locale;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class Rectangle implements Shape{
    
    private double x;
    private double y;
    private final double height;
    private final double width;

    public Rectangle(double x, double y, double height, double width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public double getLeftBorder() {
        return this.x;
    }

    @Override
    public double getRightBorder() {
        return this.x + this.width;
    }

    @Override
    public double getTopBorder() {
        return this.y + this.height;
    }

    @Override
    public double getBottomBorder() {
        return this.y;
    }

    @Override
    public double getArea() {
        return this.width * this.height;
    }

    @Override
    public void moveTo(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }
    
    @Override
    public String toString(){
        return String.format(Locale.US, "Rectangle height=%.2f, width=%.2f, bottom left corner at (%.2f,%.2f), area=%.2f", 
                this.height, this.width, this.x, this.y, getArea());
    }

    
    
    
}
