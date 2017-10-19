package taffy.co.za.archcomponentspracticeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread pauseSplashScreen = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(2500);
                    openCategoryActivity();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        pauseSplashScreen.start();
    }

    private void openCategoryActivity() {
        Intent openCategoryIntent = new Intent(this, CategoryActivity.class);
        startActivity(openCategoryIntent);
        finish();
    }
}