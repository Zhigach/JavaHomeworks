import java.util.ArrayList;
import java.util.List;

/*
Создать справочник сотрудников
Необходимо:
Создать класс справочник сотрудников, который содержит внутри
коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
Табельный номер
Номер телефона
Имя
Стаж
Добавить метод, который ищет сотрудника по стажу (может быть список)
Добавить метод, который возвращает номер телефона сотрудника по имени (может быть список)
Добавить метод, который ищет сотрудника по табельному номеру
Добавить метод добавление нового сотрудника в справочник
 */
public class EmployeeDB {
    List<Employee> employeeList = new ArrayList<>();

    /**
     * Search employees with experience greater than value
     * @param experienceYears desired minimum value of experience
     * @return List of Employees
     */
    public List<Employee> searchByWorkExperience (int experienceYears) {
        return employeeList.stream().filter(employee -> employee.getWorkExperienceYears() > experienceYears).toList();
    }

    public List<String> getPhoneNumberByName(String name) {
        List<Employee> matchingEmployees = employeeList.stream().filter(employee -> employee.getName().equals(name)).toList();
        return matchingEmployees.stream().map(Employee::getPhoneNumber).toList();
    }

    public Employee getEmployeeByNumber(String personalNumber) {
        return employeeList.stream().filter(employee -> employee.getPersonalNumber().equals(personalNumber)).toList().get(0);
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

}
