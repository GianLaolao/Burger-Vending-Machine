
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

    public Record[] createRecord (Item[] items) {

        int n = items.length;

        Record records[] = new Record[n];

        for (int i = 0; i < n; i++) {
            Record newRec = new Record(items[i]);
            records[i] = newRec;
        }
        
        return records;
    }

    public CreatedItem[] initializeCreated () {

        HashMap<Item, Integer> ketIng = new HashMap<Item, Integer>();
        ketIng.put(SpecialVendo.nonSellableItems[0], 3);
        CreatedItem ketchup = new CreatedItem("Ketchup", 0, 1, null, ketIng);

        HashMap<Item, Integer> mayoIng = new HashMap<Item, Integer>();
        mayoIng.put(SpecialVendo.sellableItems[8], 2);
        CreatedItem mayo = new CreatedItem("Mayonnaise", 0, 2, null, mayoIng);

        HashMap<Item, Integer> thouIslIng = new HashMap<Item, Integer>();
        thouIslIng.put(ketchup, 1);
        thouIslIng.put(mayo, 1);
        CreatedItem thouIsl = new CreatedItem("Thousand Island", 0, 3, null, thouIslIng);

        CreatedItem create[] = {ketchup, mayo, thouIsl};

        return create;
    }
}
