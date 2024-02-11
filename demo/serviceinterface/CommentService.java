package com.example.demo.serviceinterface;

import java.util.List;

import com.example.demo.model.Comment;
import com.example.demo.model.Usersdata;

public interface CommentService {
public void SaveComment(Comment comment);
public void SaveUsers(String senderName,String receiverName);
List<String> getComments(Comment comment);
boolean checkNamenum(String  userName);
}
