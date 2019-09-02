package com.example.example.quora;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.example.quora.repositories.QuestionRepository;
import com.example.example.quora.models.Questions;

@RestController
@RequestMapping("/api")
public class QuestionController {
    @Autowired
    private QuestionRepository repository;

    @RequestMapping("/questions")
    public List<Questions> getAllQuestions() {
        return repository.findAll();
    }

    @RequestMapping("questions/{id}")
    public Questions getQuestionById(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/questions")
    public void addQuestion(@RequestBody Questions questions) {
        questions.set_id(ObjectId.get());
        questions.setInitVotes();
        repository.save(questions);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/questions/{id}")
    public void updateQuestion(@RequestBody Questions questions, @PathVariable("id") ObjectId id) {
        questions.set_id(id);
        repository.save(questions);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/questions/vote/{id}")
    public void incrementVote(@RequestBody Questions questions, @PathVariable("id") ObjectId id) {
        questions.set_id(id);
        Integer vote = questions.getUpVotes();
        vote++;
        questions.setVotes(vote);
        repository.save(questions);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/questions/{id}")
    public void deletQuestion(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }
}