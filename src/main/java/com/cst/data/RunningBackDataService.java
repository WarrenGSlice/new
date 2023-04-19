package com.cst.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.cst.entity.RBEntity;
import com.cst.repository.EditPlayerRepository;
import com.cst.repository.PlayerRepository;

@Service
public class RunningBackDataService implements DataAccessInterface<RBEntity> {

	@Autowired
	private EditPlayerRepository editRepo;
	@Autowired
	private PlayerRepository ordersRepository;

	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	/**
	 * Non-Default Constructor for constructor injection
	 * @param ordersRepository - Auto Injected Orders Repository Repository
	 * @param dataSource - Auto Injected Data Source
	 */
	public RunningBackDataService(PlayerRepository ordersRepository, DataSource dataSource) {
		this.ordersRepository = ordersRepository;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	/**
	 * Default No Args Constructor
	 */
	public RunningBackDataService() {
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * CRUD: finder to return all order entities
	 */
	@Override
	public List<RBEntity> findAll() {

		List<RBEntity> orders = new ArrayList<RBEntity>();
		try
		{
			// Get all all the Entity Orders
			Iterable<RBEntity> ordersIterable = ordersRepository.findAll();

			// Convert to a List and return the List
			orders = new ArrayList<RBEntity>();
			ordersIterable.forEach(orders::add);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		// Return the List
		return orders;
	}
	
	/**
	 * CRUD: Method to Find Orders By Order Id
	 * @param orderId - Auto Injected Iterable of Type Long
	 * @return orders - Returns Full Order
	 */
	public List<RBEntity> findByOrderId(Iterable<Long> orderId){
		List<RBEntity> orders = new ArrayList<RBEntity>();
		try
		{
			Iterable<RBEntity> ordersIterable = ordersRepository.findAllById(orderId);
			orders = new ArrayList<RBEntity>();
			ordersIterable.forEach(orders::add);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return orders;
	}

	/**
	 * Method to Find Orders By Id - Might not be used
	 * @param id - Integer
	 * @return orders - find By Order Id
	 */
	@SuppressWarnings("deprecation")
	@Override
	public RBEntity findById(Integer id) {
		
		String sql = "SELECT * FROM ORDERS WHERE order_id = ?";
		RBEntity orders = new RBEntity();
		try
		{
			orders = jdbcTemplateObject.queryForObject(sql, new Object[] {id},(rs, rowNum) -> 
					new RBEntity((int) rs.getInt("RB_ID"),
									(int)rs.getInt("RANK"),
									rs.getString("NAME"),
									rs.getString("TEAM"),
									(int)rs.getInt("BYE_WEEK"),
									(float)rs.getFloat("POINTS"),
									(int)rs.getInt("RUSH_ATTEMPTS"),
									(float)rs.getFloat("RUSH_YARDS"),
									(int)rs.getInt("RUSH_TDS"),
									(int)rs.getInt("RECEPTIONS"),
									(float)rs.getFloat("REC_YARDS"),
									(int)rs.getInt("REC_TDS"),
									(int)rs.getInt("FIRST_DOWNS"),
									(int)rs.getInt("100_YARD_GAME"),
									(int)rs.getInt("200_YARD_GAME"),
									(int)rs.getInt("40_YARD_PLAY"),
									(int)rs.getInt("40_YARD_TDS"),
									(int)rs.getInt("PASS_COMPLETED"),
									(int)rs.getInt("PASS_YARDS"),
									(int)rs.getInt("PASS_TDS"),
									(int)rs.getInt("FUM"),
									(int)rs.getInt("FUM_LOST"),
									(float)rs.getFloat("TARGET_SHARE"),
									(float)rs.getFloat("POINTS_GAME")
									));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return (RBEntity) orders;
	}
	
	/**
	 * Method find order by Priority Key
	 * @param orderId - Integer
	 * @return Order in Database
	 */
	@SuppressWarnings("deprecation")
	public RBEntity findByPk(Integer rbId) {
		RBEntity ordEnt = null;
		int results = 0;
		String sql= "SELECT COUNT(*) FROM ORDERS WHERE ORDER_ID = ?";
		try
		{
			results = jdbcTemplateObject.queryForObject(sql, new Object[]{rbId}, Integer.class);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		if (results > 0)
		{
			sql = "SELECT * FROM ORDERS WHERE ORDER_ID = ?";
			try
			{
				ordEnt = (RBEntity) jdbcTemplateObject.queryForObject(sql, new Object[]{rbId}, (rs, rowNum) ->
				new RBEntity((int) rs.getInt("RB_ID"),
						(int)rs.getInt("RANK"),
						rs.getString("NAME"),
						rs.getString("TEAM"),
						(int)rs.getInt("BYE_WEEK"),
						(float)rs.getFloat("POINTS"),
						(int)rs.getInt("RUSH_ATTEMPTS"),
						(float)rs.getFloat("RUSH_YARDS"),
						(int)rs.getInt("RUSH_TDS"),
						(int)rs.getInt("RECEPTIONS"),
						(float)rs.getFloat("REC_YARDS"),
						(int)rs.getInt("REC_TDS"),
						(int)rs.getInt("FIRST_DOWNS"),
						(int)rs.getInt("100_YARD_GAME"),
						(int)rs.getInt("200_YARD_GAME"),
						(int)rs.getInt("40_YARD_PLAY"),
						(int)rs.getInt("40_YARD_TDS"),
						(int)rs.getInt("PASS_COMPLETED"),
						(int)rs.getInt("PASS_YARDS"),
						(int)rs.getInt("PASS_TDS"),
						(int)rs.getInt("FUM"),
						(int)rs.getInt("FUM_LOST"),
						(float)rs.getFloat("TARGET_SHARE"),
						(float)rs.getFloat("POINTS_GAME")
						));
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}

		return ordEnt;
	}
	
	/**
	 * Method to Verify an Order
	 * @param id - Integer
	 * @return true - If Order Exists
	 * @return false - If Not
	 */
	@SuppressWarnings("deprecation")
	public Boolean verifyOrder(Integer id) {
		int results = 0;
		String sql = "SELECT COUNT(*) FROM runningbacks WHERE RB_ID = ?";
		try {
			results = jdbcTemplateObject.queryForObject(sql, new Object[] {id},Integer.class);
		}catch (Exception e) {
			e.printStackTrace();
		}
		if (results == 0) {
			System.out.printf("Order Does not exist: RB_ID=%s", id);
			return false;
		}
		else {
			System.out.printf("Order Exists: RB_ID=%s", id);
			return true;
		}
	}

	/**
	 * CRUD: create an entity
	 * Used in Assignment, but not application
	 */
	@Override
	public boolean create(RBEntity orders) {
		// Example of "overriding" the CrudRepository save() because it simple is never called
		// You can inject a dataSource and use the jdbcTemplate to provide a customized implementation of a save() method
		String sql = "INSERT INTO runningbacks(RB_ID, RANK, NAME, TEAM, BYE_WEEK, POINTS, RUSH_ATTEMPTS, RUSH_YARDS, RUSH_TDS, RECEPTIONS, REC_YARDS, REC_TDS, FIRST_DOWNS, 100_YARD_GAME, 200_YARD_GAME, 40_YARD_PLAY, 40_YARD_TDS, PASS_COMPLETED, PASS_YARDS, PASS_TDS, FUM, FUM_LOST, TARGET_SHARE, POINTS_GAME) VALUES(?, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try
		{
			// Execute SQL Insert
			jdbcTemplateObject.update(sql,
					orders.getRbId(),
					orders.getRank(),
					orders.getName(),
					orders.getTeam(),
					orders.getByeWeek(),
					orders.getPoints(),
					orders.getRushAttempts(),
					orders.getRushYards(),
					orders.getRushTds(),
					orders.getReceptions(),
					orders.getRecYards(),
					orders.getRecTds(),
					orders.getFirstDowns(),
					orders.getHundredYardGame(),
					orders.getTwoHundredYardGame(),
					orders.getFourtyYardPlay(),
					orders.getFourtyYardTds(),
					orders.getPassCompleted(),
					orders.getPassYards(),
					orders.getPassTds(),
					orders.getFumbles(),
					orders.getFumblesLost(),
					orders.getTargetShare(),
					orders.getPointsGame()
					);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	return true;
	}
	
	/**
	 * Method that was used to Order Id
	 * @return New Order Id
	 */
	public String getOrderNo() {
        String sql = "select max(RB_ID) from runningbacks";
        String rbId = jdbcTemplateObject.queryForObject(sql, String.class);
        if (rbId == null) {
        	rbId = (String)("1");
        } else {
        	rbId = String.valueOf(Integer.parseInt(rbId) + 1);
        }
        
        rbId.toString();
        return rbId.toString();
    }

	/**
	 * CRUD: Method to Update an Order Entity
	 */
	@Override
	public boolean update(RBEntity order) {
		
		// Return the List
		return ordersRepository.save(order) != null;
	}

	/**
	 * CRUD: Method to Delete an Order Entity
	 */
	@Override 
	public boolean delete(RBEntity t) {
		try
		{
			this.ordersRepository.delete(t);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
			
		}
		// Return the List
		return true;
	}

	/**
	 * Method to tell Console when service is initialized
	 */
	@Override
	public void init() {
		System.out.println("OrderDataService Initialized");
	}

	/**
	 * Method to tell Console when service is destroyed
	 */
	@Override
	public void destroy() {
		System.out.println("OrderDataService Destroyed");	
	}
	
	/**
	 * CRUD: Method to Find Order in Database by Order Id
	 * @param id - Order Id
	 * @return - Order in Database
	 */
	public List<RBEntity> getRunningBackByRbId(Integer Rbid){
		return editRepo.findByRbId(Rbid);
	}

	/**
	 * CRUD: Method to Find Order in Database by Company Name
	 * @param companyName - Company Name
	 * @return Order in Database
	 */
	public List<RBEntity> getRunningBackByName(String name){
		return editRepo.findByName(name);
	}
	
}
