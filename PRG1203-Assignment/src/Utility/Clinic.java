package Utility;
import Player.Player;
import Pokemon.Pokemon;
import java.util.Scanner;
import Pokedex.*;

import java.util.ArrayList;

public class Clinic {
    // displays the player's pokemon list along with their health

    public static void displayPokemonListHealth(Player player) {

        if(player.getPokemonList().isEmpty()) {
            System.out.println("You have no Pokemon in your list.");
            return;
        }

        System.out.println("Pokemon List:");
        for (Pokemon pokemon : player.getPokemonList()) {
            System.out.println(pokemon.getName() + " - " + pokemon.getHealth() + "/" + pokemon.getMaxHealth());
        }
    }

    // heals all of the player's pokemon
    public static void healPokemon(Player player) {
        for (Pokemon pokemon : player.getPokemonList()) {
            pokemon.setHealth(pokemon.getMaxHealth());
        }
        System.out.println("All Pokemon have been healed.");
    }

    public static void payToHeal(Player player) {
        if(player.getCoins() < 50) {
            System.out.println("You do not have enough coins to heal all Pokemon.");
            return;
        }
        player.setCoins(player.getCoins() - 50);
        healPokemon(player);
        System.out.println("You have healed all Pokemon for 50 coins.");
    }

    public static void payToEvolve(Player player) {
        if(player.getCoins() < 450) {
            System.out.println("You do not have enough coins to evolve a Pokemon.");
            return;
        }
        
        // display all evolvable pokemon in player's pokemon list

        ArrayList<Pokemon> evolvablePokemon = new ArrayList<>();
        for (Pokemon pokemon : player.getPokemonList()) {
            if(pokemon.canEvolve()) {
                evolvablePokemon.add(pokemon);
            }
        }

        if(evolvablePokemon.isEmpty()) {
            System.out.println("You have no Pokemon that can evolve.");
            return;
        }

        System.out.println("Select a Pokemon to evolve:");
        for (int i = 0; i < evolvablePokemon.size(); i++) {
            System.out.println((i + 1) + ". " + evolvablePokemon.get(i).getName());
        }

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        while(choice < 1 || choice > evolvablePokemon.size()) {
            System.out.println("Invalid choice. Please select a valid option.");
            choice = scanner.nextInt();
        }

        Pokemon selectedPokemon = evolvablePokemon.get(choice - 1);

        System.out.println("Pay 450 coins to evolve " + selectedPokemon.getName() + "? (y/n)");
        String confirm = scanner.next();

        while(!confirm.equalsIgnoreCase("y") && !confirm.equalsIgnoreCase("n")) {
            System.out.println("Invalid choice. Please select a valid option.");
            confirm = scanner.next();
        }

        if(confirm.equalsIgnoreCase("y")) {
            player.setCoins(player.getCoins() - 450);
            Pokemon evolvedPokemon = selectedPokemon.evolve();
            player.getPokemonList().remove(selectedPokemon);
            player.addPokemon(evolvedPokemon);
            System.out.println(selectedPokemon.getName() + " has evolved into " + evolvedPokemon.getName() + "!");
        } else {
            System.out.println("Evolution cancelled.");
        }

    }

    // displays the clinic menu
    public static void visitClinic(Player player) {
        System.out.print("\033[H\033[2J"); 
        System.out.println("Welcome to the Poke-Clinic!");
        System.out.println("Please select an option:");
        System.out.println("1. Display Pokemon List and Health");
        System.out.println("2. Heal All Pokemon (50 Coins)");
        System.out.println("3. Evolve Pokemon (450 Coins)");
        System.out.println("0. Exit");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        while(choice < 0 || choice > 2) {
            System.out.println("Invalid choice. Please select a valid option.");
            choice = scanner.nextInt();
        }

        switch (choice) {
            case 1:
                displayPokemonListHealth(player);
                break;
            case 2:
                healPokemon(player);
                break;
            case 3:
                payToEvolve(player);
                break;
            case 0:
                System.out.println("Exiting...");
                break;
        }
    }
}
