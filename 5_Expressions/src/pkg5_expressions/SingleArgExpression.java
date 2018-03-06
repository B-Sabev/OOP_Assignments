/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg5_expressions;

/**
 *
 * @author Borislav
 */
public abstract class SingleArgExpression extends Expression{
    
    private Expression arg;

    public SingleArgExpression(Expression e) {
        this.arg = e;
    }

    public Expression getArg() {
        return arg;
    }

    public void setArg(Expression arg) {
        this.arg = arg;
    }
    
    
}
