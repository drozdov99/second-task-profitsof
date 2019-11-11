package ua.profitsoft.trainee.drozdov.task3.service;

import ua.profitsoft.trainee.drozdov.task3.employee.Address;

public class AddressMergeService implements MergeService<Address>{

    private static AddressMergeService instance;

    private AddressMergeService() {
    }

    public static AddressMergeService getInstance() {
        if (instance == null) {
            instance = new AddressMergeService();
        }
        return instance;
    }


    public void merge(Address oldAddress, Address newAddress){
        oldAddress.setIndex(newAddress.getIndex());
        oldAddress.setNumber(newAddress.getNumber());
        oldAddress.setStreet(newAddress.getStreet());
    }
}
