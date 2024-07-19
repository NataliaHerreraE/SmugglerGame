import java.util.Scanner;

public class SmugglerGame {
    /*
     * Team:
     * Camilo
     * Javier
     * Jose
     * Natalia
     * Veronica
     * 
     * Program Smuggler(Merchant)
     * 
     * 10/1/2023.....
     * 
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Prepare Cities, with products and prices
        City city = new City();
        CityManager cityManager = new CityManager();
        Smuggler smuggler = new Smuggler(city,cityManager);
        // Select a random city to start the game
        cityManager.setRandomCity();
        String item="";
        String quantity="";
        cityManager.setCurrentCityIndex(2);
        //Prepare Smuggler
        Sell sell = new Sell(smuggler,cityManager);
        Purchase purchase = new Purchase(smuggler,cityManager);
       // sell.SellItem("Tequila",2);
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║               🌟  WELCOME 🌟                 ║");
        System.out.println("╚══════════════════════════════════════════════╝");
        while (smuggler.isAlive()) {
            //System.out.println("Current City: " + cityManager.getCurrentCity().getName());
            /*
            System.out.println("Smuggler");
            System.out.println("1.- See Inventory");
            System.out.println("2.- Money");
            System.out.println("3.- Display current City: " + cityManager.getCurrentCity().getName());
            System.out.println("4.- Buy wares");
            System.out.println("5.- Sell wares");
            System.out.println("6.- Travel to new city");
            String temp=scanner.nextLine();
             */
            System.out.println();
            System.out.println("Please select an option from the menu below:");
            System.out.println();
            System.out.println("╔══════════════════════════════════════════════╗");
            System.out.println("║              🌟 SMUGGLER MENU 🌟             ║");
            System.out.println("╠══════════════════════════════════════════════╣");
            System.out.println("║ 1. See Inventory                             ║");
            System.out.println("║ 2. Check Money                               ║");
            System.out.println("║ 3. Display Current City:   " + (cityManager.getCurrentCity().getName()) + "         ║");
            System.out.println("║ 4. Buy Items                                 ║");
            System.out.println("║ 5. Sell Items                                ║");
            System.out.println("║ 6. Travel to a New City                      ║");
            System.out.println("║ 7. Exit                                      ║");
            System.out.println("╚══════════════════════════════════════════════╝");
            System.out.println();
            // Display menu and handle user input (inventory, money, actions, etc.)
            // Implement travel logic with a chance of getting caught.
            // Handle buying and selling of items.
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1"://Show Smuggler Inventory
                    System.out.println();
                    System.out.println("╔══════════════════════════════════════════════════╗");
                    System.out.println("║              🎒 SMUGGLER INVENTORY 🎒            ║");
                    System.out.println("╚══════════════════════════════════════════════════╝");
                    // call method to display inventory
                    smuggler.displayInventory();
                    break;
                case "2"://Show Smuggler Money
                    System.out.println();
                    System.out.println("╔════════════════════════════════════════════════╗");
                    System.out.println("║             💰 CURRENT MONEY 💰                ║");
                    System.out.println("╚════════════════════════════════════════════════╝");
                    // call method to show Smuggler's money
                    System.out.println("Amount:" + String.format("%.2f",smuggler.getMoney()));
                    break;
                case "3"://Display current City prices and quantity
                    System.out.println();
                    System.out.println("╔════════════════════════════════════════════════╗");
                    System.out.println("║           🌆 CURRENT CITY DETAILS 🌆          ║");
                    System.out.println("╚════════════════════════════════════════════════╝");
                    // call method to display current City's prices...
                    cityManager.getCurrentCity().displayCityDetail();
                    break;
                case "4"://buy wares
                    System.out.println();
                    System.out.println("╔════════════════════════════════════════════════╗");
                    System.out.println("║                 🛍️ BUY ITEMS 🛍️                ║");
                    System.out.println("╚════════════════════════════════════════════════╝");
                    System.out.println();
                    cityManager.getCurrentCity().displayItembyCity();
                    // Code to buy items
                    int cityQuantity=0;
                    do {
                        System.out.println();
                        System.out.println("Enter the item name you want to buy");
                        item = scanner.nextLine();
                        if (!smuggler.itemExist(item)){ System.out.println("Item not found, please validate for any typo...");}
                    }while(!smuggler.itemExist(item));
                    do {
                        System.out.println("Enter the quantity");
                        quantity = scanner.nextLine();
                        // we must validate the available number of items on the current city
                        cityQuantity = purchase.getItemQuantity(cityManager.getCurrentCity().getName(), item);
                        if (Integer.parseInt(quantity)>cityQuantity ){ System.out.println("There are not enough items in this city...");}
                    }while (Integer.parseInt(quantity)>cityQuantity);
                    purchase.BuyItem(item, Integer.parseInt(quantity));
                    break;
                case "5"://sell wares
                    System.out.println();
                    System.out.println("╔════════════════════════════════════════════════╗");
                    System.out.println("║                💸 SELL ITEMS 💸                ║");
                    System.out.println("╚════════════════════════════════════════════════╝");
                    System.out.println();
                    // Code to Sell items
                    System.out.println("current City: "+ cityManager.getCurrentCity().getName());
                    smuggler.displayInventoryWithPricesToSell();
                    do{
                        System.out.println();
                        System.out.println("Enter the item name you want to sell");
                        item=scanner.nextLine();
                        if (!smuggler.itemExist(item)){ System.out.println("Item not found, please validate for any typo...");}
                    }while(!smuggler.itemExist(item));
                    System.out.println("Enter the quantity");
                    quantity = scanner.nextLine();
                    sell.SellItem(item, Integer.parseInt(quantity));
                    break;
                case "6"://travel to new city
                    System.out.println("╔════════════════════════════════════════════════╗");
                    System.out.println("║           ✈️ TRAVEL TO A NEW CITY ✈️           ║");
                    System.out.println("╚════════════════════════════════════════════════╝");
                    System.out.println();
                    // Code to travel to a new city
                    int selectedCityIndex;

                    do {
                        cityManager.displayCities();
                        System.out.println("Select the city where you want to travel: (between 1 and " + cityManager.getCities().size() + ")");
                        String optCity = scanner.nextLine();

                        try {
                            selectedCityIndex = Integer.parseInt(optCity);
                            if (selectedCityIndex < 1 || selectedCityIndex > cityManager.getCities().size()) {
                                System.out.println("Error: Please enter a number between 1 and " + cityManager.getCities().size());
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Error: invalid enter. Enter only numbers between 1 and " + cityManager.getCities().size());
                            selectedCityIndex = -1; // Establece un valor inválido para continuar el bucle.
                        }
                    } while (selectedCityIndex < 1 || selectedCityIndex > cityManager.getCities().size());

                    cityManager.setCurrentCityIndex(selectedCityIndex - 1);
                    cityManager.getCurrentCity().displayCityDetail();

                    /*cityManager.displayCities();
                    System.out.println("Select the city where you want to travel: (between 1 and " + cityManager.getCities().size() +")");
                    String optCity= scanner.nextLine();
                    optCity=smuggler.travelNewCity(optCity); // DON'T DELETE THIS is the probability and penalities when move to new city...
                    cityManager.setCurrentCityIndex(Integer.parseInt(optCity)-1);
                    cityManager.getCurrentCity().displayCityDetail();*/
                    break;
                case "7":
                    System.out.println();
                    System.out.println("===============================================");
                    System.out.println("Exiting the game. Thank you for playing!");
                    System.out.println("We hope you had a great time. Goodbye!");
                    System.out.println("===============================================");
                    System.out.println();
                    System.exit(0);
                    break;
                default:
                    System.out.println();
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                    System.out.println();
                    break;
            }
        }
        //System.out.println("Game Over!");
        System.out.println();
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║               🎮 GAME OVER! 🎮                 ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println("Thanks for playing Smuggler Game! 🚀");
        System.out.println("Feel free to play again. Goodbye! 👋");
        System.out.println("===============================================");
    }
}