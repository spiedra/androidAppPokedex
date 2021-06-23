package spiedra.jc.androidapppokedex.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import spiedra.jc.androidapppokedex.R;
import spiedra.jc.androidapppokedex.models.Pokemon;

public class PokeListAdapter extends RecyclerView.Adapter<PokeListViewHolder> {

    private final ArrayList<Pokemon> pokemonList;
    private final Context context;

    public PokeListAdapter(Context context) {
        pokemonList = new ArrayList<>();
        this.context = context;
    }

    @NonNull
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

    public void appendDataToPokeList(ArrayList<Pokemon> pokemonList) {
        this.pokemonList.addAll(pokemonList);
        notifyDataSetChanged();
    }
}
