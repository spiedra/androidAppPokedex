package spiedra.jc.androidapppokedex.adapters;

import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAdapter {
    private static RetrofitAdapter instance = null;
    private final Retrofit retrofit;
    private static final String BASE_URL = "https://pokeapi.co/api/v2/";

    private RetrofitAdapter() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(
                        new GsonBuilder().serializeNulls().create()
                )).build();
    }

    public static RetrofitAdapter getInstance() {
        if (instance == null)
            instance = new RetrofitAdapter();

        return instance;
    }

    public Retrofit getInstanceRetrofit(){
        return this.retrofit;
    }
}
