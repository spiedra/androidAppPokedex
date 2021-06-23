package spiedra.jc.androidapppokedex.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import spiedra.jc.androidapppokedex.models.PokeApiResponse;
import spiedra.jc.androidapppokedex.models.Pokemon;

public interface PokeApiService {
    @GET("pokemon")
    Call<PokeApiResponse> getPokemonList(@Query("limit") int limit, @Query("offset") int offset);

    @GET("pokemon/{id}")
    Call<Pokemon> getPokemonInfo(@Path("id") int id);
}
