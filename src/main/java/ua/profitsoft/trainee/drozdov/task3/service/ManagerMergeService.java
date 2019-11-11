package ua.profitsoft.trainee.drozdov.task3.service;

import ua.profitsoft.trainee.drozdov.task3.employee.Manager;

public class ManagerMergeService extends EmployeeMergeService<Manager> {

    private static ManagerMergeService instance;

    private ManagerMergeService(){}

    public static ManagerMergeService getInstance(){
        if (instance == null) {
            instance = new ManagerMergeService();
        }
        return instance;
    }

    @Override
    public void merge(Manager oldEmployee, Manager newEmployee) {
        super.merge(oldEmployee, newEmployee);
        oldEmployee.setHobby(newEmployee.getHobby());
    }

}
