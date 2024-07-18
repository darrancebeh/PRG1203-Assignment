package Player;
import Pokemon.Pokemon;
import java.util.ArrayList;

public class Player {
    private String username;
    private int wins;
    private int losses;
    private int draws;
    private int totalGames;
    private int score;
    private ArrayList<Pokemon> pokemon_list;

    public Player(String username) {
        this.username = username;
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
        this.totalGames = 0;
        this.score = 0;
        this.pokemon_list = new ArrayList<Pokemon>();
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

    public ArrayList<Pokemon> getPokemonList() {
        return pokemon_list;
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

    public void addPokemon(Pokemon pokemon) {
        pokemon_list.add(pokemon);
    }

    public void removePokemon(Pokemon pokemon) {
        pokemon_list.remove(pokemon);
    }

    public void clearPokemonList() {
        pokemon_list.clear();
    }
}
