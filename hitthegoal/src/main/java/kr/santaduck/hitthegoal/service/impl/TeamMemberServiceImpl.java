package kr.santaduck.hitthegoal.service.impl;

import org.springframework.stereotype.Service;

import kr.santaduck.hitthegoal.dao.TeamMemberDao;
import kr.santaduck.hitthegoal.service.TeamMemberService;

@Service
public class TeamMemberServiceImpl implements TeamMemberService {

	TeamMemberDao teamMemberDao;
	
	@Override
	public int updateKing(int teamId, int oldKing, int newKing) {
		return teamMemberDao.updateKingDao(teamId, oldKing, newKing);
	}

}
