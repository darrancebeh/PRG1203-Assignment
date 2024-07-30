package Pokedex;

import Pokemon.Pokemon;
import Pokemon.Move;
import Pokemon.MoveType;
import Pokemon.Type;

public class Bulbasaur extends Pokemon {
    public Bulbasaur() {
        super(
            "Bulbasaur",
            75,
            75,
            15,
            50,
            Type.GRASS,
            new Move[] {
                new Move("Tackle", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                new Move("Vine Whip", Type.GRASS, 45, (byte) 100, (byte) 25, MoveType.SPECIAL),
                new Move("Razor Leaf", Type.GRASS, 55, (byte) 95, (byte) 15, MoveType.SPECIAL),
                new Move("Synthesis", Type.GRASS, 50, (byte) 100, (byte) 0, MoveType.STATUS)
            }
        );
    }

    @Override
    public Pokemon evolve() {
        return new Ivysaur();
    }

    public boolean canEvolve() {
        return true;
    }
}