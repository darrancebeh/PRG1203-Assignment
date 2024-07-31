package Pokedex;

import Pokemon.Pokemon;
import Pokemon.Move;
import Pokemon.MoveType;
import Pokemon.Type;

public class Ivysaur extends Pokemon {
    public Ivysaur() {
        super(
            "Ivysaur",
            100,
            100,
            20,
            60,
            Type.GRASS,
            new Move[] {
                new Move("Tackle", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                new Move("Vine Whip", Type.GRASS, 55, (byte) 100, (byte) 25, MoveType.SPECIAL),
                new Move("Razor Leaf", Type.GRASS, 45, (byte) 95, (byte) 15, MoveType.SPECIAL),
                new Move("Synthesis", Type.GRASS, 50, (byte) 100, (byte) 0, MoveType.STATUS),
                new Move("Poison Powder", Type.POISON, 65, (byte) 75, (byte) 35, MoveType.SPECIAL)
            }
        );
    }
    @Override
    public Pokemon evolve() {
        System.out.println("Ivysaur cannot evolve further.");
        return null;
    }

    public boolean canEvolve() {
        return false;
    }
    
}
