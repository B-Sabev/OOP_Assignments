/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9_logicalformulas;

/**
 *
 * @author Borislav
 */


public interface Form {
    public void accept ( FormVisitor v); 
    
    /*
    // implement in all concrete classes, or the enum
    public void accpet (FormVisitor v)
        v.visit(this);
    
    */

    /*
    Implement the interface with enum for all operations 
    True
    False
    And
    Or
    ...
    */
}
