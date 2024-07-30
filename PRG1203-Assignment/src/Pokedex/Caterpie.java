package Pokedex;

import Pokemon.Pokemon;
import Pokemon.Move;
import Pokemon.MoveType;
import Pokemon.Type;

public class Caterpie extends Pokemon {
    public Caterpie() {
        super(
            "Caterpie",
            60,
            60,
            15,
            50,
            Type.BUG,
            new Move[] {
                new Move("Tackle", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                new Move("Bug Bite", Type.BUG, 45, (byte) 100, (byte) 25, MoveType.SPECIAL),
                new Move("Struggle Bug", Type.BUG, 55, (byte) 95, (byte) 15, MoveType.SPECIAL),
                new Move("String Shot", Type.BUG, 50, (byte) 100, (byte) 0, MoveType.STATUS)
            }
        );
    }
    @Override
    public Pokemon evolve() {
        return new Metapod();
    }

    public boolean canEvolve() {
        return true;
    }
}