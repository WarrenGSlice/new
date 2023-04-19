package com.cst.repository;

import java.util.List;

import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import com.cst.entity.RBEntity;

@Service
public interface EditPlayerRepository extends Repository<RBEntity, Integer>{

	/**
	 * CRUD: Searches Database to Find a Player by the RB ID
	 * @param rbId - Integer
	 * @return List of Players that matched the searched for RB ID
	 */
	List<RBEntity> findByRbId(Integer rbId);
	
	/**
	 * CRUD: Searched Database to Find a Player by the  Name
	 * @param name - String
	 * @return List of Players that matched the search for Name
	 */
	List<RBEntity> findByName(String name);
	
}
