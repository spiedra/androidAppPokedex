package spiedra.jc.androidapppokedex.models;

import java.util.ArrayList;

public class PokeApiResponse {
    private final ArrayList<Pokemon> results;

    public PokeApiResponse(ArrayList<Pokemon> results) {
        this.results = results;
    }

    public ArrayList<Pokemon> getResults() {
        return results;
    }
}
