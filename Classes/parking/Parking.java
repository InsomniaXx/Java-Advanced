package Advanced.Classes.parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (capacity > this.data.size()) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        int index = -1;

        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getManufacturer().equals(manufacturer) &&
                    this.data.get(i).getModel().equals(model)) {
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

    public Car getLatestCar() {
        int index = -1;
        int latestYear = Integer.MIN_VALUE;

        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getYear() >= latestYear) {
                latestYear = this.data.get(i).getYear();
                index = i;
            }
        }

        if (index == -1) {
            return null;
        } else {
            return this.data.get(index);
        }
    }

    public Car getCar(String manufacturer, String model) {
        int index = -1;

        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getManufacturer().equals(manufacturer) &&
                    this.data.get(i).getModel().equals(model)) {
                index = i;
            }
        }
        if (index == -1) {
           return null;
        } else {
            return this.data.get(index);
        }
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("The cars are parked in %s:", this.type)).append(System.lineSeparator());

        for (int i = 0; i < this.data.size(); i++) {
            stringBuilder.append(this.data.get(i)).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
