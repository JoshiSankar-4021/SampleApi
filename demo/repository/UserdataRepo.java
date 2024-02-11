
package com.example.demo.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Comment;
import com.example.demo.model.Usersdata;

import jakarta.transaction.Transactional;

public interface UserdataRepo extends JpaRepository<Usersdata, BigInteger> {

	@Query(value = "select userid from usersdata where usename=?1", nativeQuery = true)
	public BigInteger getUserIdbyName(@Param("userName") String userName);
	
	@Modifying
	@Transactional
	@Query(value="INSERT INTO usersdata (usename) VALUES (?)",nativeQuery = true)
	public void Insertuser(@Param("username") String userName);
	
	
}
