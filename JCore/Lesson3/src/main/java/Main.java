import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //SET UP
        Employee employee1 = new Employee("Ivan Ivanov",
                "Engineer",
                "+16566565",
                50000,
                LocalDate.of(1990,3,4));
        Employee employee2 =  new Employee("Piotr Petrov",
                "Mechanic",
                "+765642815",
                60000,
                LocalDate.of(1971,10,15));
        Employee employee3 =  new Employee("Michael Saint",
                "Security",
                "+7111147721",
                10000,
                LocalDate.of(1980,9,17));
        Employee employee4 =  new Head("Vasiliy Dark",
                "Analyst",
                "+799942342",
                140000,
                LocalDate.of(1955,2,4));
        Employee employee5 =  new Employee("John Doe",
                "Scram master",
                "+7963422423",
                150000,
                LocalDate.of(1989,8,20));
        //END SET UP

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);
        employeeList.add(employee5);

        Employee.printInfo(employeeList);
        System.out.println(Employee.findAverageAgeAndSalary(employeeList));
        Head.increaseSalaryForOldGuys(employeeList, 45, 5000);
        Employee.printInfo(employeeList);
        System.out.println(Employee.findAverageAgeAndSalary(employeeList));

        System.out.println(Employee.datesComparator("2022-01-12", "2022-01-12"));
    }

//    private static void increaseSalaryForOldGuys(List<Employee> employeeList, int thresholdAge, double increment) {
//        for (Employee employee : employeeList) {
//            if (employee.getAge() >= thresholdAge) {
//                employee.addSalary(increment);
//            }
//        }
//    }
}

