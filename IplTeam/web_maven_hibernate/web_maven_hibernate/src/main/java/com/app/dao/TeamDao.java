package com.app.dao;

import java.util.List;
import com.app.pojos.Team;


public interface TeamDao {
     String addNewTeam(Team newTeam);
     List<Team> displayTeamId();
     Team displayTeamById(Integer id);
     List<Team> getTeamByMaxAgeWic(int age,int wicket);
     
}
