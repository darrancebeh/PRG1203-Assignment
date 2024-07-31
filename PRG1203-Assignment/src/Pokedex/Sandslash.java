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
                new Move("Earth SLASH", Type.GROUND, 100, (byte) 100, (byte) 65, MoveType.SPECIAL),
                new Move("Sand Recover", Type.GROUND, 40, (byte) 100, (byte) 0, MoveType.STATUS),
                new Move("Slash", Type.NORMAL, 65, (byte) 100, (byte) 20, MoveType.PHYSICAL)
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
