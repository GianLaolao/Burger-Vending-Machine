
public class SpecialVendo extends RegularVendo{

    //methods for Special vendo
    protected static Item nonSellableItems[];
    private Record nonSellRecords[];
    protected static CreatedItem createdItems[];
    private Record createdRecords[];
    
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

    public Record getnonSellItemRecord(Item item) {

        for (Record r : nonSellRecords) {
            if (r.getItem().equals(item))
                return r;
        }

        return null;
    }

    public Record[] getCreatedRecords() {
        return createdRecords;
    }

    public Record getCreatedItemRecord(Item item) {

        for (Record r : createdRecords) {
            if (r.getItem().equals(item))
                return r;
        }

        return null;
    }
}
