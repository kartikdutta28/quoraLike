package com.example.example.quora.models;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@Document(collection = "comments")

public class Comments {
	@Id
	private ObjectId _id;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date date = new Date();
	private ObjectId _qid;
	public String commentBody;

	public Comments() {

	}

	public Comments(ObjectId _id, String commentBody) {
		this._id = _id;
		this.commentBody = commentBody;
	}

	public String get_id() {
		return _id.toHexString();
	}

	public String get_qid() {
		return _qid.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public void set_qid(ObjectId _qid) {
		this._qid = _qid;
	}

}
