package com.example.example.quora.repositories;

import com.example.example.quora.models.Questions;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends MongoRepository<Questions, Integer> {

    Questions findBy_id(ObjectId _Id);
}
