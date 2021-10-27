package Advanced.Classes.E03SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCost;
    private double distance;


    public Car(String model, double fuelAmount, double fuelCost) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
    }

    public Car(String model, int distance) {
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public String getModel() {
        return model;
    }

    public double getFuelCost() {
        return fuelCost;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setFuelCost(double fuelCost) {
        this.fuelCost = fuelCost;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String toString() {
        return String.format("%s %.2f %.0f", this.model, this.fuelAmount, this.distance);
    }
    public boolean drive(double kmToDrive) {
        double fuelRequired = kmToDrive * fuelCost;

        if (fuelRequired > this.fuelAmount) {
            return false;
        } else {
            this.fuelAmount -= fuelRequired;
            this.distance += kmToDrive;
            return true;
        }
    }
}
