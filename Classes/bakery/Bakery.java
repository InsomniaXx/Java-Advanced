package Advanced.Classes.bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    public List<Employee> employees;
    public String name;
    public int capacity;
    private static int count = 0;


    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (capacity > employees.size()) {
            employees.add(employee);
            count++;
        }
    }

    public boolean remove(String name) {
        int index = -1;
        for (int i = 0; i < this.employees.size(); i++) {
            if (this.employees.get(i).getName().equals(name)) {
                index = i;
            }
        }
        if (index == - 1) {
            return false;
        } else {
            this.employees.remove(index);
            return true;
        }
    }

    public Employee getOldestEmployee() {
        int age = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < this.employees.size(); i++) {
            if (this.employees.get(i).getAge() >= age) {
                index = i;
                age = this.employees.get(i).getAge();
            }
        }
        return this.employees.get(index);
    }

    public Employee getEmployee(String name) {
        int index = 0;
        for (int i = 0; i < this.employees.size(); i++) {
            if (this.employees.get(i).getName().equals(name)) {
                index = i;
            }
        }
        return this.employees.get(index);
    }

    public int getCount() {
        return count;
    }

    public String report() {
        StringBuilder strBuild = new StringBuilder();
        strBuild.append(String.format("Employees working at Bakery %s:", this.name))
                .append(System.lineSeparator());
        for (int i = 0; i < this.employees.size(); i++) {
            strBuild.append(this.employees.get(i).toString());
            strBuild.append(System.lineSeparator());
        }
        return strBuild.toString().trim();
    }
}
