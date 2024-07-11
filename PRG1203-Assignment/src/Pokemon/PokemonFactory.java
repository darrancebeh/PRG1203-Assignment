package Pokemon;

public class PokemonFactory {
    public static Pokemon createPokemon(String name) {
        switch (name) {
            case "Bulbasaur":
                return new Pokemon("Bulbasaur", 45, Type.GRASS, new Move[]{Move.TACKLE, Move.GROWL, Move.VINE_WHIP, Move.LEECH_SEED});
            case "Charmander":
                return new Pokemon("Charmander", 39, Type.FIRE, new Move[]{Move.SCRATCH, Move.GROWL, Move.EMBER, Move.SMOKESCREEN});
            case "Squirtle":
                return new Pokemon("Squirtle", 44, Type.WATER, new Move[]{Move.TACKLE, Move.TAIL_WHIP, Move.WATER_GUN, Move.WITHDRAW});
            case "Pikachu":
                return new Pokemon("Pikachu", 35, Type.ELECTRIC, new Move[]{Move.THUNDER_SHOCK, Move.GROWL, Move.QUICK_ATTACK, Move.ELECTRO_BALL});
            case "Jigglypuff":
                return new Pokemon("Jigglypuff", 115, Type.NORMAL, new Move[]{Move.SING, Move.DEFENSE_CURL, Move.POUND, Move.DOUBLE_SLAP});
            case "Meowth":
                return new Pokemon("Meowth", 40, Type.NORMAL, new Move[]{Move.SCRATCH, Move.GROWL, Move.BITE, Move.PAY_DAY});
            case "Psyduck":
                return new Pokemon("Psyduck", 50, Type.WATER, new Move[]{Move.SCRATCH, Move.TAIL_WHIP, Move.WATER_GUN, Move.CONFUSION});
            case "Machop":
                return new Pokemon("Machop", 70, Type.FIGHTING, new Move[]{Move.KARATE_CHOP, Move.LOW_KICK, Move.LEER, Move.FOCUS_ENERGY});
            case "Geodude":
                return new Pokemon("Geodude", 40, Type.ROCK, new Move[]{Move.TACKLE, Move.DEFENSE_CURL, Move.ROCK_THROW, Move.MAGNITUDE});
            case "Gastly":
                return new Pokemon("Gastly", 30, Type.GHOST, new Move[]{Move.LICK, Move.SPITE, Move.HYPNOSIS, Move.NIGHT_SHADE});
            case "Onix":
                return new Pokemon("Onix", 35, Type.ROCK, new Move[]{Move.TACKLE, Move.SCREECH, Move.BIND, Move.ROCK_THROW});
            case "Drowzee":
                return new Pokemon("Drowzee", 60, Type.PSYCHIC, new Move[]{Move.POUND, Move.HYPNOSIS, Move.DISABLE, Move.CONFUSION});
            case "Krabby":
                return new Pokemon("Krabby", 30, Type.WATER, new Move[]{Move.BUBBLE, Move.LEER, Move.VICE_GRIP, Move.HARDEN});
            default:
                throw new IllegalArgumentException("Unknown Pokemon: " + name);
        }
    }
}