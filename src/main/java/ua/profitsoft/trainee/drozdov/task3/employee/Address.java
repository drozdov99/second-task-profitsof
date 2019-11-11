package ua.profitsoft.trainee.drozdov.task3.employee;

import java.util.Objects;

public class Address {
    private String street;
    private String number;
    private int index;

    public Address(String street, String number, int index) {
        this.street = street;
        this.number = number;
        this.index = index;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return index == address.index &&
                Objects.equals(street, address.street) &&
                Objects.equals(number, address.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, number, index);
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", index=" + index +
                '}';
    }
}
