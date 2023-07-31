
import java.util.ArrayList;

public class CreatedItem extends Item{
    
    private ArrayList<Item> ingredients = new ArrayList<>();

    public CreatedItem(String name, int price, float calories, String path, ArrayList<Item> ingredients) {

        super(name, price, calories, path);
        this.ingredients = ingredients;
    }

    public ArrayList<Item> getIngredients() {
        return ingredients;
    }

    public void addStock(int quantity, CreatedItem item) {
      
        for (int i = 0; i < quantity; i++) {
            for (Item ingredient : item.getIngredients()) {
                ingredient.getStock().remove(0);
            }
        }
    }
}
