import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

public class Employee {
    private String name;
    private String position;
    private String phone;
    private double salary;
    private LocalDate birthDate;

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getPhone() {
        return phone;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return Period.between(birthDate,LocalDate.now()).getYears();
    }
    public Employee(String name, String position, String phone, double salary, LocalDate birthDate) {
        this.name = name;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.birthDate = birthDate;
    }

    public void addSalary(double increment) {
        setSalary(getSalary() + increment);
    }
    @Override
    public String toString() {
        return String.format("Employee %s %s: %s, %d, %s, %f", position, name, phone, getAge(), phone, salary);
    }
    public void printInfo() {
        System.out.println(this);
    }
    public static void printInfo(List<Employee> employeeList) {
        for (Employee employee : employeeList) {
            employee.printInfo();
        }
    }

    public static String findAverageAgeAndSalary(List<Employee> employeeList) {
        double sumAge = 0;
        double sumSalary = 0;
        for (Employee employee : employeeList) {
            sumAge += employee.getAge();
            sumSalary += employee.getSalary();
        }
        return String.format("Average age is %f\nAverage salary is %f",
                sumAge/employeeList.size(),
                sumSalary/employeeList.size());
    }

    /*
    Написать прототип компаратора - метод внутри класса сотрудника, сравнивающий две даты,
     представленные в виде трёх чисел гггг-мм-дд, без использования условного оператора.
    */
    /**
     * Comparator prototype
     * @param date1 "гггг-мм-дд" formatted date
     * @param date2 "гггг-мм-дд" formatted date
     * @return returns true if first date is earlier tha the second one
     */
    public static boolean datesComparator(String date1, String date2) {
        LocalDate ld1 = LocalDate.parse(date1, DateTimeFormatter.ISO_LOCAL_DATE );
        LocalDate ld2 = LocalDate.parse(date2, DateTimeFormatter.ISO_LOCAL_DATE );
        return ld2.isAfter(ld1);
    }
}
