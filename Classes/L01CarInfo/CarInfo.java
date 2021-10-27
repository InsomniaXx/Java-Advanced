package Advanced.Classes.L01CarInfo;

public class CarInfo {
    private String brand;
    private String model;
    private int horsePower;

    public CarInfo(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public CarInfo(String carBrand, String carModel) {
    }

    public String getCarBrand() {
        return brand;
    }
    public String getCarModel() {
        return model;
    }
    public int getCarHorsePower() {
        return horsePower;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String toString() {
        return String.format("The car is: %s %s - %d HP.",
                this.getCarBrand(), this.getCarModel(), this.getCarHorsePower());
    }
}
