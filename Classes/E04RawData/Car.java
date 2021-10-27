package Advanced.Classes.E04RawData;

public class Car {
    private String model;

    private Cargo cargo = new Cargo();
    private Engine engine = new Engine();
    private Tire tire = new Tire();

    public Car(String model, int engineSpeed, int enginePower, int cargoWeight,
               String cargoType, double tirePressure_1, int tireAge_1,
               double tirePressure_2, int tireAge_2,
               double tirePressure_3, int tireAge_3,
               double tirePressure_4, int tireAge_4) {
        this.model = model;
        engine.setEngineSpeed(engineSpeed);
        engine.setEnginePower(enginePower);
        cargo.setCargoWeight(cargoWeight);
        cargo.setCargoType(cargoType);
        tire.setTirePressure_1(tirePressure_1);
        tire.setTireAge_1(tireAge_1);
        tire.setTirePressure_2(tirePressure_2);
        tire.setTireAge_2(tireAge_2);
        tire.setTirePressure_3(tirePressure_3);
        tire.setTireAge_3(tireAge_3);
        tire.setTirePressure_4(tirePressure_4);
        tire.setTireAge_4(tireAge_4);
    }

    public String getModel() {
        return model;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Engine getEngine() {

        return engine;
    }

    public Tire getTire() {

        return tire;
    }

    public void setModel(String model) {

        this.model = model;
    }

    public String toString() {

        return String.format("%s", model);
    }

    public boolean underTirePressure() {
        if (tire.getTirePressure_1() < 1 ||
                tire.getTirePressure_2() < 1 ||
                tire.getTirePressure_3() < 1 ||
                tire.getTirePressure_4() < 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean highEnginePower() {
        if (engine.getEnginePower() > 250) {
            return true;
        } else {
            return false;
        }
    }
}
