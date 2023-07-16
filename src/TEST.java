/*
 * A RegularVendo holds the eight (8) item slots available for purchase. 
 */

import java.util.ArrayList;

public class TEST {
    //item array 
    private ArrayList<ArrayList<Item>> item = new ArrayList<>();



/*
 * adds an item to an item array
 * @param product an item object to be added
 */

    public boolean addItem(ArrayList<Item> product) {

        if (item.size() != 8) {
               item.add(product);
               return true;
        }   
       return false;
    }

/*
 * removes an item in the item array
 * @param slot the slot number of the item to be removed
 */

    public boolean removeItem(int slot) {

      //TODO
    
        return false;
    }

/*
 * returns the item chosen by the user 
 * @return the item chosen by the user 
 */

    public Item[] getItems() {
        
        //TODO
        
        return null;
    }

/*
 * returns the number of items restocked or replaced 
 * @param quantity the number of items added
 * @param item the specific item added 
 */

    public void restockItem(int quantity, Item item) {

       //TODO
    }

/*
 * sets the price for a chosen item 
 * @param price the price of the item 
 * @param slot the occupied slot of an item 
 */

    public void setItemPrice(int price, int slot) {

        //TODO
    }

/* 
 * returns the item selected 
 * @param slot the slot of the selected item 
 * @return the item select 
 */

    public ArrayList<Item> getItem(int slot) {
        
        return item.get(slot);
    }

/*
 * returns the price of the selected item 
 * @param slot the slot of the selected item 
 * @return the price of the selected item 
 */

    public int getItemPrice(int slot) {
        //TODO
        return 0;
    }
  
/* 
 * returns the item dispensed to the user 
 * @param slot the slot of the selected item 
 * @param quantity of the selected item 
 * @return the item dispensed to the user 
 */

    public Item dispenseItem(int slot, int quantity) {

        //TODO
        
        return null;
    }

}
