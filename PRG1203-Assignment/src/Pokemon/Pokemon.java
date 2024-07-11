public class Pokemon {
    private final String name;
    private int health;
    private final int maxHealth;
    private final PokemonType type;
    private final Moves[] moves;

    public Pokemon(String name, int health, PokemonType type, Move[] moves) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.type = type;
        this.moves = moves;
    }
    
}
