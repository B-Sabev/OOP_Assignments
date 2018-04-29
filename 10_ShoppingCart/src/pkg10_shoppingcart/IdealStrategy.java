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
public class IdealStrategy implements Payment {
    
    public String bank;
    public String accNum;
    public String pin;
    
    public IdealStrategy(String bank, String accNum, String pin) {
        this.bank = bank;
        this.accNum = accNum;
        this.pin = pin;
    }
    
    @Override
    public boolean pay(double amount) {
        System.out.println(amount + " paid using iDeal.");
        return true;
    }

    @Override
    public String changePaymentMethod(String paymentMethod) {
        paymentMethod = "iDeal";
        return paymentMethod;
    }
    
}
