package kr.santaduck.hitthegoal.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.santaduck.hitthegoal.dto.Team;

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

}
