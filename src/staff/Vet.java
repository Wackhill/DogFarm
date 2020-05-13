package staff;

import dogs.Dog;

public class Vet extends DogWorker {
    public Vet(int workerId) {
        super(workerId);
    }

    @Override
    public void doJob(Dog dog) {
        if (!dog.isHealthy()) {
            System.out.println("Vet with id: " + this.getId() + " checks dog with id: " + dog.getId());
            System.out.println("Dog is not healthy.");
            System.out.println("Dog with is being treated.");
            dog.setHealthy(true);
            System.out.println("Dog with is now healthy.");
        }
        else {
            System.out.println("Dog with id: " + dog.getId() + " is healthy");
        }
    }
}
