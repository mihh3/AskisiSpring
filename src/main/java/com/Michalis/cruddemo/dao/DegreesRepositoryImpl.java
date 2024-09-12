package com.Michalis.cruddemo.dao;

import com.Michalis.cruddemo.entity.Degree;
import com.Michalis.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DegreesRepositoryImpl implements DeegreesRepository{

    private EntityManager entityManager;


    public DegreesRepositoryImpl(EntityManager entityManager){
        this.entityManager = entityManager ;
    }


    @Override
    @Transactional
    public void addDegree(Degree aDegree) {
        if (findByTitle(aDegree.getTitle()).isEmpty()){
            entityManager.persist(aDegree);}
        else
            System.out.println("Degree With Title : " +aDegree.getTitle() +" already exists ! ");
    }

    @Override
    @Transactional
    public void deleteDegree(int degreeId) {

        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE highestDegreeID= :theData", Student.class);
        theQuery.setParameter("theData",degreeId);

        // Check if the degreeId is matching with any student
        // If not matching the degree gets deleted
        if (theQuery.getResultList().isEmpty()) {
            Degree degreeToDelete = entityManager.find(Degree.class, degreeId);
            entityManager.remove(degreeToDelete);
        }
        // If matching the following message gets printed .
        else
            System.out.println("Cannot delete degree with ID : " +degreeId +" because it is assigned to a student ");
    }

    @Override
    public List<Degree> findByTitle(String title) {

        // The query
        TypedQuery<Degree> theQuery = entityManager.createQuery("FROM Degree WHERE title= :theData",Degree.class);
        // set query parameters
        theQuery.setParameter("theData",title) ;
        //return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Degree> returnAllRecords() {
        TypedQuery<Degree> theQuery = entityManager.createQuery("FROM Degree ",Degree.class);
        return theQuery.getResultList();
    }
}
