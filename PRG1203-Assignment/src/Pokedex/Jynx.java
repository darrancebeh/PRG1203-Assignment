package Pokedex;

import Pokemon.Pokemon;
import Pokemon.Move;
import Pokemon.MoveType;
import Pokemon.Type;

public class Jynx extends Pokemon {
    public Jynx() {
        super(
            "Jynx",
            75,
            75,
            15,
            50,
            Type.ICE,
            new Move[] {
                new Move("Pound", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                new Move("Ice Punch", Type.ICE, 55, (byte) 100, (byte) 25, MoveType.SPECIAL),
                new Move("Blizzard", Type.ICE, 45, (byte) 95, (byte) 15, MoveType.SPECIAL),
                new Move("Hail", Type.ICE, 50, (byte) 100, (byte) 0, MoveType.STATUS)
            }
        );
    }

    @Override
    public Pokemon evolve() {
        return null; // Jynx does not evolve
    }

    public boolean canEvolve() {
        return false;
    }
}