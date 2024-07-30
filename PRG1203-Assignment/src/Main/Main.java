package Main;

import Player.Player;
import Utility.PokeballShop;
import Utility.Clinic;


import java.util.Scanner;

public class Main {

    public void main(String[] args) {
        System.out.print("\033[H\033[2J"); 
        Player player = new Player("");
        System.out.println("Welcome to Pokemon GaOle for Assignment PRG1203!");
        System.out.println("Please enter your username: ");
        
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        player.setUsername(username);
        System.out.println("\nWelcome, " + player.getUsername() + "!");


        int playerOption = getPlayerMenuOption();
        while(playerOption != 0) {
            optionMenu(player, playerOption);
            playerOption = getPlayerMenuOption();
        }
    }

    public int getPlayerMenuOption() {
        System.out.print("\033[H\033[2J"); 
        System.out.println("Please enter your desired action: ");
        System.out.println("1. Start a new game");
        System.out.println("2. Visit the Pokeball Shop");
        System.out.println("3. Visit the Poke-Clinic");  
        System.out.println("4. View Pokeball and Pokemon Inventory");
        System.out.println("5. View Game Statistics");
        System.out.println("0. Exit");

        Scanner scanner = new Scanner(System.in);
        int action = scanner.nextInt();

        while(action < 0 || action > 5) {
            System.out.println("Invalid action. Please enter a valid action: ");
            action = scanner.nextInt();
        }

        return action;
    }

    public void optionMenu(Player player, int action) {
        switch (action) {
            case 1:
                GaOle.newGame(player);
                break;
            case 2:
                System.out.println("Visiting the Pokeball Shop...");
                PokeballShop.visitShop(player);
            case 3:
                System.out.println("Visiting the Poke-Clinic...");
                Clinic.visitClinic(player);
            case 4:
                System.out.println("Viewing your inventory...");
                break;
            case 5:
                System.out.println("Viewing your statistics...");
                break;
            case 0:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid action. Exiting...");
                break;
        }
    }
}