package com.example.example.quora;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.example.quora.repositories.CommentsRepository;
import com.example.example.quora.models.Comments;

@RestController
@RequestMapping("/api")
public class CommentController {
    @Autowired
    private CommentsRepository repository;

    @RequestMapping("/comments")
    public List<Comments> getAllComment() {
        return repository.findAll();
    }

    @RequestMapping("/comments/{id}")
    public Comments getCommenttById(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/comments/{id}")
    public void addComment(@RequestBody Comments comment, @PathVariable("id") ObjectId id) {
        comment.set_id(ObjectId.get());
        comment.set_qid(id);
        repository.save(comment);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/comments/{id}")
    public void updateComment(@RequestBody Comments comment, @PathVariable("id") ObjectId id) {
        comment.set_id(id);
        repository.save(comment);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/comments/{id}")
    public void deleteComment(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }
}
