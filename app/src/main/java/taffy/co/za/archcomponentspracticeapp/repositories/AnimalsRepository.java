package taffy.co.za.archcomponentspracticeapp.repositories;

import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import taffy.co.za.archcomponentspracticeapp.data.service.AnimalAPI;
import taffy.co.za.archcomponentspracticeapp.data.service.AnimalAPIClient;
import taffy.co.za.archcomponentspracticeapp.models.Animal;

public class AnimalsRepository {
    AnimalAPI animalAPI;
    ArrayList<Animal> animalsList;

    public ArrayList<Animal> getAnimalsPerCategory(String category){

        animalAPI = AnimalAPIClient.getAPIClient().create(AnimalAPI.class);
        Call<ArrayList<Animal>> call = animalAPI.getAllAnimals(category);
        call.enqueue(new Callback<ArrayList<Animal>>() {
            @Override
            public void onResponse(Call<ArrayList<Animal>> call, Response<ArrayList<Animal>> response) {
                animalsList = response.body();
            }

            @Override
            public void onFailure(Call<ArrayList<Animal>> call, Throwable t) {
               // animalsList = null;
                new Exception("Error. Could not get animals");
            }
        });

        return animalsList;
    }
}
