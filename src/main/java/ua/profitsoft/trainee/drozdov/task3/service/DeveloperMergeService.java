package ua.profitsoft.trainee.drozdov.task3.service;

import ua.profitsoft.trainee.drozdov.task3.employee.Developer;

public class DeveloperMergeService extends EmployeeMergeService<Developer> {

    private static DeveloperMergeService instance;

    private DeveloperMergeService(){}

    public static DeveloperMergeService getInstance(){
        if (instance == null) {
            instance = new DeveloperMergeService();
        }
        return instance;
    }

    @Override
    public void merge(Developer oldEmployee, Developer newEmployee) {
        super.merge(oldEmployee, newEmployee);
        oldEmployee.setProgrammingLanguage(newEmployee.getProgrammingLanguage());
    }
}
