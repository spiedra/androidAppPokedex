package spiedra.jc.androidapppokedex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import spiedra.jc.androidapppokedex.adapters.PokeListAdapter;
import spiedra.jc.androidapppokedex.adapters.RetrofitAdapter;
import spiedra.jc.androidapppokedex.models.PokeApiResponse;
import spiedra.jc.androidapppokedex.service.PokeApiService;

public class MainActivity extends AppCompatActivity {

    private RetrofitAdapter retrofitAdapter;
    private PokeListAdapter pokeListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.retrofitAdapter = RetrofitAdapter.getInstance();
        RecyclerView recyclerView = findViewById(R.id.recycleView);
        this.pokeListAdapter = new PokeListAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(pokeListAdapter);
        this.makeCall();
    }

    public void makeCall() {
        PokeApiService pokeApiService = retrofitAdapter.getInstanceRetrofit().create(PokeApiService.class);
        Call<PokeApiResponse> call = pokeApiService.getPokemonList(125, 0);

        call.enqueue(new Callback<PokeApiResponse>() {
            @Override
            public void onResponse(@NonNull Call<PokeApiResponse> call, @NonNull Response<PokeApiResponse> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    pokeListAdapter.appendDataToPokeList(response.body().getResults());
                } else {
                    Log.d("Error", "Something happened");
                }
            }

            @Override
            public void onFailure(@NonNull Call call, @NonNull Throwable t) {
                Log.d("Error", t.toString());
            }
        });
    }
}