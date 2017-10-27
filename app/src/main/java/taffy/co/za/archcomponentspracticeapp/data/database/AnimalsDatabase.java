package taffy.co.za.archcomponentspracticeapp.data.database;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;

public abstract class AnimalsDatabase extends RoomDatabase {
    private static final String LOG_TAG = AnimalsDatabase.class.getSimpleName();
    private static final String DATABASE_NAME = "animals_db";

    // For Singleton instantiation
    private static final Object LOCK = new Object();
    private static AnimalsDatabase sInstance;

    public static AnimalsDatabase getInstance(Context context) {
        Log.d(LOG_TAG, "Getting the database instance");
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        AnimalsDatabase.class, AnimalsDatabase.DATABASE_NAME).build();
                Log.d(LOG_TAG, "Made new database");
            }
        }
        return sInstance;
    }

    public abstract AnimalsDAO animalsDao();
}
