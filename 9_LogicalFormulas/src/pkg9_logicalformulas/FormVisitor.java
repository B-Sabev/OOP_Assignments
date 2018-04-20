package pkg9_logicalformulas;

/**
 * Visitor interface for visiting all realizations of the Form interface
 * 
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
interface FormVisitor<R>{

    R visit( BinOpForm form );
    R visit( NotForm form);
    R visit( AtomForm form);
    R visit( ConstForm form);
}
