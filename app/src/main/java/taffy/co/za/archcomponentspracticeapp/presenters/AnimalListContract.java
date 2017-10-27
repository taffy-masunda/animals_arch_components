package taffy.co.za.archcomponentspracticeapp.presenters;

import java.util.List;

import taffy.co.za.archcomponentspracticeapp.models.Animal;

public interface AnimalListContract {

    interface Presenter {
        void loadAnimals(String category);
    }

    interface View {
        void updateAnimalList(List<Animal> animalList);
        void hideLoading();
        void showLoading();
    }
}