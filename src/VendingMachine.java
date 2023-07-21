import java.util.*;

/*
 * A VendingMachine represents the vending machine. It contains the regular vending machine, 
 * records, vending machine money, user money, and total sales. 
 */

public class VendingMachine {
    
    protected Item itemInfos[] = new Item[8]; //can be changed to Items 
  
    protected MoneyCalc moneyCalc = new MoneyCalc();


    //TODO

/* 
 * takes payment from the user 
 * @param type the money paid by user 
 */
    public void takePayment(int type) {

        // switch(type){
        //     case 1:
        //         userMoney.setOnePeso(userMoney.getOnePeso().getQuantity() + 1);
        //         break;
        //     case 2:
        //         userMoney.setFivePeso(userMoney.getFivePeso().getQuantity() + 1);
        //         break;
        //     case 3:
        //         userMoney.setTenPeso(userMoney.getTenPeso().getQuantity() + 1);
        //         break;
        //     case 4:
        //         userMoney.setTwentyPeso(userMoney.getTwentyPeso().getQuantity() + 1);
        //         break;
        //     case 5:
        //         userMoney.setFiftyPeso(userMoney.getFiftyPeso().getQuantity() + 1);
        //         break;
        //     case 6:
        //         userMoney.setHundredPeso(userMoney.getHundredPeso().getQuantity() + 1);
        //         break;
        // }
    }



    public boolean addItem(String name, int price, float calories, int quantity) { 
        
        //TODO

        return false;
    }

/* 
 * removes item from the vending machine 
 * @param slot the slot occupied by the item being removed 
 */

    public boolean removeItem(int slot) { 

        //TODO
        
        return false;
    }

/* 
 * restocks or replaces item of the inventory or vending machine 
 * @param quantity the quantity of item to be restocked  
 * @param slot the slot to be occupied for restocking 
 */

    public boolean restockItem(int quantity, int slot) {
    
        //TODO
    
        return false;
    }

/* 
 * sets item price  
 * @param price the set price for the selected item 
 * @param slot the slot of the item selected 
 */

    public boolean setItemPrice(int price, int slot){

       //TODO
           
        return false;
    }

/* 
 * adds money to the vending machine 
 * @param quantity the quantity of vendoMoney  
 * @param type the money added
 */

    public void addMoney(int quantity, int type) {
        
    //TODO modify
         switch(type){
            // case 1:
            //     vendoMoney.setOnePeso(vendoMoney.getOnePeso().getQuantity() + quantity);
            //     break;
            // case 2:
            //     vendoMoney.setFivePeso(vendoMoney.getFivePeso().getQuantity() + quantity);
            //     break;
            // case 3: 
            //     vendoMoney.setTenPeso(vendoMoney.getTenPeso().getQuantity() + quantity);
            //     break;
            // case 4:
            //     vendoMoney.setTwentyPeso(vendoMoney.getTwentyPeso().getQuantity() + quantity);
            //     break;
            // case 5:
            //     vendoMoney.setFiftyPeso(vendoMoney.getFiftyPeso().getQuantity() + quantity);
            //     break;
            // case 6:
            //     vendoMoney.setHundredPeso(vendoMoney.getHundredPeso().getQuantity() + quantity);
            //     break;
        }
    }

/*
 * checks the money of the user 
 * @param slot the slot of the item selected
 * @param quantity the quantity of item bought by the user
 */

    public boolean checkUserMoney(int slot, int quantity) {

        //TODO
        // Item item = regular.getItem(slot);
        // int price = item.getPrice() * quantity;

        // if (price > userMoney.getTotal()){
        //     return false;
        // }

        return true;
    }

/* 
 * produces money change for the user 
 * @param slot the slot of the selected item 
 * @param quantity the quantity of the selected item of the user 
 */

    public MoneyBox produceChange(int slot, int quantity) {

        //TODO modify

        // MoneyBox changeBox = new MoneyBox(); 
        // // Item item = regular.getItem(slot);
        // int change = userMoney.getTotal() - (item.getPrice() * quantity);

        // if(change > vendoMoney.getTotal()) {
        //     return null;
        // }
    
        // if (vendoMoney.getHundredPeso().getQuantity() != 0){
        //     int amount = change / 100;
        //     if ((change / 100 != 0) && amount > vendoMoney.getHundredPeso().getQuantity()) {
        //         change -= vendoMoney.getHundredPeso().getQuantity() * 100;
        //         changeBox.setHundredPeso(vendoMoney.getHundredPeso().getQuantity());
        //         vendoMoney.setHundredPeso(0);
        //     }
        //     else if (change / 100 != 0) {
        //         change -= amount * 100;
        //         vendoMoney.setHundredPeso(vendoMoney.getHundredPeso().getQuantity() - amount);
        //         changeBox.setHundredPeso(amount);
        //     }
            
        // }
        // if (vendoMoney.getFiftyPeso().getQuantity() != 0){
        //     int amount = change / 50;
        //     if ((change / 50 != 0) && amount > vendoMoney.getFiftyPeso().getQuantity()) {
        //         change -= vendoMoney.getFiftyPeso().getQuantity() * 50;
        //         changeBox.setFiftyPeso(vendoMoney.getFiftyPeso().getQuantity());
        //         vendoMoney.setFiftyPeso(0);
        //     }
        //     else if (change /50 != 0) {
        //         change -= amount * 50;
        //         vendoMoney.setFiftyPeso(vendoMoney.getFiftyPeso().getQuantity() - amount);
        //         changeBox.setFiftyPeso(amount);
        //     }
            
        // }
        // if (vendoMoney.getTwentyPeso().getQuantity() != 0){
        //     int amount = change / 20;
        //     if ((change / 20 != 0) && amount > vendoMoney.getTwentyPeso().getQuantity()) {
        //         change -= vendoMoney.getTwentyPeso().getQuantity() * 20;
        //         changeBox.setTwentyPeso(vendoMoney.getTwentyPeso().getQuantity());
        //         vendoMoney.setTwentyPeso(0);
        //     }
        //     else if (change / 20 != 0){
        //         change -= amount * 20;
        //         vendoMoney.setTwentyPeso(vendoMoney.getTwentyPeso().getQuantity() - amount);
        //         changeBox.setTwentyPeso(amount);
        //     }
        // }
        // if (vendoMoney.getTenPeso().getQuantity() != 0){
        //     int amount = change / 10;
        //     if ((change / 10 != 0) && amount > vendoMoney.getTenPeso().getQuantity()) {
        //         change -= vendoMoney.getTenPeso().getQuantity() * 10;
        //         changeBox.setTenPeso(vendoMoney.getTenPeso().getQuantity());
        //         vendoMoney.setTenPeso(0);
        //     }
        //     else if (change / 10 != 0){
        //         change -= amount * 10;
        //         vendoMoney.setTenPeso(vendoMoney.getTenPeso().getQuantity() - amount);
        //         changeBox.setTenPeso(amount);
        //     }
           
        // }
        // if (vendoMoney.getFivePeso().getQuantity() != 0){
        //     int amount = change / 5;
        //     if ((change / 5 != 0) && amount > vendoMoney.getFivePeso().getQuantity()) {
        //         change -= vendoMoney.getFivePeso().getQuantity() * 5;
        //         changeBox.setFivePeso(vendoMoney.getFivePeso().getQuantity());
        //         vendoMoney.setFivePeso(0);
        //     }
        //     else if (change / 5 != 0){
        //         change -= amount * 5;
        //         vendoMoney.setFivePeso(vendoMoney.getFivePeso().getQuantity() - amount);
        //         changeBox.setFivePeso(amount);
        //     }
            
        // }
        // if (vendoMoney.getOnePeso().getQuantity() != 0){
        //     int amount = change / 1;
        //     if ((change / 1 != 0) && amount > vendoMoney.getOnePeso().getQuantity()) {
        //         change -= vendoMoney.getOnePeso().getQuantity();
        //         vendoMoney.setOnePeso(0);
        //         changeBox.setOnePeso(amount);
        //     }
        //     else if (change / 1 != 0){
        //         change -= amount;
        //         vendoMoney.setOnePeso(vendoMoney.getOnePeso().getQuantity() - amount);
        //         changeBox.setOnePeso(amount);
        //     }
            
        // }


        // if (change != 0)
        //     return null;
        // else {
        //     addMoney(userMoney.getOnePeso().getQuantity(), 1);
        //     addMoney(userMoney.getFivePeso().getQuantity(), 2);
        //     addMoney(userMoney.getTenPeso().getQuantity(), 3);
        //     addMoney(userMoney.getTwentyPeso().getQuantity(), 4);
        //     addMoney(userMoney.getFiftyPeso().getQuantity(), 5);
        //     addMoney(userMoney.getHundredPeso().getQuantity(), 6);

        //     resetUserMoney();

        //     return changeBox;
        // }
        
    }
    /*
     * resets userMoney quantity for each denomination to 0
     */
    public void resetUserMoney() {
        // userMoney.setOnePeso(0);
        // userMoney.setFivePeso(0);
        // userMoney.setTenPeso(0);
        // userMoney.setTwentyPeso(0);
        // userMoney.setFiftyPeso(0);
        // userMoney.setHundredPeso(0);
    }

    
/* 
 * retrieves profit for the vending machine  
 */

    public int retrieveProfit() {

        int profit;

        // profit = vendoMoney.getTotal();

        // vendoMoney.getOnePeso().setQuantity(0);
        // vendoMoney.getFivePeso().setQuantity(0);
        // vendoMoney.getTenPeso().setQuantity(0);
        // vendoMoney.getTwentyPeso().setQuantity(0);
        // vendoMoney.getFiftyPeso().setQuantity(0);
        // vendoMoney.getHundredPeso().setQuantity(0);

        return profit;
    }
   
    
    
  

    /* 
     * computes for the total sales of the vending machine 
     * returns the total sales
     */
    

}
