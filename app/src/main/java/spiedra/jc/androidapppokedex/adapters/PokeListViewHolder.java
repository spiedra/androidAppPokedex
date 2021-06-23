package spiedra.jc.androidapppokedex.adapters;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.renderscript.Sampler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import spiedra.jc.androidapppokedex.MainActivity;
import spiedra.jc.androidapppokedex.PokeInfoActivity;
import spiedra.jc.androidapppokedex.R;
import spiedra.jc.androidapppokedex.models.Pokemon;

public class PokeListViewHolder extends RecyclerView.ViewHolder{

    private TextView tvPokeName;
    private ImageView imageView;
    public View view;

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
