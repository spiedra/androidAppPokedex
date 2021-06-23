package spiedra.jc.androidapppokedex.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.util.ArrayList;
import spiedra.jc.androidapppokedex.PokeInfoActivity;
import spiedra.jc.androidapppokedex.R;
import spiedra.jc.androidapppokedex.models.Pokemon;

public class PokeListViewHolder extends RecyclerView.ViewHolder{

    private final TextView tvPokeName;
    private final ImageView imageView;

    public PokeListViewHolder(View itemView) {
        super(itemView);
        this.tvPokeName = itemView.findViewById(R.id.tvPokemonName);
        this.imageView = itemView.findViewById(R.id.imageView);
    }

    public void bind(ArrayList<Pokemon> pokeList, int position, Context context) {
        this.tvPokeName.setText(pokeList.get(position).getName());
        Glide.with(context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + pokeList.get(position).getId() + ".png")
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(this.imageView);

            itemView.setOnClickListener(v -> {
            Intent i = new Intent(v.getContext(), PokeInfoActivity.class);
            i.putExtra("id", String.valueOf(pokeList.get(position).getId()));
            v.getContext().startActivity(i);
        });
    }
}
