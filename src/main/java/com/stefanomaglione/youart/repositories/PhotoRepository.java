package com.stefanomaglione.youart.repositories;


import com.stefanomaglione.youart.domain.Photo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends CrudRepository<Photo, Long> {



    //public List<Customer> findByuserName(String n);
    public Photo findByName(String n);
    public Photo findById(String id);

}