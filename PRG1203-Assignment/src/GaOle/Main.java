package GaOle;
import java.util.Scanner;
import java.util.ArrayList;

import Pokemon.PokemonFactory;
import Player.Player;

public class Main {
    public static void newGame(Player player) {
        System.out.println("Starting a new game...");
        gameSetUp(player);

        System.out.println("Generating scenario...");

    



    }

    public static void gameGenerateScenario() {
        System.out.println("Generating scenario...");
        System.out.println("\n\nTwo wild pokemons have appeared!");


    }

    public static void gameSetUp(Player player) {
        System.out.println("These random pokemon are more likely to appear in this game: ");
        ArrayList<String> randomPokemonList = new ArrayList<>();

        while(randomPokemonList.size() < 3) {
            String randomPokemon = PokemonFactory.getRandomPokemon();
            if (!randomPokemonList.contains(randomPokemon)) {
                randomPokemonList.add(randomPokemon);
            }
        }

        for (String pokemon : randomPokemonList) {
            System.out.println(pokemon);
        }


        System.out.println("Proceed to start game? [Y/N]");
        Scanner scanner = new Scanner(System.in);

        String proceed = scanner.nextLine();
        if (proceed.equalsIgnoreCase("Y")) {
            System.out.println("Starting game...");
        } else {
            System.out.println("Exiting...");
            return ;
        }

        System.out.println("Game started!");
        System.out.println("Choose your pokemon: ");
        String[] randomStartingPokemon = Pokemon.PokemonFactory.randomizePokemon();
        for (String pokemon : randomStartingPokemon) {
            System.out.println(pokemon);
        }

        System.out.println("Enter precisely, the NAME of the pokemon you want to choose: ");
        String chosenPokemon = scanner.nextLine();

        boolean found = false;
        
        for(String pokemon : randomStartingPokemon) {
            if (pokemon.equalsIgnoreCase(chosenPokemon)) {
                System.out.println("You have collected " + chosenPokemon + "!");
                PokemonFactory.createPokemon(chosenPokemon);
                player.addPokemon(chosenPokemon);
                found = true;
                break;
            }
        }

        if(found = false) {
            System.out.println("Invalid pokemon name. Exiting...");
            return;
        }
    }

    public static void main(String[] args) {
        Player player = new Player("");
        System.out.println("Welcome to Pokemon GaOle for Assignment PRG1203!");
        System.out.println("Please enter your username: ");
        
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        player.setUsername(username);
        System.out.println("\nWelcome, " + player.getUsername() + "!");

        System.out.println("Please enter your desired action: ");
        System.out.println("1. Start a new game");
        System.out.println("2. View your profile");
        System.out.println("3. Change your username");  
        System.out.println("0. Exit");

        int action = scanner.nextInt();

        switch (action) {
            case 1:
                System.out.println("Starting a new game...");
                newGame(player);
                break;
            case 2:
                System.out.println("Viewing your profile...");
                break;
            case 3:
                System.out.println("Meeting the Team...");
                break;
            case 0:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid action. Exiting...");
                break;
        }
        
        // Additional game setup and logic can go here
        scanner.close();
    }
}