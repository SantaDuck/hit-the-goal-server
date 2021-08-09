package kr.santaduck.hitthegoal.service;

import java.util.List;

import kr.santaduck.hitthegoal.dto.Goal;

public interface GoalService {
	
	// Create
	public Goal addGoal(Goal goal);
	
	// Read
	public List<Goal> getGoals(int teamId, int memberId);
	public Goal getGoal(int id);
	
	// Update
	public int updateGoal(int id, Goal goal);
	
	// Delete
	public int deleteGoal(int id);
}
