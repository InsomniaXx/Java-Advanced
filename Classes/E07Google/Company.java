package Advanced.Classes.E07Google;

public class Company {
    private String companyName;
    private String department;
    private String salary;

    public Company(String companyName, String department, String salary) {
        this.companyName = companyName;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        StringBuilder strBuild = new StringBuilder();
        strBuild.append(this.companyName).append(" ");
        strBuild.append(this.department).append(" ");
        Double salaryD = Double.parseDouble(this.salary); // here
        strBuild.append(String.format("%.2f", salaryD)).append(" "); // here
        return strBuild.toString();
    }

}
