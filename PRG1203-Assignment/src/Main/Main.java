package GaOle;

import Player.Player;

import java.util.Scanner;

public class Main {

    public void main(String[] args) {
        System.out.print("\033[H\033[2J"); 
        Player player = new Player("");
        GaOle GaOle = new GaOle();
        System.out.println("Welcome to Pokemon GaOle for Assignment PRG1203!");
        System.out.println("Please enter your username: ");
        
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        player.setUsername(username);
        System.out.println("\nWelcome, " + player.getUsername() + "!");

        GaOle.optionMenu(player);
    }
}