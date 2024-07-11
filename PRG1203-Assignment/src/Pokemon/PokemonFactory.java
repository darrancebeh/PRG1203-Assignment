package Pokemon;

public class PokemonFactory {
    public static Pokemon createCharizard(String name, int health, Type type, Move[] moves) {
        
    }
    
    public static Move createMove(String name, Type type, int power, byte accuracy, byte pp, MoveType moveType) {
        return new Move(name, type, power, accuracy, pp, moveType);
    }
    
    public static MoveType createMoveType() {
        return new MoveType();
    }
}
