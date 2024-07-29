package Utility;

public class Pokeball {
    private final String name;
    private final double catchRate;

    public Pokeball(String name, double catchRate) {
        this.name = name;
        this.catchRate = catchRate;
    }

    public String getName() {
        return name;
    }

    public double getCatchRate() {
        return catchRate;
    }

    // construct a list of pokeballs

    public static Pokeball createPokeball(String name) {

        switch(name.toLowerCase()){
            case "pokeball":
                return new Pokeball("Pokeball", 0.35);
            case "great ball":
                return new Pokeball("Great Ball", 0.5);

            // only ultra ball and master ball can be used to catch legendary pokemon
            
            case "ultra ball":
                return new Pokeball("Ultra Ball", 0.85);
            case "master ball":
                return new Pokeball("Master Ball", 0.99);
            default:
                return null;
        }
    }
}
