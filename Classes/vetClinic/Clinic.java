package Advanced.Classes.vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.capacity > this.data.size()) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        int index = -1;

        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                index = i;
            }
        }

        if (index == -1) {
            return false;
        } else {
            this.data.remove(index);
            return true;
        }
    }

    public Pet getPet(String name, String owner)  {
        int index = -1;

        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name) && data.get(i).getOwner().equals(owner)) {
                index = i;
            }
        }
        if (index == -1) {
            return null;
        } else {
            return this.data.get(index);
        }
    }

    public Pet getOldestPet() {
        int index = -1;
        int maxAge = Integer.MIN_VALUE;

        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getAge() >= maxAge) {
                maxAge = this.data.get(i).getAge();
                index = i;
            }
        }
        return this.data.get(index);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The clinic has the following patients:")
        .append(System.lineSeparator());

        for (int i = 0; i < this.data.size(); i++) {
            stringBuilder
                    .append(this.data.get(i).getName())
                    .append(" ")
                    .append(this.data.get(i).getOwner())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
