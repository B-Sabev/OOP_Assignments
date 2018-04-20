/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9_logicalformulas;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
interface FormVisitor<R>{

    R visit( BinOpForm form );
    R visit( NotForm form);
    R visit( AtomForm form);
    R visit( ConstForm form);
}
