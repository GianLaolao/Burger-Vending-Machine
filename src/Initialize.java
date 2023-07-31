
import java.io.*;
import java.util.*;

public class Initialize {
    
    public Item[] initialize(String path) {

        Item[] items;
        String name;
        int price;
        float calories;
        String icon;
        Scanner sc;
        File file = new File(path);
        try {
            sc = new Scanner(file);
        } catch (IOException e) {
            return null;
        }

        int n = sc.nextInt();
        sc.nextLine();
        items = new Item[n];

        for (int i = 0; i < n; i++) {

            name = sc.nextLine();
            price = sc.nextInt();
            calories = sc.nextFloat();
            sc.nextLine();
            icon = sc.nextLine();
            

            Item a = new Item(name, price, calories,icon);

            items[i] = a;
        }
        
        sc.close();

        return items;
    }

    public void initializeCreated () {

        ArrayList<Item> ketIng = new ArrayList<>();
        ketIng.add(SpecialVendo.nonSellableItems[0]);
        ketIng.add(SpecialVendo.nonSellableItems[0]);
        ketIng.add(SpecialVendo.nonSellableItems[0]);
        CreatedItem ketchup = new CreatedItem("Ketchup", 0, 1, null, ketIng);

        ArrayList<Item> mayoIng = new ArrayList<>();
        mayoIng.add(RegularVendo.sellableItems[8]);
        mayoIng.add(RegularVendo.sellableItems[8]);
        mayoIng.add(RegularVendo.sellableItems[8]);
        CreatedItem mayo = new CreatedItem("Mayonnaise", 0, 2, null, mayoIng);

        
    }
}
