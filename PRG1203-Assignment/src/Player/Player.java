package Player;
import Pokemon.Pokemon;
import Utility.Pokeball;

import java.util.ArrayList;

public class Player {
    private String username;
    private int wins;
    private int losses;
    private int draws;
    private int totalGames;
    private int score;
    private int coins;
    private ArrayList<Pokeball> pokeballList;
    private ArrayList<Pokemon> pokemonList;

    public Player(String username) {
        this.username = username;
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
        this.totalGames = 0;
        this.score = 0;
        this.coins = 0;
        this.pokeballList = new ArrayList<Pokeball>();
        this.pokemonList = new ArrayList<Pokemon>();
    }

    public String getUsername() {
        return username;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getDraws() {
        return draws;
    }

    public int getTotalGames() {
        // total games = wins + losses + draws

        return wins + losses + draws;
    }

    public int getScore() {
        return score;
    }

    public int getCoins() {
        return coins;
    }

    public ArrayList<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public Pokeball getPokeball(String pokeballName) {
        for (Pokeball pokeball : pokeballList) {
            if (pokeball.getName().equalsIgnoreCase(pokeballName)) {
                return pokeball;
            }
        }
        return null;
    }

    public void addPokeball(Pokeball pokeball) {
        pokeballList.add(pokeball);
    }

    public void removePokeball(String pokeballName) {
        for (Pokeball pokeball : pokeballList) {
            if (pokeball.getName().equalsIgnoreCase(pokeballName)) {
                pokeballList.remove(pokeball);
            }
        }
    }

    public ArrayList<Pokeball> getPokeballList() {
        return pokeballList;
    }

    public String getPokeballListString() {
        int pokeballQuantity = 0;
        int greatBallQuantity = 0;
        int ultraBallQuantity = 0;

        for (Pokeball pokeball : pokeballList) {
            if (pokeball.getName().equalsIgnoreCase("Pokeball")) {
                pokeballQuantity++;
            } else if (pokeball.getName().equalsIgnoreCase("Great Ball")) {
                greatBallQuantity++;
            } else if (pokeball.getName().equalsIgnoreCase("Ultra Ball")) {
                ultraBallQuantity++;
            }
        }

        return "Pokeball: " + pokeballQuantity + "\nGreat Ball: " + greatBallQuantity + "\nUltra Ball: " + ultraBallQuantity;
    }

    public void attemptCapturePokemon(Pokemon pokemon, Pokeball pokeball) {
        double random = Math.random();
        if (random <= pokeball.getCatchRate()) {
            addPokemon(pokemon);
            System.out.println("Congratulations! You have captured " + pokemon.getName() + "!");
        } else {
            System.out.println("Oh no! " + pokemon.getName() + " has escaped!");
        }


        // remove pokeball from player's inventory after attempt

        removePokeball(pokeball.getName());
    }

    // get pokemon list in string list

    public String[] getPokemonListString() {
        String[] pokemonListString = new String[pokemonList.size()];
        for (int i = 0; i < pokemonList.size(); i++) {
            pokemonListString[i] = pokemonList.get(i).getName();
        }
        return pokemonListString;
    }

    public Pokemon getPokemon(String pokemonName) {
        for (Pokemon pokemon : pokemonList) {
            if (pokemon.getName().equalsIgnoreCase(pokemonName)) {
                return pokemon;
            }
        }
        return null;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void addPokemon(Pokemon pokemon) {
        pokemonList.add(pokemon);
    }

    public void removePokemon(Pokemon pokemon) {
        pokemonList.remove(pokemon);
    }

    public void clearPokemonList() {
        pokemonList.clear();
    }
    
    public void displayStats() {
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Total Games: " + totalGames);
        System.out.println("Score: " + score);
        System.out.println("Coins: " + coins);

        System.out.println("\nPokemon List:");
        for (Pokemon pokemon : pokemonList) {
            System.out.println(pokemon.toString());
        }

        System.out.println("\nPokeball List:");
        for (Pokeball pokeball : pokeballList) {
            System.out.println(pokeball.toString());
        }
    }
}
