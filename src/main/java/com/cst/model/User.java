package com.cst.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cst.entity.UserEntity;



public class User {

	@NotNull(message="UserName is a Required Field")
	@Size(min=1, max=32, message="UserName Must be Between 1 & 32 characters")
	private String username;
	
	@NotNull(message="Password is a Required Field")
	@Size(min=1, max=32, message="Password Must be Between 1 & 32 characters")
	private String password;
	

	/**
	 * User Constructor Method
	 * @param username - String
	 * @param password - String
	 */
	public User(String username, String password) 
	{
		this.username = username;
		this.password = password;
	}

	/**
	 * User Constructor Method
	 */
	public User() {
    	
    }

	/**
	 * User Constructor Method
	 * @param user - Auto Injected User Entity Entity
	 */
	public User(UserEntity user)
	{
		username = user.getUsername();
		password = user.getPassword();
	}

	//----------GETTERS & SETTERS------------\\
	
	
	/**
	 * Getter - UserName 
	 * @return UserName
	 */
    public String getUsername() {
    	return username;
	}
	 
    /**
     * Setter - UserName
     * @param username - String
     */
    public void setUsername(String username) {
    	this.username = username;
	}
	    
    /**
     * Getter - Password
     * @return Password
     */
    public String getPassword() {
    	return password;
	}
	 
    /**
     * Setter - Password
     * @param password - String
     */
    public void setPassword(String password) {
    	this.password = password;
	}
	 
   
    
    /**
     * User To String Method
     */
    @Override
	public String toString() {
		return "User [username=" + username + ", password=" + password +  "]";
	}
	
}
