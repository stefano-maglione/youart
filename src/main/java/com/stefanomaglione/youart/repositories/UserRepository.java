package com.stefanomaglione.youart.repositories;

import com.stefanomaglione.youart.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {



    //public List<Customer> findByuserName(String n);
    public User findByEmail(String n);
    public User findByCustomerId(String id);

}