package com.CustomException.test.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id
	private int id;
private String username;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public User() {
	super();
	// TODO Auto-generated constructor stub
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}

}
