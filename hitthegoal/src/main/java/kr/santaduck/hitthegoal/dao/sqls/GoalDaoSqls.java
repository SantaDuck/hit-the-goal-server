package kr.santaduck.hitthegoal.dao.sqls;

public class GoalDaoSqls {
	
	// Create
	
	// Read
	public static final String SELECT_ALL_GOALS = 
			"SELECT id, team_id, term, member_id, contents, is_achived, create_date FROM goal";
	
	public static final String SELECT_GOAL_BY_ID =
			"SELECT id, team_id, term, member_id, contents, is_achived, create_date FROM goal WHERE id=:id";
	
	public static final String SELECT_GOAL_BY_TEAM_ID =
			"SELECT id, team_id, term, member_id, contents, is_achived, create_date FROM goal WHERE team_id=:team_id";

	public static final String SELECT_GOAL_BY_MEMBER_ID =
			"SELECT id, team_id, term, member_id, contents, is_achived, create_date FROM goal WHERE member_id=:member_id";
	
	public static final String SELECT_GOAL_BY_TEAM_ID_AND_MEMBER_ID =
			"SELECT id, team_id, term, member_id, contents, is_achived, create_date FROM goal WHERE team_id=:team_id AND member_id=:member_id";

	// Update
	public static final String UPDATE_GOAL =
			"UPDATE goal SET contents=:contents WHERE id=:id";
	
	// Delete
	public static final String DELETE_GOAL =
			"DELETE FROM goal WHERE id=:id";
}
