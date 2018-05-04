package pkg10_shoppingcart;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class TestShopping {
    
    
    public void showTest(){
         ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Watermelon());
        cart.addItem(new Watermelon());
        cart.addItem(new WashingMachine());
        cart.addItem(new Wineglasses());
        cart.checkOut(); 
        cart.changePaymentMethod( new CreditCardStrategy("999-999-999",
                                                         "30-12-2020") );
        cart.checkOut(); // check out second time - no amount to pay because no new items are added
        // add more items
        cart.addItem(new Watermelon());
        cart.addItem(new WashingMachine());
        cart.addItem(new Wineglasses());
        cart.checkOut(); // now pay again onew less watermelon -4.5, shipping cost doesn't change
    }
}
