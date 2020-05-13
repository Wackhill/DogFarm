package staff;

import dogs.Dog;
import dogs.TrainingInstructions;

import java.util.Random;

public class Trainer extends DogWorker {
    public Trainer(int workerId) {
        super(workerId);
    }

    @Override
    public void doJob(Dog dog) {
        TrainingInstructions currentInstruction = getRandomInstruction();
        System.out.println("Trainer with id: " + this.getId() + " is sending " + currentInstruction + " instruction to the dog with id: " + dog.getId());
        dog.performDailyRoutine(currentInstruction);
    }

    private TrainingInstructions getRandomInstruction() {
        TrainingInstructions[] allInstructions = TrainingInstructions.values();
        return allInstructions[new Random().nextInt(allInstructions.length)];
    }
}
