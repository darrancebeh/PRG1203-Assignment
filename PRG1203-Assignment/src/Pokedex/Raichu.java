package Pokedex;

import Pokemon.Pokemon;
import Pokemon.Move;
import Pokemon.MoveType;
import Pokemon.Type;

public class Raichu extends Pokemon {
    public Raichu() {
        super(
            "Raichu",
            90,
            90,
            15,
            50,
            Type.ELECTRIC,
            new Move[] {
                new Move("Quick Attack", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                new Move("Thunder Shock", Type.ELECTRIC, 55, (byte) 100, (byte) 25, MoveType.SPECIAL),
                new Move("Thunderbolt", Type.ELECTRIC, 45, (byte) 95, (byte) 15, MoveType.SPECIAL),
                new Move("Thunder Wave", Type.ELECTRIC, 50, (byte) 100, (byte) 0, MoveType.STATUS)
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
