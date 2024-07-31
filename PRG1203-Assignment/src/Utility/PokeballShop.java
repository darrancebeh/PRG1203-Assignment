package Utility;

import Player.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PokeballShop {
    private List<Pokeball> pokeballs;
    private Scanner scanner;

    public PokeballShop() {
        pokeballs = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        pokeballs.add(Pokeball.createPokeball("Pokeball"));
        pokeballs.add(Pokeball.createPokeball("Great Ball"));
        pokeballs.add(Pokeball.createPokeball("Ultra Ball"));
        pokeballs.add(Pokeball.createPokeball("Master Ball"));
    }

    public void displayPokeballShop() {
        System.out.print("\033[H\033[2J"); 
        System.out.println("Welcome to the Pokeball Shop!");
        System.out.println("Here are the pokeballs available for purchase:");
        for (int i = 0; i < pokeballs.size(); i++) {
            Pokeball pokeball = pokeballs.get(i);
            System.out.println((i + 1) + ". " + pokeball.getName() + " - " + pokeball.getPrice() + " Coins");
        }
    }

    public int promptUser(Player player) {
        displayPokeballShop();
        System.out.println("You have " + player.getCoins() + " Coins.");
        System.out.println("Please select a pokeball to purchase (1-4) (10 to exit): ");
        
        int choice = scanner.nextInt();

        while(choice < 1 || choice > 4 && choice != 10) {
            System.out.println("Invalid choice. Please select a valid option.");
            return promptUser(player);
        }

        return choice;
    }

    public void buyPokeball(Player buyer, int choice) {
        if (choice > 0 && choice <= pokeballs.size()) {
            if(buyer.getCoins() < pokeballs.get(choice - 1).getPrice()) {
                System.out.println("You do not have enough coins to purchase this pokeball.");
                return;
            }
            buyer.setCoins(buyer.getCoins() - pokeballs.get(choice - 1).getPrice());
            Pokeball selectedPokeball = pokeballs.get(choice - 1);
            System.out.println("You have purchased a " + selectedPokeball.getName() + " for $" + selectedPokeball.getPrice());
            buyer.addPokeball(selectedPokeball);
        } else {
            System.out.println("Invalid choice. Please select a valid option.");
        }
    }

    public void visitShop(Player player){
        PokeballShop pokeballShop = new PokeballShop();
        pokeballShop.displayPokeballShop();

        System.out.println("\nYou have " + player.getCoins() + " Coins.");

        if(player.getCoins() < 200) {
            System.out.println("You do not have enough coins to purchase a Pokeball.");
            System.out.println("Returning to main menu...");
            scanner.nextLine();
            return;
        }

        System.out.println("Would you like to make a purchase [Y/N/]?");
        String choice = scanner.nextLine();

        while(!choice.equalsIgnoreCase("Y") && !choice.equalsIgnoreCase("N")) {
            System.out.println("Invalid choice. Please select a valid option.");
            choice = scanner.nextLine();
        }

        if(choice.equalsIgnoreCase("Y")) {
            int pokeballChoice = pokeballShop.promptUser(player);
            if(pokeballChoice != 10) {
                pokeballShop.buyPokeball(player, pokeballChoice);
            }
        } else {
            System.out.println("Thank you for visiting the Pokeball Shop!");
            System.out.println("Returning to main menu...");

            scanner.nextLine();
        }
    }
}