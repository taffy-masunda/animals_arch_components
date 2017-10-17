package taffy.co.za.archcomponentspracticeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

import taffy.co.za.archcomponentspracticeapp.adapters.AnimalsRecyclerViewAdapter;
import taffy.co.za.archcomponentspracticeapp.models.Animal;

public class AnimalsListActiivity extends AppCompatActivity {

    RecyclerView animalsRecycler;
    AnimalsRecyclerViewAdapter animalsAdapter;
    ArrayList<Animal> animalsList;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_list_actiivity);

        setToolbar();
        addAnimals();
        animalsRecycler = findViewById(R.id.animals_recyclerview);
        animalsRecycler.setLayoutManager(new GridLayoutManager(this, 2));
        animalsAdapter = new AnimalsRecyclerViewAdapter(this, animalsList);
        animalsRecycler.setAdapter(animalsAdapter);
    }

    public void addAnimals(){
        animalsList = new ArrayList<Animal>();
        animalsList.add(new Animal("Lion","This is  just a lion and we trying it out","lion.jpg"));
        animalsList.add(new Animal("Zebra","This is  just a zebra and we trying it out","zebra.jpg"));
        animalsList.add(new Animal("Dog","This is  just a dog and we trying it out","dog.jpg"));
        animalsList.add(new Animal("Cat","This is  just a cat and we trying it out","cat.jpg"));
        animalsList.add(new Animal("Horse","This is  just a horse and we trying it out","horse.png"));
        animalsList.add(new Animal("Tiger","This is  just a tiger and we trying it out","tiger.jpg"));
    }

    private void setToolbar() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Farm Animals");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.back_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnimalsListActiivity.super.onBackPressed();
            }
        });
    }
}
