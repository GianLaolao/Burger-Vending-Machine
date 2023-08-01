
import java.util.*;

/*
 * A VendingMachine represents the vending machine. It contains the regular vending machine, 
 * records, vending machine money, user money, and total sales. 
 */

public class VendingMachine {
    
    //can be changed to Items

    private MoneyCalc moneyCalc = new MoneyCalc();
    private RegularVendo regular = new RegularVendo();
    private SpecialVendo special = new SpecialVendo();

    
    public void addItem(int slot, int index) { 
        
        if (index != -1)
            regular.getSlotsItem()[slot] = RegularVendo.sellableItems[index];

    }

// /* 
//  * removes item from the vending machine 
//  * @param slot the slot occupied by the item being removed 
//  */
//     public boolean removeItem(int slot) { 

        //not need i think

//         return false;
//     }

/* 
 * restocks or replaces item of the inventory or vending machine 
 * @param quantity the quantity of item to be restocked  
 * @param slot the slot to be occupied for restocking 
 */
    public void restockSellable(int quantity, int slot) {
    
        RegularVendo.sellableItems[slot].addStock(quantity, RegularVendo.sellableItems[slot]);
    }

    public void restockNonSellable (int quantity, int slot) {

        SpecialVendo.nonSellableItems[slot].addStock(quantity, SpecialVendo.nonSellableItems[slot]);

    }

    public boolean restockCreatedItems (int quantity, int slot) {

        return SpecialVendo.createdItems[slot].addStock(quantity, SpecialVendo.createdItems[slot]);
    }

/* 
 * sets item price  
 * @param price the set price for the selected item 
 * @param slot the slot of the item selected 
 */
    public void setSellabeItemPrice(int price, int slot){

        RegularVendo.sellableItems[slot].setPrice(price);
    
    }

    public void setNonSellabeItemPrice(int price, int slot){

        SpecialVendo.nonSellableItems[slot].setPrice(price);
    }

    public void setCreatedItemPrice(int price, int slot){

        SpecialVendo.createdItems[slot].setPrice(price);
    }

    public void dispenseItem(ArrayList<Item> items) {

        // Item bought; 

        // bought = RegularVendo.itemStock[slot].get(0);
      
        // RegularVendo.itemStock[slot].remove(0);

    }

    // public int getTotalSales() {

    //     int totalSales = 0;
    //     for(int i = 0; i < regular.getSellableRecords().length; i++) {
    //         totalSales += RegularVendo.sellableRecords[i].getSoldAmount();
    //     }
        
    //     return totalSales;
    // }

    public Item[] getOrder(int[] order) {

        //TODO

        return null;
    }

    public MoneyCalc getMoneyCalc() {
        return moneyCalc;
    }

    public RegularVendo getRegular() {
        return regular;
    }

    public SpecialVendo getSpecial() {
        return special;
    }

    
}
    




   
   
    
    
