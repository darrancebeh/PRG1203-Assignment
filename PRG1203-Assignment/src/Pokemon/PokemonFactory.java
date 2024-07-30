package Pokemon;
import java.util.ArrayList;
import java.util.List;

import Pokedex.*;

public class PokemonFactory {
    public static String[] getAllPokemon() {
        return new String[] {
            "Bulbasaur",
            "Charmander",
            "Squirtle",
            "Pikachu",
            "Mankey",
            "Ekans",
            "Sandshrew",    
            "Spearow",
            "Caterpie",
            "Geodude",
            "Ghastly",
            "Magnemite",
            "Jynx",
            "Abra",
            "Dratini",
            "Umbreon",
            "Clefairy",
            "Mewtwo",
            "Arceus"
        };
    }

    public static String[] getAllLegendary() {
        return new String[] {
            "Mewtwo",
            "Arceus"
        };
    }

    public static Pokemon createPokemon(String name) {

        // for simplicity, all pokemon will have four moves:
        // one physical attack that does low damage but does not cost pp to use
        // two special moves that deal higher damage and will require pp to use
        // and a status move that doesnt cost pp to use and will increase the pokemon's current pp

        // pokemons of all types will be created
        
        switch (name.toLowerCase()) {
            case "bulbasaur":
                return new Bulbasaur();

            case "charmander":
                return new Charmander();

            case "squirtle":
                return new Squirtle();

            case "pikachu":
                return new Pikachu();

            //fighting pokemon

            case "mankey":
                return new Mankey();

            //poison pokemon

            case "ekans":
                return new Ekans();

            //ground pokemon

            case "sandshrew":
                return new Sandshrew();

            //flying pokemon

            case "spearow":
                return new Spearow();

            //bug pokemon

            case "caterpie":
                return new Caterpie();

            //rock pokemon

            case "geodude":
                return new Geodude();

            //ghost pokemon

            case "ghastly":
                return new Ghastly();

            //steel pokemon

            case "magnemite":
                return new Magnemite();

            //ice pokemon

            case "jynx":
                return new Jynx();

            //psychic pokemon

            case "abra":
                return new Abra();

            //dragon pokemon

            case "dratini":
                return new Dratini();

            // dark pokemon

            case "umbreon":
                return new Umbreon();

            // fairy pokemon

            case "clefairy":
                return new Clefairy();

            // rare legendary pokemons that will have higher stats and stronger moves

            case "mewtwo":
                return new Mewtwo();

            case "arceus":
                return new Arceus();

            default:
                return null;
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

    public static String[] getRandomPokemonNoLegendaryList(int count) {
        String[] allPokemon = getAllPokemon();
        String[] allLegendary = getAllLegendary();
        List<String> randomPokemonList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int randomIndex = (int) (Math.random() * allPokemon.length);
            String randomPokemon = allPokemon[randomIndex];
            if (!randomPokemon.equals(allLegendary[0]) && !randomPokemon.equals(allLegendary[1])) {
                randomPokemonList.add(randomPokemon);
            } else {
                i--;
            }
        }
        return randomPokemonList.toArray(new String[0]);
    }

    // method that gets the name of a pokemon and returns the stats and type of pokemon without instantiating the object

    public static String getPokemonStats(String name) {
        switch (name.toLowerCase()) {
            case "bulbasaur":
                return "Bulbasaur\nType: Grass\nHealth: 75\nMax Health: 75\nPP: 15\nMax PP: 50";

            case "charmander":
                return "Charmander\nType: Fire\nHealth: 70\nMax Health: 70\nPP: 15\nMax PP: 50";

            case "squirtle":
                return "Squirtle\nType: Water\nHealth: 80\nMax Health: 80\nPP: 15\nMax PP: 50";

            case "pikachu":
                return "Pikachu\nType: Electric\nHealth: 65\nMax Health: 65\nPP: 15\nMax PP: 50";

            case "mankey":
                return "Mankey\nType: Fighting\nHealth: 70\nMax Health: 70\nPP: 15\nMax PP: 50";

            case "ekans":
                return "Ekans\nType: Poison\nHealth: 70\nMax Health: 70\nPP: 15\nMax PP: 50";

            case "sandshrew":
                return "Sandshrew\nType: Ground\nHealth: 75\nMax Health: 75\nPP: 15\nMax PP: 50";

            case "spearow":
                return "Spearow\nType: Flying\nHealth: 70\nMax Health: 70\nPP: 15\nMax PP: 50";

            case "caterpie":
                return "Caterpie\nType: Bug\nHealth: 60\nMax Health: 60\nPP: 15\nMax PP: 50";

            case "geodude":
                return "Geodude\nType: Rock\nHealth: 75\nMax Health: 75\nPP: 15\nMax PP: 50";

            case "ghastly":
                return "Ghastly\nType: Ghost\nHealth: 65\nMax Health: 65\nPP: 15\nMax PP: 50";

            case "magnemite":
                return "Magnemite\nType: Steel\nHealth: 70\nMax Health: 70\nPP: 15\nMax PP: 50";

            case "jynx":
                return "Jynx\nType: Ice\nHealth: 75\nMax Health: 75\nPP: 15\nMax PP: 50";

            case "abra":
                return "Abra\nType: Psychic\nHealth: 65\nMax Health: 65\nPP: 15\nMax PP: 50";

            case "dratini":
                return "Dratini\nType: Dragon\nHealth: 70\nMax Health: 70\nPP: 15\nMax PP: 50";

            case "umbreon":
                return "Umbreon\nType: Dark\nHealth: 80\nMax Health: 80\nPP: 15\nMax PP: 50";

            case "clefairy":
                return "Clefairy\nType: Fairy\nHealth: 75\nMax Health: 75\nPP: 15\nMax PP: 50";

            case "mewtwo":
                return "Mewtwo\nType: Psychic\nHealth: 100\nMax Health: 100\nPP: 20\nMax PP: 60";

            case "arceus":
                return "Arceus\nType: Normal\nHealth: 120\nMax Health: 120\nPP: 25\nMax PP: 70";

            default:
                return "null";
        }
    }
}