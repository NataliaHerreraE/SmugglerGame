import java.util.List;

public class Purchase {
    Smuggler smuggler;
    CityManager cityManager;
    public Purchase(Smuggler smuggler, CityManager cityManager) {

        this.smuggler = smuggler;
        this.cityManager=cityManager;
    }
    // CityManager cityManager = new CityManager();
    public void BuyItem(String itemName, int quantity) {
        // When the Smuggler buys items in current city, he pays the City Sales Price, that's why we get sell prices from City
        //                 vvvvvvvv -- Here...
        double buyPrices= getSellPrices(cityManager.getCurrentCity().getName(),itemName);
        double finalMoney,purchase;
        double inicialMoney=smuggler.getMoney();
        purchase= buyPrices*quantity;
        if (checkMoney(purchase) == true)
        {
            //take the item out
            smuggler.addInventoryItem(itemName,quantity);

            //take the money related to the sale
            finalMoney= smuggler.getMoney()-purchase;

            smuggler.setMoney(finalMoney);
/*
            System.out.println("Current Money:"+smuggler.getMoney());
            System.out.println("Purchase:"+purchase);
            System.out.println("Money before Purchase:"+inicialMoney);
 */
            System.out.println("╔══════════════════════════════════════════════╗");
            System.out.printf("║   💰 Current Money: $%-12.2f                  ║\n", smuggler.getMoney());
            System.out.printf("║   💸 Purchase: $%-12.2f                       ║\n", purchase);
            System.out.printf("║   💼 Money before Purchase: $%-12.2f          ║\n", inicialMoney);
            System.out.println("╚══════════════════════════════════════════════╝");
        }
        else
        {
            //System.out.println("sorry, You do not have enough money :(");
            System.out.println("⛔️ Sorry, you don't have enough funds for this purchase.");
            System.out.println("💰 Earn more money and try again! You've got this! 💪");
        }
    }
    //check if the smuggler has enough quantity in the inventory
    public boolean checkMoney(double purchase) {

       if (smuggler.getMoney()>purchase) {
           return true;
       }
       return false;
    }
    public double getBuyPrices(String city, String itemName) {
        //get the list of item depending on the city
        for (Item item : cityManager.getItemsForCity(city)
        ) {
            //find the price of the item
            if (item.getName().equals(itemName))
            {
                return item.getBuyPrice();
            }

        }
        return 0;
    }
    public double getSellPrices(String city, String itemName) {
        //get the list of item depending on the city
        for (Item item : cityManager.getItemsForCity(city)
        ) {
            //find the price of the item
            if (item.getName().equals(itemName))
            {
                return item.getSalesPrice();
            }

        }
        return 0;
    }
    public int getItemQuantity(String city, String itemName) {
        //get the list of item depending on the city
        for (Item item : cityManager.getItemsForCity(city)
        ) {
            //find the price of the item
            if (item.getName().equals(itemName))
            {
                return item.getQuantity();
            }

        }
        return 0;
    }

}
