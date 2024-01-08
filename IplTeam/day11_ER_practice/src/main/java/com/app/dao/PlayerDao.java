package com.app.dao;

import com.app.pojos.Player;
import com.app.pojos.Team;

public interface PlayerDao {
//add a method to insert new player details
	String addNewPlayer(Integer teamId, Player newPlayer);
	public String addTeamToOwner(String ownerEmail,Team newTeam);
}
