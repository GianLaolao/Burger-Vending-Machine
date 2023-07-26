/*
 * A RegularVendo holds the eight (8) item slots available for purchase. 
 */

import java.util.*;

public class RegularVendo extends VendingMachine{

    //can hold item instances
    protected static Item itemStock[] = new Item[8]; //accepts ArrayList of Item
    protected static Record records[] = new Record[8];

    //TODO
    public Item dispenseItem(int slot) {


        return itemStock[0].get(0);
    }

    


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

    public int getTotalSales() {

        int totalSales = 0;
        for(int i = 0; i < records.length; i++) {
            totalSales += (records[i].getSoldAmount());
        }

        return totalSales;
    }
}
