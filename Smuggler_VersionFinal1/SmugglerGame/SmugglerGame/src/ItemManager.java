import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class ItemManager {
    private static ItemManager instance = new ItemManager();
    private ItemManager() {
    }
    public List<Item> setItemsbyCity()
    {
        List<Item> items = new ArrayList<>();
        Random rnd = new Random();
        items.add(new Hachis("Hachis", (int) (rnd.nextDouble() * 200 + 50),  (int) (rnd.nextDouble() * 10 + 1)));
        items.add(new Weed("Weed", (int) (rnd.nextDouble() * 200 + 50),  (int) (rnd.nextDouble() * 10 + 1)));
        items.add(new Tequila("Tequila", (int) (rnd.nextDouble() * 200 + 50),  (int) (rnd.nextDouble() * 10 + 1)));
        items.add(new AguaArdiente("AguaArdiente", (int) (rnd.nextDouble() * 200 + 50), (int) (rnd.nextDouble() * 10 + 1)));
        items.add(new Tobacco("Tobacco", (int) (rnd.nextDouble() * 200 + 50), (int) (rnd.nextDouble() * 10 + 1)));
        return items;
    }
    public void getItem(){

    }
    public List<Item> setItemsbySmuggler() {
        List<Item> items = new ArrayList<>();
        Random rnd = new Random();
        items.add(new Hachis("Hachis",0,0));
        items.add(new Weed("Weed",0,0));
        items.add(new Tequila("Tequila",0,0));
        items.add(new AguaArdiente("AguaArdiente",0,0));
        items.add(new Tobacco("Tobacco",0,0));
        return items;
    }
    public static ItemManager Instace()
    {
        return instance;
    }

}
