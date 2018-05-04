/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg10_shoppingcart;

/**
 *
 * @author Austin
 */
public class CreditCardStrategy implements Payment {

    public String cardNum;
    public String expiration;
    
    public CreditCardStrategy(String cardNum, String exp) {
        this.cardNum = cardNum;
        this.expiration = exp;
    }
    
    @Override
    public boolean pay(double amount) {
        System.out.println(amount + " paid with a Credit Card.");
        return true;
    }
  
}
