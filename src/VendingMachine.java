import java.util.*;

/*
 * A VendingMachine represents the vending machine. It contains the regular vending machine, 
 * records, vending machine money, user money, and total sales. 
 */

public abstract class VendingMachine {
    
    protected static Item sellableItems[] = new Item[10]; //can be changed to Items 
    protected static Item nonSellableItems[] = new Item[8];
    protected static MoneyCalc moneyCalc = new MoneyCalc();


    //TODO



    public static Item[] getSellableItems() {
        return sellableItems;
    }

    public static Item[] getNonSellables() {
        return nonSellableItems;
    }




   
   
    
    
  

    
    

}
