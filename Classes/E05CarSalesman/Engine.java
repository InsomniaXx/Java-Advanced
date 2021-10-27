package Advanced.Classes.E05CarSalesman;

public class Engine {
    private String model;
    private int power;
    private int displacement = 0;
    private String efficiency = "n/a";

    public Engine(String model, int power, int displacement, String efficiency) {
        this(model, power);
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
    }

    public Engine(String model, int power, int displacement) {
        this(model, power);
        this.displacement = displacement;
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power);
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        String printDisplacement;
        if (displacement == 0) {
            printDisplacement = "n/a";
        } else {
            printDisplacement = displacement + "";
        }

        stringBuilder.append(model).append(":").append("\n")
                .append("Power: ").append(power).append("\n")
                .append("Displacement: ").append(printDisplacement).append("\n")
                .append("Efficiency: ").append(efficiency);

        return stringBuilder.toString();
    }
}
