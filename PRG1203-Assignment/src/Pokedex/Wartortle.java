package Pokedex;

import Pokemon.Pokemon;
import Pokemon.Move;
import Pokemon.MoveType;
import Pokemon.Type;

public class Wartortle extends Pokemon {
    public Wartortle() {
        super(
            "Wartortle",
            90,
            90,
            15,
            50,
            Type.WATER,
            new Move[] {
                new Move("Tackle", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                new Move("Water Gun", Type.WATER, 55, (byte) 100, (byte) 25, MoveType.SPECIAL),
                new Move("Hydro Pump", Type.WATER, 45, (byte) 95, (byte) 15, MoveType.SPECIAL),
                new Move("Rain Dance", Type.WATER, 50, (byte) 100, (byte) 0, MoveType.STATUS)
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
