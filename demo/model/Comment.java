package com.example.demo.model;
import java.math.BigInteger;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="comment")
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="commentid",nullable=false,unique=true,columnDefinition = "BIGINT")
  private BigInteger commentid;
  
  @Column(name="message",length=255,nullable=true,unique=false)
  private String message;
  
  @Column(name="comment_date_time",nullable=false)
  private Date commentDateTime;
  
  @Column(name="posted_by_user", nullable=false)  
  private BigInteger commentFromid;
  

  @Column(name="post_receivedby_user", nullable=false)  
  private BigInteger commentToid;
  
  @Transient
  private String commentFrom;
  
  @Transient
  private String commentTo;
  
  
 public Comment(BigInteger commentid,String message,Date commentDateTime,BigInteger commentFromid, String commentFrom, String commentTo, BigInteger commentToid) {
	 this.commentid=commentid;
	 this.message=message;
	 this.commentDateTime=commentDateTime;
	 this.commentFromid=commentFromid;
	 this.commentFrom=commentFrom;
	 this.commentTo=commentTo;
	 this.commentToid=commentToid;
 }

public BigInteger getCommentid() {
	return commentid;
}

public void setCommentid(BigInteger commentid) {
	this.commentid = commentid;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public Date getCommentDateTime() {
	return commentDateTime;
}

public void setCommentDateTime(Date commentDateTime) {
	this.commentDateTime = commentDateTime;
}

public BigInteger getCommentFromid() {
	return commentFromid;
}

public void setCommentFromid(BigInteger commentFromid) {
	this.commentFromid = commentFromid;
}

public String getCommentFrom() {
	return commentFrom;
}

public void setCommentFrom(String commentFrom) {
	this.commentFrom = commentFrom;
}

public String getCommentTo() {
	return commentTo;
}

public BigInteger getCommentToid() {
	return commentToid;
}

public void setCommentToid(BigInteger commentToid) {
	this.commentToid = commentToid;
}

public String setCommentTo(String commentTo) {
	return this.commentTo = commentTo;
}
}