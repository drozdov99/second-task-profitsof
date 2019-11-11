package ua.profitsoft.trainee.drozdov.task3.service;

import ua.profitsoft.trainee.drozdov.task3.employee.Employee;

public abstract class EmployeeMergeService<T extends Employee> implements MergeService<T>{

    public void merge(T oldEmployee, T newEmployee){
        AddressMergeService.getInstance().merge(oldEmployee.getAddress(), newEmployee.getAddress());
    }


}
