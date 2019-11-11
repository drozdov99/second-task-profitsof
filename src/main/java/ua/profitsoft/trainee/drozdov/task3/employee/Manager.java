package ua.profitsoft.trainee.drozdov.task3.employee;

import java.util.Objects;

public class Manager extends Employee {

    private String hobby;

    public Manager(String first_name, String last_name, Address address, String hobby) {
        super(first_name, last_name, address);
        this.hobby = hobby;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }


    public boolean fullEquals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Objects.equals(hobby, manager.hobby) && ((Manager) o).getAddress().equals(this.getAddress());
    }

}

