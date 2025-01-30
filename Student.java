public class Student {
    private String name;
    private int age;
    private String rollNumber;
    private double gpa;

    public Student(String name, int age, String rollNumber, double gpa) {
        this.name = name;
        this.age = age;
        this.rollNumber = rollNumber;
        this.gpa = gpa;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}
