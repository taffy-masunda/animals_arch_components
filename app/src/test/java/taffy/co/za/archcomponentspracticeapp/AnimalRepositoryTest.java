package taffy.co.za.archcomponentspracticeapp;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import taffy.co.za.archcomponentspracticeapp.models.Animal;
import taffy.co.za.archcomponentspracticeapp.repositories.AnimalsRepository;


public class AnimalRepositoryTest {
    @Test
    public void checkList(){
        AnimalsRepository animalsRepo = new AnimalsRepository();
        ArrayList<Animal> animalsList = animalsRepo.getAnimalsPerCategory("farm");

        Assert.assertNotNull(animalsList.size());
    }
}
