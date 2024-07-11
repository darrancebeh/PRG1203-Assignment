package Player;
import java.util.ArrayList;

public class Player {
    private String username;
    private int wins;
    private int losses;
    private int draws;
    private int totalGames;
    private int score;
    private ArrayList<String> pokemon_list;

    public Player(String username) {
        this.username = username;
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
        this.totalGames = 0;
        this.score = 0;
        this.pokemon_list = new ArrayList<String>();
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
        return totalGames;
    }

    public int getScore() {
        return score;
    }

    public ArrayList<String> getPokemonList() {
        return pokemon_list;
    }

    public void addWin() {
        wins++;
        totalGames++;
    }

    public void addLoss() {
        losses++;
        totalGames++;
    }

    public void addDraw() {
        draws++;
        totalGames++;
    }

    public void addPokemon(String pokemon) {
        pokemon_list.add(pokemon);
    }

    public void removePokemon(String pokemon) {
        pokemon_list.remove(pokemon);
    }

    public void clearPokemonList() {
        pokemon_list.clear();
    }
}
