package com.example.demo.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Userschat;

public interface UserchantRepo extends JpaRepository<Userschat, BigInteger>{
	@Query(value="select commentfrom from userchat where commentto=?1",nativeQuery = true)
	public List<String> getCommentfrom(@Param("commentto")String userName);
}
