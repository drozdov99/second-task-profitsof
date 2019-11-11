package ua.profitsoft.trainee.drozdov.task3.employee;

import java.util.Objects;

public class Developer extends Employee {
    private String programmingLanguage;

    public Developer(String first_name, String last_name, Address address, String programmingLanguage) {
        super(first_name, last_name, address);
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public String toString() {
        return "Developer{" + super.toString()+
                "programmingLanguage='" + programmingLanguage + '\'' +
                '}';
    }
    public boolean fullEquals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Developer developer = (Developer) o;
        return Objects.equals(programmingLanguage, ((Developer) o).programmingLanguage) && ((Developer) o).getAddress().equals(this.getAddress());
    }
}
