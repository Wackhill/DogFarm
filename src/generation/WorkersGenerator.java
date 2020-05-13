package generation;

import staff.Cleaner;
import staff.Feeder;
import staff.Trainer;
import staff.Vet;

import java.util.List;

public class WorkersGenerator {
    //All this class methods could be replaced with single method, that uses reflection,
    //but it's kinda not the smartest idea. At least, in case of working speed
    //and code readability.

    public void createFeeders(int feedersToCreate, List<Feeder> feedersList) {
        for (int i = 0; i < feedersToCreate; i++) {
            feedersList.add(new Feeder(i));
        }
    }

    public void createTrainers(int trainersToCreate, List<Trainer> trainersList) {
        for (int i = 0; i < trainersToCreate; i++) {
            trainersList.add(new Trainer(i));
        }
    }

    public void createVets(int vetsToCreate, List<Vet> vetsList) {
        for (int i = 0; i < vetsToCreate; i++) {
            vetsList.add(new Vet(i));
        }
    }

    public void createCleaners(int cleanersToCreate, List<Cleaner> cleanerList) {
        for (int i = 0; i < cleanersToCreate; i++) {
            cleanerList.add(new Cleaner(i));
        }
    }
}