package Pokedex;

import Pokemon.Pokemon;
import Pokemon.Move;
import Pokemon.MoveType;
import Pokemon.Type;

public class Magnemite extends Pokemon {
    public Magnemite() {
        super(
            "Magnemite",
            70,
            70,
            15,
            50,
            Type.STEEL,
            new Move[] {
                new Move("Tackle", Type.NORMAL, 20, (byte) 100, (byte) 10, MoveType.PHYSICAL),
                new Move("Thunder Shock", Type.ELECTRIC, 55, (byte) 100, (byte) 25, MoveType.SPECIAL),
                new Move("Flash Cannon", Type.STEEL, 45, (byte) 95, (byte) 15, MoveType.SPECIAL),
                new Move("Magnet Rise", Type.STEEL, 50, (byte) 100, (byte) 0, MoveType.STATUS)
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