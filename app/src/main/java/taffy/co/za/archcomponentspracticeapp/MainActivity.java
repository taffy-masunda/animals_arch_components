package taffy.co.za.archcomponentspracticeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import taffy.co.za.archcomponentspracticeapp.adapters.CategoryRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler;
    CategoryRecyclerViewAdapter categoryRecyclerViewAdapter;
    String[] categories;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolbar();
        setArray();
        initializaCategoryRecyclerview();
    }

    private void setToolbar() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Animal Games");
        toolbar.setNavigationIcon(R.drawable.back_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.super.onBackPressed();
            }
        });
        setSupportActionBar(toolbar);
    }

    private void setArray(){
        categories = new String[]{"category 1", "two", "three", "three", "three", "three", "three",
                "three", "three", "three", "three", "three", "three", "three", "three", "three",
                "three", "three", "three", "three", "three", "three", "three", "three", "three",
                "three", "three", "three", "three", "three", "three", "three", "three", "three",
                "three", "three"};
    }

    private void initializaCategoryRecyclerview() {
        categoryRecycler = findViewById(R.id.category_recyclerview);
        categoryRecycler.setLayoutManager(new LinearLayoutManager(this));
        categoryRecyclerViewAdapter = new CategoryRecyclerViewAdapter(this, categories);
        categoryRecycler.setAdapter(categoryRecyclerViewAdapter);
    }
}
