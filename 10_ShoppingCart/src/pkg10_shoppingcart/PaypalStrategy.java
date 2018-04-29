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
public class PaypalStrategy implements Payment {
    
    public String email;
    public String password;
    
    public PaypalStrategy(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    @Override
    public boolean pay(double amount) {
        System.out.println(amount + " paid with PayPal.");
        return true;
    }

    @Override
    public String changePaymentMethod(String paymentMethod) {
        paymentMethod = "PayPal";
        return paymentMethod;
    }
    
}
