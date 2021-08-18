package service;

import moduls.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ICustomerRepo;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    @Autowired
    ICustomerRepo iCustomerRepo;

    public ArrayList<Customer> list = new ArrayList<>();

    public void save(Customer customer) {
        iCustomerRepo.save(customer);
    }

    public void findAll() {
        list = (ArrayList<Customer>) iCustomerRepo.findAll();
    }
    public void findById(int id) {
        iCustomerRepo.findById(id);
    }

    public void edit(Customer customer) {
        iCustomerRepo.edit(customer);
    }

//    public void delete(int index) {
//        iCustomerRepo.remove(list.get(index));
//        list.remove(index);
//    }
}
