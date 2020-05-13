package food;

import dogs.Age;

import java.util.ArrayList;
import java.util.List;

public class FoodPortion {
    private List<PortionItem> portion = new ArrayList<>();

    public FoodPortion(Age dogAge) {
        makePortion(dogAge);
    }

    private void makePortion(Age dogAge) {
        switch (dogAge) {
            case YOUNG:
                portion.add(new PortionItem(100, Foods.MEAT));
                portion.add(new PortionItem(100, Foods.BREAD));
                portion.add(new PortionItem(150, Foods.WATER));
                break;
            case ADULT:
                portion.add(new PortionItem(250, Foods.MEAT));
                portion.add(new PortionItem(150, Foods.BREAD));
                portion.add(new PortionItem(200, Foods.WATER));
                break;
            case OLD:
                portion.add(new PortionItem(100, Foods.MEAT));
                portion.add(new PortionItem(150, Foods.BREAD));
                portion.add(new PortionItem(200, Foods.WATER));
                break;
            default:
                throw new RuntimeException("\"" + dogAge + "\" dogs are not supported");
        }
    }

    public List<PortionItem> getPortion() {
        return portion;
    }

    public class PortionItem {
        private int weight;
        private Foods food;

        private PortionItem(int weight, Foods food) {
            this.weight = weight;
            this.food = food;
        }

        @Override
        public String toString() {
            return weight + " grams of " + food;
        }
    }
}
