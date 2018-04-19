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
interface FormVisitor {

    // instead of void, return a generic evaluating the form
    void visit( BinOpForm form );
    void visit( NotForm form);
    void visit( AtomForm form);
    void visit( ConstForm form);
}
