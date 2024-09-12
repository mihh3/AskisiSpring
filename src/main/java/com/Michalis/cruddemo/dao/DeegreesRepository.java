package com.Michalis.cruddemo.dao;

import com.Michalis.cruddemo.entity.Degree;

import java.util.List;

public interface DeegreesRepository {

    void addDegree(Degree aDegree);

    void deleteDegree(int degreeId);

    List<Degree> findByTitle(String title);

    List<Degree> returnAllRecords();






}
