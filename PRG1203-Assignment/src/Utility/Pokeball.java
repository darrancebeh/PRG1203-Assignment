package Utility;

public class Pokeball {
    private final String name;
    private final double catchRate;
    private int price;

    public Pokeball(String name, double catchRate, int price) {
        this.name = name;
        this.catchRate = catchRate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getCatchRate() {
        return catchRate;
    }

    public int getPrice() {
        return price;
    }

    // construct a list of pokeballs

    public static Pokeball createPokeball(String name) {

        switch(name.toLowerCase()){
            case "pokeball":
                return new Pokeball("Pokeball", 0.35, 200);
            case "great ball":
                return new Pokeball("Great Ball", 0.5, 600);

            // only ultra ball and master ball can be used to catch legendary pokemon
            
            case "ultra ball":
                return new Pokeball("Ultra Ball", 0.75, 850);
            case "master ball":
                return new Pokeball("Master Ball", 0.99, 1000);
            default:
                return null;
        }
    }
}
