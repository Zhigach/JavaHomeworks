package task2;

import java.time.LocalDate;

public class Customer {
    String name;
    LocalDate birthDate;
    String phone;
    Sex sex;

    public Customer(String name, LocalDate birthDate, String phone, Sex sex) {
        this.name = name;
        this.birthDate = birthDate;
        this.phone = phone;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer:" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", phone='" + phone + '\'' +
                ", sex=" + sex +
                '}';
    }
}
