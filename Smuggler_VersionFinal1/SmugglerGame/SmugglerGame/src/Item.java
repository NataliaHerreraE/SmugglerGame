
abstract class Item {
    private String name;
    private double salesPrice;
    private double buyPrice;
    private int quantity;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getBuyPrice() {
        return buyPrice;
    }
    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }
    public double getSalesPrice() {
        return salesPrice;
    }
    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Item(String name, double salesPrice, int quantity) {  // to be sure that buyPrice is 70% of salesPrice on the Cities price inicialization
        this.name = name;
        this.buyPrice= salesPrice*0.7;
        this.salesPrice= salesPrice;
        this.quantity= quantity;
    }
    public Item(String name, double buyPrice, double salesPrice, int quantity) {
        this.name = name;
        this.buyPrice= buyPrice;
        this.salesPrice= salesPrice;
        this.quantity= quantity;
    }
    public Item(String name) {
        this.name = name;
        this.buyPrice= 0;
        this.salesPrice= 0;
        this.quantity= 0;
    }
}