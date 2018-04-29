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
public interface Payment {
    //public String paymentMethod = "iDeal";
    public abstract boolean pay(double amount);
    public String changePaymentMethod(String paymentMethod);
}
