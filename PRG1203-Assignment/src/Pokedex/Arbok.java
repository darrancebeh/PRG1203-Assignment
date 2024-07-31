package Pokedex;

import Pokemon.Pokemon;
import Pokemon.Move;
import Pokemon.MoveType;
import Pokemon.Type;

public class Arbok extends Pokemon {
    public Arbok() {
        super(
            "Arbok",
            80,
            80,
            15,
            50,
            Type.POISON,
            new Move[] {
                new Move("Bite", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                new Move("Poison Sting", Type.POISON, 55, (byte) 100, (byte) 25, MoveType.SPECIAL),
                new Move("Sludge Bomb", Type.POISON, 45, (byte) 95, (byte) 15, MoveType.SPECIAL),
                new Move("Acid", Type.POISON, 50, (byte) 100, (byte) 0, MoveType.STATUS)
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
