package taffy.co.za.archcomponentspracticeapp.data.service;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import taffy.co.za.archcomponentspracticeapp.models.Animal;

/**
 * Created by TMasunda on 2017/10/17.
 */

public interface AnimalAPI {

    @GET("get_animals_per_category.php?category=")
    Call<ArrayList<Animal>> getAllAnimals(@Query("category") String category);
}
