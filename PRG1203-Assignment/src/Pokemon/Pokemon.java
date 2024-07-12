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

    public void attack(Move move, Pokemon opponent) {
        System.out.println(this.name + " used " + move.getName() + " on " + opponent.getName() + "!");
        System.out.println("The move effectiveness was: " + move.effectivenessToString(move.getEffectivenessAgainst(opponent.getType().name())));
        int damage = calculateDamage(move, opponent);
        opponent.setHealth(opponent.getHealth() - damage);
    }

    public int calculateDamage(Move move, Pokemon opponent) {
        int damage = move.getPower();
        int effectiveness = move.getEffectivenessAgainst(opponent.getType().name());
        if (effectiveness == 1) {
            damage *= 2;
        } else if (effectiveness == -1) {
            damage /= 2;
        } else if (effectiveness == -2) {
            damage *= 0;
        } else {
            damage *= 1;
        }

        return damage;
    }

    
    
}
