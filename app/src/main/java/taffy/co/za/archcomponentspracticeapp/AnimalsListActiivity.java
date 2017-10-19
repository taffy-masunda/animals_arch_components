package taffy.co.za.archcomponentspracticeapp;

import android.app.ProgressDialog;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import taffy.co.za.archcomponentspracticeapp.adapters.AnimalsRecyclerViewAdapter;
import taffy.co.za.archcomponentspracticeapp.data.service.AnimalAPI;
import taffy.co.za.archcomponentspracticeapp.data.service.AnimalAPIClient;
import taffy.co.za.archcomponentspracticeapp.models.Animal;

public class AnimalsListActiivity extends AppCompatActivity {

    RecyclerView animalsRecycler;
    AnimalsRecyclerViewAdapter animalsAdapter;
    ImageView loadingImage;
    ArrayList<Animal> animalsList;
    private Toolbar toolbar;
    AnimalAPI animalAPI;
    ProgressDialog progressDialog;
    Bundle categoryBundle;
    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_list_actiivity);

        categoryBundle = getIntent().getExtras();
        category = categoryBundle.get("animalCategory").toString();
        loadingImage = findViewById(R.id.loading_image);
        setToolbar();
        addAnimals();
    }

    private void setToolbar() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(categoryBundle.get("animalCategoryDescription").toString());
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.back_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnimalsListActiivity.super.onBackPressed();
            }
        });
    }

    public void addAnimals() {
        animalAPI = AnimalAPIClient.getAPIClient().create(AnimalAPI.class);
        Call<ArrayList<Animal>> call = animalAPI.getAllAnimals(category);
        call.enqueue(new Callback<ArrayList<Animal>>() {
            @Override
            public void onResponse(Call<ArrayList<Animal>> call, Response<ArrayList<Animal>> response) {
                animalsList = response.body();
                loadingImage.setVisibility(View.GONE);
                setRecyclerView();
            }

            @Override
            public void onFailure(Call<ArrayList<Animal>> call, Throwable t) {
                loadingImage.setVisibility(View.GONE);
                Toast.makeText(AnimalsListActiivity.this, "Error getting animals.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setRecyclerView() {
        animalsRecycler = findViewById(R.id.animals_recyclerview);
        animalsRecycler.setLayoutManager(new GridLayoutManager(this, 2));
        animalsAdapter = new AnimalsRecyclerViewAdapter(this, animalsList);
        animalsRecycler.setAdapter(animalsAdapter);
    }
}
