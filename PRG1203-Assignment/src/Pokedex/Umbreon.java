package Pokedex;

import Pokemon.Pokemon;
import Pokemon.Move;
import Pokemon.MoveType;
import Pokemon.Type;

public class Umbreon extends Pokemon {
    public Umbreon() {
        super(
            "Umbreon",
            80,
            80,
            15,
            50,
            Type.DARK,
            new Move[] {
                new Move("Bite", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                new Move("Pursuit", Type.DARK, 45, (byte) 100, (byte) 25, MoveType.SPECIAL),
                new Move("Foul Play", Type.DARK, 55, (byte) 95, (byte) 15, MoveType.SPECIAL),
                new Move("Confuse Ray", Type.DARK, 50, (byte) 100, (byte) 0, MoveType.STATUS)
            }
        );
    }
    @Override
    
    public Pokemon evolve() {
        return null; // Umbreon does not evolve
    }

    public boolean canEvolve() {
        return false;
    }
}