package Pokedex;

import Pokemon.Pokemon;
import Pokemon.Move;
import Pokemon.MoveType;
import Pokemon.Type;

public class Fearow extends Pokemon {
    public Fearow() {
        super(
            "Fearow",
            90,
            90,
            15,
            50,
            Type.FLYING,
            new Move[] {
                new Move("Peck", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                new Move("Drill Peck", Type.FLYING, 45, (byte) 100, (byte) 25, MoveType.SPECIAL),
                new Move("Sky Attack", Type.FLYING, 55, (byte) 95, (byte) 15, MoveType.SPECIAL),
                new Move("Agility", Type.FLYING, 50, (byte) 100, (byte) 0, MoveType.STATUS)
            }
        );
    }
    @Override
    public Pokemon evolve() {
        return null;
    }

    public boolean canEvolve() {
        return false;
    }
    
}
