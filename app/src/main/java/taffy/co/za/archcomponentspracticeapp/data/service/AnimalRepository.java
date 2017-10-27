package taffy.co.za.archcomponentspracticeapp.data.service;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import taffy.co.za.archcomponentspracticeapp.models.Animal;

public class AnimalRepository {
    AnimalAPI animalAPI;
    public Boolean isLoaded = false;

    public void getAnimalsList(String category, final AnimalRepositoryCallback animalRepositoryCallback){

        animalAPI = AnimalAPIClient.getAPIClient().create(AnimalAPI.class);
        Call<ArrayList<Animal>> call = animalAPI.getAllAnimals(category);
        call.enqueue(new Callback<ArrayList<Animal>>() {
            @Override
            public void onResponse(Call<ArrayList<Animal>> call, Response<ArrayList<Animal>> response) {
                animalRepositoryCallback.onAnimalsFetched(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Animal>> call, Throwable t) {
                animalRepositoryCallback.onFailure(t);
            }
        });
    }

    public interface AnimalRepositoryCallback {
        void onAnimalsFetched(List<Animal> animalList);
        void onFailure(Throwable e);
    }
}
