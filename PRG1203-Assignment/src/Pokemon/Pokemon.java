package Pokemon;

public abstract class Pokemon {
    private final String name;
    private int health;
    private int maxHealth;
    private int pp;
    private int maxPp;
    private final Type type;
    private Move[] moves;

    public Pokemon(String name, int health, int maxHealth, int pp, int maxPp, Type type, Move[] moves) {
        this.name = name;
        this.health = health;
        this.maxHealth = maxHealth;
        this.pp = pp;
        this.maxPp = maxPp;
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

    public int getPp() {
        return pp;
    }

    public int getMaxPp() {
        return maxPp;
    }

    public Type getType() {
        return type;
    }

    public Move[] getMoves() {
        return moves;
    }

    public void setHealth(int health) {
        // health cannot be less than 0

        if (health < 0) {
            health = 0;
        }

        // health cannot exceed max health

        if (health > this.maxHealth) {
            health = this.maxHealth;
        }

        this.health = health;

    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public void setMaxPp(int maxPp) {
        this.maxPp = maxPp;
    }

    public void attack(Move move, Pokemon opponent) {
        System.out.println(this.name + " used " + move.getName() + " on " + opponent.getName() + "!");
        System.out.println("The move effectiveness was: " + move.effectivenessToString(move.getEffectivenessAgainst(opponent.getType().name())));
        int damage = move.calculateDamage(move, opponent);
        opponent.setHealth(opponent.getHealth() - damage);

        // decrease pp after use

        this.setPp(this.getPp() - move.getPp());

        // display damage dealt

        System.out.println(opponent.getName() + " has taken " + damage + " damage!");
    }

    public void statusIncreasePp(Move move, Pokemon actor) {
        int ppIncrement = move.getPower();

        // pp cannot exceed max pp

        if (actor.getPp() + ppIncrement > actor.getMaxPp()) {
            ppIncrement = actor.getMaxPp() - actor.getPp();
        }
    
        actor.setPp(actor.getPp() + ppIncrement);

        System.out.println(actor.getName() + " used " + move.getName() + "!");
        System.out.println(actor.getName() + " has gained " + ppIncrement + " PP!");
    }

    public void toString (Pokemon pokemon) {
        System.out.println("Name: " + pokemon.getName());
        System.out.println("Health: " + pokemon.getHealth() + "/" + pokemon.getMaxHealth());
        System.out.println("PP: " + pokemon.getPp() + "/" + pokemon.getMaxPp());
        System.out.println("Type: " + pokemon.getType().name());

        String status = (pokemon.getHealth() == 0) ? "Fainted" : "Active";
        System.out.println("Status: " + status);
    }

    public abstract Pokemon evolve();
    public abstract boolean canEvolve();
}
