package taffy.co.za.archcomponentspracticeapp.presenters;

import java.util.List;

import taffy.co.za.archcomponentspracticeapp.data.service.AnimalRepository;
import taffy.co.za.archcomponentspracticeapp.models.Animal;

public class AnimalListPresenter implements AnimalListContract.Presenter{

    private AnimalRepository animalRepository;
    private AnimalListContract.View view;
    public AnimalListPresenter(AnimalListContract.View view) {
        animalRepository = new AnimalRepository();
        this.view = view;
    }

    @Override
    public void loadAnimals(String category) {
        view.showLoading();
        animalRepository.getAnimalsList(category, new AnimalRepository.AnimalRepositoryCallback() {
            @Override
            public void onAnimalsFetched(List<Animal> animalList) {
                view.updateAnimalList(animalList);
                view.hideLoading();
            }

            @Override
            public void onFailure(Throwable e) {

            }
        });
    }
}