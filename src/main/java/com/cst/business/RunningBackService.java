package com.cst.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cst.data.RunningBackDataService;
import com.cst.entity.RBEntity;
import com.cst.model.RBModel;

@Service
public class RunningBackService implements RunningBackInterface {
	
	@Autowired
	private RunningBackDataService service;
	List<RBModel> runningBacks = new ArrayList<>();

	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("Hello From Running Back Service");
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RBModel> getRunningBacks() {

		// Get all the RB Entities
		List<RBEntity> rbEntity = service.findAll();
		
		// Iterate over the Entities and create a new list
		List<RBModel> runningBackDomain = new ArrayList<RBModel>();
		for(RBEntity entity : rbEntity)
		{
			runningBackDomain.add(new RBModel(entity.getRbId(), entity.getRank(), entity.getName(), entity.getTeam(), entity.getByeWeek(),entity.getPoints(), entity.getRushAttempts(), entity.getRushYards(),
					entity.getRushTds(), entity.getReceptions(), entity.getRecYards(), entity.getRecTds(), entity.getFirstDowns(), entity.getHundredYardGame(), entity.getTwoHundredYardGame(),
					entity.getFourtyYardPlay(), entity.getFourtyYardTds(), entity.getPassCompleted(), entity.getPassYards(), entity.getPassTds(), entity.getFumbles(), entity.getFumblesLost(), 
					entity.getTargetShare(), entity.getPointsGame()));
		}
		return runningBackDomain;
	}

	@Override
	public List<RBModel> AddPlayer(RBModel item) {
		runningBacks.add(item);
		return runningBacks;
	}

	@Override
	public void AddPlayers(List<String[]> items) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean ContainsItem(RBModel item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean RemoveItem(RBModel item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RBEntity findByPk(Integer pk) {
		// TODO Auto-generated method stub
		return null;
	}

}
