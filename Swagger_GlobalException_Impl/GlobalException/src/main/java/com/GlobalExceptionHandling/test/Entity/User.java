package com.GlobalExceptionHandling.test.Entity;

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
public User(int id, String username) {
	super();
	this.id = id;
	this.username = username;
}
@Override
public String toString() {
	return "User [id=" + id + ", username=" + username + "]";
}

}
