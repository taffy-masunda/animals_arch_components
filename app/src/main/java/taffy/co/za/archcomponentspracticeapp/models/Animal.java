package taffy.co.za.archcomponentspracticeapp.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Animal {

    @PrimaryKey
    private String id;
    private String name;
    private String description;
    private String habitat;
    private String image_url;
    private String category;

    public Animal() {
    }

    public Animal(String name, String description,  String image_url) {
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
