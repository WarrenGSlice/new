package com.cst.data;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface DataAccessInterface<T> {

	/**
	 * Method to Find All
	 * @return Entire List
	 */
	public List<T> findAll();
	
	/**
	 * Method to Find by ID
	 * @param id - Integer
	 * @return Single Item
	 */
	public T findById(Integer id);
	
	/**
	 * Method to Create new Database Entry
	 * @param t - Passes Generic
	 * @return New Entry in Database
	 */
	public boolean create(T t);
	
	/**
	 * Method to Update Database Entry
	 * @param t - Passes Generic
	 * @return Updates Entry
	 */
	public boolean update(T t);
	
	/**
	 * Method to Delete Database Entry
	 * @param t - Passes Generic
	 * @return Deletes Entry
	 */
	public boolean delete(T t);
	
	/**
	 * Method for Testing
	 */
	public void init();
			
	/**
	 * Method For Testing
	 */
	public void destroy();

}