package Advanced.Classes.rabbits;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit) {
        if (capacity > this.data.size()) {
            data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name) {
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

    public void removeSpecies(String species) {
        int index = -1;
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getSpecies().equals(species)) {
                index = i;
                this.data.remove(index);
            }
        }
    }
    public Rabbit sellRabbit(String name) {
        int index = -1;
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                index = i;
                this.data.get(i).setAvailable(false);
            }
        }
        return this.data.get(index);
    }
    public List<Rabbit> sellRabbitBySpecies(String species) {
        int index = -1;
        List<Rabbit> soldRabbits = new ArrayList<>();

        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getSpecies().equals(species)) {
                index = i;
                soldRabbits.add(this.data.get(index));
            }
        }
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getSpecies().equals(species)) {
                index = i;
                this.data.remove(index);
                i --;
            }
        }
        return soldRabbits;
    }
    public int count() {
        return this.data.size();
    }
    public String report() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("Rabbits available at %s:", this.name))
                .append(System.lineSeparator());

        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).isAvailable()) {
                stringBuilder.append(this.data.get(i))
                        .append(System.lineSeparator());
            }
        }
        return stringBuilder.toString().trim();
    }


}
