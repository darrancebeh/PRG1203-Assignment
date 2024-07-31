package Pokedex;

import Pokemon.Pokemon;
import Pokemon.Move;
import Pokemon.MoveType;
import Pokemon.Type;

public class Ghastly extends Pokemon {
    public Ghastly() {
        super(
            "Ghastly",
            65,
            65,
            15,
            50,
            Type.GHOST,
            new Move[] {
                new Move("Lick", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                new Move("Shadow Ball", Type.GHOST, 55, (byte) 100, (byte) 25, MoveType.SPECIAL),
                new Move("Dream Eater", Type.GHOST, 45, (byte) 95, (byte) 15, MoveType.SPECIAL),
                new Move("Night Shade", Type.GHOST, 50, (byte) 100, (byte) 0, MoveType.STATUS)
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