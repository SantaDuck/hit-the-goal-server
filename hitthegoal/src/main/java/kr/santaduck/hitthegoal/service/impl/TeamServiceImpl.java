package kr.santaduck.hitthegoal.service.impl;

import java.util.Date;

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

}
