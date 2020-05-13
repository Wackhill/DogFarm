import aviary.Aviary;
import dogs.Dog;
import dogs.DogJobs;
import generation.DogsGenerator;
import generation.WorkersGenerator;
import staff.Cleaner;
import staff.Feeder;
import staff.Trainer;
import staff.Vet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FarmEmulator implements Farm {
    private int dogsNumber;
    private int aviariesNumber;
    private int feedersNumber;
    private int cleanersNumber;
    private int trainersNumber;
    private int vetsNumber;

    private List<Dog> dogs = new ArrayList<>();
    private List<Aviary> aviaries = new ArrayList<>();
    private List<Feeder> feeders = new ArrayList<>();
    private List<Cleaner> cleaners = new ArrayList<>();
    private List<Trainer> trainers = new ArrayList<>();
    private List<Vet> vets = new ArrayList<>();

    public FarmEmulator(int dogsNumber, int aviariesNumber, int feedersNumber, int cleanersNumber, int trainersNumber, int vetsNumber) {
        this.dogsNumber = dogsNumber;
        this.aviariesNumber = aviariesNumber;
        this.feedersNumber = feedersNumber;
        this.cleanersNumber = cleanersNumber;
        this.trainersNumber = trainersNumber;
        this.vetsNumber = vetsNumber;
    }

    public void emulate() {
        if (aviariesNumber >= dogsNumber) {
            createFarmItems(dogs, aviaries, feeders, cleaners, trainers, vets);

            System.out.println("========== MORNING FEEDING ==========");
            feedDogs(feeders, dogs);

            System.out.println("========== CHECKING DOGS HEALTH CONDITIONS ==========");
            checkDogsHealth(vets, dogs);

            System.out.println("========== CLEANING AVIARIES ==========");
            aviariesCleaning(cleaners, aviaries);

            System.out.println("\n========== DOGS DAILY ROUTINE ==========");
            dogsDailyRoutine(trainers, dogs);

            System.out.println("========== EVENING FEEDING ==========");
            feedDogs(feeders, dogs);
        }
        else {
            throw new RuntimeException("Impossible to place " + dogsNumber + " dogs in " + aviariesNumber + " aviaries");
        }
    }

    @Override
    public void createFarmItems(List<Dog> dogs, List<Aviary> aviaries, List<Feeder> feeders, List<Cleaner> cleaners, List<Trainer> trainers, List<Vet> vets) {
        DogsGenerator dogsGenerator = new DogsGenerator();
        dogsGenerator.createDogs(dogsNumber, dogs);
        WorkersGenerator workersGenerator = new WorkersGenerator();
        workersGenerator.createFeeders(feedersNumber, feeders);
        workersGenerator.createCleaners(cleanersNumber, cleaners);
        workersGenerator.createTrainers(trainersNumber, trainers);
        workersGenerator.createVets(vetsNumber, vets);

        for (int i = 0; i < dogsNumber; i++) {
            Aviary newAviary = new Aviary.Builder()
                    .withId(i)
                    .dirty(false)
                    .withDog(dogs.get(i))
                    .build();
            aviaries.add(newAviary);
            dogs.get(i).setAviary(newAviary);
        }
    }

    @Override
    public void feedDogs(List<Feeder> feeders, List<Dog> dogs) {
        int currentDogNumber = 0;
        while (currentDogNumber < dogs.size()) {
            feeders.get(currentDogNumber % feeders.size()).doJob(dogs.get(currentDogNumber));
            currentDogNumber++;
            System.out.println();
        }
    }

    @Override
    public void checkDogsHealth(List<Vet> vets, List<Dog> dogs) {
        int currentDogNumber = 0;
        while (currentDogNumber < dogs.size()) {
            vets.get(currentDogNumber % vets.size()).doJob(dogs.get(currentDogNumber));
            currentDogNumber++;
            System.out.println();
        }
    }

    @Override
    public void aviariesCleaning(List<Cleaner> cleaners, List<Aviary> aviaries) {
        int currentAviaryNumber = 0;
        while (currentAviaryNumber < aviaries.size()) {
            cleaners.get(currentAviaryNumber % cleaners.size()).doJob(aviaries.get(currentAviaryNumber));
            currentAviaryNumber++;
        }
    }

    @Override
    public void dogsDailyRoutine(List<Trainer> trainers, List<Dog> dogs) {
        int trainingDogs = 0;
        DogJobs[] allJobs = DogJobs.values();

        for (Dog dog : dogs) {
            switch (dog.getAge()) {
                case YOUNG:
                    trainers.get(trainingDogs % trainers.size()).doJob(dog);
                    trainingDogs++;
                    break;
                case ADULT:
                    dog.performDailyRoutine(allJobs[new Random().nextInt(allJobs.length)]);
                    break;
                case OLD:
                    dog.performDailyRoutine();
                    break;
            }
            dog.getAviary().setDirty(true);
            System.out.println();
        }
    }
}
