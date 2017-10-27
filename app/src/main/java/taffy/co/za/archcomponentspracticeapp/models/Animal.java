package taffy.co.za.archcomponentspracticeapp.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class Animal {

    @PrimaryKey @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("habitat")
    private String habitat;

    @SerializedName("image_url")
    private String image_url;

    @SerializedName("category")
    private String category;

    public Animal() {
    }

    public Animal(String id, String name, String description, String habitat, String image_url, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.habitat = habitat;
        this.image_url = image_url;
        this.category = category;
    }

    public Animal(String name, String description, String image_url) {
        this.name = name;
        this.description = description;
        this.image_url = image_url;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHabitat() {
        return this.habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getImageUrl() {
        return this.image_url;
    }

    public void setImageUrl(String image_url) {
        this.image_url = image_url;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
