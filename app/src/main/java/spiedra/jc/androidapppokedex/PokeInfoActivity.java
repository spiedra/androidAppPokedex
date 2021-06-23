package spiedra.jc.androidapppokedex;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import spiedra.jc.androidapppokedex.adapters.RetrofitAdapter;
import spiedra.jc.androidapppokedex.models.Pokemon;
import spiedra.jc.androidapppokedex.service.PokeApiService;

public class PokeInfoActivity extends AppCompatActivity {
    private RetrofitAdapter retrofitAdapter;
    private TextView txPokeName;
    private TextView tvPokeHeight;
    private TextView tvPokeWeight;
    private ImageView imagePoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poke_info);
        this.retrofitAdapter = RetrofitAdapter.getInstance();
        this.displayPokeInfo();
    }

    public void displayPokeInfo() {
        Intent intent = getIntent();
        this.imagePoke = findViewById(R.id.pokeImageInfo);
        this.txPokeName = findViewById(R.id.tvPokeNameInfo);
        this.tvPokeHeight = findViewById(R.id.tvHeight);
        this.tvPokeWeight = findViewById(R.id.tvWeight);
        this.makeCall(Integer.parseInt(intent.getStringExtra("id")));
    }

    private void makeCall(int id) {
        PokeApiService pokeApiService = retrofitAdapter.getInstanceRetrofit().create(PokeApiService.class);
        Call<Pokemon> call = pokeApiService.getPokemonInfo(id);

        call.enqueue(new Callback<Pokemon>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(@NonNull Call<Pokemon> call, @NonNull Response<Pokemon> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    txPokeName.setText(response.body().getName());
                    tvPokeHeight.setText("Height: " + response.body().getHeight());
                    tvPokeWeight.setText("Weight: " + response.body().getWeight() + " lbs");
                    displayPokeImageInfo(id);
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

    private void displayPokeImageInfo(int id) {
        Glide.with(this)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + id + ".png")
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imagePoke);
    }
}
