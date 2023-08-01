
public class SpecialVendo extends RegularVendo{
    //TODO

    //methods for Special vendo

    protected static Item nonSellableItems[] = new Item[8];
    protected static Record nonSellRecords[] = new Record[10];
    protected static CreatedItem createdItems[] = new CreatedItem[3];
    protected static Record createdRecords[] = new Record[3]; 
    // private Item specialItem[] 
    
    public static Item[] getNonSellables() {
        return nonSellableItems;
    }
}
