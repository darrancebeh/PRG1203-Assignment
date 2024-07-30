package Pokedex;

import Pokemon.Pokemon;
import Pokemon.Move;
import Pokemon.MoveType;
import Pokemon.Type;

public class Abra extends Pokemon {
    public Abra() {
        super(
            "Abra",
            65,
            65,
            15,
            50,
            Type.PSYCHIC,
            new Move[] {
                new Move("Teleport", Type.PSYCHIC, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                new Move("Psybeam", Type.PSYCHIC, 45, (byte) 100, (byte) 25, MoveType.SPECIAL),
                new Move("Psychic", Type.PSYCHIC, 55, (byte) 95, (byte) 15, MoveType.SPECIAL),
                new Move("Calm Mind", Type.PSYCHIC, 50, (byte) 100, (byte) 0, MoveType.STATUS)
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