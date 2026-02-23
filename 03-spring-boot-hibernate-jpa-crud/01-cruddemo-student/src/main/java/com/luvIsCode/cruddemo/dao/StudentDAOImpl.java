package com.luvIsCode.cruddemo.dao;
import com.luvIsCode.cruddemo.entity.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{


    //define field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    //implement save method
    @Override
    @Transactional
    public void save(Student theStudent){
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id){
        return entityManager.find(Student.class,id);
    }

    //not using transactional annotation because just writing the method for reading the data,
    @Override
    public List<Student> findAll() {
        //create query
        //                      deafult sort : asc [FROM Student order by lastName] || for desc/asc [FROM Student order by lastName desc/asc]
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student",Student.class);
        //return query result
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        //create query
        //                                     jpql name parameter are prefixed with colon[:theData] || lastName = _______
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);

         //set parameter
         theQuery.setParameter("theData",theLastName);
         //return query result
        return theQuery.getResultList();
    }

    // adding a method to update the object
    @Override
    @Transactional // adding a trans. annotation because here we are actually making change on database
    public void update(Student theStudent) {
        entityManager.merge(theStudent); //.merge is used to tell the entityManager to update the obj.
    }

    //adding a method for delete operation
    @Override
    @Transactional
    public void delete(Integer id) {
        //find the student
        Student theStudent = entityManager.find(Student.class, id);
        //delete the student
        entityManager.remove(theStudent);
    }

    //for deleting all the students
    @Override
    @Transactional
    public int deleteAll() {
        int numRowDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowDeleted;
    }

}
