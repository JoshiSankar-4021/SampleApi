package com.example.demo.serviceinterfaceimpl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Comment;
import com.example.demo.model.Userschat;
import com.example.demo.model.Usersdata;
import com.example.demo.repository.CommentRepo;
import com.example.demo.repository.UserchantRepo;
import com.example.demo.repository.UserdataRepo;
//import com.example.demo.repository.UserdataRepo;
import com.example.demo.serviceinterface.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentRepo commentrepo;
	@Autowired
	private UserdataRepo userdatarepo;
	@Autowired
	private UserchantRepo userchantrepo;
	
	
	@Override
	public void SaveComment(Comment comment) {
		// TODO Auto-generated method stub
		
		BigInteger userid=userdatarepo.getUserIdbyName(comment.getCommentFrom());
		BigInteger receiverId=userdatarepo.getUserIdbyName(comment.getCommentTo());
		System.out.println(userid);
		if(userid==null) {
			userdatarepo.Insertuser(comment.getCommentFrom());
			userid=userdatarepo.getUserIdbyName(comment.getCommentFrom());
		}
		if(receiverId==null) {
			userdatarepo.Insertuser(comment.getCommentTo());
			receiverId=userdatarepo.getUserIdbyName(comment.getCommentFrom());
		}
		
		 Calendar cal = Calendar.getInstance();
	     Date date=cal.getTime();
	     comment.setCommentDateTime(date);
	     comment.setCommentFromid(userid);
	     comment.setCommentToid(receiverId);
		 commentrepo.save(comment);
	}
	@Override
	public void SaveUsers(String senderName, String receiverName) {
		// TODO Auto-generated method stub
		Userschat userschat=new Userschat();
		userschat.setCommentFromUser(senderName);
		userschat.setCommentToUser(receiverName);
		userchantrepo.save(userschat);
	}
	@Override
	public List<String> getComments(Comment comment) {
		BigInteger receiverId=userdatarepo.getUserIdbyName(comment.getCommentTo());
		System.out.println(receiverId);
		List<String> comments=commentrepo.findAllById(receiverId);
		return comments;
	}
	@Override
	public boolean checkNamenum(String  userName) {
		// TODO Auto-generated method stub
		if(userName.isBlank()||userName.isEmpty()) {
			return true;
		}
		Pattern regex = Pattern.compile("[$&+,:;=\\\\?@#|/'<>.^*()%!-]");
		if(regex.matcher(userName).find()) {
			return true;
		}
		char[]user=userName.toCharArray();
		for(char Name : user){
	         if(Character.isDigit(Name)){
	            return true;
	         }
	      }
		
		return false;
	}
	
}
