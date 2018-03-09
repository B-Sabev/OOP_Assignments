/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg5_expressions;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public abstract class SingleArgExpression extends Expression{
    
    private Expression arg;

    protected SingleArgExpression(Expression e) {
        super();
        this.arg = e;
    }
    
    @Override
    public boolean isReducable(){
        return this.arg.isReducable();
    }

    public Expression getArg() {
        return arg;
    }

    public void setArg(Expression arg) {
        this.arg = arg;
    }
}
