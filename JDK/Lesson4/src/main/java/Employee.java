/*
    каждый сотрудник должен иметь следующие атрибуты:
    Табельный номер
    Номер телефона
    Имя
    Стаж
 */
public class Employee {
    String personalNumber;
    String phoneNumber;
    String Name;
    int workExperienceYears;

    public Employee(String personalNumber, String phoneNumber, String name, int workExperienceYears) {
        this.personalNumber = personalNumber;
        this.phoneNumber = phoneNumber;
        Name = name;
        this.workExperienceYears = workExperienceYears;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setWorkExperienceYears(int workExperienceYears) {
        this.workExperienceYears = workExperienceYears;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return Name;
    }

    public int getWorkExperienceYears() {
        return workExperienceYears;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "personalNumber='" + personalNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", Name='" + Name + '\'' +
                ", workExperienceYears=" + workExperienceYears +
                '}';
    }
}
