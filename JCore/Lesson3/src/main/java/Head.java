/*
Опишите класс руководителя, наследник от сотрудника.
Перенесите статический метод повышения зарплаты в класс руководителя,
 модифицируйте метод таким образом, чтобы он мог поднять заработную плату всем,
  кроме руководителей. В основной программе создайте руководителя и поместите его в общий массив сотрудников.
   Повысьте зарплату всем сотрудникам и проследите, чтобы зарплата руководителя не повысилась.
 */
import java.time.LocalDate;
import java.util.List;

public class Head extends Employee{
    public Head(String name, String position, String phone, double salary, LocalDate birthDate) {
        super(name, position, phone, salary, birthDate);
    }
    public static void increaseSalaryForOldGuys(List<Employee> employeeList, int thresholdAge, double increment) {
        for (Employee employee : employeeList) {
            if (!(employee instanceof Head) && employee.getAge() >= thresholdAge) {
                employee.addSalary(increment);
            }
        }
    }
}
