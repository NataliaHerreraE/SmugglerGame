import java.util.ArrayList;
import java.util.List;

class City {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public City(){



    }

    //se agrego nuevo

    public void setIndex(int index) {
        this.index = index;
    }

    //se agrego nuevo

    public int getIndex() {
        return index;
    }


    public void setItems(List<Item> items) {
        this.items = items;
    }

    private String name;

    //se agrego nuevo
    private int index;


    public List<Item> items = new ArrayList<>();



    public City(String name) {
        this.name = name;
    }
    public City(String name, List<Item> items ) {
        this.name = name;
        this.items=items;
    }

    //nuevo
    public City(String name, List<Item> items , int index ) {
        this.name = name;
        this.items=items;
        this.index=index;
    }

    public void displayCityDetail()
    {
        System.out.println("City: " + this.getName() );
            for (Item item : this.getItems()) {
                //System.out.printf("Product name: %-20s \tCity buy price: %7s\tCity sales price: %7s\tQuantity: %3s\n", item.getName(), String.format("%.2f",item.getBuyPrice()), String.format("%.2f",item.getSalesPrice()), item.getQuantity());
                System.out.printf("╔═════════════════════════════════════════════════════════════════════════════════════════════════════╗\n");
                System.out.printf("  %-25s  City Buy Price: $%8.2f  City Sales Price: $%8.2f  Quantity: %3d  \n",
                        item.getName(), item.getBuyPrice(), item.getSalesPrice(), item.getQuantity());
                System.out.printf("╚═════════════════════════════════════════════════════════════════════════════════════════════════════╝\n");
        }
    }

    public void displayItembyCity()
    {
        System.out.println("City: " + this.getName() );
       /* for (Item item : this.getItems()) {
          //  System.out.println("Product name: " + item.getName() + "\tBuy price: " + item.getBuyPrice() + "\tSales price: " +  item.getSalesPrice() + "\tQuantity: " + item.getQuantity());
            System.out.println("City: " + this.getName() );*/
        for (Item item : this.getItems()) {
            System.out.printf("╔═════════════════════════════════════════════════════════════════════════════════════════════════════╗\n");
            System.out.printf("  %-25s  City Buy Price: $%7.2f  City Sales Price: $%7.2f  Quantity: %3d  \n",
                    item.getName(), item.getBuyPrice(), item.getSalesPrice(), item.getQuantity());
            System.out.printf("╚═════════════════════════════════════════════════════════════════════════════════════════════════════╝\n");

        }
    }


    // Getter methods for name, buyingPrices, sellingPrices, etc.
}