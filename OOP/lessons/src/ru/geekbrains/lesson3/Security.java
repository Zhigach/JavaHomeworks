package lessons.src.ru.geekbrains.lesson3;

public class Security extends Employee{

    public Security(String name, String surname, int age, int experience, double baseSalary) {
        super(name, surname, age, experience, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return this.baseSalary*12*16 * Math.max(Math.pow(experience, 0.25), 1); // 2/2 12 hour duty
    }
    public String toString() {
        return String.format("%s %s; %d лет; Стаж %d лет; Охранник; Месячная заработная плата: %.2f (у.е.)",
                surname, name, age, experience, calculateSalary());
    }
}
