package Pokedex;

import Pokemon.Pokemon;
import Pokemon.Move;
import Pokemon.MoveType;
import Pokemon.Type;

public class Charmander extends Pokemon {
    public Charmander() {
        super(
            "Charmander",
            70,
            70,
            15,
            50,
            Type.FIRE,
            new Move[] {
                new Move("Scratch", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                new Move("Ember", Type.FIRE, 45, (byte) 100, (byte) 25, MoveType.SPECIAL),
                new Move("Flamethrower", Type.FIRE, 55, (byte) 95, (byte) 15, MoveType.SPECIAL),
                new Move("Fire Spin", Type.FIRE, 50, (byte) 100, (byte) 0, MoveType.STATUS)
            }
        );
    }
    @Override
    public Pokemon evolve() {
        return new Charmeleon();
    }

    public boolean canEvolve() {
        return true;
    }
}