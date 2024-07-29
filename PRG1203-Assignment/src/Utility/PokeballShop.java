package Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PokeballShop {
    private List<Pokeball> pokeballs;

    public PokeballShop() {
        pokeballs = new ArrayList<>();
        pokeballs.add(new Pokeball("Pokeball", 200));
        pokeballs.add(new Pokeball("Great Ball", 600));
        pokeballs.add(new Pokeball("Ultra Ball", 1200));
        pokeballs.add(new Pokeball("Master Ball", 5000));
    }

    public void displayPokeballShop() {
        System.out.println("Welcome to the Pokeball Shop!");
        System.out.println("Here are the pokeballs available for purchase:");
        for (int i = 0; i < pokeballs.size(); i++) {
            Pokeball pokeball = pokeballs.get(i);
            System.out.println((i + 1) + ". " + pokeball.getName() + " - $" + pokeball.getPrice());
        }
    }

    public void buyPokeball(int choice) {
        if (choice > 0 && choice <= pokeballs.size()) {
            Pokeball selectedPokeball = pokeballs.get(choice - 1);
            System.out.println("You have purchased a " + selectedPokeball.getName() + " for $" + selectedPokeball.getPrice());
        } else {
            System.out.println("Invalid choice. Please select a valid option.");
        }
    }

    public static void main(String[] args) {
        PokeballShop shop = new PokeballShop();
        shop.displayPokeballShop();
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of the pokeball you want to buy: ");
        int choice = scanner.nextInt();
        shop.buyPokeball(choice);
        scanner.close();
    }
}