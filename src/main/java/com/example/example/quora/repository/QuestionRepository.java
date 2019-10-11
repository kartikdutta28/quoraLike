package com.example.example.quora.repository;

import com.example.example.quora.models.Questions;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuestionRepository extends MongoRepository<Questions, Integer> {

    Questions findBy_id(ObjectId _Id);

    List<Questions> findByUpVotes(Integer upVotes);
}
