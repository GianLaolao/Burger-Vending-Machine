
import java.util.*;

public class CreatedItem extends Item{
    
    // private ArrayList<Item> ingredients = new ArrayList<>();
    private Map<Item, Integer> ingredients;

    public CreatedItem(String name, int price, float calories, String path, HashMap<Item, Integer> ingredients) {

        super(name, price, calories, path);
        this.ingredients = ingredients;
    }

    // public ArrayList<Item> getIngredients() {
    //     return ingredients;
    // }


    private boolean checkStock (int quantity) {

        for (HashMap.Entry<Item, Integer> x : ingredients.entrySet()) {
            Item one = x.getKey();
            int num = x.getValue();

            if (one.getStock().size() < num*quantity) 
                return false;      
        }

       return true;
    }

    public boolean addStock(int quantity, CreatedItem item) {
        
        if (checkStock(quantity)) {
            for (int i = 0; i < quantity; i++) {
                for (HashMap.Entry<Item, Integer> x : ingredients.entrySet()) {
                    Item one = x.getKey();
                    int num = x.getValue();
                    
                    for (int j = 0; j < num; j++) {
                        one.getStock().remove(0);
                    }
                }

               stock.add(item);
            }
        }
        else
            return false;
        
        return true;
    }
}
