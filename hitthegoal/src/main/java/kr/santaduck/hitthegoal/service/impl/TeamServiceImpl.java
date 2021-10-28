package kr.santaduck.hitthegoal.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.santaduck.hitthegoal.dao.TeamDao;
import kr.santaduck.hitthegoal.dto.Team;
import kr.santaduck.hitthegoal.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	TeamDao teamDao;
	
	@Override
	@Transactional
	public Team addTeam(Team team) {
		team.setCreateDate(new Date());
		int id = teamDao.insert(team);
		team.setId(id);
		
		return team;
	}

	// Read
	@Override
	public List<Team> getTeams() {
		return teamDao.findAll();
	}

	@Override
	public List<Team> getTeams(int memberId) {
		return teamDao.findByMemberId(memberId);
	}

	@Override
	public Team getTeam(int id) {
		return teamDao.findById(id);
	}

}
