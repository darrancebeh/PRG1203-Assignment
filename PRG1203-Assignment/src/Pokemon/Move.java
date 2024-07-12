package Pokemon;

public class Move {
    private final String name;
    private final Type type;
    private final int power;
    private final byte accuracy;
    private final byte pp;
    private final MoveType moveType;

    public Move(String name, Type type, int power, byte accuracy, byte pp, MoveType moveType) {
        this.name = name;
        this.type = type;
        this.power = power;
        this.accuracy = accuracy;
        this.pp = pp;
        this.moveType = moveType;
    }

    // Getters
    public String getName() {
        return name;
    }

    public Type getType() {
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

    // Example of a method that could be added
    public int getEffectivenessAgainst(String defendingType) {
        return type.getEffectivenessAgainst(defendingType);
    }
    
    public String effectivenessToString(int effectiveness) {
        return type.effectivenessToString(effectiveness);
    }
}