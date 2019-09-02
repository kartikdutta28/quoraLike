package com.example.example.quora.repositories;

import com.example.example.quora.models.Post;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post,Integer>{
	Post findBy_id(ObjectId _Id);
}
