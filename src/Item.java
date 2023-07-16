/*
 * An Item represents a vending machine item available for purchase. It contains 
 * the name of the item, its price, amount of calories, and quantity. 
 */

public class Item {
    //initialize variables 
    private String name;
    private int price;
    private float calories;

    /*
     * creates an Item object given the name of the item, its price, amount of calories, and quantity. 
     * @param name the name of the item 
     * @param price the price of the item 
     * @param calories the amount of calories of the item
     * @param quantity the quantity of the item
     */

    public Item (String name, int price, float calories, int quantity) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    /*
     * sets the exact price for each item
     * @param price the price of the item 
     */

    public void setPrice(int price) {
        this.price = price;
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

}