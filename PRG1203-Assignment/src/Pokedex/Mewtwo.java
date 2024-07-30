package Pokedex;

import Pokemon.Pokemon;
import Pokemon.Move;
import Pokemon.MoveType;
import Pokemon.Type;

public class Mewtwo extends Pokemon {
    public Mewtwo() {
        super(
            "Mewtwo",
            125,
            125,
            20,
            60,
            Type.PSYCHIC,
            new Move[] {
                new Move("Swift", Type.NORMAL, 40, (byte) 100, (byte) 15, MoveType.PHYSICAL),
                new Move("Psychic", Type.PSYCHIC, 70, (byte) 100, (byte) 30, MoveType.SPECIAL),
                new Move("Aura Sphere", Type.PSYCHIC, 100, (byte) 95, (byte) 20, MoveType.SPECIAL),
                new Move("Recover", Type.PSYCHIC, 60, (byte) 100, (byte) 0, MoveType.STATUS)
            }
        );
    }
    @Override
    
    public Pokemon evolve() {
        return null; // Mewtwo does not evolve
    }

    public boolean canEvolve() {
        return false;
    }
}