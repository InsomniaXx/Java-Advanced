package Advanced.Classes.groomingSalon;

import java.util.ArrayList;
import java.util.List;


public class GroomingSalon {
    private int capacity;
    List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void add(Pet pet) {
        if (this.data.size() < capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        boolean isRemoved = false;

        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                isRemoved = true;
                this.data.remove(i);
            }
        }

        return isRemoved;
    }

    public Pet getPet(String name, String owner) {
        Pet pet = null;
        for (Pet p : this.data) {
            if (p.getName().equals(name) && p.getOwner().equals(owner)) {
                pet = new Pet(p.getName(), p.getAge(), p.getOwner());
            }
        }
        return pet;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();

        if (this.data.size() > 0) {
            stringBuilder.append("The grooming salon has the following clients:");
            for (Pet p : this.data) {
                stringBuilder.append("\n").append(p.getName()).append(" ").append(p.getOwner());
            }
        }
        return stringBuilder.toString();
    }
}
