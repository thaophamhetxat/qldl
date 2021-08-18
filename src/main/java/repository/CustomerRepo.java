package repository;

import moduls.Customer;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepo implements ICustomerRepo {
    @Autowired
    EntityManager entityManager;


    @Override
    public List<Customer> findAll() {
        String queryStr = "SELECT c FROM Customer AS c ";
        TypedQuery<Customer> query = entityManager.createQuery(queryStr, Customer.class);
        return (ArrayList<Customer>) query.getResultList();
    }

    @Override
    public Customer findById(int id) {
        String queryStr = "select c from Customer c where  c.id=:id";
        TypedQuery<Customer> query = entityManager.createQuery(queryStr, Customer.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Customer save(Customer customer) {
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.persist(customer);
        txn.commit();
        return customer;
    }

    @Override
    public void edit(Customer customer) {
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.merge(customer);
        txn.commit();
    }

//    @Override
//    public void remove(int id) {
//        Customer customer = findById(id);
//        if (customer != null) {
//            entityManager.remove(customer);
//        }
//
//    }
}
