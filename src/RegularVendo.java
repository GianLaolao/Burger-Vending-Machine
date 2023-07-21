/*
 * A RegularVendo holds the eight (8) item slots available for purchase. 
 */

import java.util.*;

public class RegularVendo extends VendingMachine{
    //can hold item instances
      protected ArrayList<Record> records = new ArrayList<>();



    //TODO




       /* 
     * returns the records of an item 
     * @param item the item selected by the user for its records
     */

     


    public Record getItemRecord(Item item) {

        for (int i = 0; i < records.size(); i++){
            if (records.get(i).getItem().getName().contains(item.getName()))
                return records.get(i);
        }
        return null;
    }

    public ArrayList<Record> getRecords() {
        return records; //returns the vending machine records
    }
    
    public int getTotalSales() {

        int totalSales = 0;
        for(int i = 0; i < records.size(); i++) {
            totalSales += (records.get(i).getSoldAmount());
        }

        return totalSales;
    }
}
