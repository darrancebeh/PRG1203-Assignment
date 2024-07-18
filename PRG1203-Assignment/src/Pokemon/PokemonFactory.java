package Pokemon;
import java.util.ArrayList;
import java.util.List;

public class PokemonFactory {
    public static String[] getAllPokemon() {
        return new String[] {
            "Bulbasaur",
            "Charmander",
            "Squirtle",
            "Pikachu"
        };
    }

    public static Pokemon createPokemon(String name) {
        
        switch (name.toLowerCase()) {
            case "bulbasaur":
                return new Pokemon("Bulbasaur", 45, Type.GRASS, new Move[] {
                    new Move("Tackle", Type.NORMAL, 40, (byte) 100, (byte) 35, MoveType.PHYSICAL),
                    new Move("Vine Whip", Type.GRASS, 45, (byte) 100, (byte) 25, MoveType.PHYSICAL),
                    new Move("Growl", Type.NORMAL, 0, (byte) 100, (byte) 40, MoveType.STATUS),
                    new Move("Leech Seed", Type.GRASS, 0, (byte) 90, (byte) 10, MoveType.STATUS)
                });

            case "charmander":
                return new Pokemon("Charmander", 39, Type.FIRE, new Move[] {
                    new Move("Scratch", Type.NORMAL, 40, (byte) 100, (byte) 35, MoveType.PHYSICAL),
                    new Move("Ember", Type.FIRE, 40, (byte) 100, (byte) 25, MoveType.SPECIAL),
                    new Move("Growl", Type.NORMAL, 0, (byte) 100, (byte) 40, MoveType.STATUS),
                    new Move("Smokescreen", Type.NORMAL, 0, (byte) 100, (byte) 20, MoveType.STATUS)
                });

            case "squirtle":
                return new Pokemon("Squirtle", 44, Type.WATER, new Move[] {
                    new Move("Tackle", Type.NORMAL, 40, (byte) 100, (byte) 35, MoveType.PHYSICAL),
                    new Move("Water Gun", Type.WATER, 40, (byte) 100, (byte) 25, MoveType.SPECIAL),
                    new Move("Tail Whip", Type.NORMAL, 0, (byte) 100, (byte) 40, MoveType.STATUS),
                    new Move("Bubble", Type.WATER, 40, (byte) 100, (byte) 30, MoveType.SPECIAL)
                });

            case "pikachu":
                return new Pokemon("Pikachu", 35, Type.ELECTRIC, new Move[] {
                    new Move("Quick Attack", Type.NORMAL, 40, (byte) 100, (byte) 30, MoveType.PHYSICAL),
                    new Move("Thunder Shock", Type.ELECTRIC, 40, (byte) 100, (byte) 30, MoveType.SPECIAL),
                    new Move("Growl", Type.NORMAL, 0, (byte) 100, (byte) 40, MoveType.STATUS),
                    new Move("Tail Whip", Type.NORMAL, 0, (byte) 100, (byte) 30, MoveType.STATUS)
                });

            default:
                throw new IllegalArgumentException("Unknown Pokemon: " + name);
        }
    }

    public static String[] getRandomPokemonList(int count) {
        String[] allPokemon = getAllPokemon();
        List<String> randomPokemonList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int randomIndex = (int) (Math.random() * allPokemon.length);
            randomPokemonList.add(allPokemon[randomIndex]);
        }
        return randomPokemonList.toArray(new String[0]);
    }
}