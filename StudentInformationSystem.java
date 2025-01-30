import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentInformationSystem {
    private final ArrayList<Student> students;  // `final` for the students field

    public StudentInformationSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Scanner scanner) {
        try {
            System.out.print("Enter student name: ");
            final String name = scanner.nextLine();  // `final` for the name field

            System.out.print("Enter student age: ");
            final int age = scanner.nextInt();  // `final` for the age field
            scanner.nextLine(); // Consume newline left-over

            System.out.print("Enter student roll number: ");
            final String rollNumber = scanner.nextLine();  // `final` for the roll number field

            System.out.print("Enter student GPA: ");
            final double gpa = scanner.nextDouble();  // `final` for the GPA field
            scanner.nextLine(); // Consume newline left-over

            Student student = new Student(name, age, rollNumber, gpa);
            students.add(student);

            System.out.println("Student added successfully!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter correct data types.");
            scanner.nextLine(); // Consume invalid input
        }
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
        } else {
            for (Student student : students) {
                System.out.println("Name: " + student.getName());
                System.out.println("Age: " + student.getAge());
                System.out.println("Roll Number: " + student.getRollNumber());
                System.out.println("GPA: " + student.getGpa());
                System.out.println();
            }
        }
    }

    public void searchStudent(Scanner scanner) {
        System.out.print("Enter student roll number to search: ");
        String rollNumber = scanner.nextLine();

        for (Student student : students) {
            if (student.getRollNumber().equals(rollNumber)) {
                System.out.println("Name: " + student.getName());
                System.out.println("Age: " + student.getAge());
                System.out.println("Roll Number: " + student.getRollNumber());
                System.out.println("GPA: " + student.getGpa());
                return;
            }
        }

        System.out.println("Student not found!");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);  // Use a single scanner instance

        while (true) {
            System.out.println("Student Information System");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1 -> addStudent(scanner);  // Pass the scanner instance
                case 2 -> displayStudents();
                case 3 -> searchStudent(scanner);  // Pass the scanner instance
                case 4 -> {
                    System.out.println("Exiting...");
                    scanner.close();  // Close the scanner when done
                    return;
                }
                default -> System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    public static void main(String[] args) {
        StudentInformationSystem system = new StudentInformationSystem();
        system.run();
    }

    // Student class nested inside the same file
    class Student {
        private final String name;  // `final` for fields that won't change
        private final int age;      // `final` for fields that won't change
        private final String rollNumber;  // `final` for fields that won't change
        private final double gpa;    // `final` for fields that won't change

        public Student(String name, int age, String rollNumber, double gpa) {
            this.name = name;
            this.age = age;
            this.rollNumber = rollNumber;
            this.gpa = gpa;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getRollNumber() {
            return rollNumber;
        }

        public double getGpa() {
            return gpa;
        }
    }
}

