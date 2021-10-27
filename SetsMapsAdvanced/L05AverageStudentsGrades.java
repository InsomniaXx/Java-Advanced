package Advanced.SetsMapsAdvanced;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class L05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> students = new TreeMap<>();

        for (int i = 0; i < count; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String studentName = input[0];
            double studentGrade = Double.parseDouble(input[1]);

            if (!students.containsKey(studentName)) {
                students.put(studentName, new ArrayList<>());
            }

            students.get(studentName).add(studentGrade);
        }

        for (Map.Entry<String, List<Double>> mapStudents : students.entrySet()) {
            double averageGrade = 0;
            int countGrades = 0;
            for (double grades : mapStudents.getValue()) {
                averageGrade += grades;
                countGrades++;
            }
            averageGrade = averageGrade / countGrades;

            DecimalFormat df = new DecimalFormat("#0.00");
            String grades = "";

            for (Double grade : mapStudents.getValue()) {
                grades += df.format(grade) + " ";
            }

            System.out.printf("%s -> %s(avg: %.2f)%n", mapStudents.getKey(), grades, averageGrade);
        }
    }
}
