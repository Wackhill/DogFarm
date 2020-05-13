package aviary;

import dogs.Dog;

public class Aviary {
    private int id;
    private boolean isDirty;
    private Dog dog;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDirty(boolean dirty) {
        isDirty = dirty;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public static class Builder {
        private Aviary newAviary;

        public Builder() {
            newAviary = new Aviary();
        }

        public Builder withId(int id) {
            newAviary.id = id;
            return this;
        }

        public Builder dirty(boolean isDirty) {
            newAviary.isDirty = isDirty;
            return this;
        }

        public Builder withDog(Dog dog) {
            newAviary.dog = dog;
            return this;
        }

        public Aviary build() {
            return newAviary;
        }
    }
}
