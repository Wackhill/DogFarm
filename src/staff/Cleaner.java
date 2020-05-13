package staff;

import aviary.Aviary;

public class Cleaner extends AviaryWorker {

    public Cleaner(int workerId) {
        super(workerId);
    }

    @Override
    public void doJob(Aviary aviary) {
        System.out.println("Cleaner with id: " + this.getId() + " is cleaning aviary with id: " + aviary.getId());
    }
}
