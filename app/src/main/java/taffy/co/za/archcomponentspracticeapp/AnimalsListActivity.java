package taffy.co.za.archcomponentspracticeapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import taffy.co.za.archcomponentspracticeapp.adapters.AnimalsRecyclerViewAdapter;
import taffy.co.za.archcomponentspracticeapp.data.service.AnimalAPI;
import taffy.co.za.archcomponentspracticeapp.models.Animal;
import taffy.co.za.archcomponentspracticeapp.presenters.AnimalListContract;
import taffy.co.za.archcomponentspracticeapp.presenters.AnimalListPresenter;

public class AnimalsListActivity extends AppCompatActivity implements AnimalListContract.View {

    RecyclerView animalsRecycler;
    AnimalsRecyclerViewAdapter animalsAdapter;
    ImageView loadingImage;
    List<Animal> animalsList;
    private Toolbar toolbar;
    AnimalAPI animalAPI;
    Bundle categoryBundle;
    String category;
    AnimalListPresenter animalsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_list_actiivity);

        categoryBundle = getIntent().getExtras();
        category = categoryBundle.get("animalCategory").toString();
        loadingImage = findViewById(R.id.loading_image);
        animalsPresenter = new AnimalListPresenter(this);
        setToolbar();
        animalsPresenter.loadAnimals(category);
    }

    private void setToolbar() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(categoryBundle.get("animalCategoryDescription").toString());
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.back_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnimalsListActivity.super.onBackPressed();
            }
        });
    }

    private void setRecyclerView() {
        animalsRecycler = findViewById(R.id.animals_recyclerview);
        animalsRecycler.setLayoutManager(new GridLayoutManager(this, 2));
        animalsAdapter = new AnimalsRecyclerViewAdapter(this, animalsList);
        animalsRecycler.setAdapter(animalsAdapter);
    }

    @Override
    public void updateAnimalList(List<Animal> animalList) {
        this.animalsList = animalList;
        setRecyclerView();
    }

    @Override
    public void hideLoading() {
        loadingImage.setVisibility(View.GONE);
    }

    @Override
    public void showLoading() {
        loadingImage.setVisibility(View.VISIBLE);
    }
}
