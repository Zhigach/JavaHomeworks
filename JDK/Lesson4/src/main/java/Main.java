public class Main {
    public static void main(String[] args) {
        EmployeeDB employeeDB = new EmployeeDB();
        employeeDB.addEmployee(new Employee("62345", "79998887766", "Stepan", 5));
        employeeDB.addEmployee(new Employee("52345", "79998887755", "Ivan", 4));
        employeeDB.addEmployee(new Employee("42345", "79998887744", "Fedor", 7));
        employeeDB.addEmployee(new Employee("32345", "79998887733", "Ilon", 1));
        employeeDB.addEmployee(new Employee("22345", "79998887722", "The Mask", 7));
        employeeDB.addEmployee(new Employee("12345", "79998887711", "Vlad", 5));

        System.out.println(employeeDB.getEmployeeByNumber("22345"));
        System.out.println(employeeDB.getPhoneNumberByName("Ilon"));
        System.out.println(employeeDB.searchByWorkExperience(3));
    }
}
