



public class Controller {
    
    VendingMachine regular = new RegularVendo();
    VendingMachine special = new SpecialVendo();
    
    public Item dispenseItem(int slot) {

        Item bought; 

        bought = RegularVendo.itemStock.get(slot).get(0);
      
        RegularVendo.itemStock.get(slot).remove(0);

        return bought;
    }

    public int getTotalSales() {

        int totalSales = 0;
        for(int i = 0; i < RegularVendo.records.length; i++) {
            totalSales += RegularVendo.records[i].getSoldAmount();
        }
        
        return totalSales;
    }
}
