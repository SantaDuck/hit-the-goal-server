package kr.santaduck.hitthegoal.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.santaduck.hitthegoal.dto.Goal;

import static kr.santaduck.hitthegoal.dao.sqls.GoalDaoSqls.*;

@Repository
public class GoalDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Goal> rowMapper = BeanPropertyRowMapper.newInstance(Goal.class);
	
	public GoalDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("goal")
				.usingGeneratedKeyColumns("id");
	}
	
	// READ
	public List<Goal> getGoals(int teamId, int memberId) {
		// 모든 Goal 가져오기
		if(teamId == 0 && memberId == 0) {
			return jdbc.query(SELECT_ALL_GOALS, rowMapper);
		}
		
		return jdbc.query(SELECT_ALL_GOALS, rowMapper);
	}
}
