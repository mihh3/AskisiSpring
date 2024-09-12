package com.Michalis.cruddemo.dao;

import com.Michalis.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
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
    public void save(Student theStudent) {

        entityManager.persist(theStudent);
    }

    //implement the findById method which returns a student from the database into a Student object
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName asc", Student.class) ;
        // return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName= :theData",Student.class);
        // set query parameters
        theQuery.setParameter("theData",lastName) ;
        //return query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {

        entityManager.merge(theStudent);

    }

    @Override
    @Transactional
    public void delete(Integer id) {

        // retrieve the student
        Student theStudent = entityManager.find(Student.class,id);
        // delete the student
        entityManager.remove(theStudent);

    }

    @Override
    @Transactional
    public int deleteAll() {

        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }

    @Override
    public List<Student> findByAccepted(boolean acceptedValue) {

        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE accepted= :theData",Student.class);
        // set the parameter of the query
        theQuery.setParameter("theData",acceptedValue) ;
        // return the result set
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByDegreeId(Integer id) {

        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE highestDegreeID= :theData",Student.class);
        theQuery.setParameter("theData",id) ;
        return theQuery.getResultList();
    }


}
