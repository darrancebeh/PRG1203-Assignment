package Pokedex;

import Pokemon.Pokemon;
import Pokemon.Move;
import Pokemon.MoveType;
import Pokemon.Type;

public class Clefairy extends Pokemon {
    public Clefairy() {
        super(
            "Clefairy",
            75,
            75,
            15,
            50,
            Type.FAIRY,
            new Move[] {
                new Move("Pound", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                new Move("Disarming Voice", Type.FAIRY, 45, (byte) 100, (byte) 25, MoveType.SPECIAL),
                new Move("Moonblast", Type.FAIRY, 55, (byte) 95, (byte) 15, MoveType.SPECIAL),
                new Move("Cosmic Power", Type.FAIRY, 50, (byte) 100, (byte) 0, MoveType.STATUS)
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