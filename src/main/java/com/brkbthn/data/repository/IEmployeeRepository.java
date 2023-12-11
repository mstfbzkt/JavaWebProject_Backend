package com.brkbthn.data.repository;

import com.brkbthn.data.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends CrudRepository<EmployeeEntity, Long> {
    // CrudRepository<> nin içi tablo adı ve primary key(id) ile dolduruluyor


    //Delivery Query
    EmployeeEntity findByEmail (String email);
}
