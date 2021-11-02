package kr.santaduck.hitthegoal.service;

import java.util.List;

import kr.santaduck.hitthegoal.dto.Team;

public interface TeamService {

	// Create
	public Team addTeam(Team team);	
	
	// Read
	public List<Team> getTeams();
	public List<Team> getTeams(int memberId);
	public Team getTeam(int id);
	
	// Update
	public int updateTeamName(int id, String teamName);
	public int updateKing(int id, int oldKing, int newKing);
	
	// Delete
}
