package kr.santaduck.hitthegoal.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.santaduck.hitthegoal.dao.sqls.TeamDaoSqls;
import kr.santaduck.hitthegoal.dto.Team;
import static kr.santaduck.hitthegoal.dao.sqls.TeamDaoSqls.*;

@Repository
public class TeamDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Team> rowMapper = BeanPropertyRowMapper.newInstance(Team.class);
	
	public TeamDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("team")
				.usingGeneratedKeyColumns("id");
	}

	// Create
	public int insert(Team team) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(team);
		return insertAction.executeAndReturnKey(params).intValue();
	}

	
	// Read
	public List<Team> findAll() {
		return jdbc.query(SELECT_ALL_TEAMS, rowMapper);
	}

	public List<Team> findByMemberId(int memberId) {
		Map<String, Object> params = new HashMap<>();
		params.put("member_id", memberId);
		
		return jdbc.query(SELECT_TEAMS_BY_MEMBER_ID, params, rowMapper);
	}

	public Team findById(int id) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		
		return jdbc.queryForObject(SELECT_TEAM_BY_ID, params, rowMapper);
	}
	
	
	// Update
	public int updateTeam(int id, Team team) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		params.put("team_name", team.getTeamName());
		
		return jdbc.update(UPDATE_TEAM_NAME, params);
	}

}
