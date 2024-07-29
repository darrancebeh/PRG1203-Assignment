package Pokemon;
import java.util.ArrayList;
import java.util.List;

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
                return new Pokemon(
                    "Bulbasaur",
                    75,
                    75,
                    15,
                    50,
                    Type.GRASS,
                    new Move[] {
                        new Move("Tackle", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                        new Move("Vine Whip", Type.GRASS, 45, (byte) 100, (byte) 25, MoveType.SPECIAL),
                        new Move("Razor Leaf", Type.GRASS, 55, (byte) 95, (byte) 15, MoveType.SPECIAL),
                        new Move("Synthesis", Type.GRASS, 50, (byte) 100, (byte) 0, MoveType.STATUS)
                    }
                );

            case "charmander":
                return new Pokemon(
                    "Charmander",
                    70,
                    70,
                    15,
                    50,
                    Type.FIRE,
                    new Move[] {
                        new Move("Scratch", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                        new Move("Ember", Type.FIRE, 45, (byte) 100, (byte) 25, MoveType.SPECIAL),
                        new Move("Flamethrower", Type.FIRE, 55, (byte) 95, (byte) 15, MoveType.SPECIAL),
                        new Move("Fire Spin", Type.FIRE, 50, (byte) 100, (byte) 0, MoveType.STATUS)
                    }
                );

            case "squirtle":
                return new Pokemon(
                    "Squirtle",
                    80,
                    80,
                    15,
                    50,
                    Type.WATER,
                    new Move[] {
                        new Move("Tackle", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                        new Move("Water Gun", Type.WATER, 45, (byte) 100, (byte) 25, MoveType.SPECIAL),
                        new Move("Hydro Pump", Type.WATER, 55, (byte) 95, (byte) 15, MoveType.SPECIAL),
                        new Move("Rain Dance", Type.WATER, 50, (byte) 100, (byte) 0, MoveType.STATUS)
                    }
                );

            case "pikachu":
                return new Pokemon(
                    "Pikachu",
                    65,
                    65,
                    15,
                    50,
                    Type.ELECTRIC,
                    new Move[] {
                        new Move("Quick Attack", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                        new Move("Thunder Shock", Type.ELECTRIC, 45, (byte) 100, (byte) 25, MoveType.SPECIAL),
                        new Move("Thunderbolt", Type.ELECTRIC, 55, (byte) 95, (byte) 15, MoveType.SPECIAL),
                        new Move("Thunder Wave", Type.ELECTRIC, 50, (byte) 100, (byte) 0, MoveType.STATUS)
                    }
                );

            //fighting pokemon

            case "mankey":
                return new Pokemon(
                    "Mankey",
                    70,
                    70,
                    15,
                    50,
                    Type.FIGHTING,
                    new Move[] {
                        new Move("Scratch", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                        new Move("Karate Chop", Type.FIGHTING, 45, (byte) 100, (byte) 25, MoveType.SPECIAL),
                        new Move("Cross Chop", Type.FIGHTING, 55, (byte) 95, (byte) 15, MoveType.SPECIAL),
                        new Move("Focus Energy", Type.FIGHTING, 50, (byte) 100, (byte) 0, MoveType.STATUS)
                    }
                );

            //poison pokemon

            case "ekans":
                return new Pokemon(
                    "Ekans",
                    70,
                    70,
                    15,
                    50,
                    Type.POISON,
                    new Move[] {
                        new Move("Bite", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                        new Move("Poison Sting", Type.POISON, 45, (byte) 100, (byte) 25, MoveType.SPECIAL),
                        new Move("Sludge Bomb", Type.POISON, 55, (byte) 95, (byte) 15, MoveType.SPECIAL),
                        new Move("Acid", Type.POISON, 50, (byte) 100, (byte) 0, MoveType.STATUS)
                    }
                );

            //ground pokemon

            case "sandshrew":
                return new Pokemon(
                    "Sandshrew",
                    75,
                    75,
                    15,
                    50,
                    Type.GROUND,
                    new Move[] {
                        new Move("Scratch", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                        new Move("Mud-Slap", Type.GROUND, 45, (byte) 100, (byte) 25, MoveType.SPECIAL),
                        new Move("Earthquake", Type.GROUND, 55, (byte) 95, (byte) 15, MoveType.SPECIAL),
                        new Move("Sand Attack", Type.GROUND, 50, (byte) 100, (byte) 0, MoveType.STATUS)
                    }
                );

            //flying pokemon

            case "spearow":
                return new Pokemon(
                    "Spearow",
                    70,
                    70,
                    15,
                    50,
                    Type.FLYING,
                    new Move[] {
                        new Move("Peck", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                        new Move("Wing Attack", Type.FLYING, 45, (byte) 100, (byte) 25, MoveType.SPECIAL),
                        new Move("Aerial Ace", Type.FLYING, 55, (byte) 95, (byte) 15, MoveType.SPECIAL),
                        new Move("Agility", Type.FLYING, 50, (byte) 100, (byte) 0, MoveType.STATUS)
                    }
                );

            //bug pokemon

            case "caterpie":
                return new Pokemon(
                    "Caterpie",
                    60,
                    60,
                    15,
                    50,
                    Type.BUG,
                    new Move[] {
                        new Move("Tackle", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                        new Move("Bug Bite", Type.BUG, 45, (byte) 100, (byte) 25, MoveType.SPECIAL),
                        new Move("Struggle Bug", Type.BUG, 55, (byte) 95, (byte) 15, MoveType.SPECIAL),
                        new Move("String Shot", Type.BUG, 50, (byte) 100, (byte) 0, MoveType.STATUS)
                    }
                );

            //rock pokemon

            case "geodude":
                return new Pokemon(
                    "Geodude",
                    75,
                    75,
                    15,
                    50,
                    Type.ROCK,
                    new Move[] {
                        new Move("Tackle", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                        new Move("Rock Throw", Type.ROCK, 45, (byte) 100, (byte) 25, MoveType.SPECIAL),
                        new Move("Rock Slide", Type.ROCK, 55, (byte) 95, (byte) 15, MoveType.SPECIAL),
                        new Move("Rock Polish", Type.ROCK, 50, (byte) 100, (byte) 0, MoveType.STATUS)
                    }
                );

            //ghost pokemon

            case "ghastly":
                return new Pokemon(
                    "Ghastly",
                    65,
                    65,
                    15,
                    50,
                    Type.GHOST,
                    new Move[] {
                        new Move("Lick", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                        new Move("Shadow Ball", Type.GHOST, 45, (byte) 100, (byte) 25, MoveType.SPECIAL),
                        new Move("Dream Eater", Type.GHOST, 55, (byte) 95, (byte) 15, MoveType.SPECIAL),
                        new Move("Night Shade", Type.GHOST, 50, (byte) 100, (byte) 0, MoveType.STATUS)
                    }
                );

            //steel pokemon

            case "magnemite":
                return new Pokemon(
                    "Magnemite",
                    70,
                    70,
                    15,
                    50,
                    Type.STEEL,
                    new Move[] {
                        new Move("Tackle", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                        new Move("Thunder Shock", Type.ELECTRIC, 45, (byte) 100, (byte) 25, MoveType.SPECIAL),
                        new Move("Flash Cannon", Type.STEEL, 55, (byte) 95, (byte) 15, MoveType.SPECIAL),
                        new Move("Magnet Rise", Type.STEEL, 50, (byte) 100, (byte) 0, MoveType.STATUS)
                    }
                );

            //ice pokemon

            case "jynx":
                return new Pokemon(
                    "Jynx",
                    75,
                    75,
                    15,
                    50,
                    Type.ICE,
                    new Move[] {
                        new Move("Pound", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                        new Move("Ice Punch", Type.ICE, 45, (byte) 100, (byte) 25, MoveType.SPECIAL),
                        new Move("Blizzard", Type.ICE, 55, (byte) 95, (byte) 15, MoveType.SPECIAL),
                        new Move("Hail", Type.ICE, 50, (byte) 100, (byte) 0, MoveType.STATUS)
                    }
                );

            //psychic pokemon

            case "abra":
                return new Pokemon(
                    "Abra",
                    65,
                    65,
                    15,
                    50,
                    Type.PSYCHIC,
                    new Move[] {
                        new Move("Teleport", Type.PSYCHIC, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                        new Move("Psybeam", Type.PSYCHIC, 45, (byte) 100, (byte) 25, MoveType.SPECIAL),
                        new Move("Psychic", Type.PSYCHIC, 55, (byte) 95, (byte) 15, MoveType.SPECIAL),
                        new Move("Calm Mind", Type.PSYCHIC, 50, (byte) 100, (byte) 0, MoveType.STATUS)
                    }
                );

            //dragon pokemon

            case "dratini":
                return new Pokemon(
                    "Dratini",
                    70,
                    70,
                    15,
                    50,
                    Type.DRAGON,
                    new Move[] {
                        new Move("Wrap", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                        new Move("Dragon Rage", Type.DRAGON, 45, (byte) 100, (byte) 25, MoveType.SPECIAL),
                        new Move("Dragon Breath", Type.DRAGON, 55, (byte) 95, (byte) 15, MoveType.SPECIAL),
                        new Move("Dragon Dance", Type.DRAGON, 50, (byte) 100, (byte) 0, MoveType.STATUS)
                    }
                );

            // dark pokemon

            case "umbreon":
                return new Pokemon(
                    "Umbreon",
                    80,
                    80,
                    15,
                    50,
                    Type.DARK,
                    new Move[] {
                        new Move("Bite", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                        new Move("Pursuit", Type.DARK, 45, (byte) 100, (byte) 25, MoveType.SPECIAL),
                        new Move("Foul Play", Type.DARK, 55, (byte) 95, (byte) 15, MoveType.SPECIAL),
                        new Move("Confuse Ray", Type.DARK, 50, (byte) 100, (byte) 0, MoveType.STATUS)
                    }
                );

            // fairy pokemon

            case "clefairy":
                return new Pokemon(
                    "Clefairy",
                    75,
                    75,
                    15,
                    50,
                    Type.FAIRY,
                    new Move[] {
                        new Move("Pound", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                        new Move("Disarming Voice", Type.FAIRY, 45, (byte) 100, (byte) 25, MoveType.SPECIAL),
                        new Move("Moonblast", Type.FAIRY, 55, (byte) 95, (byte) 15, MoveType.SPECIAL),
                        new Move("Cosmic Power", Type.FAIRY, 50, (byte) 100, (byte) 0, MoveType.STATUS)
                    }
                );

            // rare legendary pokemons that will have higher stats and stronger moves

            case "mewtwo":
                return new Pokemon(
                    "Mewtwo",
                    125,
                    125,
                    20,
                    60,
                    Type.PSYCHIC,
                    new Move[] {
                        new Move("Swift", Type.NORMAL, 40, (byte) 100, (byte) 15, MoveType.PHYSICAL),
                        new Move("Psychic", Type.PSYCHIC, 70, (byte) 100, (byte) 30, MoveType.SPECIAL),
                        new Move("Aura Sphere", Type.PSYCHIC, 100, (byte) 95, (byte) 20, MoveType.SPECIAL),
                        new Move("Recover", Type.PSYCHIC, 60, (byte) 100, (byte) 0, MoveType.STATUS)
                    }
                );

            case "arceus":
                return new Pokemon(
                    "Arceus",
                    150,
                    150,
                    30,
                    70,
                    Type.NORMAL,
                    new Move[] {
                        new Move("Hyper Beam", Type.NORMAL, 70, (byte) 100, (byte) 35, MoveType.SPECIAL),
                        new Move("Judgement", Type.NORMAL, 80, (byte) 100, (byte) 40, MoveType.SPECIAL),
                        new Move("Extreme Speed", Type.NORMAL, 90, (byte) 95, (byte) 30, MoveType.PHYSICAL),
                        new Move("Recover", Type.NORMAL, 60, (byte) 100, (byte) 0, MoveType.STATUS)
                    }
                );

            default:
                return new Pokemon("default", 0, 0, 0, 0, null, null);
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