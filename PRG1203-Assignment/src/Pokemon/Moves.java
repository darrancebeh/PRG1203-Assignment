public class Moves {
    private final String name;
    private final PokemonType type;
    private final int power;
    private final byte accuracy;
    private final byte pp;
    private final MoveType moveType;

    public Moves(String name, PokemonType type, int power, byte accuracy, byte pp, MoveType moveType) {
        this.name = name;
        this.type = type;
        this.power = power;
        this.accuracy = accuracy;
        this.pp = pp;
        this.moveType = moveType;
    }

    public String getName() {
        return name;
    }

    public PokemonType getType() {
        return type;
    }

    public int getPower() {
        return power;
    }

    public byte getAccuracy() {
        return accuracy;
    }

    public byte getPp() {
        return pp;
    }

    public MoveType getMoveType() {
        return moveType;
    }

    public String toString() {
        return name + " (" + type + ")" + " Power: " + power + " Accuracy: " + accuracy + " PP: " + pp;
    }

}
