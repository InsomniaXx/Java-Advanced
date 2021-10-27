package Advanced.Classes.E07Google;

public class Pokemon {
    private String name;
    private String type;

    public Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        StringBuilder strBuild = new StringBuilder();
        strBuild.append(this.name).append(" ");
        strBuild.append(this.type).append(" ");
        return strBuild.toString();
    }
}
