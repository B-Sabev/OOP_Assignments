/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qtrees;

import java.io.Writer;

/**
 *
 * @author Borislav
 */
public class GrayNode implements QTNode{
    
    public static final int MAX_CHILDREN = 4;
    private final QTNode[] children;
    private int numChildren;
    

    public GrayNode(QTNode[] children) {
        this.children = children;
        this.numChildren = 0;
    }

    public GrayNode() {
        this.children = new QTNode[MAX_CHILDREN];
    }
    
    public QTNode[] getChildren(){
        return this.children;
    }
    
    public void addChild(QTNode child){
        if(numChildren < MAX_CHILDREN){
            children[numChildren] = child;
            numChildren++;
        }       
    }
    
    @Override
    public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
        this.children[0].fillBitmap(x,y,width/2,bitmap);
        this.children[1].fillBitmap(x + width/2,y,width/2,bitmap);
        this.children[2].fillBitmap(x + width/2,y + width/2,width/2,bitmap);
        this.children[3].fillBitmap(x,y + width/2,width/2,bitmap);
    }

    @Override
    public void writeNode(Writer out) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
