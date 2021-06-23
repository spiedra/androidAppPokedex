package spiedra.jc.androidapppokedex.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pokemon {
    @Expose
    @SerializedName("name")
    private final String name;
    @Expose
    @SerializedName("url")
    private final String url;
    @Expose
    @SerializedName("height")
    private final int height;
    @Expose
    @SerializedName("weight")
    private final int weight;

    public Pokemon(String name, String url, int height, int weight) {
        this.name = name;
        this.url = url;
        this.height = height;
        this.weight = weight;
    }


    public String getName() {
        return name;
    }

    public int getId() {
        String[] splitUrl = url.split("/");
        return Integer.parseInt(splitUrl[splitUrl.length - 1]);
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

}
