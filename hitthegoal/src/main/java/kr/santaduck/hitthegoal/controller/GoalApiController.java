package kr.santaduck.hitthegoal.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.santaduck.hitthegoal.dto.Goal;
import kr.santaduck.hitthegoal.service.GoalService;

@RestController
public class GoalApiController {

	@Autowired
	GoalService goalService;
	
	// Create
	@PostMapping(path = "/goals")
	public Goal write(@RequestBody Goal goal, HttpServletRequest request) {
		
		Goal resultGoal = goalService.addGoal(goal);
		return resultGoal;
	}
	
	// Read
	@GetMapping(path = "/goals")
	public Map<String, Object> getGoals(
			@RequestParam(name = "teamId", required = false, defaultValue = "0") int teamId,
			@RequestParam(name = "memberId", required = false, defaultValue = "0") int memberId) {
		
		// 목록 가져오기
		List<Goal> goals = goalService.getGoals(teamId, memberId);
		
		// 반환할 객체 만들기
		Map<String, Object> map = new HashMap<>();
		map.put("goals", goals);
		
		return map;
	}
	
	@GetMapping(path = "/goals/{id}")
	public Map<String, Object> getGoal(@PathVariable("id") int id) {
		try {
			Goal goal = goalService.getGoal(id);
			
			Map<String, Object> map = new HashMap<>();
			map.put("goal", goal);
			
			return map;
		} catch (EmptyResultDataAccessException e) {
			return Collections.emptyMap();
		}
	}
	
	// update
	@PutMapping(path = "/goals/{id}")
	public Map<String, Object> update(@PathVariable("id") int id, @RequestBody HashMap<String, Object> body) {

		goalService.updateGoal(id, (String) body.get("contents"));
		
		Map<String, Object> map = new HashMap<>();
		map.put("result", goalService.getGoal(id));
		
		return map;
	}
	
	// delete
	@DeleteMapping(path = "/goals/{id}")
	public String delete(@PathVariable("id") int id) {
		return goalService.deleteGoal(id) != 0 ? "success" : "fail";
	}
	
	
}
