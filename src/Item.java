/*
 * An Item represents a vending machine item available for purchase. It contains 
 * the name of the item, its price, amount of calories, and quantity. 
 */

import java.util.ArrayList;

public class Item {
    //initialize variables 
    private String name;
    private int price;
    private float calories;
    private String icon;
    private ArrayList<Item> stock = new ArrayList<>();

    /*
     * creates an Item object given the name of the item, its price, amount of calories, and quantity. 
     * @param name the name of the item 
     * @param price the price of the item 
     * @param calories the amount of calories of the item
     * @param quantity the quantity of the item
     */

    public Item (String name, int price, float calories, String path) {
        this.name = name;
        this.price = price;
        this.calories = calories;
        icon = path;
    }

    /*
     * sets the exact price for each item
     * @param price the price of the item 
     */

    public void setPrice(int price) {
        this.price = price;
    } 


    public void addStock (int quantity, Item item) {

        ArrayList<Item> newStock = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            Item newItem = item;
            newStock.add(newItem);
        }
        
        stock = newStock;
    }


    /* 
     * returns the name of the chosen item 
     * @return the nume of the chosen item 
     */

    public String getName() {
        return name;
    }

    /*
     * returns the price of the chosen item 
     * @return the price of the chosen item 
     */

    public int getPrice() {
        return price;
    }

    /* 
     * returns the amount of calories of the chosen item 
     * @return the amount of calories of the chosen item 
     */

    public float getCalories() {
        return calories;
    }

    public String getIcon() {
        return icon;
    }

    public ArrayList<Item> getStock() {
        return stock;
    }


}