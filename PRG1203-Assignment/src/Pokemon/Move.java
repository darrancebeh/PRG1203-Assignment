package Pokemon;

public enum Move {
    TACKLE("Tackle", Type.NORMAL, 40, (byte) 100, (byte) 35, MoveType.PHYSICAL),
    GROWL("Growl", Type.NORMAL, 0, (byte) 100, (byte) 40, MoveType.STATUS),
    EMBER("Ember", Type.FIRE, 40, (byte) 100, (byte) 25, MoveType.SPECIAL),
    WATER_GUN("Water Gun", Type.WATER, 40, (byte) 100, (byte) 25, MoveType.SPECIAL),
    VINE_WHIP("Vine Whip", Type.GRASS, 45, (byte) 100, (byte) 25, MoveType.PHYSICAL),
    THUNDER_SHOCK("Thunder Shock", Type.ELECTRIC, 40, (byte) 100, (byte) 30, MoveType.SPECIAL),
    QUICK_ATTACK("Quick Attack", Type.NORMAL, 40, (byte) 100, (byte) 30, MoveType.PHYSICAL),
    PECK("Peck", Type.FLYING, 35, (byte) 100, (byte) 35, MoveType.PHYSICAL),
    THUNDER_WAVE("Thunder Wave", Type.ELECTRIC, 0, (byte) 90, (byte) 20, MoveType.STATUS),
    CONFUSION("Confusion", Type.PSYCHIC, 50, (byte) 100, (byte) 25, MoveType.SPECIAL),
    FLAMETHROWER("Flamethrower", Type.FIRE, 90, (byte) 100, (byte) 15, MoveType.SPECIAL),
    POWER_WHIP("Power Whip", Type.GRASS, 120, (byte) 85, (byte) 10, MoveType.PHYSICAL),
    HYDRO_PUMP("Hydro Pump", Type.WATER, 110, (byte) 80, (byte) 5, MoveType.SPECIAL),
    THUNDERBOLT("Thunderbolt", Type.ELECTRIC, 90, (byte) 100, (byte) 15, MoveType.SPECIAL),
    TAIL_WHIP("Tail Whip", Type.NORMAL, 0, (byte) 100, (byte) 30, MoveType.STATUS),
    THUNDER("Thunder", Type.ELECTRIC, 110, (byte) 70, (byte) 10, MoveType.SPECIAL),
    ZEN_HEADBUTT("Zen Headbutt", Type.PSYCHIC, 80, (byte) 90, (byte) 15, MoveType.PHYSICAL),
    AMNESIA("Amnesia", Type.PSYCHIC, 0, (byte) 100, (byte) 20, MoveType.STATUS),
    AQUA_TAIL("Aqua Tail", Type.WATER, 90, (byte) 90, (byte) 10, MoveType.PHYSICAL),
    SCRATCH("Scratch", Type.NORMAL, 40, (byte) 100, (byte) 35, MoveType.PHYSICAL),
    PSYSTRIKE("Psystrike", Type.PSYCHIC, 100, (byte) 100, (byte) 10, MoveType.SPECIAL),
    HIGH_HORSEPOWER("High Horsepower", Type.GROUND, 95, (byte) 95, (byte) 10, MoveType.PHYSICAL),
    BELCH("Belch", Type.POISON, 120, (byte) 90, (byte) 10, MoveType.SPECIAL),
    SHADOW_BALL("Shadow Ball", Type.GHOST, 80, (byte) 100, (byte) 15, MoveType.SPECIAL),
    HEX("Hex", Type.GHOST, 65, (byte) 100, (byte) 10, MoveType.SPECIAL),
    PAYBACK("Payback", Type.DARK, 50, (byte) 100, (byte) 10, MoveType.PHYSICAL),
    LICK("Lick", Type.GHOST, 30, (byte) 100, (byte) 30, MoveType.PHYSICAL);

    private final String name;
    private final Type type;
    private final int power;
    private final byte accuracy;
    private final byte pp;
    private final MoveType moveType;

    Move(String name, Type type, int power, byte accuracy, byte pp, MoveType moveType) {
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

}