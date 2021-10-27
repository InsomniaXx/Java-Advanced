package Advanced.Classes.university;
public class Main {
    public static void main(String[] args) {
        // Initialize the repository
        University university = new University(10);
// Initialize entities
        Student student = new Student("John", "Smith", "Astrology");
        Student studentTwo = new Student("Anna", "Cameron", "Geometry");
        Student studentThree = new Student("Samy", "Johnson", "Algebra");
        Student studentFour = new Student("Rihanna", "Fenty", "Music");
        Student studentFive = new Student("Ellie", "Goulding", "Music");
// Print OOP.Abstraction.L03StudentSystem.Student
        System.out.println(student);
        // OOP.Abstraction.L03StudentSystem.Student: John Smith, Astrology
// Register OOP.Abstraction.L03StudentSystem.Student
        String register = university.registerStudent(student);
        System.out.println(university.getCapacity()); // 10
        System.out.println(register); // Added student John Smith
        String registerTwo = university.registerStudent(studentTwo);
        String registerThree = university.registerStudent(studentThree);
        String registerFour = university.registerStudent(studentFour);
// Dismiss OOP.Abstraction.L03StudentSystem.Student
        String dismissed = university.dismissStudent(student);
        System.out.println(dismissed); // Removed student John Smith
        String dismissedTwo = university.dismissStudent(studentFive);
        System.out.println(dismissedTwo); // OOP.Abstraction.L03StudentSystem.Student not found
// Get OOP.Abstraction.L03StudentSystem.Student
        System.out.println(university.getStudent("Rihanna", "Fenty"));
// OOP.Abstraction.L03StudentSystem.Student: Rihanna Fenty, Music
        System.out.println(university.getStudentCount()); // 3
        System.out.println(university.getStatistics());
//==OOP.Abstraction.L03StudentSystem.Student: First Name = Anna, Last Name = Cameron, Best Subject = Geometry
        //==OOP.Abstraction.L03StudentSystem.Student: First Name = Samy, Last Name = Johnson, Best Subject = Algebra
        //==OOP.Abstraction.L03StudentSystem.Student: First Name = Rihanna, Last Name = Fenty, Best Subject = Music

    }
}
