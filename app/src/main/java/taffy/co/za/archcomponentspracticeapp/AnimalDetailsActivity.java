package taffy.co.za.archcomponentspracticeapp;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.Locale;

public class AnimalDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    android.support.v7.widget.Toolbar toolbar;
    ImageView animalImageview;
    TextView nameTextview, categoryTextview, habitatTextview, descriptionTextview;
    FloatingActionButton animalSoundFab;
    TextToSpeech textToSpeech;
    int result;
    private static final String notSupported = "Sorry, text to speech not supported on your device.";
    Bundle animalDetailsBundle;
    MediaPlayer animalSoundPlayer;
    public static String BASE_URL = "http://api.spectradigital.co.za/animals_app";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_details);

        initializeVariables();
        setToolbar();
        setViewTextAndImage();
        setUpAnimalPlayer("howl_catoye.mp3");
    }

    private void initializeVariables() {
        animalDetailsBundle = getIntent().getExtras();
        animalImageview = findViewById(R.id.animal_imageview);
        nameTextview = findViewById(R.id.animal_name_textview);
        categoryTextview = findViewById(R.id.category_textview);
        habitatTextview = findViewById(R.id.habitat_textview);
        descriptionTextview = findViewById(R.id.description_textview);
        animalSoundFab = findViewById(R.id.read_out_fab);

        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    result = textToSpeech.setLanguage(Locale.US);
                } else {
                    Toast.makeText(AnimalDetailsActivity.this, notSupported, Toast.LENGTH_SHORT).show();
                }
            }
        }); 

        animalSoundFab.setOnClickListener(this);
    }

    private void setToolbar() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(animalDetailsBundle.get("animalName").toString());
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.back_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnimalDetailsActivity.super.onBackPressed();
            }
        });
    }

    private void setViewTextAndImage() {
        String url = BASE_URL + "/animal_pics/" + animalDetailsBundle.get("imageUrl");
        String animalName = animalDetailsBundle.get("animalName").toString();
        String animalCategory = animalDetailsBundle.get("animalCategory").toString();
        String animalHabitat = animalDetailsBundle.get("animalHabitat").toString();
        String animalDescription = animalDetailsBundle.get("animalDescription").toString();

        Glide.with(this)
                .load(url)
                .into(animalImageview);
        nameTextview.setText(animalName);
        categoryTextview.setText(animalCategory);
        habitatTextview.setText(animalHabitat);
        descriptionTextview.setText(animalDescription);
    }

    public void setUpAnimalPlayer(String animalSound){
        if(!animalDetailsBundle.get("soundUrl").equals(null)){
            Uri animalSoundUri = Uri.parse( BASE_URL + "/animal_sounds/" + animalDetailsBundle.get("soundUrl"));
            animalSoundPlayer = MediaPlayer.create(getApplicationContext(), animalSoundUri);
        }
    }

    public void playAnimalSound() {
        animalSoundPlayer.start();
        animalSoundFab.setEnabled(false);
        animalSoundPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                animalSoundFab.setEnabled(true);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.read_out_fab:
                playAnimalSound();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        animalSoundPlayer.reset();
        animalSoundPlayer.release();
        animalSoundPlayer = null;
    }
}
