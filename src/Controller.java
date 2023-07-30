


public class Controller {
    
    RegularVendo regular = new RegularVendo();
    SpecialVendo special = new SpecialVendo();
    int[] slots = new int[8];
    
    public void addItem(int slot, int index) { 
        
        if (index != -1)
            RegularVendo.slotsItem[slot] = VendingMachine.sellableItems[index];

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
    
        VendingMachine.sellableItems[slot].addStock(quantity, VendingMachine.sellableItems[slot]);
    }

/* 
 * sets item price  
 * @param price the set price for the selected item 
 * @param slot the slot of the item selected 
 */
    public void setSellabeItemPrice(int price, int slot){

        VendingMachine.sellableItems[slot].setPrice(price);
    
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

    public void restockNonSellable (int quantity) {

        //TODO

    }

    public void restockSpecialItems (int quantity) {

        //TODO

    }
}
