package Pokedex;

import Pokemon.Pokemon;
import Pokemon.Move;
import Pokemon.MoveType;
import Pokemon.Type;

public class Graveler extends Pokemon {
    public Graveler() {
        super(
            "Graveler",
            85,
            85,
            15,
            50,
            Type.ROCK,
            new Move[] {
                new Move("Tackle", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                new Move("Rock Throw", Type.ROCK, 55, (byte) 100, (byte) 25, MoveType.SPECIAL),
                new Move("Rock Slide", Type.ROCK, 45, (byte) 95, (byte) 15, MoveType.SPECIAL),
                new Move("Rock Polish", Type.ROCK, 50, (byte) 100, (byte) 0, MoveType.STATUS)
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
