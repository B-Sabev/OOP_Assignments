/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg10_icecream;

/**
 *
 * @author Borislav
 */
public abstract class Ice {
        protected String description;
        public abstract int getPrice();
        
        // default constructor with default description
        public Ice(){
            this.description = "unknown ice";
        }
        
        public String getDescription(){
            return description;
        }
        
        public String toString(){
            int euro = getPrice() / 100;
            int cents = getPrice() % 100;
            return String.format("Description: " + getDescription() + "\n" +
                                 "price: %d,%d euro",euro, cents);
        }
}
