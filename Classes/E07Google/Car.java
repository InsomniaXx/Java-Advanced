package Advanced.Classes.E07Google;

public class Car {
    private String model;
    private String speed;

    public Car(String model, String speed) {
        this.model = model;
        this.speed = speed;
    }

    @Override
    public String toString() {
        StringBuilder strBuild = new StringBuilder();
        strBuild.append(this.model).append(" ");
        strBuild.append(this.speed).append(" ");
        return strBuild.toString();
    }
}
