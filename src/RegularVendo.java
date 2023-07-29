/*
 * A RegularVendo holds the eight (8) item slots available for purchase. 
 */

import java.util.*;

public class RegularVendo extends VendingMachine{

    //can hold item instances
    protected static Item[] slotsItem = new Item[8]; //accepts ArrayList of Item
    protected static Record records[] = new Record[10];

    //TODO    

    public static void setRecords(Record[] records) {
        RegularVendo.records = records;
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

    public void setSlot(int slot, Item item) {
        slotsItem[slot] = item;
    }

    public static Item[] getSlotsItem() {
        return slotsItem;
    }
}
