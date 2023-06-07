package lessons.src.ru.geekbrains.lesson3;

public abstract class Employee implements Comparable<Employee> {

    protected String name;
    protected String surname;
    /**
     * salary in UE per hour
     */
    protected double baseSalary; // UE/hour
    protected double salary;
    protected int age;
    protected int experience;

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public double getBaseSalary() {
        return baseSalary;
    }
    public int getAge() {
        return age;
    }
    public int getExperience() {
        return experience;
    }
    public Employee(String name, String surname, int age, int experience, double baseSalary) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.experience = experience;
        this.baseSalary = baseSalary;
    }

    /**
     * Расчет среднемесячной заработной платы
     * @return
     */
    public abstract double calculateSalary();

    @Override
    public int compareTo(Employee o) {
        int res = surname.compareTo(o.surname);
        if (res == 0)
            return Double.compare(calculateSalary(), o.calculateSalary());
        else
            return res;
    }
}
