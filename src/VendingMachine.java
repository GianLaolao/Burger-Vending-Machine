
/*
 * A VendingMachine represents the vending machine. It contains the regular vending machine, 
 * records, vending machine money, user money, and total sales. 
 */

public class VendingMachine {
    
    //can be changed to Items

    protected static MoneyCalc moneyCalc = new MoneyCalc();
    RegularVendo regular = new RegularVendo();
    SpecialVendo special = new SpecialVendo();

    
    public void addItem(int slot, int index) { 
        
        if (index != -1)
            RegularVendo.slotsItem[slot] = RegularVendo.sellableItems[index];

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

    public Item dispenseItem(int slot) {

        // Item bought; 

        // bought = RegularVendo.itemStock[slot].get(0);
      
        // RegularVendo.itemStock[slot].remove(0);

        return null;
    }

    public int getTotalSales() {

        int totalSales = 0;
        for(int i = 0; i < RegularVendo.sellableRecords.length; i++) {
            totalSales += RegularVendo.sellableRecords[i].getSoldAmount();
        }
        
        return totalSales;
    }

    public Item[] getOrder(int[] order) {

        //TODO

        return null;
    }

    public void restockNonSellable (int quantity, int slot) {

        SpecialVendo.nonSellableItems[slot].addStock(quantity, SpecialVendo.nonSellableItems[slot]);

    }

    public void restockSpecialItems (int quantity) {

        //TODO

    }
}
    




   
   
    
    
