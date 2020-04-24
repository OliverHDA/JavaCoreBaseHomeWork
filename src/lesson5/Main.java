package lesson5;

public class Main {

    public static void main(String[] args) {
        Person[] employees = new Person[5];
        employees[0] = new Person("Andreev Andrei", "Company director", "anandrei@mailbox.com", "8(495)000-00-01", 400000, 48);
        employees[1] = new Person("Borisov Boris", "Engineer", "boboris@mailbox.com", "8(495)000-00-02", 100000, 52);
        employees[2] = new Person("Konstantinov Konstantin", "QA Engineer", "kokonstantin@mailbox.com", "8(495)000-00-03", 100000, 25);
        employees[3] = new Person("Sergeev Sergei", "Team leader", "sesergei@mailbox.com", "8(495)000-00-04", 200000, 42);
        employees[4] = new Person("Ivanov Ivan", "Java Developer", "ivivan@mailbox.com", "8(495)000-00-05", 120000, 32);

        for (Person employee : employees) {
            if (employee.age > 40) {
                employee.info();
            }
        }
    }
}
