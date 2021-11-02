package kr.santaduck.hitthegoal.dao.sqls;

public class TeamDaoSqls {

	// Read
	public final static String SELECT_ALL_TEAMS =
			"SELECT id, team_name, king, quantity, create_date FROM team";
	
	public final static String SELECT_TEAMS_BY_MEMBER_ID =
			"SELECT team.id, team.team_name, team.king, team.quantity, team.create_date FROM team INNER JOIN team_member ON team_member.team_id=team.id WHERE team_member.member_id=:member_id";

	public final static String SELECT_TEAM_BY_ID =
			"SELECT id, team_name, king, quantity, create_date FROM team WHERE id=:id";
	
	
	// Update
	public final static String UPDATE_TEAM_NAME =
			"UPDATE team SET team_name=:team_name WHERE id=:id";
	
	public final static String UPDATE_KING =
			"UPDATE team SET king=:new_king WHERE id=:id";
}
