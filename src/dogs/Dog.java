package dogs;

import aviary.Aviary;
import food.FoodPortion;

public class Dog {
    private int id = -1;
    private boolean isHealthy;
    private boolean isHungry = true;
    private boolean isTrained;
    private Age age;
    private Aviary aviary;

    public void eat(FoodPortion food) {
        System.out.println("Dog (" + this.getAge() + ") just ate: ");
        for (FoodPortion.PortionItem portionItem : food.getPortion()) {
            System.out.println(" - " + portionItem);
        }
        isHungry = false;
    }

    //Using overloaded methods in this task was definitely not the best idea, but I can explain.
    //Daily routine of young dogs.
    public void performDailyRoutine(TrainingInstructions instruction) {
        System.out.println("Dog with id: " + this.getId() + " (" + this.getAge() + ") just received " + instruction + " instruction");
        isTrained = true;
        isHungry = true;
    }

    //Daily routine of adult dogs.
    public void performDailyRoutine(DogJobs job) {
        System.out.println("Dog with id: " + this.getId() + " (" + this.getAge() + ") is going to work in " + job);
        isHungry = true;
    }

    //Daily routine of old dogs.
    public void performDailyRoutine() {
        System.out.println("Dog with id: " + this.getId() + " (" + this.getAge() + ") is too old to do anything");
        isHungry = true;
    }

    public int getId() {
        return id;
    }

    public boolean isHealthy() {
        return isHealthy;
    }

    public Age getAge() {
        return age;
    }

    public Aviary getAviary() {
        return aviary;
    }

    public void setHealthy(boolean healthy) {
        isHealthy = healthy;
    }

    public void setAviary(Aviary aviary) {
        this.aviary = aviary;
    }

    public static class Builder {
        private Dog newDog;

        public Builder() {
            newDog = new Dog();
        }

        public Builder withId(int id) {
            newDog.id = id;
            return this;
        }

        public Builder healthy(boolean isHealthy) {
            newDog.isHealthy = isHealthy;
            return this;
        }

        public Builder hungry(boolean isHungry) {
            newDog.isHungry = isHungry;
            return this;
        }

        public Builder trained(boolean isTrained) {
            newDog.isTrained = isTrained;
            return this;
        }

        public Builder withAge(Age age) {
            newDog.age = age;
            return this;
        }

        public Dog build() {
            return newDog;
        }
    }
}
