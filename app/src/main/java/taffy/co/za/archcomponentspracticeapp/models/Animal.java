package taffy.co.za.archcomponentspracticeapp.models;

import android.arch.persistence.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class Animal {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("habitat")
    @Expose
    private String habitat;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("sound_url")
    @Expose
    private Object soundUrl;
    @SerializedName("category")
    @Expose
    private String category;

    public Animal() {
    }

    public Animal(String id, String name, String description, String habitat, String imageUrl, Object soundUrl, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.habitat = habitat;
        this.imageUrl = imageUrl;
        this.soundUrl = soundUrl;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Object getSoundUrl() {
        return soundUrl;
    }

    public void setSoundUrl(Object soundUrl) {
        this.soundUrl = soundUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}