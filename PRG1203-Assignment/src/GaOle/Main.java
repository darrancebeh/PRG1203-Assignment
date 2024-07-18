package GaOle;

import Pokemon.Pokemon;
import Pokemon.PokemonFactory;
import Player.Player;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public void newGame(Player player) {
        Player opponent = new Player("Opponent");
        System.out.println("Starting a new game...");

        ArrayList<String> featuredPokemonList = new ArrayList<>();
        featuredPokemonList = gameStartSetup(player);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Proceed to generate scenario? [Y/N]");
        String proceed = scanner.nextLine();

        if (proceed.equalsIgnoreCase("Y")) {
            System.out.println("Generating scenario...");
        } else {
            System.out.println("Exiting...");
            optionMenu(player);
        }

        gameGenerateScenario(player, opponent, featuredPokemonList);
    }
        
    public ArrayList<String> gameStartSetup(Player player) {
        System.out.println("These random pokemon are more likely to appear in this game: ");
        ArrayList<String> randomPokemonList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            String randomPokemon = PokemonFactory.getRandomPokemonList(1)[0];
            randomPokemonList.add(randomPokemon);
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
            optionMenu(player);
        }

        System.out.println("Game started!");
        System.out.println("\n\nChoose TWO Pokemon from the list below:");

        String[] startingPokemonList = PokemonFactory.getRandomPokemonList(3);
        
        String [] chosenPokemonList = new String[2];
        int chosenCount = 0;
        while (chosenCount < 2) {
            System.out.println("\n\nPokemon List:");
            for (String pokemon : startingPokemonList) {
                System.out.println(pokemon);
            }

            System.out.println("\nEnter PRECISELY, the name of the pokemon you want to choose: ");
            String chosenPokemon = scanner.nextLine();
            
            boolean isValidPokemon = false;
            for (String pokemon : startingPokemonList) {
                if (pokemon.equalsIgnoreCase(chosenPokemon) && chosenPokemon != "") {
                    isValidPokemon = true;
                    break;
                }
            }
            
            if (!isValidPokemon) {
                System.out.println("Invalid pokemon. Please choose from the list and enter the pokemon name PRECISELY.");
                continue;
            }

            chosenCount++;
            
            for (int i = 0; i < 2; i++) {
                if (chosenPokemonList[i] == null) {
                    chosenPokemonList[i] = chosenPokemon;
                    if(i == 0) {
                        System.out.println("First pokemon chosen: " + chosenPokemon);
                    } else {
                        System.out.println("Second pokemon chosen: " + chosenPokemon);
                    }

                    // removes chosen pokemon from list
                    for (int j = 0; j < startingPokemonList.length; j++) {
                        if (startingPokemonList[j].equalsIgnoreCase(chosenPokemon)) {
                            startingPokemonList[j] = "";
                            break;
                        }
                    }
                    break;
                }
            }
        }

        System.out.println("You have successfully chosen your starting Pokemon! Let the game begin!");

        player.addPokemon(PokemonFactory.createPokemon(chosenPokemonList[0]));
        player.addPokemon(PokemonFactory.createPokemon(chosenPokemonList[1]));

        System.out.println("Your starting Pokemon lineup: ");

        for (Pokemon pokemon : player.getPokemonList()) {
            System.out.println(pokemon.getName());
        }

        return randomPokemonList;

    }

    public void gameGenerateScenario(Player player, Player opponent, ArrayList<String> featuredPokemonList) {
        String[] randomPokemonList = new String[6];

        randomPokemonList[0] = featuredPokemonList.get(0);
        randomPokemonList[1] = featuredPokemonList.get(1);
        randomPokemonList[2] = featuredPokemonList.get(2);

        while(randomPokemonList.length < 6) {
            String randomPokemon = PokemonFactory.getRandomPokemonList(1)[0];
            randomPokemonList[randomPokemonList.length] = randomPokemon;
        }
        
        
        System.out.println("Generating scenario...");
        System.out.println("\n\nTwo wild pokemons have appeared!");

        ArrayList<String> randomPokemonAppearance = new ArrayList<>();

        while(randomPokemonAppearance.size() < 2) {
            String randomPokemon = randomPokemonList[(int) (Math.random() * randomPokemonList.length)];
            randomPokemonAppearance.add(randomPokemon);
        }


        for (String pokemon : randomPokemonAppearance) {
            System.out.println(pokemon);
        }

        System.out.println("Your Pokemon List: ");
        for (Pokemon pokemon : player.getPokemonList()) {
            System.out.println(pokemon.getName());
        }

        String [] chosenPokemonList = new String[2];
        while (chosenPokemonList[0] == null || chosenPokemonList[1] == null) {
            System.out.println("\n\nYour Pokemon List:");

            for (Pokemon pokemon : player.getPokemonList()) {
                System.out.println(pokemon.getName());
            }

            System.out.println("\nEnter PRECISELY, the name of the pokemon you want to choose: ");
            Scanner scanner = new Scanner(System.in);
            String chosenPokemon = scanner.nextLine();
            
            boolean isValidPokemon = false;
            for (Pokemon pokemon : player.getPokemonList()) {
                if (pokemon.getName().equalsIgnoreCase(chosenPokemon)) {
                    isValidPokemon = true;
                    break;
                }
            }
            
            if (!isValidPokemon) {
                System.out.println("Invalid pokemon. Please choose from the list and enter the pokemon name PRECISELY.");
                continue;
            }
            
            boolean isAlreadyChosen = false;
            for (String chosen : chosenPokemonList) {
                if (chosen != null && chosen.equalsIgnoreCase(chosenPokemon)) {
                    isAlreadyChosen = true;
                    break;
                }
            }
            
            if (isAlreadyChosen) {
                System.out.println("You have already chosen this pokemon. Please choose a different one.");
                continue;
            }
            
            for (int i = 0; i < 2; i++) {
                if (chosenPokemonList[i] == null) {
                    chosenPokemonList[i] = chosenPokemon;
                    if(i == 0) {
                        System.out.println("First pokemon chosen: " + chosenPokemon);
                    } else {
                        System.out.println("Second pokemon chosen: " + chosenPokemon);
                    }
                    break;
                }
            }
        }

    }


    public void optionMenu(Player player) {
        System.out.println("Please enter your desired action: ");
        System.out.println("1. Start a new game");
        System.out.println("2. View your profile");
        System.out.println("3. Change your username");  
        System.out.println("0. Exit");

        Scanner scanner = new Scanner(System.in);
        int action = scanner.nextInt();

        switch (action) {
            case 1:
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
    }
    public void main(String[] args) {
        Player player = new Player("");
        System.out.println("Welcome to Pokemon GaOle for Assignment PRG1203!");
        System.out.println("Please enter your username: ");
        
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        player.setUsername(username);
        System.out.println("\nWelcome, " + player.getUsername() + "!");

        optionMenu(player);
    }
}