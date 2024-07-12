package Pokemon;
import java.util.Arrays;

public enum Type {
    // ENUM: TYPE(SUPER_EFFECTIVE, NOT_VERY_EFFECTIVE, NO_EFFECT)

    NORMAL(new String[]{},
            new String[]{"Rock", "Steel"},
            new String[]{"Ghost"}),

    FIGHTING(new String[]{"Normal", "Rock", "Steel", "Ice", "Dark"},
            new String[]{"Poison", "Flying", "Bug", "Psychic", "Fairy"},
            new String[]{"Ghost"}),

    POISON(new String[]{"Grass", "Fairy"},
            new String[]{"Poison", "Ground", "Rock", "Ghost"},
            new String[]{"Steel"}),

    GROUND(new String[]{"Poison", "Rock", "Steel", "Fire", "Electric"},
            new String[]{"Bug", "Grass"},
            new String[]{"Flying"}),

    FLYING(new String[]{"Fighting", "Bug", "Grass"},
            new String[]{"Rock", "Steel", "Electric"},
            new String[]{}),

    BUG(new String[]{"Grass", "Psychic", "Dark"},
            new String[]{"Fighting", "Poison", "Flying", "Ghost", "Steel", "Fire", "Fairy"},
            new String[]{}),

    ROCK(new String[]{"Flying", "Bug", "Fire", "Ice"},
            new String[]{"Fighting", "Ground", "Steel"},
            new String[]{}),

    GHOST(new String[]{"Ghost", "Psychic"},
            new String[]{"Dark"},
            new String[]{"Normal"}),

    STEEL(new String[]{"Rock", "Ice", "Fairy"},
            new String[]{"Steel", "Fire", "Water", "Electric"},
            new String[]{}),

    FIRE(new String[]{"Bug", "Steel", "Grass", "Ice"},
            new String[]{"Rock", "Fire", "Water", "Dragon"},
            new String[]{}),

    WATER(new String[]{"Ground", "Rock", "Fire"},
            new String[]{"Water", "Grass", "Dragon"},
            new String[]{}),

    ELECTRIC(new String[]{"Flying", "Water"},
            new String[]{"Electric", "Grass", "Dragon"},
            new String[]{"Ground"}),

    GRASS(new String[]{"Ground", "Rock", "Water"},
            new String[]{"Poison", "Flying", "Bug", "Steel", "Fire", "Grass", "Dragon"},
            new String[]{}),

    ICE(new String[]{"Ground", "Flying", "Grass", "Dragon"},
            new String[]{"Steel", "Fire", "Water", "Ice"},
            new String[]{}),

    PSYCHIC(new String[]{"Fighting", "Poison"},
            new String[]{"Steel", "Psychic"},
            new String[]{"Dark"}),

    DRAGON(new String[]{"Dragon"},
            new String[]{"Steel"},
            new String[]{"Fairy"}),

    DARK(new String[]{"Ghost", "Psychic"},
            new String[]{"Fighting", "Dark", "Fairy"},
            new String[]{}),
            
    FAIRY(new String[]{"Fighting", "Dragon", "Dark"},
            new String[]{"Poison", "Steel", "Fire"},
            new String[]{});

    private final String[] superEffective;
    private final String[] notVeryEffective;
    private final String[] noEffect;

    Type(String[] superEffective, String[] notVeryEffective, String[] noEffect) {
        this.superEffective = superEffective;
        this.notVeryEffective = notVeryEffective;
        this.noEffect = noEffect;
    }

    // returns an int value to determine the effectiveness of the move
    // 1: super effective
    // 0: normal
    // -1: not very effective
    // -2: no effect

    public int getEffectivenessAgainst(String type) {
        for (String t : superEffective) {
                if (t.equals(type)) {
                        return 1;
                }
        }

        for (String t : notVeryEffective) {
                if (t.equals(type)){
                        return -1;
                }
        }

        for (String t : noEffect) {
                if (t.equals(type)){
                        return -2;
                }
        }

        return 0;
        }

}
