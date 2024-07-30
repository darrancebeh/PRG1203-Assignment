package Pokedex;

import Pokemon.Pokemon;
import Pokemon.Move;
import Pokemon.MoveType;
import Pokemon.Type;

public class Ekans extends Pokemon {
    public Ekans() {
        super(
            "Ekans",
            70,
            70,
            15,
            50,
            Type.POISON,
            new Move[] {
                new Move("Bite", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                new Move("Poison Sting", Type.POISON, 45, (byte) 100, (byte) 25, MoveType.SPECIAL),
                new Move("Sludge Bomb", Type.POISON, 55, (byte) 95, (byte) 15, MoveType.SPECIAL),
                new Move("Acid", Type.POISON, 50, (byte) 100, (byte) 0, MoveType.STATUS)
            }
        );
    }
    @Override
    public Pokemon evolve() {
        return new Arbok();
    }

    public boolean canEvolve() {
        return true;
    }
}