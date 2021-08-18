package repository;


import moduls.Customer;

import java.util.List;

public interface ICustomerRepo {
     List<Customer> findAll();

     Customer findById(int id);

     Customer save(Customer customer);
     void edit(Customer customer);
//     void remove(Customer id);

}
