package kr.santaduck.hitthegoal.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.santaduck.hitthegoal.dto.Team;
import kr.santaduck.hitthegoal.service.TeamService;

@RestController
public class TeamApiController {

	@Autowired
	TeamService teamService;
	
	// Create
	@PostMapping(path = "/teams")
	public Team write(@RequestBody Team team, HttpServletRequest request) {
		Team resultTeam = teamService.addTeam(team);
		return resultTeam;
	}
	
	// Read
	@GetMapping(path = "/teams")
	public Map<String, Object> findAll() {
		List<Team> teams = teamService.getTeams();
		
		Map<String, Object> map = new HashMap<>();
		map.put("teams", teams);
		
		return map;
	}
	
	@GetMapping(path = "/teams", params = "memberId")
	public Map<String, Object> findByMemberId(@RequestParam(name="memberId", required = true) int memberId) {
		List<Team> teams = teamService.getTeams(memberId);
		
		Map<String, Object> map = new HashMap<>();
		map.put("teams", teams);
		
		return map;
	}
	
	@GetMapping(path = "/teams/{id}")
	public Map<String, Object> getTeam(@PathVariable("id") int id) {
		try {
			Team team = teamService.getTeam(id);
			
			Map<String, Object> map = new HashMap<>();
			map.put("team", team);
			
			return map;
		} catch (EmptyResultDataAccessException e) {
			return Collections.emptyMap();
		}
	}
}
