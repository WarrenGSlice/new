package com.cst.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.cst.entity.RBEntity;

@Service
public interface PlayerRepository extends CrudRepository<RBEntity, Long>{

	/**
	 * CRUD: Searched the Database to find All Players
	 */
	@Override
	@Query(value= "SELECT * FROM RUNNINGBACKS")
	public List<RBEntity> findAll();
	
	/**
	 * CRUD: Searches the Database to find all Players By Team Name
	 * @param team - String
	 * @return Players in Database that Matched Searched for Team Name
	 */
	public List<RBEntity> findByTeam(String team);
	
	/**
	 * CRUD: Searches the Database to find all Players By  Name
	 * @param Name - String
	 * @return Players in Database that matched Searched for Name
	 */
	@Query(value= "SELECT * FROM RUNNINGBACKS")
	public List<RBEntity> findByName(String name);
	
	/**
	 * CRUD: Searches the Database to find all Players by Rank
	 * @param rank - Integer
	 * @return Players in Database that matches Searched for rank
	 */
	@Query(value= "SELECT * FROM RUNNINGBACKS")
	public List<RBEntity> findByRank(Integer rank);
	
	/**
	 * CRUD: Searches the Database to find all Players by RB ID
	 * @param rbId - String
	 * @return Players in Database that Matches Searched for RB ID
	 */
	@Query(value= "SELECT * FROM RUNNINGBACKS")
	public List<RBEntity> findById(String rbId);
	
	/**
	 * CRUD: Searches the Database to find all Players by RB ID
	 * @param rbId - Integer
	 * @return Players in Database that Matches Searched for RB ID
	 */
	public RBEntity findByRbId(Integer rbId);
	
}
