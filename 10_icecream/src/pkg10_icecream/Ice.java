package pkg10_icecream;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public abstract class Ice {
        protected String description;
        public abstract int getPrice();
        
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
