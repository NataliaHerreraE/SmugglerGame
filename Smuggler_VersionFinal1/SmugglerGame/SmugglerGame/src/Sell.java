import java.util.List;
public class Sell {
    Smuggler smuggler;
    CityManager cityManager;
    public Sell(Smuggler smuggler,CityManager cityManager) {
        this.smuggler = smuggler;
        this.cityManager=cityManager;
    }
   // CityManager cityManager = new CityManager();
    public void SellItem(String itenName, int quantity) {
        //verify if it has the quantity to sell the item
        //getSalesPrices(cityManager.getCurrentCity().getName(),itenName) return the sales price for a specific Item
        double salesAmount,salesPrices=getSalesPrices(cityManager.getCurrentCity().getName(),itenName);
        double finalMoney;
        if (checkItemQuantity(itenName, quantity) == true) {
            //System.out.println("Inicial money "+smuggler.getMoney());
            System.out.printf("💰 Initial Money: $%-10.2f\n", smuggler.getMoney());
            //take the item out
            smuggler.removeInventoryItem(itenName,quantity);
            salesAmount= salesPrices*quantity;
            //add the money related to the sale
           finalMoney= smuggler.getMoney()+salesAmount;
           smuggler.setMoney(finalMoney);
            System.out.println();
            System.out.printf("💸 Sales: $%-10.2f\n", salesAmount);
            System.out.printf("💰 Final Money: $%-10.2f\n", smuggler.getMoney());
            /*
            System.out.println("Sales: "+salesAmount);
            System.out.println("final money "+smuggler.getMoney());
             */
        } else {
            System.out.println();
            System.out.println("⛔️ Sorry, you do not have enough items to sell.");
            System.out.println("📦 Stock up your inventory and try again!");
            //System.out.println("sorry, You do not have enough item to sell");
        }
    }
    //check if the smuggler has enough quantity in the inventory
    public boolean checkItemQuantity(String name, int quantity) {
        List<Item> inventory = smuggler.getInventory();
        for (Item itemInventory : inventory) {
            if (itemInventory.getName().equals(name) &&  itemInventory.getQuantity()>=quantity) {
                return true;
            }
        }
        return false;
    }
    public double getSalesPrices(String city, String itenName) {
            //get the list of item depending on the city
        for (Item item : cityManager.getItemsForCity(city)) {
            //find the price of the item
            if (item.getName().equals(itenName)){
                return item.getBuyPrice(); // this MUST be buy Price, since is the price the City allows to pay for the Item
            }
        }
        return 0;
    }
}



