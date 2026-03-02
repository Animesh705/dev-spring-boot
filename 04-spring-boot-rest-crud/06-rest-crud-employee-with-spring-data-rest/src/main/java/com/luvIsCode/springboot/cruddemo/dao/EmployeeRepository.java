package com.luvIsCode.springboot.cruddemo.dao;

import com.luvIsCode.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource(path="members")
//now in url instead of employee , members will be used - (http://localhost:8080/magic-api/members)

//----------------------------------------------------<entity type, primary key>
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //that's it we dont need to write anything else

}
