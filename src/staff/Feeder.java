package staff;

import dogs.Dog;
import food.FoodPortion;

public class Feeder extends DogWorker {

    public Feeder(int workerId) {
        super(workerId);
    }

    @Override
    public void doJob(Dog dog) {
        System.out.println("Feeded with id: " + this.getId() + " is feeding the dog with id: " + dog.getId());
        FoodPortion foodPortion = new FoodPortion(dog.getAge());
        dog.eat(foodPortion);
    }
}
