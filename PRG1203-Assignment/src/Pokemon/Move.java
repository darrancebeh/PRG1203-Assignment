package Pokemon;

public class Move {
    private final String name;
    private final Type type;
    private final int power;

    // accuracy not implemented in the battle system to reduce complications
    // but the option is there for future development
    
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

    public int getEffectivenessAgainst(String defendingType) {
        return type.getEffectivenessAgainst(defendingType);
    }
    
    public String effectivenessToString(int effectiveness) {
        return type.effectivenessToString(effectiveness);
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

    public void decideMoveType(Move move, Pokemon actor, Pokemon target) {
        if (move.getMoveType() == MoveType.PHYSICAL) {
            actor.attack(move, target);
        } else if (move.getMoveType() == MoveType.SPECIAL) {
            actor.attack(move, target);
        } else if (move.getMoveType() == MoveType.STATUS) {
            actor.statusIncreasePp(move, actor);
        }
    }
}