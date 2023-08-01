/*
 * A RegularVendo holds the eight (8) item slots available for purchase. 
 */

public class RegularVendo{

    //can hold item instances
    protected static Item sellableItems[] = new Item[10]; 
    private Record sellableRecords[] = new Record[10];
    private Item[] slotsItem = new Item[8]; //accepts ArrayList of Item

    //TODO    

    public void setRecords(Record[] records) {
        this.sellableRecords = records;
    }

    public Record[] getSellableRecords() {
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

    public Item[] getSlotsItem() {
        return slotsItem;
    }
}
