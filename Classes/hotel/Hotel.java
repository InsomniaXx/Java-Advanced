package Advanced.Classes.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }
    public void add(Person person) {
        if (this.capacity > this.roster.size()) {
            this.roster.add(person);
        }
    }
    public boolean remove(String name) {
        int index = -1;
        for (int i = 0; i < this.roster.size(); i++) {
            if (this.roster.get(i).getName().equals(name)) {
                index = i;
                this.roster.remove(index);
            }
        }
        if (index == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Person getPerson(String name, String hometown) {
        int index = -1;
        for (int i = 0; i < this.roster.size(); i++) {
            if (this.roster.get(i).getName().equals(name) && this.roster.get(i).getHometown().equals(hometown)) {
                index = i;
            }
        }
        if (index == -1) {
            return null;
        } else {
            return this.roster.get(index);
        }
    }
    public int getCount() {
        return this.roster.size();
    }
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("The people in the hotel %s are:", this.name))
                .append(System.lineSeparator());

        for (int i = 0; i < this.roster.size(); i++) {
            stringBuilder.append(this.roster.get(i))
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
