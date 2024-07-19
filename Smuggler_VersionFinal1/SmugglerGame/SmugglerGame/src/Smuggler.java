import java.util.List;
import java.util.Random;
public class Smuggler {
    //1.3.1
    private List<Item> inventory ;
    public List<Item> getInventory() {
        return inventory;
    }
    private CityManager cityManager;
    private double amount;
    public double getAmount() {
        return amount;
    }
    private boolean Alive = true;
    public void setAlive(boolean Alive ){
        this.Alive = Alive;
    }
    //1.3.2
    private double money;
    public double getMoney() {
        return money;
    }
    public void setMoney(double money) {
        this.money = money;
    }
    //1.3.3
    private City city;
    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }
    private int fine;
    public int getFine() {
        return fine;
    }
    public void setFine(int fine) {
        this.fine = fine;
    }
    public Smuggler(City city,CityManager cityManager) {
        // Initialize money, inventory, and fine
        this.money =3000;
        this.fine=100;
        this.city = city;
        this.inventory = ItemManager.Instace().setItemsbySmuggler();
        this.cityManager=cityManager;
    }
    public Smuggler(){
        this.inventory = ItemManager.Instace().setItemsbySmuggler();
    }
    //nuevo
    public void displayInventory()
    {
        for(Item item : this.inventory )
        {
            System.out.printf("Product name: %-20s \tQuantity: %3s\n",item.getName(), item.getQuantity());
        }
    }
    public void displayInventoryWithPrices()
    {
        //store in the variable the current city.
        String currentCity=cityManager.getCurrentCity().getName();
        //Iterate over the cities to get the product for city
        for (int i = 0; i < cityManager.getItemsForCity(currentCity).size(); i++) {
            //System.out.println("Product name: " + cityManager.getItemsForCity(currentCity).get(i).getName() + "\tSmuggler buy price: " +cityManager.getItemsForCity(currentCity ).get(i).getBuyPrice() + "\tSmuggler sales price: " +  cityManager.getItemsForCity(currentCity ).get(i).getSalesPrice() + "\tQuantity: "+getInventory().get(i).getQuantity());
            // Only shows the sales prices of products
            System.out.printf("Product name: %-20s \tCity sales price: %7s\tQuantity: %3s\n", cityManager.getItemsForCity(currentCity).get(i).getName(),String.format("%.2f",cityManager.getItemsForCity(currentCity ).get(i).getSalesPrice()),getInventory().get(i).getQuantity());
        }
    }
    public void displayInventoryWithPricesToSell()
    {
        //store in the variable the current city.
        String currentCity=cityManager.getCurrentCity().getName();
        //Iterate over the cities to get the product for city
        for (int i = 0; i < cityManager.getItemsForCity(currentCity).size(); i++) {
            //System.out.println("Product name: " + cityManager.getItemsForCity(currentCity).get(i).getName() + "\tSmuggler buy price: " +cityManager.getItemsForCity(currentCity ).get(i).getBuyPrice() + "\tSmuggler sales price: " +  cityManager.getItemsForCity(currentCity ).get(i).getSalesPrice() + "\tQuantity: "+getInventory().get(i).getQuantity());
            // Only shows the sales prices of products
            System.out.printf("Product name: %-20s \tCity buy price: %7s\tQuantity: %3s\n", cityManager.getItemsForCity(currentCity).get(i).getName(),String.format("%.2f",cityManager.getItemsForCity(currentCity ).get(i).getBuyPrice()),getInventory().get(i).getQuantity());
        }
    }
    public boolean isAlive() {
        // Implement logic to check if the game is won or lost
        return Alive;
    }
    public void addInventoryItem(String name, int quantity){
        int newQuantity;
        for (Item itemI:getInventory()) {
            if (name.equals(itemI.getName())){
                newQuantity= itemI.getQuantity()+quantity;
                itemI.setQuantity(newQuantity);
                System.out.println("New quantity "+ itemI.getName()+":"+newQuantity);
            }
        }
    }
    public void removeInventoryItem(String name, int quantity){
        int newQuantity;
        for (Item itemI:getInventory()) {
            if (name.equals(itemI.getName())){
                newQuantity= itemI.getQuantity()-quantity;
                itemI.setQuantity(newQuantity);
                System.out.println("New quantity "+ itemI.getName()+":"+newQuantity);
            }
        }
    }
    public int getInventoryByItem(String name){
        for (Item item:getInventory()) {
            if(name.equals(item.getName()))
                return item.getQuantity();
        }
        return 0;
    }
    public boolean itemExist(String name){
        for (Item item:getInventory()) {
            if(name.equals(item.getName()))
                return true;
        }
        return false;
    }
    public String travelNewCity(String city)
    {
        Random rnd = new Random();
        int freeChance  = (int)(rnd.nextDouble() * 10); // we get a Random number which will be the get caught Chance
        /*
        System.out.println("Free chance: "+ freeChance );// this is the random chance to get free must be greater than caught chance
        System.out.println("Item count = caught chance: "+ getCaughtChance() ); // will return de percent to be caught deppending on the kind of diferent items
         */
        System.out.println("🎲 Free Chance: " + freeChance); // Random chance to get free (must be greater than caught chance)
        System.out.println("🎣 Caught Chance: " + getCaughtChance() + "%"); // Percent chance to be caught depending on the type of different items
        if (freeChance < getCaughtChance()){ // if get free Chances are lower than get caught Chances, Smuggler is captured
            //code when the smuggler is get caught
            money = money - fine; // On this part the fine is deducted from amount Smuggler has
            fine = fine + 50; // Next fine is set to furrent fine + $50
            clearInventory(); // on This method ALL items are remoded... (must be updated to only remove 1 kind of items...)
            if(money <= 0){ // If Smuggler is without money, we set the is alive to False so the game ENDs...
                setAlive( false);
            }
            int punishmentCity = (int)(rnd.nextDouble() * 10);if (punishmentCity==0){punishmentCity=1;} // Since Smuggler was captured, we assign a random city to travel (removing undefined 0)
            /*
            System.out.println("the Smmugler has been captured!!!!!"); // Captured message showed...
            System.out.println("will be moved to City: "+punishmentCity); // Captured message showed...
            System.out.println("the Smmugler has this money left: "+money); // Captured message showed...
             */
            System.out.println();
            System.out.println("🚨 Alert! The Smuggler has been captured! 🚨");
            System.out.println("✈️ will be moved to City: "+punishmentCity); // Captured message showed...
            System.out.println("💸 Has been charged with a fine of: $"+(getFine()-50)); // Captured message showed minus $50 since it is called after fine...
            System.out.println("💰 the Smmugler has this money left: "+money); // Captured message showed...
            return Integer.toString(punishmentCity); // We return the destination city for Smuggler
        }
        //System.out.println("the Smmugler reached safely :) ");
        System.out.println();
        System.out.println("🎉 Hooray! The Smuggler has reached safely! 🎉");
        return city;
    }
    public int getCaughtChance(){
        int caughtChance = 0;
        for(Item item : this.inventory )
        {
            if (item.getQuantity() > 0 ){caughtChance ++; }
        }
        return caughtChance;
    }
    public void clearInventory(){
        int maxItemCount=0;
        for(Item item : this.inventory)
        {
            if (item.getQuantity()>maxItemCount){
                maxItemCount=item.getQuantity();
            }
        }
        for(Item item : this.inventory)
        {
            if (item.getQuantity()==maxItemCount){
                item.setQuantity(0);
                break;
            }
        }
    }
}