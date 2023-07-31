/*
 * A RegularVendo holds the eight (8) item slots available for purchase. 
 */

public class RegularVendo{

    //can hold item instances
    protected static Item sellableItems[] = new Item[10]; 
    protected static Record sellableRecords[] = new Record[10];
    protected static Item[] slotsItem = new Item[8]; //accepts ArrayList of Item

    //TODO    

    public static void setRecords(Record[] records) {
        RegularVendo.sellableRecords = records;
    }

    public Record[] getRecords() {
        return sellableRecords; //returns the vending machine records
    }

    /* 
     * returns the records of an item 
     * @param 
     */
    public Record getItemRecord(int slot) {
        return sellableRecords[slot];
    }

    public void setSlot(int slot, Item item) {
        slotsItem[slot] = item;
    }

    public static Item[] getSlotsItem() {
        return slotsItem;
    }
}
