
public class SpecialVendo extends RegularVendo{
    //TODO

    //methods for Special vendo

    protected static Item nonSellableItems[] = new Item[8];
    private Record nonSellRecords[] = new Record[10];
    protected static CreatedItem createdItems[] = new CreatedItem[3];
    private Record createdRecords[] = new Record[3]; 
    
    public static Item[] getNonSellableItems() {
        return nonSellableItems;
    }

    public static CreatedItem[] getCreatedItems() {
        return createdItems;
    }

    public void setNonSellRecords(Record[] nonSellRecords) {
        this.nonSellRecords = nonSellRecords;
    }

    public void setCreatedRecords(Record[] createdRecords) {
        this.createdRecords = createdRecords;
    }

    public Record[] getNonSellRecords() {
        return nonSellRecords;
    }

    public Record[] getCreatedRecords() {
        return createdRecords;
    }
}
