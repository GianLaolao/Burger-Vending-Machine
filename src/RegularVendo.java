/*
 * A RegularVendo holds the eight (8) item slots available for purchase. 
 */

import java.util.*;

public class RegularVendo extends VendingMachine{

    //can hold item instances
    protected static ArrayList<ArrayList<Item>> itemStock = new ArrayList<>(); //accepts ArrayList of Item
    protected static Record records[] = new Record[10];

    //TODO    

    public Record[] getRecords() {
        return records; //returns the vending machine records
    }

    /* 
     * returns the records of an item 
     * @param 
     */
    public Record getItemRecord(int slot) {
        return records[slot];
    }

    public static ArrayList<ArrayList<Item>> getItemStock() {
        return itemStock;
    }
}
