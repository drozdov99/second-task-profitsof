package ua.profitsoft.trainee.drozdov.task3.service;

import java.util.List;

import ua.profitsoft.trainee.drozdov.task3.employee.Developer;
import ua.profitsoft.trainee.drozdov.task3.employee.Employee;
import ua.profitsoft.trainee.drozdov.task3.employee.Manager;

public class EmployeeListMergeService<T extends Employee> {

    private static EmployeeListMergeService<Employee> instance;

    public static EmployeeListMergeService<Employee> getInstance() {
        if (instance == null) {
            instance = new EmployeeListMergeService<>();
        }
        return instance;
    }

    public void mergeList(List<T> oldList, List<T> newList) {

        if(oldList == null || newList == null){
            throw new NullPointerException();
        }

        else if(!newList.isEmpty()) {
            for (int i = 0; i < oldList.size(); i++) {
                T employee1 = oldList.get(i);
                if (!newList.contains(employee1)) {
                    oldList.remove(employee1);
                    i--;
                }
            }

            for (T oldEmp : oldList) {
                if (oldEmp.getClass().equals(Developer.class)) {
                    DeveloperMergeService.getInstance().merge((Developer) oldEmp, (Developer) newList.get(newList.indexOf(oldEmp)));
                }
                if (oldEmp.getClass().equals(Manager.class)) {
                    ManagerMergeService.getInstance().merge((Manager) oldEmp, (Manager) newList.get(newList.indexOf(oldEmp)));
                }
            }

            newList.stream().filter(employee -> !oldList.contains(employee)).forEach(oldList::add);
        }

    }

}
