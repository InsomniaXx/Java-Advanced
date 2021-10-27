package Advanced.Classes.E05CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight = 0;
    private String color = "n/a";

    public Car(String model, Engine engine, int weight, String color) {
        this(model, engine);
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String printWeight;

        if (weight == 0) {
            printWeight = "n/a";
        } else {
            printWeight = weight + "";
        }

        stringBuilder.append(model).append(":").append("\n")
                .append(engine.toString()).append("\n")
                .append("Weight: ").append(printWeight).append("\n")
                .append("Color: ").append(color);

        return stringBuilder.toString();
    }
}
