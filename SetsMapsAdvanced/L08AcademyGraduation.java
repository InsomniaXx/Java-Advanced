package Advanced.SetsMapsAdvanced;

import java.text.DecimalFormat;
import java.util.*;

public class L08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> students = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String studentName = scanner.nextLine();
            String[] studentGrades = scanner.nextLine().split(" ");

            students.putIfAbsent(studentName, new ArrayList<>());
            List<Double> grades = students.get(studentName);

            for (String currentGrade : studentGrades) {
                grades.add(Double.parseDouble(currentGrade));
            }
        }

        for (Map.Entry<String, List<Double>> student : students.entrySet()) {
            double countGrades = 0;
            int count = 0;
            double averageGrade = 0;

            for (double grade : student.getValue()) {
                countGrades += grade;
                count++;
            }

            averageGrade = countGrades / count;
            DecimalFormat df = new DecimalFormat("#.##############################");

            System.out.printf("%s is graduated with %s%n", student.getKey(), df.format(averageGrade));
        }
        System.out.println();

    }
}
