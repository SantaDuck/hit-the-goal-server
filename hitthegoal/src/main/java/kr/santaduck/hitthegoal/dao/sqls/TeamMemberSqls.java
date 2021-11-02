package kr.santaduck.hitthegoal.dao.sqls;

public class TeamMemberSqls {

	public final static String UPDATE_KING =
			"UPDATE team_member SET is_king = CASE WHEN member_id=:old_king THEN false WHEN member_id=new_king THEN true END WHERE team_id=:team_id";
}
