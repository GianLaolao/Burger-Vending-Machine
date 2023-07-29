import java.util.*;

/*
 * A VendingMachine represents the vending machine. It contains the regular vending machine, 
 * records, vending machine money, user money, and total sales. 
 */

public abstract class VendingMachine {
    
    protected static Item sellableInfos[] = new Item[10]; //can be changed to Items 
    protected static Item nonSellableInfos[] = new Item[8];
    protected static MoneyCalc moneyCalc = new MoneyCalc();


    //TODO



    public boolean addItem(int quantity, int type) { 
        
        

        return false;
    }

/* 
 * removes item from the vending machine 
 * @param slot the slot occupied by the item being removed 
 */

    public boolean removeItem(int slot) { 

        

        return false;
    }

/* 
 * restocks or replaces item of the inventory or vending machine 
 * @param quantity the quantity of item to be restocked  
 * @param slot the slot to be occupied for restocking 
 */

    public boolean restockItem(int quantity, int slot) {
    
        //TODO
    
        return false;
    }

/* 
 * sets item price  
 * @param price the set price for the selected item 
 * @param slot the slot of the item selected 
 */

    public boolean setItemPrice(int price, int slot){

       //TODO
           
        return false;
    }

    public static Item[] getSellableInfos() {
        return sellableInfos;
    }

    public static Item[] getNonSellable() {
        return nonSellableInfos;
    }




   
   
    
    
  

    
    

}
