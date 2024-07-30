package Pokedex;

import Pokemon.Pokemon;
import Pokemon.Move;
import Pokemon.MoveType;
import Pokemon.Type;

public class Dratini extends Pokemon {
    public Dratini() {
        super(
            "Dratini",
            70,
            70,
            15,
            50,
            Type.DRAGON,
            new Move[] {
                new Move("Wrap", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                new Move("Dragon Rage", Type.DRAGON, 45, (byte) 100, (byte) 25, MoveType.SPECIAL),
                new Move("Dragon Breath", Type.DRAGON, 55, (byte) 95, (byte) 15, MoveType.SPECIAL),
                new Move("Dragon Dance", Type.DRAGON, 50, (byte) 100, (byte) 0, MoveType.STATUS)
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