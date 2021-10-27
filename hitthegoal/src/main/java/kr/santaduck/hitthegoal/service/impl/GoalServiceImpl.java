package kr.santaduck.hitthegoal.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.santaduck.hitthegoal.dao.GoalDao;
import kr.santaduck.hitthegoal.dto.Goal;
import kr.santaduck.hitthegoal.service.GoalService;

@Service
public class GoalServiceImpl implements GoalService {
	@Autowired
	GoalDao goalDao;
	
	// Create
	@Override
	@Transactional(readOnly = false)
	public Goal addGoal(Goal goal) {
		goal.setCreateDate(new Date());
		int id = goalDao.insert(goal);
		goal.setId(id);
		
		return goal;
	}

	// Read
	@Override
	@Transactional
	public List<Goal> getGoals(int teamId, int memberId) {
		return goalDao.list(teamId, memberId);
	}

	@Override
	@Transactional
	public Goal getGoal(int id) {
		return goalDao.getGoal(id);
	}

	
	// Update
	@Override
	public int updateGoal(int id, String contents) {
		return goalDao.update(id, contents);
	}

	
	// Delete
	@Override
	public int deleteGoal(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
