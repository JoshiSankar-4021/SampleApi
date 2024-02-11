package com.example.demo.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, BigInteger> {

	@Query(value="select message from comment where post_receivedby_user=?1",nativeQuery = true)
	List<String> findAllById(@Param("userid") BigInteger userid);
	

}
