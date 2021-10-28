package kr.santaduck.hitthegoal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.santaduck.hitthegoal.dto.Team;
import kr.santaduck.hitthegoal.service.TeamService;

@RestController
public class TeamApiController {

	@Autowired
	TeamService teamService;
	
	// Create
	@PostMapping(path = "/team")
	public Team write(@RequestBody Team team, HttpServletRequest request) {
		Team resultTeam = teamService.addTeam(team);
		return resultTeam;
	}
}
