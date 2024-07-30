package Pokedex;

import Pokemon.Pokemon;
import Pokemon.Move;
import Pokemon.MoveType;
import Pokemon.Type;

public class Arceus extends Pokemon {
    public Arceus() {
        super(
            "Arceus",
            150,
            150,
            30,
            70,
            Type.NORMAL,
            new Move[] {
                new Move("Hyper Beam", Type.NORMAL, 70, (byte) 100, (byte) 35, MoveType.SPECIAL),
                new Move("Judgement", Type.NORMAL, 80, (byte) 100, (byte) 40, MoveType.SPECIAL),
                new Move("Extreme Speed", Type.NORMAL, 90, (byte) 95, (byte) 30, MoveType.PHYSICAL),
                new Move("Recover", Type.NORMAL, 60, (byte) 100, (byte) 0, MoveType.STATUS)
            }
        );
    }

    @Override
    public Pokemon evolve() {
        return null; // Arceus does not evolve
    }

    public boolean canEvolve() {
        return false;
    }
}