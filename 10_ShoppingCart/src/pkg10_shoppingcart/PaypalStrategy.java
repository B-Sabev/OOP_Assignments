package pkg10_shoppingcart;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
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
    
}
