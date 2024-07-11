package Pokemon;

public class Pokemon {
    private final String name;
    private int health;
    private final int maxHealth;
    private final Type type;
    private Move[] moves;

    public Pokemon(String name, int health, Type type, Move[] moves) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.type = type;
        this.moves = moves;
    }   

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public Type getType() {
        return type;
    }

    public Move[] getMoves() {
        return moves;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    
    
}
