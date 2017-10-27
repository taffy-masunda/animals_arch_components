package taffy.co.za.archcomponentspracticeapp.data.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AnimalAPIClient {
    public static final String BASE_URL = "http://api.spectradigital.co.za/animals_app/";
    public static Retrofit retrofit = null;

    public static Retrofit getAPIClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
