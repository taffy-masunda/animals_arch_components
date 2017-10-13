package taffy.co.za.archcomponentspracticeapp.data.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface AnimalDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void bulkInsertAnimals(Animal... animals);

    @Query("SELECT * FROM animals")
    List<Animal> getAllAimals();

    @Query("SELECT * FROM animals WHERE id = :id")
    Animal getAnimal(String id);
}
