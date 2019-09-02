package com.example.example.quora.models;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
@Document(collection = "posts")
public class Post{
	@Id
	private ObjectId _id;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date date=new Date();
	private String body;
	private List<Comments> comments;//One Post can have multiple Comments
	public Post() {}
	public Post(ObjectId _id, String body,List<Comments>comments) {
	    this._id = _id;
	    this.body = body;
	    this.comments=comments;	  
	}
	public String get_id() { return _id.toHexString(); }
	public void set_id(ObjectId _id) { this._id = _id; }
	public List<Comments> getComments(){return this.comments;}
}