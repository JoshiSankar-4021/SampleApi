package com.example.demo.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.logging.log4j.util.Chars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Comment;
import com.example.demo.serviceinterface.CommentService;

import jakarta.servlet.ServletException;

@RestController
@Component
public class CommentController {

	@Autowired
	private CommentService commentservice;
	
	String nResponse="Invalid Request";
	
	boolean senderNameConNum;
	boolean receiverNameConNum;
	@PostMapping("/addcomment")
	public String PostComment(@RequestBody Comment comment) throws ServletException {
		
		
		senderNameConNum=commentservice.checkNamenum(comment.getCommentFrom());
		
		receiverNameConNum=commentservice.checkNamenum(comment.getCommentTo());
		 
		if(senderNameConNum||receiverNameConNum) {
			return nResponse;
		}	
		commentservice.SaveComment(comment);
		System.out.println("Comment Add SUCESSFUL");
		commentservice.SaveUsers(comment.getCommentFrom(),comment.getCommentTo());
		return "Comment Added Successfully";
	}
	
	@GetMapping("/getcomment")
	public List<String> Getcomment(@RequestBody Comment comment) {
		
		receiverNameConNum=commentservice.checkNamenum(comment.getCommentTo());
		List<String>comments=commentservice.getComments(comment);
		if(receiverNameConNum) {
			comments.add(nResponse);
			System.out.println(comments.size());
			return comments;
		}
		
		System.out.println("Comment Add START");
		return comments;
	}
}