package staff;

import aviary.Aviary;

public abstract class AviaryWorker {
    private int id;

    public AviaryWorker(int workerId) {
        this.id = workerId;
    }

    public abstract void doJob(Aviary aviary);

    public int getId() {
        return id;
    }
}
