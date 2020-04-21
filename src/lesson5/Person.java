package lesson5;

public class Person {
    private String fullName;
    private String position;
    public String email;
    public String phoneNumber;
    public int salary;
    public int age;

    public Person(String fullName, String position, String email, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void info() {
        System.out.printf("Сотрудник - %s%nДолжность - %s%nEmail - %s%nТелоефон - %s%nВозраст - %d%n", fullName, position, email, phoneNumber, age);
        System.out.println();
    }
}
