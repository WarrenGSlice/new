package com.cst.model;

public class RBModel {

	//Variables
	public Integer rbId;
	public Integer rank;
	public String name;
	public String team;
	public Integer byeWeek;
	public Float points;
	public Integer rushAttempts;
	public Float rushYards;
	public Integer rushTds;
	public Integer receptions;
	public Float recYards;
	public Integer recTds;
	public Integer firstDowns;
	public Integer hundredYardGame;
	public Integer twoHundredYardGame;
	public Integer fourtyYardPlay;
	public Integer fourtyYardTds;
	public Integer passCompleted;
	public Integer passYards;
	public Integer passTds;
	public Integer fumbles;
	public Integer fumblesLost;
	public Float targetShare;
	public Float pointsGame;
	
	
	
	public RBModel(Integer rbId, Integer rank, String name, String team, Integer byeWeek, Float points,
			Integer rushAttempts, Float rushYards, Integer rushTds, Integer receptions, Float recYards, Integer recTds,
			Integer firstDowns, Integer hundredYardGame, Integer twoHundredYardGame, Integer fourtyYardPlay,
			Integer fourtyYardTds, Integer passCompleted, Integer passYards, Integer passTds, Integer fumbles,
			Integer fumblesLost, Float targetShare, Float pointsGame) {
		this.rbId = rbId;
		this.rank = rank;
		this.name = name;
		this.team = team;
		this.byeWeek = byeWeek;
		this.points = points;
		this.rushAttempts = rushAttempts;
		this.rushYards = rushYards;
		this.rushTds = rushTds;
		this.receptions = receptions;
		this.recYards = recYards;
		this.recTds = recTds;
		this.firstDowns = firstDowns;
		this.hundredYardGame = hundredYardGame;
		this.twoHundredYardGame = twoHundredYardGame;
		this.fourtyYardPlay = fourtyYardPlay;
		this.fourtyYardTds = fourtyYardTds;
		this.passCompleted = passCompleted;
		this.passYards = passYards;
		this.passTds = passTds;
		this.fumbles = fumbles;
		this.fumblesLost = fumblesLost;
		this.targetShare = targetShare;
		this.pointsGame = pointsGame;
	}
	
	public RBModel(Integer rank, String name, String team, Integer byeWeek, Float points,
			Integer rushAttempts, Float rushYards, Integer rushTds, Integer receptions, Float recYards, Integer recTds,
			Integer firstDowns, Integer hundredYardGame, Integer twoHundredYardGame, Integer fourtyYardPlay,
			Integer fourtyYardTds, Integer passCompleted, Integer passYards, Integer passTds, Integer fumbles,
			Integer fumblesLost, Float targetShare, Float pointsGame) {
		this.rank = rank;
		this.name = name;
		this.team = team;
		this.byeWeek = byeWeek;
		this.points = points;
		this.rushAttempts = rushAttempts;
		this.rushYards = rushYards;
		this.rushTds = rushTds;
		this.receptions = receptions;
		this.recYards = recYards;
		this.recTds = recTds;
		this.firstDowns = firstDowns;
		this.hundredYardGame = hundredYardGame;
		this.twoHundredYardGame = twoHundredYardGame;
		this.fourtyYardPlay = fourtyYardPlay;
		this.fourtyYardTds = fourtyYardTds;
		this.passCompleted = passCompleted;
		this.passYards = passYards;
		this.passTds = passTds;
		this.fumbles = fumbles;
		this.fumblesLost = fumblesLost;
		this.targetShare = targetShare;
		this.pointsGame = pointsGame;
	}

	public RBModel(Integer rbId, Integer rank, String name, String team, Integer byeWeek, Float points,
			Integer rushAttempts, Float rushYards, Integer rushTds, Integer receptions, Float recYards, Integer recTds,
			Integer firstDowns, Integer fumbles, Integer fumblesLost, Float targetShare, Float pointsGame) {
		this.rbId = rbId;
		this.rank = rank;
		this.name = name;
		this.team = team;
		this.byeWeek = byeWeek;
		this.points = points;
		this.rushAttempts = rushAttempts;
		this.rushYards = rushYards;
		this.rushTds = rushTds;
		this.receptions = receptions;
		this.recYards = recYards;
		this.recTds = recTds;
		this.firstDowns = firstDowns;
		this.fumbles = fumbles;
		this.fumblesLost = fumblesLost;
		this.targetShare = targetShare;
		this.pointsGame = pointsGame;
	}
	
	public RBModel(Integer rank, String name, String team, Integer byeWeek, Float points,
			Integer rushAttempts, Float rushYards, Integer rushTds, Integer receptions, Float recYards, Integer recTds,
			Integer firstDowns, Integer fumbles, Integer fumblesLost, Float targetShare, Float pointsGame) {
		this.rank = rank;
		this.name = name;
		this.team = team;
		this.byeWeek = byeWeek;
		this.points = points;
		this.rushAttempts = rushAttempts;
		this.rushYards = rushYards;
		this.rushTds = rushTds;
		this.receptions = receptions;
		this.recYards = recYards;
		this.recTds = recTds;
		this.firstDowns = firstDowns;
		this.fumbles = fumbles;
		this.fumblesLost = fumblesLost;
		this.targetShare = targetShare;
		this.pointsGame = pointsGame;
	}
	
	public RBModel() {
		
	}
	
	public RBModel(int input) {
		super();
		this.rbId = input;
		this.rank = -1;
		this.name = "";
		this.team = "";
		this.byeWeek = -1;
		this.points = -1f;
		this.rushAttempts = -1;
		this.rushYards = -1f;
		this.rushTds = -1;
		this.receptions = -1;
		this.recYards = -1f;
		this.recTds = -1;
		this.firstDowns = -1;
		this.hundredYardGame = -1;
		this.twoHundredYardGame = -1;
		this.fourtyYardPlay = -1;
		this.fourtyYardTds = -1;
		this.passCompleted = -1;
		this.passYards = -1;
		this.passTds = -1;
		this.fumbles = -1;
		this.fumblesLost = -1;
		this.targetShare = -1f;
		this.pointsGame = -1.00f;
	}
	
	public RBModel(String[] playerArray) {
		this.rbId = Integer.parseInt(playerArray[0]);
		this.rank = Integer.parseInt(playerArray[1]);
		this.name = playerArray[2];
		this.team = playerArray[3];
		this.byeWeek = Integer.parseInt(playerArray[4]);
		this.points = Float.parseFloat(playerArray[5]);
		this.rushAttempts = Integer.parseInt(playerArray[6]);
		this.rushYards = Float.parseFloat(playerArray[7]);
		this.rushTds = Integer.parseInt(playerArray[8]);
		this.receptions = Integer.parseInt(playerArray[9]);
		this.recYards = Float.parseFloat(playerArray[10]);
		this.recTds = Integer.parseInt(playerArray[11]);
		this.firstDowns = Integer.parseInt(playerArray[12]);
		this.hundredYardGame = Integer.parseInt(playerArray[13]);
		this.twoHundredYardGame = Integer.parseInt(playerArray[14]);
		this.fourtyYardPlay = Integer.parseInt(playerArray[15]);
		this.fourtyYardTds = Integer.parseInt(playerArray[16]);
		this.passCompleted = Integer.parseInt(playerArray[17]);
		this.passYards = Integer.parseInt(playerArray[18]);
		this.passTds = Integer.parseInt(playerArray[19]);
		this.fumbles = Integer.parseInt(playerArray[20]);
		this.fumblesLost = Integer.parseInt(playerArray[21]);
		this.targetShare = Float.parseFloat(playerArray[22]);
		this.pointsGame = Float.parseFloat(playerArray[23]);
				
	}

	public Integer getRbId() {
		return rbId;
	}

	public void setRbId(Integer rbId) {
		this.rbId = rbId;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public Integer getByeWeek() {
		return byeWeek;
	}

	public void setByeWeek(Integer byeWeek) {
		this.byeWeek = byeWeek;
	}

	public Float getPoints() {
		return (float) ((rushAttempts*0.1)+(rushYards/10)+(rushTds*6)+(receptions*1)+(recYards/10)+(recTds*6)+(firstDowns*0.1)+(fumbles*-0)+(fumblesLost*-2)+(hundredYardGame*2)+(twoHundredYardGame*4)+(fourtyYardPlay*1)+(fourtyYardTds*1.5)+(passCompleted*0.20)+(passYards*0.04)+(passTds*5));
	}

	public void setPoints(Float points) {
		this.points = points;
	}

	public Integer getRushAttempts() {
		return rushAttempts;
	}

	public void setRushAttempts(Integer rushAttempts) {
		this.rushAttempts = rushAttempts;
	}

	public Float getRushYards() {
		return rushYards;
	}

	public void setRushYards(Float rushYards) {
		this.rushYards = rushYards;
	}

	public Integer getRushTds() {
		return rushTds;
	}

	public void setRushTds(Integer rushTds) {
		this.rushTds = rushTds;
	}

	public Integer getReceptions() {
		return receptions;
	}

	public void setReceptions(Integer receptions) {
		this.receptions = receptions;
	}

	public Float getRecYards() {
		return recYards;
	}

	public void setRecYards(Float recYards) {
		this.recYards = recYards;
	}

	public Integer getRecTds() {
		return recTds;
	}

	public void setRecTds(Integer recTds) {
		this.recTds = recTds;
	}
	
	public Integer getFirstDowns() {
		return firstDowns;
	}
	
	public void setFirstDowns(Integer firstDowns) {
		this.firstDowns = firstDowns;
	}
	
	

	public Integer getHundredYardGame() {
		return hundredYardGame;
	}

	public void setHundredYardGame(Integer hundredYardGame) {
		this.hundredYardGame = hundredYardGame;
	}

	public Integer getTwoHundredYardGame() {
		return twoHundredYardGame;
	}

	public void setTwoHundredYardGame(Integer twoHundredYardGame) {
		this.twoHundredYardGame = twoHundredYardGame;
	}

	public Integer getFourtyYardPlay() {
		return fourtyYardPlay;
	}

	public void setFourtyYardPlay(Integer fourtyYardPlay) {
		this.fourtyYardPlay = fourtyYardPlay;
	}

	public Integer getFourtyYardTds() {
		return fourtyYardTds;
	}

	public void setFourtyYardTds(Integer fourtyYardTds) {
		this.fourtyYardTds = fourtyYardTds;
	}

	public Integer getPassCompleted() {
		return passCompleted;
	}

	public void setPassCompleted(Integer passCompleted) {
		this.passCompleted = passCompleted;
	}

	public Integer getPassYards() {
		return passYards;
	}

	public void setPassYards(Integer passYards) {
		this.passYards = passYards;
	}

	public Integer getPassTds() {
		return passTds;
	}

	public void setPassTds(Integer passTds) {
		this.passTds = passTds;
	}

	public Integer getFumbles() {
		return fumbles;
	}

	public void setFumbles(Integer fumbles) {
		this.fumbles = fumbles;
	}

	public Integer getFumblesLost() {
		return fumblesLost;
	}

	public void setFumblesLost(Integer fumblesLost) {
		this.fumblesLost = fumblesLost;
	}

	public Float getTargetShare() {
		return targetShare;
	}

	public void setTargetShare(Float targetShare) {
		this.targetShare = targetShare;
	}

	public Float getPointsGame() {
		return pointsGame;
	}

	public void setPointsGame(Float pointsGame) {
		this.pointsGame = pointsGame;
	}
	
	@Override
	public String toString() {
		return "RBModel [rbId=" + rbId + ", rank=" + rank + ", name=" + name + ", team=" + team + ", byeWeek=" + byeWeek
				+ ", points=" + points + ", rushAttempts=" + rushAttempts + ", rushYards=" + rushYards + ", rushTds="
				+ rushTds + ", receptions=" + receptions + ", recYards=" + recYards + ", recTds=" + recTds
				+ ", firstDowns=" + firstDowns + ", hundredYardGame=" + hundredYardGame + ", twoHundredYardGame="
				+ twoHundredYardGame + ", fourtyYardPlay=" + fourtyYardPlay + ", fourtyYardTds=" + fourtyYardTds
				+ ", passCompleted=" + passCompleted + ", passYards=" + passYards + ", passTds=" + passTds
				+ ", fumbles=" + fumbles + ", fumblesLost=" + fumblesLost + ", targetShare=" + targetShare
				+ ", pointsGame=" + pointsGame + "]";
	}
	
	
}
