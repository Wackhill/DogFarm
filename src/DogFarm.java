public class DogFarm {
    private static final int DOGS_TO_CREATE = 20;
    private static final int AVIARIES_TO_CREATE = 30;
    private static final int FEEDERS_TO_CREATE = 1;
    private static final int CLEANERS_TO_CREATE = 3;
    private static final int TRAINERS_TO_CREATE = 2;
    private static final int VETS_TO_CREATE = 3;

    public static void main(String[] args) {
        FarmEmulator farmEmulator = new FarmEmulator(DOGS_TO_CREATE, AVIARIES_TO_CREATE, FEEDERS_TO_CREATE, CLEANERS_TO_CREATE, TRAINERS_TO_CREATE, VETS_TO_CREATE);
        farmEmulator.emulate();
    }
}
