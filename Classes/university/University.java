package Advanced.Classes.university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        String out = null;
        if (this.capacity < this.students.size()) {
            out = "No seats in the Advanced.Classes.university";

        } else {
            if (this.students.size() > 0) {
                for (int s = 0; s < this.students.size(); s++) {
                    if (students.get(s).getFirstName().equals(student.getFirstName()) &&
                            students.get(s).getLastName().equals(student.getLastName())) {
                        out = "OOP.Abstraction.L03StudentSystem.Student is already in the Advanced.Classes.university";
                        break;
                    }
                }
                this.students.add(student);
                out = "Added student " + student.getFirstName() + " " + student.getLastName();
            } else {
                this.students.add(student);
                out = "Added student " + student.getFirstName() + " " + student.getLastName();
            }

        }
        return out;
    }

    public String dismissStudent(Student student) {
        String out = "";
        if (this.students.size() > 0) {
            for (int s = 0; s < this.students.size(); s++) {
                if (students.get(s).getFirstName().equals(student.getFirstName()) &&
                        students.get(s).getLastName().equals(student.getLastName())) {
                    this.students.remove(student);
                    out = "Removed student " + student.getFirstName() + " " + student.getLastName();
                    break;
                } else {
                    out = "OOP.Abstraction.L03StudentSystem.Student not found";
                }
            }
        } else {
            out = "OOP.Abstraction.L03StudentSystem.Student not found";
        }

        return out;
    }

    public Student getStudent(String firstName, String lastName) {
        Student student = null;

        for (int s = 0; s < this.students.size(); s++) {
            if (this.students.get(s).getFirstName().equals(firstName) &&
                    this.students.get(s).getLastName().equals(lastName)) {
                student = new Student(this.students.get(s).getFirstName(),
                        this.students.get(s).getLastName(),
                        this.students.get(s).getBestSubject());
                break;
            }
        }
        return student;
    }
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < this.students.size(); i++) {
            stringBuilder.append(String.format("==OOP.Abstraction.L03StudentSystem.Student: First Name = %s, Last Name = %s, Best Subject = %s",
                    students.get(i).getFirstName(), students.get(i).getLastName(), students.get(i).getBestSubject()));
            stringBuilder.append("\n");

//            if (i + 1 < this.students.size()) {
//                stringBuilder.append("\n");
//            }
        }
        return stringBuilder.toString();
    }
}
