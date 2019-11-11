import org.junit.Assert;
import org.junit.Test;
import ua.profitsoft.trainee.drozdov.task3.employee.Address;
import ua.profitsoft.trainee.drozdov.task3.employee.Developer;
import ua.profitsoft.trainee.drozdov.task3.employee.Employee;
import ua.profitsoft.trainee.drozdov.task3.employee.Manager;
import ua.profitsoft.trainee.drozdov.task3.service.EmployeeListMergeService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeListMergeServiceTest {

   @Test
    public void testOldListEmptyTest(){
        List<Employee> oldList = new ArrayList<>();
        List<Employee> newList = new ArrayList<>();
        Employee employee1 = new Developer("Vadim","Drozdov", new Address("Nauki","51B",61485), "Java");
        newList.add(employee1);
        EmployeeListMergeService.getInstance().mergeList(oldList, newList);
        Assert.assertTrue(new Developer("Vadim", "Drozdov", new Address("Nauki", "51B", 61485), "Java").fullEquals(oldList.get(0)));
    }
    @Test
    public void testNewListEmptyTest(){
        List<Employee> oldList = new ArrayList<>();
        List<Employee> newList = new ArrayList<>();
        oldList.add(new Developer("Vadim","Drozdov", new Address("Nauki","51B",61485), "Java"));
        EmployeeListMergeService.getInstance().mergeList(oldList, newList);
        Assert.assertFalse(oldList.isEmpty());
    }

    @Test
    public void testUpdateEmployeeFromOldList(){
        List<Employee> oldList = new ArrayList<>();
        List<Employee> newList = new ArrayList<>();
        oldList.add(new Developer("Vadim","Drozdov",
                new Address("Nauki","51B",61485), "Java"));
        newList.add(new Developer("Vadim","Drozdov",
                new Address("Pobedi","61B",6185), "Scala"));
        EmployeeListMergeService.getInstance().mergeList(oldList, newList);
        Assert.assertTrue(new Developer("Vadim", "Drozdov",
                new Address("Pobedi", "61B", 6185), "Scala").fullEquals(oldList.get(0)));
    }
    @Test
    public void testMergeEmployeeList() {
        List<Employee> oldList = new ArrayList<>();
        List<Employee> newList = new ArrayList<>();

        oldList.add(new Developer("Vadim", "Drozdov",
                new Address("Nauki", "51B", 61485), "Java"));
        oldList.add(new Developer("Oleg", "Drozdov",
                new Address("Svobodi", "5B", 61425), "Java"));
        oldList.add(new Developer("Igor", "Drozdov",
                new Address("Skovorodi", "1B", 65485), "Ruby"));

        newList.add(new Developer("Vadim", "Drozdov",
                new Address("Pobedi", "61B", 6185), "Scala"));
        newList.add(new Manager("Victor", "Drozdov",
                new Address("Pobedi", "12", 32244), "Soccer"));

        EmployeeListMergeService.getInstance().mergeList(oldList, newList);

        Assert.assertEquals(2, oldList.size());
        Assert.assertTrue(new Developer("Vadim", "Drozdov",
                new Address("Pobedi", "61B", 6185), "Scala").fullEquals(oldList.get(0)));
        Assert.assertTrue(new Manager("Victor", "Drozdov",
                new Address("Pobedi", "12", 32244), "Soccer").fullEquals(oldList.get(1)));

    }

}
