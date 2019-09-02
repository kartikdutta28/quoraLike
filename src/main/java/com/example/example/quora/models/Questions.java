package com.example.example.quora.models;

import java.util.Date;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

@Data
@Document(collection = "questions")
public class Questions {
    @Id
    private ObjectId _id;
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date date = new Date();
    private String title;
    private String body;
    public Integer upVotes;

    public Questions() {
    }

    public Questions(ObjectId _id, String title, String body, Integer upVotes) {
        this._id = _id;
        this.title = title;
        this.body = body;
        this.upVotes = upVotes;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public String getTitle() {
        return this.title;
    }

    public String getBody() {
        return this.body;
    }

    public Integer getUpVotes() {
        return this.upVotes;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setInitVotes() {
        this.upVotes = 1;
    }

    public void setVotes(Integer vote) {
        this.upVotes = vote;
    }

}