
import java.io.*;
import java.util.*;

public class Initialize {
    
    public Item[] initialize(String path) {

        Item[] items;
        String name;
        int price;
        float calories;
        Scanner sc;
        File file = new File(path);
        try {
            sc = new Scanner(file);
        } catch (IOException e) {
            return null;
        }

        int n = sc.nextInt();
        items = new Item[n];

        for (int i = 0; i < n; i++) {

            sc.nextLine();
            name = sc.nextLine();
            price = sc.nextInt();
            calories = sc.nextFloat();
            

            Item a = new Item(name, price, calories);

            items[i] = a;
        }
        
        sc.close();

        return items;
    }

    public static void main(String[] args) {
        Initialize x = new Initialize();

        Item[] item = x.initialize("src\\ItemSellable.txt");

        for (int i = 0; i < item.length; i++) {
            System.out.println(item[i].getName());
            System.out.println(item[i].getPrice());
            System.out.println(item[i].getCalories());
            System.out.print("\n");
        }
    }
}
