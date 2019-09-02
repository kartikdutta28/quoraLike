package com.example.example.quora;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.example.quora.repositories.PostRepository;
import com.example.example.quora.models.Post;;

@RestController
@RequestMapping("/api")
public class PostController {
	@Autowired
	private PostRepository repository;

	@RequestMapping("/posts")
	public List<Post> getAllPost() {
		return repository.findAll();
	}

	@RequestMapping("/posts/{id}")
	public Post getPostById(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/posts")
	public void addPost(@RequestBody Post post) {
		post.set_id(ObjectId.get());
		repository.save(post);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/posts/{id}")
	public void updatePost(@RequestBody Post post, @PathVariable("id") ObjectId id) {
		post.set_id(id);
		repository.save(post);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/posts/{id}")
	public void deletePost(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
	}
}
