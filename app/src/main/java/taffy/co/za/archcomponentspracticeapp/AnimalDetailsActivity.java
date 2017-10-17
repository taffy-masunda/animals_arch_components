package taffy.co.za.archcomponentspracticeapp;

import android.speech.tts.TextToSpeech;
import android.speech.tts.Voice;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;

import java.util.Locale;

public class AnimalDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    android.support.v7.widget.Toolbar toolbar;
    ImageView animalImageview;
    TextView nameTextview, categoryTextview, habitatTextview, descriptionTextview;
    FloatingActionButton speakOutFab;
    TextToSpeech textToSpeech;
    int result;

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
        animalImageview = findViewById(R.id.animal_imageview);
        nameTextview = findViewById(R.id.animal_name_textview);
        categoryTextview = findViewById(R.id.category_textview);
        habitatTextview = findViewById(R.id.habitat_textview);
        descriptionTextview = findViewById(R.id.description_textview);
        speakOutFab = findViewById(R.id.read_out_fab);

        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    result = textToSpeech.setLanguage(Locale.US);
                } else {
                    Toast.makeText(AnimalDetailsActivity.this, "Sorry, text to speech not supported on your device.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        speakOutFab.setOnClickListener(this);
    }

    private void setToolbar() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Cat");
        setSupportActionBar(toolbar);
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
                .load(R.drawable.cat)
                .into(animalImageview);
    }

    private void setViewText() {
        nameTextview.setText("name");
        categoryTextview.setText("catagory");
        habitatTextview.setText("habitat");
        descriptionTextview.setText("description");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.read_out_fab:
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Toast.makeText(AnimalDetailsActivity.this, "Sorry, text to speech not supported on your device.", Toast.LENGTH_SHORT).show();
                } else {
                    String textToSpeak = "This is a "+ nameTextview.getText().toString() + " and it lives in " + habitatTextview.getText().toString();
                    textToSpeech.speak(textToSpeak, TextToSpeech.QUEUE_FLUSH, null);
                }
                break;
        }
    }
}
