package Pokemon;
import java.util.ArrayList;
import java.util.Arrays;
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

    public static String[] randomizePokemon() {
        String[] allPokemon = getAllPokemon();
        List<String> allPokemonList = new ArrayList<>(Arrays.asList(allPokemon));
        allPokemonList.addAll(Arrays.asList(allPokemon));
        String[] randomPokemon = new String[3];
        for (int i = 0; i < 3; i++) {
            int randomIndex = (int) (Math.random() * allPokemonList.size());
            randomPokemon[i] = allPokemonList.remove(randomIndex);
        }
        return randomPokemon;
    }

    public static Pokemon createPokemon(String name) {
        switch (name) {
            case "Bulbasaur":
                return new Pokemon("Bulbasaur", 45, Type.GRASS, new Move[] {
                    new Move("Tackle", Type.NORMAL, 40, (byte) 100, (byte) 35, MoveType.PHYSICAL),
                    new Move("Vine Whip", Type.GRASS, 45, (byte) 100, (byte) 25, MoveType.PHYSICAL),
                    new Move("Growl", Type.NORMAL, 0, (byte) 100, (byte) 40, MoveType.STATUS),
                    new Move("Leech Seed", Type.GRASS, 0, (byte) 90, (byte) 10, MoveType.STATUS)
                });

            case "Charmander":
                return new Pokemon("Charmander", 39, Type.FIRE, new Move[] {
                    new Move("Scratch", Type.NORMAL, 40, (byte) 100, (byte) 35, MoveType.PHYSICAL),
                    new Move("Ember", Type.FIRE, 40, (byte) 100, (byte) 25, MoveType.SPECIAL),
                    new Move("Growl", Type.NORMAL, 0, (byte) 100, (byte) 40, MoveType.STATUS),
                    new Move("Smokescreen", Type.NORMAL, 0, (byte) 100, (byte) 20, MoveType.STATUS)
                });

            case "Squirtle":
                return new Pokemon("Squirtle", 44, Type.WATER, new Move[] {
                    new Move("Tackle", Type.NORMAL, 40, (byte) 100, (byte) 35, MoveType.PHYSICAL),
                    new Move("Water Gun", Type.WATER, 40, (byte) 100, (byte) 25, MoveType.SPECIAL),
                    new Move("Tail Whip", Type.NORMAL, 0, (byte) 100, (byte) 40, MoveType.STATUS),
                    new Move("Bubble", Type.WATER, 40, (byte) 100, (byte) 30, MoveType.SPECIAL)
                });

            case "Pikachu":
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
}