package Advanced.Classes.christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if (capacity > this.data.size()) {
            this.data.add(present);
        }
    }

    public boolean remove(String name) {
        int index = -1;

        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                index = i;
                this.data.remove(index);
            }
        }
        if (index == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Present heaviestPresent() {
        int index = -1;
        double maxWeight = Double.NEGATIVE_INFINITY;

        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getWeight() > maxWeight) {
                index = i;
                maxWeight = this.data.get(i).getWeight();
            }
        }
        if (index == -1) {
            return null;
        } else {
            return this.data.get(index);
        }
    }

    public Present getPresent(String name) {
        int index = -1;

        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                index = i;
            }
        }
        if (index == -1) {
            return null;
        } else {
            return this.data.get(index);
        }
    }

    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.color)
                .append(" bag contains:")
                .append(System.lineSeparator());

        for (int i = 0; i < this.data.size(); i++) {
            stringBuilder.append(this.data.get(i))
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
