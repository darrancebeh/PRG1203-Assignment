package Pokedex;

import Pokemon.Pokemon;
import Pokemon.Move;
import Pokemon.MoveType;
import Pokemon.Type;


public class Sandslash extends Pokemon {
    public Sandslash() {
        super(
            "Sandslash",
            75,
            110,
            15,
            65,
            Type.GROUND,
            new Move[] {
                new Move("Scratch", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                new Move("Earthquake", Type.GROUND, 100, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                new Move("Sand Attack", Type.GROUND, 0, (byte) 100, (byte) 15, MoveType.STATUS),
                new Move("Slash", Type.NORMAL, 70, (byte) 100, (byte) 20, MoveType.PHYSICAL)
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
