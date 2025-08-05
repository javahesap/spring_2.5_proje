package com.example.model;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String role;

    public User(String username, String role) {
		// TODO Auto-generated constructor stub
    	this.username=username;
    	this.role=role;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	// Getter - Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
    
}
