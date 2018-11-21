package com.sayisal.loto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;

public interface DrawDatesRepository extends MongoRepository<String, String> {

    public ArrayList<String> findAllBy();

}
