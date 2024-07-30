package Pokedex;

import Pokemon.Pokemon;
import Pokemon.Move;
import Pokemon.MoveType;
import Pokemon.Type;

public class Spearow extends Pokemon {
    public Spearow() {
        super(
            "Spearow",
            70,
            70,
            15,
            50,
            Type.FLYING,
            new Move[] {
                new Move("Peck", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                new Move("Wing Attack", Type.FLYING, 45, (byte) 100, (byte) 25, MoveType.SPECIAL),
                new Move("Aerial Ace", Type.FLYING, 55, (byte) 95, (byte) 15, MoveType.SPECIAL),
                new Move("Agility", Type.FLYING, 50, (byte) 100, (byte) 0, MoveType.STATUS)
            }
        );
    }
    @Override
    public Pokemon evolve() {
        return new Fearow();
    }

    public boolean canEvolve() {
        return true;
    }
}