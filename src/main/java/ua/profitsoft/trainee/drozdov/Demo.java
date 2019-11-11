package ua.profitsoft.trainee.drozdov;

import ua.profitsoft.trainee.drozdov.task3.employee.*;
import ua.profitsoft.trainee.drozdov.task2.StringBinaryEncoderService;
import ua.profitsoft.trainee.drozdov.task1.StringVowelsSeparatorService;
import ua.profitsoft.trainee.drozdov.task3.service.EmployeeListMergeService;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {

        String line = "Hello";
        System.out.println(StringBinaryEncoderService.getInstance().encodeMessage(line));
        System.out.println(StringVowelsSeparatorService.getInstance().interviewRecursionTest(line));

        List<Employee> oldList = new ArrayList<>();
        List<Employee> newList = new ArrayList<>();

        Employee employee1 = new Developer("Vadim","Drozdov",
                new Address("Nauki","51B",61485), "Java");
        Employee employee2 = new Developer("Vadim","Drozdov",
                new Address("Pobedi","51B",61485), "Scala");

        oldList.add(employee1);
        newList.add(employee2);
        EmployeeListMergeService.getInstance().mergeList(oldList, newList);

        for (Employee e : oldList) {
            System.out.println(e.toString());
        }

    }
}