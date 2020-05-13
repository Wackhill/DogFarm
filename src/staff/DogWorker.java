package staff;

import dogs.Dog;

public abstract class DogWorker {
    private int id;

    public DogWorker(int workerId) {
        this.id = workerId;
    }

    public abstract void doJob(Dog dog);

    public int getId() {
        return id;
    }
}
