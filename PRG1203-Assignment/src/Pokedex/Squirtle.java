package Pokedex;

import Pokemon.Pokemon;
import Pokemon.Move;
import Pokemon.MoveType;
import Pokemon.Type;

public class Squirtle extends Pokemon {
    public Squirtle() {
        super(
            "Squirtle",
            80,
            80,
            15,
            50,
            Type.WATER,
            new Move[] {
                new Move("Tackle", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                new Move("Water Gun", Type.WATER, 45, (byte) 100, (byte) 25, MoveType.SPECIAL),
                new Move("Hydro Pump", Type.WATER, 55, (byte) 95, (byte) 15, MoveType.SPECIAL),
                new Move("Rain Dance", Type.WATER, 50, (byte) 100, (byte) 0, MoveType.STATUS)
            }
        );
    }
    @Override
    public Pokemon evolve() {
        return new Wartortle();
    }

    public boolean canEvolve() {
        return true;
    }
}