package Pokedex;

import Pokemon.Pokemon;
import Pokemon.Move;
import Pokemon.MoveType;
import Pokemon.Type;

public class Mankey extends Pokemon {
    public Mankey() {
        super(
            "Mankey",
            70,
            70,
            15,
            50,
            Type.FIGHTING,
            new Move[] {
                new Move("Scratch", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                new Move("Karate Chop", Type.FIGHTING, 55, (byte) 100, (byte) 25, MoveType.SPECIAL),
                new Move("Cross Chop", Type.FIGHTING, 45, (byte) 95, (byte) 15, MoveType.SPECIAL),
                new Move("Focus Energy", Type.FIGHTING, 50, (byte) 100, (byte) 0, MoveType.STATUS)
            }
        );
    }
    @Override
    public Pokemon evolve() {
        return new Primeape();
    }

    public boolean canEvolve() {
        return true;
    }
}