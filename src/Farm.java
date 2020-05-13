import aviary.Aviary;
import dogs.Dog;
import staff.Cleaner;
import staff.Feeder;
import staff.Trainer;
import staff.Vet;

import java.util.List;

public interface Farm {
    void createFarmItems(List<Dog> dogs, List<Aviary> aviaries, List<Feeder> feeders, List<Cleaner> cleaners, List<Trainer> trainers, List<Vet> vets);
    void feedDogs(List<Feeder> feeders, List<Dog> dogs);
    void checkDogsHealth(List<Vet> vets, List<Dog> dogs);
    void aviariesCleaning(List<Cleaner> cleaners, List<Aviary> aviaries);
    void dogsDailyRoutine(List<Trainer> trainers, List<Dog> dogs);
}
