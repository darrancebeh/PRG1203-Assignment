package Main;

import Player.Player;
import Utility.PokeballShop;
import Utility.Clinic;

import java.util.Scanner;

public class Main {
    private Scanner scanner;

    public void main(String[] args) {
        this.scanner = new Scanner(System.in);
        System.out.print("\033[H\033[2J"); 
        PokeballShop pokeballShop = new PokeballShop();
        Clinic clinic = new Clinic();
        Player player = new Player("");
        System.out.println("Welcome to Pokemon GaOle for Assignment PRG1203!");
        System.out.println("Please enter your username: ");
        
        String username = scanner.nextLine();

        player.setUsername(username);
        System.out.println("\nWelcome, " + player.getUsername() + "!");


        int playerOption = getPlayerMenuOption();
        while(playerOption != 0) {
            optionMenu(player, playerOption, clinic, pokeballShop);
            playerOption = getPlayerMenuOption();
        }
    }

    public int getPlayerMenuOption() {
        System.out.print("\033[H\033[2J"); 
        System.out.println("Please enter your desired action:\n");
        System.out.println("1. Start a new game");
        System.out.println("2. Visit the Pokeball Shop");
        System.out.println("3. Visit the Poke-Clinic");  
        System.out.println("4. View Pokeball and Pokemon Inventory");
        System.out.println("5. View Game Statistics");
        System.out.println("0. Exit\n");

        int action = scanner.nextInt();

        while(action < 0 || action > 5) {
            System.out.println("Invalid action. Please enter a valid action: ");
            action = scanner.nextInt();
        }

        return action;
    }

    public void optionMenu(Player player, int action, Clinic clinic, PokeballShop pokeballShop) {
        switch (action) {
            case 1:
                GaOle.newGame(player);
                break;
            case 2:
                System.out.println("Visiting the Pokeball Shop...");
                pokeballShop.visitShop(player);
                break;
            case 3:
                System.out.println("Visiting the Poke-Clinic...");
                clinic.visitClinic(player);
                break;
            case 4:
                System.out.println("Viewing your Pokeball inventory...");
                scanner.nextLine();
                System.out.print("\033[H\033[2J");

                System.out.println("Pokeball Inventory\n");
                System.out.println("You have " + player.getPokeballList().size() + " pokeballs.");

                if(player.getPokeballList().size() == 0) {
                    System.out.println("You have no pokeballs to display.");
                    System.out.println("Visit the Pokeball Shop to purchase some!");
                } else {
                    System.out.println(player.getPokeballListString());
                }

                System.out.println("\nInput any key to return to the main menu.");
                scanner.nextLine();
                break;

            case 5:
                System.out.println("Viewing your statistics...");
                scanner.nextLine();
                System.out.print("\033[H\033[2J"); 

                System.out.println("Player Statistics\n");
                System.out.println("Username: " + player.getUsername());
                System.out.println("Wins: " + player.getWins());
                System.out.println("Losses: " + player.getLosses());
                System.out.println("Draws: " + player.getDraws());
                System.out.println("Total Games: " + player.getTotalGames());

                System.out.println("Your GaOle Scores in Ascending Order:");
                if(player.getGameScores().size() == 0) {
                    System.out.println("You have no scores to display.");
                    System.out.println("Go play some games!");
                } else {
                    for (int i = 0; i < player.getAscendingGameScores().size(); i++) {
                        System.out.println(player.getAscendingGameScores().get(i));
                    }
                }

                System.out.println("\nInput any key to return to the main menu.");
                scanner.nextLine();
                break;

            case 0:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid action. Exiting...");
        }
    }
}