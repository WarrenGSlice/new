package com.cst.business;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cst.entity.RBEntity;
import com.cst.model.RBModel;

@Service
public interface RunningBackInterface {
	
	/**
	 * Method to run Console Test's
	 */
	public void test();

	/**
	 * Method to initiate bean instance
	 */
	public void init();
	
	/**
	 * Method to Destroy Bean Instance
	 */
	public void destroy();
	
	/**
	 * Method to Get List of Products
	 * @return - List of Products
	 */
	public List<RBModel> getRunningBacks();
	
	/**
	 * Method to Add Products
	 * @param item - Full Order of ProductModel type
	 * @return - New Order entry in Product List
	 */
	public List<RBModel> AddPlayer(RBModel item);

	/**
	 * Method to Add Items
	 * @param items - Auto Injected List of String Array items
	 * Non-Functional
	 */
	void AddPlayers(List<String[]> items);

	/**
	 * Method to see if Item Contains Item
	 * @param item - Property of ProductModel
	 * @return Full Item - If Item contains Item
	 * Method is non-functional
	 */
	boolean ContainsItem(RBModel item);
	
	/**
	 * Method for Removing Orders
	 * @param item - Full Order
	 * @return - Order is Removed From Database
	 */
	boolean RemoveItem(RBModel item);

	/**
	 * Method to find Order by Primary Key in Database
	 * @param pk - Order Id
	 * @return Full Order by Order Id
	 * Method is non-functional
	 */
	RBEntity findByPk(Integer pk);

}