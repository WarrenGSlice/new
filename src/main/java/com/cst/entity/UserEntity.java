package com.cst.entity;

import java.util.Random;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.cst.model.User;

@Table("USERS")
public class UserEntity {

	@Id
	Long userId;
	
	@Column("USER_NAME")
	String username;
	
	@Column("PASSWORD")
	String password;

	/**
	 * User Entity Constructor Method
	 */
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * User Entity Constructor Method
	 * @param user - Auto Injected User Model
	 */
	public UserEntity(User user)
	{
		Random r = new Random();
		userId = r.nextLong();
		username = user.getUsername();
		password = user.getPassword();
	}

	/**
	 * User Entity Constructor Method
	 * @param userId - Long
	 * @param username - String
	 * @param password - String
	 */
	public UserEntity(Long userId, String username, String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
	}
	
	/**
	 * User Entity Constructor Method
	 * @param username - String
	 * @param password - String
	 */
	public UserEntity(String username, String password) {
		this.username = getUsername();
		this.password = getPassword();

	}

	//----------GETTERS & SETTERS ------------\\
	
	
	public Long getUserId() {
		return userId;
	}

	/**
	 * Setter - User ID
	 * @param userId - Long
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * Getter - Username
	 * @return Username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Getter - Username
	 * @param username - Username
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
	 * Setter - password
	 * @param password - String
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Method to Get a Set of all Users
	 * @return - Set of Users
	 */
	@SuppressWarnings("unchecked")
	public Set<UserEntity> getUsers() {
		// TODO Auto-generated method stub
		return (Set<UserEntity>) new UserEntity(getUsername(), getPassword());
	}
	
	/**
	 * Helper Method of Customer User Details Class
	 * @return true - is Enabled
	 */
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
