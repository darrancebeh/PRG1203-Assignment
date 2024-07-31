package Pokedex;

import Pokemon.Pokemon;
import Pokemon.Move;
import Pokemon.MoveType;
import Pokemon.Type;

public class Sandshrew extends Pokemon {
    public Sandshrew() {
        super(
            "Sandshrew",
            75,
            75,
            15,
            50,
            Type.GROUND,
            new Move[] {
                new Move("Scratch", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                new Move("Mud-Slap", Type.GROUND, 55, (byte) 100, (byte) 25, MoveType.SPECIAL),
                new Move("Earthquake", Type.GROUND, 45, (byte) 95, (byte) 15, MoveType.SPECIAL),
                new Move("Sand Attack", Type.GROUND, 50, (byte) 100, (byte) 0, MoveType.STATUS)
            }
        );
    }
    @Override
    public Pokemon evolve() {
        return new Sandslash();
    }

    public boolean canEvolve() {
        return true;
    }
}