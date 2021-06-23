package spiedra.jc.androidapppokedex.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import spiedra.jc.androidapppokedex.PokeInfoActivity;
import spiedra.jc.androidapppokedex.R;
import spiedra.jc.androidapppokedex.models.Pokemon;

public class PokeListAdapter extends RecyclerView.Adapter<PokeListViewHolder>{

    private ArrayList<Pokemon> pokemonList;
    private Context context;

    public PokeListAdapter(Context context){
        pokemonList = new ArrayList<>();
        this.context = context;
    }

    @Override
    public PokeListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       return new PokeListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon_list, parent, false));
    }

    @Override
    public void onBindViewHolder(PokeListViewHolder holder, int position) {
        holder.bind(this.pokemonList, position, this.context);
    }

    @Override
    public int getItemCount() {
        return this.pokemonList.size();
    }

    public void appendDataToPokeList(ArrayList<Pokemon> pokemonList){
        this.pokemonList.addAll(pokemonList);
        notifyDataSetChanged();
    }
}
