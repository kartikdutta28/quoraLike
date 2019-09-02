package com.example.example.quora.repositories;

import com.example.example.quora.models.Comments;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends MongoRepository<Comments, Integer> {
    Comments findBy_id(ObjectId _Id);
}
