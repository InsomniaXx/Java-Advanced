package Advanced.Classes.E02CompanyRoster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfEmployees = Integer.parseInt(scanner.nextLine());
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < numberOfEmployees; i++) {
            String[] employeeData = scanner.nextLine().split("\\s+");

            Employee employee = null;
            String name = employeeData[0];
            double salary = Double.parseDouble(employeeData[1]);
            String position = employeeData[2];
            String department = employeeData[3];

            if (employeeData.length == 6) {
                String email = employeeData[4];
                int age = Integer.parseInt(employeeData[5]);

                employee = new Employee(name, salary, position, department, email, age);

            } else if (employeeData.length == 5) {
                String optional = employeeData[4];
                boolean isDigitOnly = isDigit(optional);

                if (isDigitOnly) {
                    int age = Integer.parseInt(optional);
                    employee = new Employee(name, salary, position, department, age);

                } else {
                    String mail = optional;
                    employee = new Employee(name, salary, position, department, mail);

                }
//                try {
//                    int age = Integer.parseInt(employeeData[4]);
//                    employee = new Employee(name, salary, position, department, age);
//                } catch (NumberFormatException e) {
//                    String mail = employeeData[4];
//                    employee = new Employee(name, salary, position, department, mail);
//                }
            } else if (employeeData.length == 4) {
                employee = new Employee(name, salary, position, department);
            }
            employees.add(employee);

        }
        System.out.println();
        String highestDepartment = getHighestDepartment(employees);

        System.out.println("Highest Average Salary: " + highestDepartment);
        employees
                .stream()
                .filter(e -> e.getDepartment().equals(highestDepartment))
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .forEach(System.out::println);

    }

    private static String getHighestDepartment(List<Employee> employees) {
        double maxSalary = Double.NEGATIVE_INFINITY;
        String department = null;

        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                department = employee.getDepartment();
            }
        }
        return department;
    }

    private static boolean isDigit(String optional) {
        boolean isDigit = true;
        for (int j = 0; j < optional.length(); j++) {
            if (!Character.isDigit(optional.charAt(j))) {
                isDigit = false;
            }
        }
        return isDigit;
    }
}
