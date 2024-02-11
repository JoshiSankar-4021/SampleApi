
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

@Entity(name = "usersdata")

@Data

@Table(name = "usersdata")

@NoArgsConstructor

@AllArgsConstructor
public class Usersdata {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userid", nullable = false, unique = true, columnDefinition = "BIGINT")
	private BigInteger userid;

	@Column(name = "usename", length = 255, nullable = true, unique = false)
	private String username;

	public Usersdata(BigInteger userid, String username) {
		this.userid = userid;
		this.username = username;
	}

	public BigInteger getUserid() {
		return userid;
	}

	public void setUserid(BigInteger userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
