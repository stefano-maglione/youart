package com.stefanomaglione.youart.repo;

import com.stefanomaglione.youart.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {



    //public List<Customer> findByuserName(String n);
    public Customer findByEmail(String n);
    public Customer findByCustomerId(String id);

}