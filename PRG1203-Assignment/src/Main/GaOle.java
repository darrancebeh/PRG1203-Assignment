package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Player.Player;
import Utility.Pokeball;
import Pokemon.Pokemon;
import Pokemon.PokemonFactory;

public class GaOle {
    public static void newGame(Player player) {
        System.out.print("\033[H\033[2J"); 
        Player opponent = new Player("Opponent");
        System.out.println("Starting a new game...");

        ArrayList<String> featuredPokemonList = new ArrayList<>();
        featuredPokemonList = gameStartSetup(player);

        if(featuredPokemonList == null) {
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter any key to proceed to generating scenario.");
        scanner.nextLine();

        System.out.println("Generating scenario...");
        ArrayList<Pokemon> pokemonsToBattle = gameGenerateScenario(player, opponent, featuredPokemonList);
        System.out.println("Enter any key to proceed to battle.");
        scanner.nextLine();

        gameBattle(player, opponent, pokemonsToBattle);

        System.out.println("Enter any key to proceed.");
        scanner.nextLine();
    }

    public static ArrayList<String> gameStartSetup(Player player) {
        System.out.print("\033[H\033[2J"); 
        System.out.println("These random pokemon are more likely to appear in this game: \n");
        ArrayList<String> randomPokemonList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            String randomPokemon = PokemonFactory.getRandomPokemonList(1)[0];
            randomPokemonList.add(randomPokemon);
        }

        for (String pokemon : randomPokemonList) {
            System.out.println(pokemon);
        }

        System.out.println("\nProceed to start game? [Y/N]");
        Scanner scanner = new Scanner(System.in);
        String proceed = scanner.nextLine();

        if (proceed.equalsIgnoreCase("Y")) {
            System.out.println("Starting game...");
        } else {
            System.out.println("Exiting...");
            return null;
        }

        System.out.print("\033[H\033[2J"); 

        System.out.println("Game started!\n");
        System.out.println("Choose TWO Pokemon from the list below:\n\n");

        String[] startingPokemonList = PokemonFactory.getRandomPokemonNoLegendaryList(3);

        List<String> playerChosenPokemonList = choosePokemonFromListString(startingPokemonList, 2);

        // creates instances of pokemon based on the player's choices and adds the pokemon to the player's pokemon list

        for (String pokemonName : playerChosenPokemonList) {
            player.addPokemon(PokemonFactory.createPokemon(pokemonName));
        }

        System.out.print("\033[H\033[2J"); 
        System.out.println("You have successfully chosen the following Pokemon:");
        for (String pokemon : playerChosenPokemonList) {
            // make the first letter of the pokemon name uppercase and the rest lowercase
            System.out.println(pokemon.substring(0, 1).toUpperCase() + pokemon.substring(1).toLowerCase());
        }

        System.out.println("\nNow, let's start the game!");

        // returns randomPokemonList to be used as the "Featured Pokemon List"
        // this list of pokemon will be given a higher chance to spawn in the game

        return randomPokemonList;
    }

    public static ArrayList<Pokemon> gameGenerateScenario(Player player, Player opponent, ArrayList<String> featuredPokemonList) {
        System.out.print("\033[H\033[2J"); 
        List<String> randomPokemonList = new ArrayList<>();
        ArrayList<Pokemon> pokemonsToBattle = new ArrayList<>();


        // featured pokemon in the setup menu has a higher chance (50%) to be in the game


        randomPokemonList.add(featuredPokemonList.get(0));
        randomPokemonList.add(featuredPokemonList.get(1));
        randomPokemonList.add(featuredPokemonList.get(2));

        while(randomPokemonList.size() < 6) {
            String randomPokemon = PokemonFactory.getRandomPokemonList(1)[0];
            randomPokemonList.add(randomPokemon);
        }
        
        System.out.println("Generating scenario...\n");
        System.out.println("Two wild pokemons have appeared!");

        ArrayList<String> randomPokemonAppearance = new ArrayList<>();

        while(randomPokemonAppearance.size() < 2) {
            String randomPokemon = randomPokemonList.get((int) (Math.random() * randomPokemonList.size()));
            randomPokemonAppearance.add(randomPokemon);
        }

        // check if theres a legendary pokemon

        boolean legendaryPokemonAppeared = false;
        String appearedLegendary = null;
        String[] allLegendaryPokemon = PokemonFactory.getAllLegendary();

        for (String pokemon : randomPokemonAppearance) {
            for (String legendaryPokemon : allLegendaryPokemon) {
                if (pokemon.equalsIgnoreCase(legendaryPokemon)) {
                    System.out.println("\nThe legendary Pokemon, " + pokemon + " has appeared!");
                    appearedLegendary = pokemon;
                    System.out.println("The other random Pokemon ran away in fright!!");
                    legendaryPokemonAppeared = true;
                    break;
                }
            }
        }

        if(!legendaryPokemonAppeared) {
            System.out.println("The following Pokemon have appeared: ");
            for (String pokemon : randomPokemonAppearance) {
                System.out.println(PokemonFactory.getPokemonStats(pokemon));
                System.out.println("----------------------------------------");
            }
        }

        if(legendaryPokemonAppeared) {
            System.out.println("\nYou have encountered a legendary Pokemon! Defeat it for a chance to catch it!");
            System.out.print("LEGENDARY POKEMON: ");
            System.out.println(PokemonFactory.getPokemonStats(appearedLegendary));
            System.out.println("----------------------------------------");
        }

        ArrayList<Pokemon> playerPokemonList = player.getPokemonList();

        List<Pokemon> playerChosenPokemonList = new ArrayList<>();
        playerChosenPokemonList = choosePokemonFromListPokemon(playerPokemonList, 2);

        for(Pokemon chosenPokemon : playerChosenPokemonList) {
            pokemonsToBattle.add(chosenPokemon);
        }

        if(!legendaryPokemonAppeared) {
            for(String pokemonName : randomPokemonAppearance) {
                pokemonsToBattle.add(PokemonFactory.createPokemon(pokemonName));
            }
        } else {
            pokemonsToBattle.add(PokemonFactory.createPokemon(appearedLegendary));
            pokemonsToBattle.add(PokemonFactory.createPokemon("default"));
        }
        

        for(Pokemon pokemonName : playerChosenPokemonList) {
            // make the first letter of the pokemon name uppercase and the rest lowercase   
            System.out.println("You have chosen: " + pokemonName.getName());
        }

        // return player selected pokemon and the random pokemon that appeared

        return pokemonsToBattle;

    }

    public static void gameBattle(Player player, Player opponent, ArrayList<Pokemon> pokemonsToBattle) {
        boolean legendaryBattle = false;
        System.out.print("\033[H\033[2J"); 
        System.out.println("Battle started!");

        Pokemon playerPokemon1 = pokemonsToBattle.get(0);
        Pokemon playerPokemon2 = pokemonsToBattle.get(1);

        Pokemon opponentPokemon1 = pokemonsToBattle.get(2);
        Pokemon opponentPokemon2 = pokemonsToBattle.get(3);

        if(opponentPokemon2 == null) {
            System.out.println("\nThis battle shall be LEGENDARY!\n");
            legendaryBattle = true;

            // remove opponentPokemon2 from the list
            pokemonsToBattle.remove(3);
        }

        List<Pokemon> playerPokemonList = new ArrayList<>();
        playerPokemonList.add(playerPokemon1);
        playerPokemonList.add(playerPokemon2);

        System.out.println("\nYour Pokemon Lineup: ");
        System.out.println(playerPokemon1.getName() + " (" + playerPokemon1.getType () + ")" + "  (HP: " + playerPokemon1.getHealth () + "/" + playerPokemon1.getMaxHealth() + ")");
        System.out.println(playerPokemon2.getName() + " (" + playerPokemon2.getType( ) + ")" + " (HP: " + playerPokemon2.getHealth()  + "/" + playerPokemon2.getMaxHealth() + ")");

        System.out.println("\nOpponent's Pokemon Lineup: ");
        System.out.println(opponentPokemon1.getName() + " (" + opponentPokemon1.getType() + ")" + " (HP: " + opponentPokemon1.getHealth() + "/" + opponentPokemon1.getMaxHealth() + ")");
        if(!legendaryBattle) {
            System.out.println(opponentPokemon2.getName() + " (" + opponentPokemon2.getType() + ")" + " (HP: " + opponentPokemon2.getHealth() + "/" + opponentPokemon2.getMaxHealth() + ")");
        }

        // randomly decides which pokemon the opponent sends first

        Pokemon opponentPokemon = legendaryBattle ? opponentPokemon1 : Math.random() < 0.5 ? opponentPokemon1 : opponentPokemon2;
        

        // player decides which pokemon to send out

        System.out.println("\nWhich Pokemon would you like to send out first?");
        System.out.println("1. " + playerPokemon1.getName() + " (" + playerPokemon1.getType() + ")" + " (HP: " + playerPokemon1.getHealth() + "/" + playerPokemon1.getMaxHealth() + ")");
        System.out.println("2. " + playerPokemon2.getName() + " (" + playerPokemon2.getType() + ")" + " (HP: " + playerPokemon2.getHealth() + "/" + playerPokemon2.getMaxHealth() + ")");
        System.out.println("\nEnter 1 or 2: ");

        Scanner scanner = new Scanner(System.in);

        int playerPokemonChoice = scanner.nextInt();

        // data validation

        while(playerPokemonChoice != 1 && playerPokemonChoice != 2) {
            System.out.println("Invalid input. Please enter 1 or 2.");
            playerPokemonChoice = scanner.nextInt();
        }

        Pokemon playerPokemon = playerPokemonChoice == 1 ? playerPokemon1 : playerPokemon2;

        System.out.println("\nOpponent sent out " + opponentPokemon.getName() + "!\n");

        
        // battle loop
        boolean playerTurn = true;
        
        while ((playerPokemon1.getHealth() > 0 || playerPokemon2.getHealth() > 0) && (opponentPokemon1.getHealth() > 0 || (opponentPokemon2 != null && opponentPokemon2.getHealth() > 0))) {
            if (playerTurn) {
                // Player's turn
                if (playerPokemon.getHealth() <= 0) {
                    System.out.println("\n" + player.getUsername() + "'s " + playerPokemon.getName() + " fainted!\n");
                    if (playerPokemon == playerPokemon1 && playerPokemon2.getHealth() > 0) {
                        playerPokemon = playerPokemon2;
                        System.out.println("You sent out " + playerPokemon.getName() + "!\n");
                    } else if (playerPokemon == playerPokemon2 && playerPokemon1.getHealth() > 0) {
                        playerPokemon = playerPokemon1;
                        System.out.println("You sent out " + playerPokemon.getName() + "!\n");
                    } 
                }

                // display player and opponent pokemmon's health and pp
                
                System.out.println("\n" + player.getUsername() + "'s " + playerPokemon.getName() + "(" + playerPokemon.getType() + ")" + " (HP: " + playerPokemon.getHealth() + "/" + playerPokemon.getMaxHealth() + ")" + " (PP: " + playerPokemon.getPp() + "/" + playerPokemon.getMaxPp() + ")");
                System.out.println(opponent.getUsername() + "'s " + opponentPokemon.getName() + "(" + opponentPokemon.getType() + ")" + " (HP: " + opponentPokemon.getHealth() + "/" + opponentPokemon.getMaxHealth() + ")" + " (PP: " + opponentPokemon.getPp() + "/" + opponentPokemon.getMaxPp() + ")");

                // display all of the pokemon's moves, attack power, and pp

                System.out.println("\n\nChoose a move: ");
                for (int i = 0; i < playerPokemon.getMoves().length; i++) {
                    System.out.println((i + 1) + ". " + playerPokemon.getMoves()[i].getName() + " (Power: " + playerPokemon.getMoves()[i].getPower() + ", PP: " + playerPokemon.getMoves()[i].getPp() + ")");
                }

                int chosenMove = scanner.nextInt();

                // data validation

                while (chosenMove < 1 || chosenMove > playerPokemon.getMoves().length) {
                    System.out.println("Invalid input. Please choose a valid move.");
                    chosenMove = scanner.nextInt();
                }

                // checks if player has enough pp to use the move

                if (playerPokemon.getMoves()[chosenMove - 1].getPp() > playerPokemon.getPp()) {
                    System.out.println("Your Pokemon does not have enough PP (mana) to use this move. Please choose another move.");
                    continue;
                }

                playerPokemon.getMoves()[chosenMove - 1].decideMoveType(playerPokemon.getMoves()[chosenMove - 1], playerPokemon, opponentPokemon);
                System.out.println("____________________________________________________________");

            } else {
                // Opponent's turn

                if(opponentPokemon.getHealth() > 0 ) {
                    System.out.println("\n" + player.getUsername() + "'s " + playerPokemon.getName() + "(" + playerPokemon.getType() + ")" + " (HP: " + playerPokemon.getHealth() + "/" + playerPokemon.getMaxHealth() + ")" + " (PP: " + playerPokemon.getPp() + "/" + playerPokemon.getMaxPp() + ")");
                    System.out.println(opponent.getUsername() + "'s " + opponentPokemon.getName() + "(" + opponentPokemon.getType() + ")" + " (HP: " + opponentPokemon.getHealth() + "/" + opponentPokemon.getMaxHealth() + ")" + " (PP: " + opponentPokemon.getPp() + "/" + opponentPokemon.getMaxPp() + ")");

                    // get the minimum pp required to do a non-status move

                    int minPp = 0;

                    for(int i = 0; i < opponentPokemon.getMoves().length - 1; i++) {
                        if(opponentPokemon.getMoves()[i].getPp() >= minPp) {
                            minPp = opponentPokemon.getMoves()[i].getPp();
                        }
                    }

                    // if opponent pokemon pp is lower than the min pp, the opponent is forced to use the status move to get pp

                    if(opponentPokemon.getPp() < minPp) {
                        // the opponent is forced to use a status move

                        opponentPokemon.getMoves()[opponentPokemon.getMoves().length - 1].decideMoveType(opponentPokemon.getMoves()[opponentPokemon.getMoves().length - 1], opponentPokemon, playerPokemon);

                    } else {

                        // randomly chooses a non-status move to use if the opponent has more than the minimum pp
                        // use a while loop to keep choosing a move until the opponent has enough pp to use the move


                        int chosenMove = (int) (Math.random() * opponentPokemon.getMoves().length - 1);

                        while (opponentPokemon.getMoves()[chosenMove].getPp() > opponentPokemon.getPp()) {
                            chosenMove = (int) (Math.random() * opponentPokemon.getMoves().length - 1);
                        }

                        opponentPokemon.getMoves()[chosenMove].decideMoveType(opponentPokemon.getMoves()[chosenMove], opponentPokemon, playerPokemon);
                        System.out.println("____________________________________________________________");
                    }


                } else {
                    System.out.println("\n" + opponent.getUsername() + "'s " + opponentPokemon.getName() + " fainted!\n");
                    if (opponentPokemon == opponentPokemon1 && opponentPokemon2 != null && opponentPokemon2.getHealth() > 0) {
                        opponentPokemon = opponentPokemon2;
                        System.out.println("Opponent sent out " + opponentPokemon.getName() + "!\n");
                    } else if (opponentPokemon == opponentPokemon2 && opponentPokemon1.getHealth() > 0) {
                        opponentPokemon = opponentPokemon1;
                        System.out.println("Opponent sent out " + opponentPokemon.getName() + "!\n");
                    }   
                }
            }

            playerTurn = !playerTurn;
        }

        if(playerPokemon1.getHealth() <= 0 && playerPokemon2.getHealth() <= 0) {
            System.out.println("You have no more Pokemon left! You have lost the battle!");
            player.setLosses(player.getLosses() + 1);

            System.out.println("You have gained 50 coins for your participation!");
            player.setCoins(player.getCoins() + 50);

            System.out.println("Returning to main menu...");

        } else if(opponentPokemon1.getHealth() <= 0 && (opponentPokemon2 == null || opponentPokemon2.getHealth() <= 0)) {
            System.out.println("You have defeated all of the opponent's Pokemon! You have won the battle!");
            player.setWins(player.getWins() + 1);

            System.out.println("You have gained 300 coins for your victory!");
            player.setCoins(player.getCoins() + 300);

            System.out.println("You are given the chance to capture the defeated Pokemon(s)!");
            
            if(player.getPokeballList().size() > 0) {
                // display the type and quantity of pokeball that the player has

                System.out.println("You have the following Pokeballs in your inventory: ");
                System.out.println(player.getPokeballListString());

                if(legendaryBattle) {
                    System.out.println("You have defeated the LEGENDARY " + opponentPokemon1.getName() + "! You will need at least an Ultra Ball or Master Ball to capture it!");

                    // check if the user has an ultra ball or master ball

                    boolean hasUltraBall = false;
                    boolean hasMasterBall = false;

                    for(Pokeball pokeball : player.getPokeballList()) {
                        if(pokeball.getName().equalsIgnoreCase("Ultra Ball")) {
                            hasUltraBall = true;
                        } else if(pokeball.getName().equalsIgnoreCase("Master Ball")) {
                            hasMasterBall = true;
                        }
                    }

                    if(hasUltraBall || hasMasterBall) {
                        System.out.println("Would you like to use an Ultra Ball or Master Ball to capture the legendary Pokemon? [Y/N]");
                        String usePokeball = scanner.nextLine();

                        if(hasUltraBall && usePokeball.equalsIgnoreCase("Y")) {
                            // asks the player if they want to use an ultra ball to capture the legendary pokemon
                            System.out.println("Use an Ultra Ball? [Y/N]");
                            String useUltraBall = scanner.nextLine();

                            if(useUltraBall.equalsIgnoreCase("Y")) {
                                player.attemptCapturePokemon(opponentPokemon1, player.getPokeball("Ultra Ball"));
                            }

                        }

                        if(hasMasterBall && usePokeball.equalsIgnoreCase("Y")) {
                            // asks the player if they want to use a master ball to capture the legendary pokemon
                            System.out.println("Use a Master Ball? [Y/N]");
                            String useMasterBall = scanner.nextLine();

                            if(useMasterBall.equalsIgnoreCase("Y")) {
                                player.attemptCapturePokemon(opponentPokemon1, player.getPokeball("Master Ball"));
                            }
                        }


                    } else {
                        System.out.println("You do not have an Ultra Ball or Master Ball in your inventory. You cannot capture the legendary Pokemon.");
                    }

                } else {
                    // display the defeated opponent pokemons
                    String[] capturablePokemon = new String[2];
                    capturablePokemon[0] = opponentPokemon1.getName();
                    capturablePokemon[1] = opponentPokemon2.getName();

                    // display capturable pokemons

                    System.out.println("The capturable Pokemon(s) are: ");

                    for(String pokemon : capturablePokemon) {
                        System.out.println(pokemon);
                    }

                    System.out.println("Would you like to use your Pokeball(s) to capture ONE of the defeated Pokemon? [Y/N]");

                    String usePokeball = scanner.nextLine();

                    if(usePokeball.equalsIgnoreCase("Y")) {
                        // let the player choose which pokemon to capture

                        System.out.println("Which Pokemon would you like to capture? ");
                        String pokemonToCapture = choosePokemonFromListString(capturablePokemon, 1).get(0);

                        // let the player choose which pokeball to use

                        System.out.println("You have the following Pokeballs in your inventory: ");

                        System.out.println(player.getPokeballListString());

                        System.out.println("Which Pokeball would you like to use? [\"x\" to exit]");

                        String pokeballToUse = scanner.nextLine();

                        // data validation
                        boolean validInput = false;

                        while(!validInput) {
                            for(Pokeball pokeball : player.getPokeballList()) {
                                if(pokeball.getName().equalsIgnoreCase(pokeballToUse)) {
                                    validInput = true;
                                    break;
                                } else if (pokeballToUse.equalsIgnoreCase("x")) {
                                    break;
                                }
                            }

                            if(!validInput) {
                                System.out.println("Invalid input. Please choose a valid Pokeball from the list.");
                                pokeballToUse = scanner.nextLine();
                            }
                        }

                        player.attemptCapturePokemon(PokemonFactory.createPokemon(pokemonToCapture), player.getPokeball(pokeballToUse));

                    } else {
                        System.out.println("You have chosen not to capture the defeated Pokemon(s).");
                    }
                }
            } else {
                System.out.println("You do not have any Pokeballs in your inventory. You cannot capture the defeated Pokemon(s).");
            }
        }

        System.out.println("\nBattle concluded!");
        System.out.println("Returning to main menu...");

    }

    public static List<Pokemon> choosePokemonFromListPokemon(ArrayList<Pokemon> playerPokemonList, int numberOfPokemon) {
        List<Pokemon> playerChosenPokemonList = new ArrayList<>();
        while (playerChosenPokemonList.size() < numberOfPokemon) {
            System.out.println("Pokemon List:\n");
            int pokemonIndex = 1;
            for (Pokemon pokemon : playerPokemonList) {
                if(pokemon == null) {
                    System.out.print(pokemonIndex + ". ");
                    System.out.println("This Pokemon has already been chosen.");
                    System.out.println("----------------------------------------");
                    pokemonIndex++;
                    continue;
                }

                // associate every pokemon with an index number
                // print the pokemon index in the list
                System.out.print(pokemonIndex + ". ");
                System.out.println(pokemon.getName() + "\n" + "Type: " + pokemon.getType() + "\n" + "Health: " + pokemon.getHealth() + "\n" + "Max Health: " + pokemon.getMaxHealth() + "\n" + "PP: " + pokemon.getPp() + "\n" + "Max PP: " + pokemon.getMaxPp());
                
                System.out.println("----------------------------------------");
                pokemonIndex++;
            }

            System.out.println("\nEnter PRECISELY, the ASSOCIATED INDEX of the Pokemon you want to choose: ");

            // instead of entering pokemon name, enter the number of the pokemon in the list

            Scanner scanner = new Scanner(System.in);
            int chosenPokemonIndex = scanner.nextInt();

            // data validation

            while (chosenPokemonIndex < 0 || chosenPokemonIndex > pokemonIndex - 1) {
                System.out.println("Invalid input. Please enter a valid number.");
                chosenPokemonIndex = scanner.nextInt();
            }

            Pokemon chosenPokemon = playerPokemonList.get(chosenPokemonIndex - 1);


            playerChosenPokemonList.add(chosenPokemon);
            System.out.print("\033[H\033[2J"); 

            //make the first letter of the pokemon name uppercase and the rest lowercase
            System.out.println("You have chosen: " + chosenPokemon.getName() + "\n\n");
            

            // make chosen pokemon null

            playerPokemonList.set(chosenPokemonIndex - 1, null);
        }

        return playerChosenPokemonList;
    }

    public static List<String> choosePokemonFromListString(String[] pokemonNameList, int numberOfPokemon) {
        Scanner scanner = new Scanner(System.in);
        List<String> chosenPokemonList = new ArrayList<>();


        // display all pokemon in the list and associate each pokemon with a number


        while (chosenPokemonList.size() < numberOfPokemon) {
            System.out.println("Pokemon List:\n");
            int pokemonIndex = 1;
            for (String pokemon : pokemonNameList) {

                // associate every pokemon with an index number
                // print the pokemon index in the list
                System.out.print(pokemonIndex + ". ");
                System.out.println(PokemonFactory.getPokemonStats(pokemon));
                System.out.println("----------------------------------------");
                pokemonIndex++;
            }

            System.out.println("\nEnter PRECISELY, the ASSOCIATED INDEX of the Pokemon you want to choose: ");

            // instead of entering pokemon name, enter the number of the pokemon in the list

            int chosenPokemonIndex = scanner.nextInt();

            // data validation

            while (chosenPokemonIndex < 0 || chosenPokemonIndex > pokemonIndex - 1) {
                System.out.println("Invalid input. Please enter a valid number.");
                chosenPokemonIndex = scanner.nextInt();
            }

            String chosenPokemonName = pokemonNameList[chosenPokemonIndex - 1];

            boolean isValidPokemon = false;
            for (String pokemon : pokemonNameList) {
                if (pokemon.equalsIgnoreCase(chosenPokemonName) && chosenPokemonName != "") {
                    isValidPokemon = true;
                    break;
                }
            }

            if (!isValidPokemon) {
                System.out.println("Invalid pokemon. Please choose from the list and enter the pokemon name PRECISELY.");
                continue;
            }

            chosenPokemonList.add(chosenPokemonName);
            System.out.print("\033[H\033[2J"); 

            //make the first letter of the pokemon name uppercase and the rest lowercase
            System.out.println("You have chosen: " + chosenPokemonName.substring(0, 1).toUpperCase() + chosenPokemonName.substring(1).toLowerCase() + "\n\n");
            

            // remove chosen pokemon from list

            for (int i = 0; i < pokemonNameList.length; i++) {
                if (pokemonNameList[i].equalsIgnoreCase(chosenPokemonName)) {
                    pokemonNameList[i] = "";
                    break;
                }
            }
        }
        return chosenPokemonList;
    }
}
