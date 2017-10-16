package taffy.co.za.archcomponentspracticeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;

public class AnimalDetailsActivity extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbar;
    ImageView animalImageview;
    TextView nameTextview, categoryTextview, habitatTextview, descriptionTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_details);

        initializeView();
        setToolbar();
        setAnimalImageview();
        setViewText();
    }

    private void initializeView() {
        toolbar = findViewById(R.id.toolbar);
        animalImageview = findViewById(R.id.animal_imageview);
        nameTextview = findViewById(R.id.animal_name_textview);
        categoryTextview = findViewById(R.id.category_textview);
        habitatTextview = findViewById(R.id.habitat_textview);
        descriptionTextview = findViewById(R.id.description_textview);
    }

    private void setToolbar() {
        setSupportActionBar(toolbar);
        toolbar.setTitle("Animal Details");
        toolbar.setNavigationIcon(R.drawable.back_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnimalDetailsActivity.super.onBackPressed();
            }
        });
    }

    private void setAnimalImageview() {
        Glide.with(this)
                .load("")
                .into(animalImageview);
    }

    private void setViewText() {
        nameTextview.setText("");
        categoryTextview.setText("");
        habitatTextview.setText("");
        descriptionTextview.setText("");
    }
}
