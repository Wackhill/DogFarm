package generation;

import dogs.Age;
import dogs.Dog;

import java.util.List;
import java.util.Random;

public class DogsGenerator {
    public void createDogs(int number, List<Dog> dogs) {
        for (int i = 0; i < number; i++) {
            int dogAge = new Random().nextInt(11);
            Dog newDog = new Dog.Builder()
                    .withId(i)
                    .healthy(new Random().nextBoolean())
                    .hungry(new Random().nextBoolean())
                    .trained(new Random().nextBoolean())
                    .withAge(intAgeToEnum(dogAge))
                    .build();
            dogs.add(newDog);
        }
    }

    private Age intAgeToEnum(int dogAge) {
        if (dogAge <= 3) {
            return Age.YOUNG;
        }
        else if(dogAge <= 8) {
            return Age.ADULT;
        }
        else {
            return Age.OLD;
        }
    }
}
