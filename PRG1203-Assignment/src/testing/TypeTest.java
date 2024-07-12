package testing;

import Pokemon.Type;

public class TypeTest {
    public static void main(String[] args) {
        System.out.println(Type.FIGHTING.getEffectivenessAgainst("Ground"));
    }
}