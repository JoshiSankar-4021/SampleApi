package com.example.demo.model;

import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "userschat")

@Data

@Table(name = "userschat")

@NoArgsConstructor

@AllArgsConstructor
public class Userschat {
	@Id
	@Column(name="userid",nullable=false,unique=true,columnDefinition = "BIGINT")
	@GeneratedValue(strategy = GenerationType.AUTO)
	BigInteger commenteduserId;
	@Column(name = "commentfrom", length = 25, nullable = true, unique = false)
	String commentFromUser;
	@Column(name = "commentto", length = 255, nullable = true, unique = false)
	String CommentToUser;
	
	public Userschat(BigInteger commenteduserId,String commentFromUser,String CommentToUser ) {
		this.commenteduserId=commenteduserId;
		this.commentFromUser=commentFromUser;
		this.CommentToUser=CommentToUser;
	}

	public Userschat() {
		// TODO Auto-generated constructor stub
	}

	public BigInteger getCommenteduserId() {
		return commenteduserId;
	}

	public void setCommenteduserId(BigInteger commenteduserId) {
		this.commenteduserId = commenteduserId;
	}

	public String getCommentFromUser() {
		return commentFromUser;
	}

	public String setCommentFromUser(String commentFromUser) {
		return this.commentFromUser = commentFromUser;
	}

	public String getCommentToUser() {
		return CommentToUser;
	}

	public String setCommentToUser(String commentToUser) {
		return CommentToUser = commentToUser;
	}
	
}
