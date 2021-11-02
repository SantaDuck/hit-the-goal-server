package kr.santaduck.hitthegoal.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.santaduck.hitthegoal.dto.TeamMember;
import static kr.santaduck.hitthegoal.dao.sqls.TeamMemberSqls.*;
@Repository
public class TeamMemberDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<TeamMember> rowMapper = BeanPropertyRowMapper.newInstance(TeamMember.class);
	
	public TeamMemberDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("team_member")
				.usingGeneratedKeyColumns("id");
	}

	public int updateKingDao(int teamId, int oldKing, int newKing) {
		Map<String, Object> params = new HashMap<>();
		params.put("team_id", teamId);
		params.put("old_king", oldKing);
		params.put("new_king", newKing);
		
		return jdbc.update(UPDATE_KING, params);
	}

}
