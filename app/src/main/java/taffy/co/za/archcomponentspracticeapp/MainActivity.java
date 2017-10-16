package taffy.co.za.archcomponentspracticeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import taffy.co.za.archcomponentspracticeapp.adapters.RecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler;
    RecyclerViewAdapter recyclerViewAdapter;
    String[] categories = {"category 1", "two", "three", "three", "three", "three", "three",
            "three", "three", "three", "three", "three", "three", "three", "three", "three",
            "three", "three", "three", "three", "three", "three", "three", "three", "three",
            "three", "three", "three", "three", "three", "three", "three", "three", "three",
            "three", "three"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categoryRecycler = findViewById(R.id.category_recyclerview);
        categoryRecycler.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter = new RecyclerViewAdapter(this, categories);
        categoryRecycler.setAdapter(recyclerViewAdapter);
    }
}
