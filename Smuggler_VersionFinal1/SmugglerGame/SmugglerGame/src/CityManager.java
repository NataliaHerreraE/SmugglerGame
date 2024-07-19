import java.util.*;

public class CityManager {
    private List<City> cities = new ArrayList<>();
    //boolean citiesInitialized = false;
    public int getCurrentCityIndex() {
        return currentCityIndex;
    }
    public List<City> getCities() {
        return cities;
    }


    public void setCurrentCityIndex(int currentCityIndex) {
        this.currentCityIndex = currentCityIndex;
    }

    private int currentCityIndex;
        //nuevo
    public CityManager() {
        // if(!citiesInitialized){
        cities.add(new City("CDMX", ItemManager.Instace().setItemsbyCity(),1)) ;
        cities.add(new City("Bogotá", ItemManager.Instace().setItemsbyCity(),2)) ;
        cities.add(new City("Sao Paulo", ItemManager.Instace().setItemsbyCity(),3)) ;
        cities.add(new City("Medellín", ItemManager.Instace().setItemsbyCity(),4)) ;
        cities.add(new City("Cancún", ItemManager.Instace().setItemsbyCity(),5)) ;
        cities.add(new City("Oaxaca", ItemManager.Instace().setItemsbyCity(),6)) ;
        cities.add(new City("Caracas", ItemManager.Instace().setItemsbyCity(),7)) ;
        cities.add(new City("Madrid", ItemManager.Instace().setItemsbyCity(),8)) ;
        cities.add(new City("Barcelona", ItemManager.Instace().setItemsbyCity(),9)) ;
        cities.add(new City("Teherán", ItemManager.Instace().setItemsbyCity(),10)) ;
        //System.out.println("cities created!");
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║        🌍 Cities successfully created! 🌍        ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
        System.out.println("Let the adventure begin! 🚀");
       // citiesInitialized =true;
       //}
    }
    public City getCurrentCity() {
        return this.cities.get(currentCityIndex) ;
    }
    public int getCurrentIndex(){
        return currentCityIndex;
    }
    //nuevo
       String getCurrentCityName() {
           String cityName = "";

           for (City city : getCities()
           ) {
               //System.out.println( city.getIndex());
               if (city.getIndex() ==getCurrentCityIndex() ) {
                   city.getName();
                   cityName = city.getName();

               }

           }
           return cityName;
       }
    public void setRandomCity () {
        Random rnd = new Random();
        this.currentCityIndex = (int) (rnd.nextDouble() * 9 + 0);
    }

    //Display the cities list
    public void displayCities()
    {
        for(City city: cities)
        {
            //System.out.println("Id:" + (cities.indexOf(city) +1)   + "\tCity: " + city.getName());
            System.out.printf("║  ID: %-4d  City: %-25s  ║\n", cities.indexOf(city) + 1, city.getName());
        }

    }
//get the item depending on the city
    public List<Item> getItemsForCity(String cityName) {
        //System.out.println("city current"+cityName);
        for (City city : cities) {
            if (city.getName().equals(cityName)) {

                return city.getItems();
            }
        }
        return new ArrayList<>(); // Returns an empty list if no city found
    }
}