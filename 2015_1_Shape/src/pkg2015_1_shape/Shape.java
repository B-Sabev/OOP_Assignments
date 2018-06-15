/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2015_1_shape;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Borislav
 */
public abstract class Shape {
    private static final int START_X = 0, START_Y = 0, START_W = 100, START_H = 100;
    
    public final void draw (Graphics g) {
        g.setColor (getFillColor ());
        fill (g, getX (), getY (), getW (), getH ());
        g.setColor (Color.BLACK);
        draw (g, getX (), getY (), getW (), getH ());
    }
    
    public Color getFillColor () {return Color.LIGHT_GRAY; }
    public int getX () {return START_X; }
    public int getY () {return START_Y; }
    public int getW () {return START_W; }
    public int getH () {return START_H; }
    public abstract void draw (Graphics g, int x, int y, int w, int h);
    public abstract void fill (Graphics g, int x, int y, int w, int h);
} 
